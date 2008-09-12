/*
 * LocalConnection.java
 *
 * Created on November 2, 2006, 3:22 PM
 *
 */

/*
 * Copyright 2008 Marcel Richter
 * 
 * This file is part of RSC (Remote Service Configurator).
 *
 *  RSC is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  RSC is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

package rsc.backend.connections.localConnection;

import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import javax.naming.ConfigurationException;
import javax.swing.JPanel;
import org.apache.commons.vfs.FileSystem;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.VFS;
import org.jdom.Element;
import rsc.RSC;
import rsc.backend.connections.AbstractConnection;
import rsc.backend.connections.Connection.Streams;
import rsc.backend.connections.ConnectionListener;

/**
 * 
 * @author marcel richter
 */
public class LocalConnection extends AbstractConnection {

    private LocalConnectionConfigurator configurator;
    private Vector<ConnectionListener> cListener;
    private FileSystem fs;

    public static String getName() {
        return "local Connection";
    }

    /** Creates a new instance of LocalConnection */
    public LocalConnection() throws ConfigurationException {
        init();
    }

    public LocalConnection(Element e) throws ConfigurationException {
        init();
    }

    private void init() {
        try {
            cListener = new Vector<ConnectionListener>();
            configurator = new LocalConnectionConfigurator(this);
            fs = VFS.getManager().resolveFile("file:///").getFileSystem();
        } catch (FileSystemException ex) {
            RSC.log(Level.SEVERE, "cant initialize local vfs", ex);
        }
    }

    public void export(Element e) {
        Element ee = new Element("localConnection");
        e.addContent(ee);
    }

    public FileSystem getFileSystem() {
        return fs;
    }

    public Streams execute(String command) throws IOException {
        Process p;

        p = Runtime.getRuntime().exec(command);
        return createStreams(p.getInputStream(), p.getOutputStream(), p.getErrorStream());
    }

    public boolean isConnected() {
        return true;
    }

    public JPanel getConfigurationPanel() {
        return configurator;
    }

    public void disconnect() {
        for (ConnectionListener l : cListener) {
            l.connectionDisconnect();
        }
    }

    public void connect() {
        for (ConnectionListener l : cListener) {
            l.connectionConnect();
        }
    }

    public void removeConnectionListener(ConnectionListener listener) {
        cListener.remove(listener);
    }

    public void addConnectionListener(ConnectionListener listener) {
        cListener.add(listener);
    }
}
