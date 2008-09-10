/*
 * IPSSnort.java
 *
 * Created on January 28, 2007, 7:22 PM
 *
 */

package rsc.backend.modules.ips.backend;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import rsc.backend.modules.ips.IPS;
import rsc.backend.modules.ips.frontend.bak.IPSConfiguratorSnort;
import rsc.frontend.DefaultContentPanelProvider;

/**
 * 
 * @author marcel richter
 */
public class IPSSnort extends DefaultContentPanelProvider {
    private IPS ips;
    private IPSConfiguratorSnort configurator;
    /** Creates a new instance of IPSSnort */
    public IPSSnort(IPS ips) {
        this.ips=ips;
        configurator=new IPSConfiguratorSnort(this);
    }

    public JPopupMenu getPopupMenu() {
        return configurator.getPopupMenu();
    }

    public JPanel getContentPanel() {
        return configurator;
    }

    public void setName(String name) {
    }
    
    public String toString() {
        return "snort.conf";
    }
    
    public String getName() {
        return toString();
    }

    public Icon getClosedIcon() {
        return null;
    }

    public Icon getOpenIcon() {
        return null;
    }
}
