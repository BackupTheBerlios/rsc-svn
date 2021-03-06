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

package rsc.backend.modules.ips;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.ConfigurationException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.tree.TreePath;
import org.apache.commons.vfs.FileObject;
import org.apache.commons.vfs.FileSystemException;
import org.jdom.Element;
import rsc.backend.Host;
import rsc.backend.connections.Connection;
import rsc.backend.modules.DefaultModule;
import rsc.backend.modules.ips.backend.Snortconf;
import rsc.backend.modules.ips.backend.SnortconfChangeListener;
import rsc.backend.modules.ips.backend.parser.SnortFactoryParser;
import rsc.backend.modules.ips.frontend.ConfiguratorPanel;
import rsc.backend.modules.ips.frontend.bak.IPSConfigurator;
import rsc.frontend.TreeElement;

/**
 * dieses modul konfiguriert snort
 * dafuer wird die konfigurationsdatei "snort.conf" geparst und alle elemente in
 * einer gui dargestellt. die konfiguration (inklusive aller rule-files) laesst 
 * sich veraendern und speichern. weiterhin ist auch ein export implementiert 
 * mit dem sich die konfiguration in einer xml-datei ablegen und transportieren laesst
 * darueber wird auch das verteilen der snort-konfiguration auf verschiedene rechner
 * realisiert
 * 
 * @author marcel richter
 */
public class IPS extends DefaultModule {
    private ConfiguratorPanel configurator;
    private String name;
    //private static PatternCompiler pc;
    private Icon openIcon,closeIcon;
    private Snortconf conf;
    private String snortConf="/etc/snort/snort.conf";
    private Vector<SnortconfChangeListener> listeners;
    
    public boolean isConnected() {
        return host.getConnection().isConnected();
    }
    
    public String getSnortConf() {
        return snortConf;
    }
    
    public void setSnortConf(String snortConf) {
        this.snortConf=snortConf;
    }
    
    /** Creates a new instance of IPS */
    public IPS(Host host) {
        super(host);
        name="IPS";
        listeners=new Vector<SnortconfChangeListener>();
        //ruleListener=new Vector<CollectionListener>();
        //rules=new Vector<IPSRule>();
        //snort=new IPSSnort(this);
        //this.add(snort);
        
        //int[] added=new int[1];
        //added[0]=this.getIndex(snort);
        //dtm.nodesWereInserted(this,added);
        
        configurator=new ConfiguratorPanel(this);
        initIcons();
        if(host.getConnection().isConnected()) {
            connectionConnect();
        }
    }
    
    public IPS(Host host, Element e) {
        super(host,e);
        name="IPS";
        listeners=new Vector<SnortconfChangeListener>();
        //ruleListener=new Vector<CollectionListener>();
        //rules=new Vector<IPSRule>();
        //snort=new IPSSnort(this);
        //this.add(snort);
        
        //int[] added=new int[1];
        //added[0]=this.getIndex(snort);
        //dtm.nodesWereInserted(this,added);
        
        configurator=new ConfiguratorPanel(this);
        initIcons();
        if(host.getConnection().isConnected()) {
            connectionConnect();
        }
    }
    
    public void export(Element e) {
        Element ee=new Element("IPS");
        e.addContent(e);
    }
    
    public void addChangeListener(SnortconfChangeListener l) {
        listeners.add(l);
    }
    
    public void removeChangeListener(SnortconfChangeListener l) {
        listeners.remove(l);
    }
    
    private void fireChangeEvent() {
        for(SnortconfChangeListener x:listeners) {
            x.snortconfChanged();
        }
    }
    
    public Snortconf getConf() {
        return conf;
    }
    
    public void connectionConnect() {
        try {
            Connection c = host.getConnection();
            FileObject fo = c.getFileSystem().resolveFile(snortConf);
            if (!fo.isWriteable() && fo.isReadable()) {
                JOptionPane.showMessageDialog(null, "cant write to snort.conf - your changes might be lost", "snort configuration", JOptionPane.INFORMATION_MESSAGE);
            }
            if (!fo.isReadable()) {
                JOptionPane.showMessageDialog(null, "cant read snort.conf", "snort configuration error", JOptionPane.ERROR_MESSAGE);
            }
            conf=SnortFactoryParser.createInstance(fo.getContent().getInputStream());//new Snortconf(fo.getContent().getInputStream());
            fireChangeEvent();
        } catch (ConfigurationException ex) {
            IPS.log(Level.SEVERE, "cant configure ips-configuration", ex);
        } catch (FileSystemException ex) {
            IPS.log(Level.SEVERE, "cant read ips-configuration", ex);
        } catch (Exception ex) {
            Logger.getLogger(IPS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initIcons() {
        openIcon=closeIcon=new ImageIcon(getClass().getResource("/rsc/backend/modules/ips/frontend/icon/ips_16.png"));
    }
    
    public static String getName() {
        return "IPS";
    }
    
    /*static {
        pc=new Perl5Compiler();
    }
    
    synchronized public static Pattern compilePattern(String pattern) throws MalformedPatternException {
        return pc.compile(pattern);
    }*/
    
    public static void log(Level level, String msg) {
         Logger.getLogger(IPS.class.getName()).log(level,msg);
    }
    
    public static void log(Level level, Throwable ex) {
        Logger.getLogger(IPS.class.getName()).log(level,null,ex);
    }
    
    public static void log(Level level, String msg, Throwable ex) {
        Logger.getLogger(IPS.class.getName()).log(level,msg,ex);
    }
    
    /*public Vector<IPSRule> getRules() {
        return rules;
    }
    
    public void addRule(IPSRule rule) {
        this.add(rule);
        rules.add(rule);
        int[] added=new int[1];
        added[0]=this.getIndex(rule);
        dtm.nodesWereInserted(this,added);
        for(CollectionListener l:ruleListener)
            l.elementAdded(rule);
    }
    
    public void removeRule(IPSRule rule) {
        Object[] objs=new Object[1];
        objs[0]=rule;
        int[] removed=new int[1];
        removed[0]=this.getIndex(rule);
        this.remove(rule);
        rules.remove(rule);
        dtm.nodesWereRemoved(this,removed,objs);
        for(CollectionListener l:ruleListener)
            l.elementRemoved(rule);
    }
    
    public void addRulesListener(CollectionListener listener) {
        ruleListener.add(listener);
    }
    
    public void removeRulesListener(CollectionListener listener) {
        ruleListener.remove(listener);
    }*/
    
    public String toString() {
        return name;
    }
    
    public boolean isMultiple() {
        return false;
    }
    
    public JPanel getConfigurator() {
        return configurator;
    }
    
    //falsch!
    public void fireDisconnectEvent() {
        configurator.fireDisconnectEvent();
    }
    
    public boolean isUseable(Connection c) {
        return true;
    }
    
    //should never be called
    public void valueForPathChanged(TreePath path, Object newValue) {
        if(path.getLastPathComponent() instanceof TreeElement)
            ((TreeElement)path.getLastPathComponent()).setName(newValue.toString());
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public JPopupMenu getPopupMenu() {
        return configurator.getPopupMenu();
    }
    
    public JPanel getContentPanel() {
        return configurator;
    }

    public Icon getClosedIcon() {
        return closeIcon;
    }

    public Icon getOpenIcon() {
        return openIcon;
    }

}