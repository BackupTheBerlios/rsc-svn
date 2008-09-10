package rsc.backend.connections.sshConnection;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.apache.commons.vfs.FileSystem;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.VFS;
import org.jdom.Element;
import rsc.RSC;
import rsc.backend.connections.AbstractConnection;
import rsc.backend.connections.Connection.Streams;
import rsc.backend.connections.ConnectionException;
import rsc.backend.connections.ConnectionListener;

/**
 *
 * @author marcel richter, philipp driess
 */
public class SSHConnection extends AbstractConnection {

    private SSHConnectionConfigurator configurator;
    private String hostname,  username,  password;
    private int port;
    private Vector<ConnectionListener> cListener;
    private FileSystem fs;
    private JSch jsch;
    private Session session;

    public SSHConnection() {
        cListener = new Vector<ConnectionListener>();
        jsch = new JSch();
        port = 22;
        username = "";
        hostname = "";
        password = "";
        configurator = new SSHConnectionConfigurator(this);
    }

    public SSHConnection(Element e) {
        cListener = new Vector<ConnectionListener>();
        jsch = new JSch();
        username = e.getAttributeValue("username");
        hostname = e.getAttributeValue("hostname");
        port = Integer.parseInt(e.getAttributeValue("port"));
        password = e.getAttributeValue("password");
        configurator = new SSHConnectionConfigurator(this);
    }

    public SSHConnection(String hostname, String username, String password, int port) {
        cListener = new Vector<ConnectionListener>();
        jsch = new JSch();
        this.port = port;
        this.username = username;
        this.hostname = hostname;
        this.password = password;
        configurator = new SSHConnectionConfigurator(this);
    }

    public void export(Element e) {
        Element ee = new Element("SSHConnection");
        ee.setAttribute("username", username);
        ee.setAttribute("hostname", hostname);
        ee.setAttribute("port", "" + port);
        ee.setAttribute("password", password);
        e.addContent(ee);
    }

    public static String getName() {
        return "SSH connection";
    }

    public JPanel getConfigurationPanel() {
        return configurator;
    }

    private void createSession() {
        try {
            session = jsch.getSession(username, hostname, port);
        } catch (JSchException ex) {
            RSC.log(Level.SEVERE, "error session could not be created", ex);
        }
    }

    public void connect() throws ConnectionException {
        if(isConnected()) {
            return;
        }
        if (fs == null) {
            try {
                fs = VFS.getManager().resolveFile("sftp://" + username + ":" + password + "@" + hostname + ":" + port + "/").getFileSystem();
            } catch (FileSystemException ex) {
                RSC.log(Level.SEVERE, "error connecting ssh-filesystem", ex);
                if (fs != null) {
                    fs.getFileSystemManager().closeFileSystem(fs);
                    fs = null;
                }
                session = null;
                throw new ConnectionException();
            }
        }
        if (session == null) {
            createSession();
        }
        UserInfo ui = new MyUserInfo();
        session.setUserInfo(ui);
        try {
            session.connect(30000);
        } catch (JSchException ex) {
            RSC.log(Level.SEVERE, "error connecting ssh", ex);
            if (fs != null) {
                fs.getFileSystemManager().closeFileSystem(fs);
                fs = null;
            }
            session = null;
            System.out.println("cant connect: " + ex.getMessage());
            throw new ConnectionException();
        }
        for (ConnectionListener l : cListener) {
            l.connectionConnect();
        }
    }

    public void disconnect() {
        if (fs != null) {
            fs.getFileSystemManager().closeFileSystem(fs);
            fs = null;
        }
        if (session != null) {
            session.disconnect();
        }
        for (ConnectionListener l : cListener) {
            l.connectionDisconnect();
        }
    }

    public boolean isConnected() {
        if (fs == null || session == null) {
            return false;
        }
        return session.isConnected();
    }

    public Streams execute(String command) throws IOException {
        Streams ret = null;
        try {
            Channel channel2;
            try {
                channel2 = session.openChannel("exec");
                channel2.setInputStream(null);
            } catch (JSchException ex) {
                ex.printStackTrace();
                throw new IOException("JSchexception");
            }
            ((ChannelExec) channel2).setCommand(command);
            ((ChannelExec) channel2).setErrStream(System.err);
            InputStream in2 = null;
            try {
                in2 = channel2.getInputStream();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                //System.out.println("open channel");
                channel2.connect();
            } catch (JSchException ex) {
                ex.printStackTrace();
            }

            byte[] tmp2 = new byte[1024];
            while (true) {
                try {
                    while (in2.available() > 0) {
                        int i = in2.read(tmp2, 0, 1024);
                        if (i < 0) {
                            break;
                        }
                        System.out.print(new String(tmp2, 0, i));

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if (channel2.isClosed()) {
                    System.out.println("exit-status: " + channel2.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ee) {
                }
            }
            //System.out.println("begin to close channel");
            channel2.disconnect();
        //System.out.println("channel closed");
        } finally {
            System.out.println("final execute");
        }
        return ret;
    }

    public FileSystem getFileSystem() {
        return fs;
    }

    public void removeConnectionListener(ConnectionListener listener) {
        cListener.remove(listener);
    }

    public void addConnectionListener(ConnectionListener listener) {
        cListener.add(listener);
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        if (!isConnected()) {
            session = null;
            this.hostname = hostname;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (!isConnected()) {
            session = null;
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!isConnected()) {
            session = null;
            this.password = password;
        }
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        if (!isConnected()) {
            session = null;
            this.port = port;
        }
    }

    public class MyUserInfo implements UserInfo, UIKeyboardInteractive {

        private Container panel;
        private String passwd;
        private JTextField passwordField = (JTextField) new JPasswordField(20);
        final GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);

        public String getPassword() {
            return password;
        }

        public boolean promptYesNo(String str) {
            Object[] options = {"yes", "no"};
            int foo = JOptionPane.showOptionDialog(null, str, "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (foo == 0) {
                return true;
            }
            return false;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase(String message) {
            return true;
        }

        public boolean promptPassword(String message) {
            Object[] ob = {passwordField};
            int result = JOptionPane.showConfirmDialog(null, ob, message, JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                passwd = passwordField.getText();
                return true;
            } else {
                return false;
            }
        }

        public void showMessage(String message) {
            JOptionPane.showMessageDialog(null, message);
        }

        public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt, boolean[] echo) {
            String[] ret = new String[1];
            ret[0] = password;
            return ret;
        }
    }
}
