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
    private Vector<Module> modules;
    private Vector<CollectionListener> modulListener;
    private HostPanel panel;
    private String name;
    private Icon openIcon,  closeIcon;

    /** Creates a new instance of Host */
    public HostImpl(Connection c, DefaultTreeModel dtm) {
        setConnection(c);
        this.dtm = dtm;
        modules = new Vector<Module>();
        modulListener = new Vector<CollectionListener>();
        panel = new HostPanel(this);
        name = "Host";
        initIcons();
    }

    public HostImpl(Element e, DefaultTreeModel dtm) {
        String x = e.getAttributeValue("connection");
        for (ConnectionContainer cc : RSC.getInstance().getConnections()) {
            if(cc.getClassName().equals(x)) {
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
        this.dtm = dtm;
        modules = new Vector<Module>();
        modulListener = new Vector<CollectionListener>();
        panel = new HostPanel(this);
        name = "Host";
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
        ee.setAttribute("connection", connection.getClass().getName());
        /*for (ConnectionContainer cc : RSC.getInstance().getConnections()) {
            if (cc.isInstance(getConnection())) {
                cc.export(ee);
            }
        }*/
        getConnection().export(ee);
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
        modules.add(modul);
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
        modules.remove(modul);
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
        return modules;
    }

    public void setConnection(Connection c) {
        if(connection!=null) {
            connection.removeConnectionListener(this);
        }
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
