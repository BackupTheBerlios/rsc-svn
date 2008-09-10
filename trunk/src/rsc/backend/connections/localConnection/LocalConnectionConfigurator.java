/*
 * LocalConnectionConfigurator.java
 *
 * Created on November 2, 2006, 3:23 PM
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