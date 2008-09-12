/*
 * LocalConnectionConfigurator.java
 *
 * Created on November 2, 2006, 3:23 PM
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

import rsc.backend.connections.*;

/**
 * 
 * @author marcel richter
 */
public class LocalConnectionConfigurator extends javax.swing.JPanel {
    LocalConnection connection;
    
    /** Creates new form LocalConnectionConfigurator */
    public LocalConnectionConfigurator(LocalConnection c) {
        connection=c;
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24));
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("connected");
        add(jLabel1, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
    
}
