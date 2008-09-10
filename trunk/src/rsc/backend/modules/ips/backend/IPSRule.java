/*
 * IPSRules.java
 *
 * Created on January 28, 2007, 7:16 PM
 *
 */

package rsc.backend.modules.ips.backend;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import rsc.backend.modules.ips.IPS;
import rsc.backend.modules.ips.frontend.bak.IPSConfiguratorRules;
import rsc.frontend.DefaultContentPanelProvider;

/**
 * 
 * @author marcel richter
 */
public class IPSRule extends DefaultContentPanelProvider {
    private IPSConfiguratorRules configurator;
    private IPS ips;
    private String name;
    
    /** Creates a new instance of IPSRules */
    public IPSRule(IPS ips, String name) {
        this.name=name;
        this.ips=ips;
        configurator=new IPSConfiguratorRules(this);
    }

    public JPopupMenu getPopupMenu() {
        return configurator.getPopupMenu();
    }

    public JPanel getContentPanel() {
        return configurator;
    }

    public void setName(String name) {
        this.name=name;
    }
    
    public String toString() {
        return name;
    }
    
    public static String getName() {
        return "rules File";
    }

    public Icon getClosedIcon() {
        return null;
    }

    public Icon getOpenIcon() {
        return null;
    }
    
}
