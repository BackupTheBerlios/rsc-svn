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
