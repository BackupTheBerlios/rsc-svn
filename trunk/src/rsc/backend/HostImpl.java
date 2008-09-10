/*
 * Host.java
 *
 * Created on November 1, 2006, 9:03 PM
 *
 */
package rsc.backend;

import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultTreeModel;
import org.jdom.Element;
import rsc.CollectionListener;
import rsc.RSC;
import rsc.backend.modules.Module;
import rsc.backend.connections.Connection;
import rsc.backend.connections.ConnectionContainer;
import rsc.backend.connections.ConnectionListener;
import rsc.frontend.DefaultContentPanelProvider;
import rsc.frontend.HostPanel;

/**
 * 
 * @author marcel richter
 */
public class HostImpl extends DefaultContentPanelProvider implements Host, ConnectionListener {

    private Connection connection;
    private DefaultTreeModel dtm;
    private Vector<Module> moduls;
    private Vector<CollectionListener> modulListener;
    private HostPanel panel;
    private String name;
    private Icon openIcon,  closeIcon;

    /** Creates a new instance of Host */
    public HostImpl(Connection c, DefaultTreeModel dtm) {
        setConnection(c);
        this.dtm = dtm;
        moduls = new Vector<Module>();
        modulListener = new Vector<CollectionListener>();
        panel = new HostPanel(this);
        name = "Host";
        initIcons();
    }

    public HostImpl(Element e) {
        String x = e.getAttributeValue("name");
        for (ConnectionContainer cc : RSC.getInstance().getConnections()) {
            if (cc.isInstance(getConnection())) {
                try {
                    connection = cc.newInstance(e);
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                } catch (SecurityException ex) {
                    ex.printStackTrace();
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
        initIcons();
    }

    private void initIcons() {
        openIcon = new ImageIcon(getClass().getResource("/rsc/frontend/icon/host_a_16.png"));
        closeIcon = new ImageIcon(getClass().getResource("/rsc/frontend/icon/host_16.png"));
    }

    public DefaultTreeModel getDTM() {
        return dtm;
    }

    public void export(Element e) {
        Element ee = new Element("host");
        for (ConnectionContainer cc : RSC.getInstance().getConnections()) {
            if (cc.isInstance(getConnection())) {
                cc.export(ee);
            }
        }
        e.addContent(ee);
    }

    public void exportModules(Element e) {

    }

    public JPopupMenu getPopupMenu() {
        return panel.getPopupMenu();
    }

    public JPanel getContentPanel() {
        return panel;
    }

    public void addModul(Module modul) {
        add(modul);
        moduls.add(modul);
        int[] added = new int[1];
        added[0] = this.getIndex(modul);
        dtm.nodesWereInserted(this, added);
        for (CollectionListener l : modulListener) {
            l.elementAdded(modul);
        }
    }

    public void removeModul(Module modul) {
        Object[] objs = new Object[1];
        objs[0] = modul;
        int[] removed = new int[1];
        removed[0] = this.getIndex(modul);
        remove(modul);
        moduls.remove(modul);
        dtm.nodesWereRemoved(this, removed, objs);
        for (CollectionListener l : modulListener) {
            l.elementRemoved(modul);
        }
    }

    public void fireModulChangeEvent(Module modul) {
        for (CollectionListener l : modulListener) {
            l.elementCanged(modul);
        }
    }

    public void addModulListener(CollectionListener listener) {
        modulListener.add(listener);
    }

    public void removeModulListener(CollectionListener listener) {
        modulListener.remove(listener);
    }

    public Vector<Module> getModuls() {
        return moduls;
    }

    public void setConnection(Connection c) {
        connection = c;
        connection.addConnectionListener(this);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName();
    }
    
    public void connectionDisconnecting() {
    }

    public void connectionDisconnect() {
    }

    public void connectionConnect() {
    }

    public Icon getClosedIcon() {
        return closeIcon;
    }

    public Icon getOpenIcon() {
        return openIcon;
    }
}
