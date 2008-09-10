/*
 * Main.java
 *
 * Created on November 1, 2006, 3:33 PM
 *
 */
package rsc;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import rsc.backend.HostImpl;
import rsc.backend.connections.AbstractConnection;
import rsc.backend.connections.ConnectionContainer;
import rsc.backend.modules.AbstractModule;
import rsc.backend.modules.ModuleContainer;
import rsc.backend.modules.ips.backend.Snortconf;
import rsc.backend.modules.ips.backend.parser.SnortFactoryParser;
import rsc.backend.plugins.AbstractPlugin;
import rsc.backend.plugins.Plugin;
import rsc.backend.plugins.PluginContainer;
import rsc.frontend.MainFrame;

/**
 * Diese Klasse implementiert das zentrale Programmobjekt als Singleton so das
 * jedes Objekt oder jede Klasse es erreichen kann. Seine Hauptaufgaben liegen
 * bei der Verwaltung der Hosts und dem Anbieten Programmweiter Funktionen.
 * @author  marcel richter
 */
public class RSC extends DefaultMutableTreeNode {

    private Vector<PluginContainer> plugins;
    private Vector<ModuleContainer> modules;
    private Vector<ConnectionContainer> connections;
    private Vector<CollectionListener> rootListener;
    private Vector<HostImpl> hosts;
    private Vector<Plugin> activePlugins;
    private static MainFrame frontend;
    private DefaultTreeModel dtm;
    private String hostDir;
    private String configFile;
    private String libPath;
    private static String[] staticPlugins = {};
    private static String[] staticModules = {"rsc.backend.modules.ips.IPS"};
    private static String[] staticConnections = {"rsc.backend.connections.localConnection.LocalConnection", "rsc.backend.connections.sshConnection.SSHConnection"};
    private static RSC instance;
    private static boolean runAsApplet;

    /** Creates a new instance of Main */
    private RSC() {
        activePlugins = new Vector<Plugin>();
        hosts = new Vector<HostImpl>();
        plugins = new Vector<PluginContainer>();
        modules = new Vector<ModuleContainer>();
        connections = new Vector<ConnectionContainer>();
        rootListener = new Vector<CollectionListener>();
        if (!runAsApplet) {
            //hostDir = System.getProperty("user.dir") + System.getProperty("file.separator") + ".rsc";
            hostDir = System.getProperty("user.home") + System.getProperty("file.separator") + ".rsc";
            configFile = hostDir + System.getProperty("file.separator") + "rsc.conf";
            libPath = /*System.getProperty("user.dir")*/ hostDir + System.getProperty("file.separator") + "extensions";
        } else {
            hostDir = "";
            configFile = "";
            libPath = "";
        }

        try {
            collector();
        } catch (Exception e) {
            System.err.println("error while loading plugins: " + e.getMessage());
        }
    }

    /**
     * Zugang zum Singleton
     * @return Instanz des RSC-Objekts
     */
    public static RSC getInstance() {
        if (instance == null) {
            instance = new RSC();
        }
        return instance;
    }

    public static void runAsApplet(boolean applet) {
        runAsApplet = applet;
    }

    public static boolean isRunAsApplet() {
        return runAsApplet;
    }

    /**
     * diese Methode wird vom MainFrame nachdem der Baum instanziert wurd aufgerufen.
     *
     * also eigentlich ziemilch daemlich und hier muss wohl ein getDTM draus werden
     * und der MainFrame holt sich dieses ab
     * @param dtm TreeModel das RSC aktualisiert wenn sich seine Hosts aendern
     */
    public void setDTM(DefaultTreeModel dtm) {
        this.dtm = dtm;
    }

    /**
     * die export-Methode wird aufgerufen um das gesamte Objekt und die in ihm
     * verwalteten Hosts in eine XML-Datei auf die der statische String "configFile"
     * verweist zu speichern
     */
    public void export() throws FileNotFoundException, IOException {
        if (!runAsApplet) {
            File f = new File(configFile);
            try {
                if (!f.exists()) {
                    if (!f.createNewFile()) {
                        throw new IOException("unable to create file");
                    }
                }
                FileOutputStream fos = new FileOutputStream(f);
                XMLOutputter serializer = new XMLOutputter();
                Element root = new Element("rsc");
                //Document doc = new Document(root);
                root.setAttribute("type", "export");
                for (HostImpl x : hosts) {
                    x.export(root);
                }
                for (Plugin x : activePlugins) {
                    Element plug = new Element("plugin");
                    plug.setAttribute("name", ((AbstractPlugin) x).getName());
                    x.export(plug);
                    root.addContent(plug);
                }
                serializer.output(root, fos);
                fos.flush();
                fos.close();
            } catch (FileNotFoundException ex) {
                throw new FileNotFoundException("file not found");
            } catch (IOException ex) {
                throw new IOException("unable to write file");
            }
        }
    }

    /**
     * mithilfe dieser Methode kann die in "configFile" enthaltene
     * Programmkonfiguration wieder hergestellt werden.
     */
    public void load() throws ParseException, IOException {
        if (!runAsApplet) {
            File f = new File(configFile);
            if (!f.exists()) {
                throw new FileNotFoundException("file not available");
            }
            try {
                //um zu validieren xsd datei erstellen!
                //SAXBuilder builder=new SAXBuilder(true);
                //builder.setFeature("http://apache.org/xml/features/validation/schema", true);
                //builder.setFeature("http://xml.org/sax/features/validation", true);
                SAXBuilder builder = new SAXBuilder(false);
                Document doc = builder.build(f);
                Element root = doc.getRootElement();
                for (Element e : (List<Element>) root.getChildren("host")) {
                    hosts.add(new HostImpl(e));
                }
                for (Element e : (List<Element>) root.getChildren("plugin")) {
                    for (PluginContainer x : plugins) {
                        if (x.isContainerOf(e)) {
                            activePlugins.add(x.newInstance(hosts, e));
                            break;
                        }
                    }
                }
            } catch (InstantiationException ex) {
                Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (JDOMException ex) {
                ex.printStackTrace();
                throw new ParseException("file parsing error", 0);
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new IOException("error at reading file");
            }
        }
    }

    /**
     * gibt den Vector aktueller Hosts aus
     * @return alle Hosts die RSC im Moment geladen hat
     */
    public Vector<HostImpl> getHosts() {
        return hosts;
    }

    public Vector<Plugin> getActivePlugins() {
        return activePlugins;
    }

    /**
     * registrieren eines objekts das ueber hinzufuegen und loeschen von hosts
     * informiert werden soll
     * @param listener hinzuzufuegender CollectionListener
     */
    public void addRootListener(CollectionListener listener) {
        rootListener.add(listener);
    }

    /**
     * objekte die sich als listener registriert haben sollten sich bei fehlendem
     * informationsbedarf und vor allem bei nicht gebrauch (loeschung) hier austragen
     * @param listener zu loeschender CollectionListener
     */
    public void removeRootListener(CollectionListener listener) {
        rootListener.remove(listener);
    }

    /**
     * fuegt der Lite der Hosts einen neuen hinzu. da es sich um eine TreeNode handelt
     * wird das TreeModel darueber informiert. Aus Entwicklungshistorischen gruenden
     * wird der ganze kram in 2 verschiedenene Vectoren eingefuegt (da RSC den
     * DefaultMutableTreeNode erweitert). Da der DefaulMutableTreeNode durch fehlende
     * Templatisierung und auch fehlenden Methoden fuer die Module untragbar ist muss
     * MutableTreeNode dringend implementiert werden.
     *
     * Zu denken ist dabei vor allem auch daran das die Module die MutableTreeNode
     * ueberschreiben sollen auch ein ContentPanelProvider sein sollen.
     * @param host HostImpl die im Programm angezeigt und bearbeitet werden kann
     */
    public void addHost(HostImpl host) {
        add(host);
        hosts.add(host);
        int[] added = new int[1];
        added[0] = this.getIndex(host);
        dtm.nodesWereInserted(this, added);
        for (CollectionListener l : rootListener) {
            l.elementAdded(host);
        }
    }

    /**
     * loeschen eines Hosts aus dem Programm
     *
     * bitte addHost beachten
     * @param host HostImpl die aus dem Programm gloescht wird
     */
    public void removeHost(HostImpl host) {
        Object[] objs = new Object[1];
        objs[0] = host;
        int[] removed = new int[1];
        removed[0] = this.getIndex(host);
        remove(host);
        hosts.remove(host);
        dtm.nodesWereRemoved(this, removed, objs);
        for (CollectionListener l : rootListener) {
            l.elementRemoved(host);
        }
    }

    public void addPlugin(Plugin plugin) {
        add(plugin);
        activePlugins.add(plugin);
        int[] added = new int[1];
        added[0] = this.getIndex(plugin);
        dtm.nodesWereInserted(this, added);
        for (CollectionListener l : rootListener) {
            l.elementAdded(plugin);
        }
    }

    public void removePlugin(Plugin plugin) {
        Object[] objs = new Object[1];
        objs[0] = plugin;
        int[] removed = new int[1];
        removed[0] = this.getIndex(plugin);
        remove(plugin);
        activePlugins.remove(plugin);
        dtm.nodesWereRemoved(this, removed, objs);
        for (CollectionListener l : rootListener) {
            l.elementRemoved(plugin);
        }
    }

    /**
     * gibt die Referenz auf den MainFrame zurueck
     * @return aktueller JFrame der GUI
     */
    public MainFrame getFrontend() {
        return frontend;
    }

    private void collector() {
        File f = new File(libPath);
        Class<AbstractPlugin> plug;
        Class<AbstractModule> mod;
        Class<AbstractConnection> con;


        plugins.clear();
        modules.clear();
        connections.clear();

        for (String c : staticPlugins) {
            try {
                plug = (Class<AbstractPlugin>) ClassLoader.getSystemClassLoader().loadClass(c);
                //hirarchie muss durchsucht werden
                //if(mod.getSuperclass().getName().equalsIgnoreCase("AbstractPlugin"))
                plugins.add(new PluginContainer(plug));
            } catch (ClassNotFoundException ex) {
                System.out.println("plugin class " + c + " not found");
            } catch (InvalidClassException ex) {
                System.out.println("class not a valid plugin " + c);
            }
        }
        for (String c : staticModules) {
            try {
                mod = (Class<AbstractModule>) ClassLoader.getSystemClassLoader().loadClass(c);
                //hirarchie muss durchsucht werden
                //if(mod.getSuperclass().getName().equalsIgnoreCase("AbstractModul"))
                modules.add(new ModuleContainer(mod));
            } catch (ClassNotFoundException ex) {
                System.out.println("connection class " + c + " not found");
            } catch (InvalidClassException ex) {
                System.out.println("class not a valid connection " + c);
            }
        }
        for (String c : staticConnections) {
            try {
                con = (Class<AbstractConnection>) ClassLoader.getSystemClassLoader().loadClass(c);
                //hirarchie muss durchsucht werden
                //if(cons.getSuperclass().getName().equalsIgnoreCase("AbstractConnection"))
                connections.add(new ConnectionContainer(con));
            } catch (ClassNotFoundException ex) {
                System.out.println("connection class " + c + " not found");
            } catch (InvalidClassException ex) {
                System.out.println("class not a valid connection " + c);
            }
        }

        //load dynamic connections and modules
        if (!runAsApplet) {
            System.out.println("libpath: " + libPath);
            if (!f.isDirectory()) {
                System.err.println(libPath + " seems not working");
                return;
            } //throw new Exception("modul-path is no directory");
            File connectionFiles[] = f.listFiles(new FileFilter() {

                public boolean accept(File pathname) {
                    if (pathname.isFile() && pathname.getName().endsWith(".jar")) {
                        return true;
                    }
                    return false;
                }
            });
            URL urls[] = new URL[connectionFiles.length];
            int i = 0;
            for (File x : connectionFiles) {
                try {
                    System.out.println("file: " + x.getAbsolutePath());
                    urls[i++] = new URL("jar:file://" + x.getAbsolutePath() + "!/");
                } catch (MalformedURLException ex) {
                    Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            URLClassLoader classLoader = new URLClassLoader(urls);
            for (File x : connectionFiles) {
                try {
                    String packet = x.getName().split("[.]")[0];
                    char clName[] = packet.toCharArray();
                    if (clName[0] >= 97 && clName[0] <= 122) {
                        clName[0] -= 0x20;
                    }
                    System.out.println("load extension: " + "rsc." + packet + "." + new String(clName));
                    try {
                        plugins.add(new PluginContainer(classLoader.loadClass("rsc." + packet + "." + new String(clName))));
                        System.out.println("plugin loeaded");
                    } catch (InvalidClassException ex) {
                        try {
                            modules.add(new ModuleContainer(classLoader.loadClass("rsc." + packet + "." + new String(clName))));
                            System.out.println("module loeaded");
                        } catch (InvalidClassException ex1) {
                            try {
                                connections.add(new ConnectionContainer(classLoader.loadClass("rsc." + packet + "." + new String(clName))));
                                System.out.println("connection loaded");
                            } catch (InvalidClassException ex2) {
                                System.err.println("dyn lib: " + "rsc." + packet + "." + new String(clName) + " is not a module nor a connection");
                            }
                        }
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    System.out.println("caught ex: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void log(Level level, String msg) {
        Logger.getLogger(RSC.class.getName()).log(level, msg);
    }

    public static void log(Level level, Throwable ex) {
        Logger.getLogger(RSC.class.getName()).log(level, null, ex);
    }

    public static void log(Level level, String msg, Throwable ex) {
        Logger.getLogger(RSC.class.getName()).log(level, msg, ex);
    }

    /**
     * innerhalb der main-Methode wird das look and feel gesetzt und das Prgramm
     * durch instantzierung des RSC-Singletons angestossen
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*FileInputStream fis = null;
        try {
        fis = new FileInputStream("/home/wariin/snort.conf");
        Snortconf sc = new Snortconf(fis);
        System.out.println("\n\n-----Result-----\n\n");
        sc.write(System.out);
        fis.close();
        } catch (ConfigurationException ex) {
        log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
        log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        log(Level.SEVERE, null, ex);
        } finally {
        try {
        fis.close();
        } catch (IOException ex) {
        log(Level.SEVERE, null, ex);
        }
        }*/
        try {
            Snortconf sc = SnortFactoryParser.createInstance(new FileInputStream("/etc/snort/snort.conf"));
            //System.out.println(sc.toString());
        } catch (Exception ex) {
            Logger.getLogger(RSC.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            //UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        RSC.getInstance();
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                frontend = new MainFrame();
                frontend.setVisible(true);
            }
            });
    }

    /**
     * Programm sucht beim start sowohl intern als auch extern nach Connection-Modulen
     * auf einen Vector dieser gibt diese Methode zugriff
     * @return alle vom Programm gefundenen externen und internen Connection-Implementierungen
     */
    public Vector<ConnectionContainer> getConnections() {
        return connections;
    }

    /**
     * Programm sucht beim start sowohl intern als auch extern nach Programm-Modulen
     * auf einen Vector dieser gibt diese Methode zugriff
     * @return alle vom Programm gefundenen externen und internen Modul-Implementierungen
     */
    public Vector<ModuleContainer> getModuls() {
        return modules;
    }

    public Vector<PluginContainer> getPlugins() {
        return plugins;
    }
}
