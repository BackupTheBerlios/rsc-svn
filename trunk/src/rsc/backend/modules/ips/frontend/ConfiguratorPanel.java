/*
 * Configurator.java
 *
 * Created on September 8, 2008, 7:23 PM
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

package rsc.backend.modules.ips.frontend;

import javax.swing.JPopupMenu;
import rsc.backend.modules.ips.IPS;

/**
 *
 * @author  marcel richter
 */
public class ConfiguratorPanel extends javax.swing.JPanel {
    private IPS ips;
    
    /** Creates new form Configurator */
    public ConfiguratorPanel(IPS ips) {
        this.ips=ips;
        //ips.getConf().getConfs(IncludePanel.class);
        initComponents();
        tp_configurator.add("Includes", new IncludePanel(ips));
    }
    
    public void fireDisconnectEvent() {
        
    }
    
    public JPopupMenu getPopupMenu() {
        return pm_ips;
    }
    
    public void refresh() {
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pm_ips = new javax.swing.JPopupMenu();
        mi_addRules = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mi_removeModul = new javax.swing.JMenuItem();
        tp_configurator = new javax.swing.JTabbedPane();
        b_save = new javax.swing.JButton();

        mi_addRules.setText("Item");
        pm_ips.add(mi_addRules);
        pm_ips.add(jSeparator1);

        mi_removeModul.setText("remove Modul");
        pm_ips.add(mi_removeModul);

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(tp_configurator, gridBagConstraints);

        b_save.setText("save Configuration");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        add(b_save, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_save;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem mi_addRules;
    private javax.swing.JMenuItem mi_removeModul;
    private javax.swing.JPopupMenu pm_ips;
    private javax.swing.JTabbedPane tp_configurator;
    // End of variables declaration//GEN-END:variables
    
}
