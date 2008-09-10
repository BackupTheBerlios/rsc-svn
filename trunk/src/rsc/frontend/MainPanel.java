/*
 * MainPanel.java
 *
 * Created on February 2, 2007, 12:21 AM
 */
package rsc.frontend;

import java.awt.Component;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import rsc.RSC;
import rsc.backend.HostImpl;
import rsc.backend.connections.sshConnection.SSHConnection;
import rsc.backend.plugins.Plugin;
import rsc.backend.plugins.PluginContainer;

/**
 *
 * @author  marcel richter
 */
public class MainPanel extends javax.swing.JPanel implements TreeModelListener, TreeSelectionListener {

    private DefaultTreeModel dtm;

    /** Creates new form MainPanel */
    public MainPanel() {
        initComponents();
        dtm = new EditableDefaultTreeModel(RSC.getInstance());
        dtm.addTreeModelListener(this);
        RSC.getInstance().setDTM(dtm);
        tree.setCellRenderer(new TreeRenderer());
        tree.addTreeSelectionListener(this);
        tree.setModel(dtm);
        EmptyPanel ep = new EmptyPanel();
        sp_main.setRightComponent(ep);
        cmb_add.addItem(new Add());
        for (PluginContainer x : RSC.getInstance().getPlugins()) {
            cmb_add.addItem(new Add(x));
        }


        //begin dummy
        HostImpl h = new HostImpl(new SSHConnection("127.0.0.1", "mariin", "bla", 22), dtm);
        h.setName("dummy1");
        RSC.getInstance().addHost(h);
        h = new HostImpl(new SSHConnection("192.168.0.10", "blob", "bloo", 22), dtm);
        h.setName("dummy2");
        RSC.getInstance().addHost(h);
    //end dummy
    }

    public void updateTree() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tree.updateUI();
            }
        });
    }

    public void elementCanged(Object element) {
        updateTree();
    }

    public void treeStructureChanged(TreeModelEvent e) {
        updateTree();
    }

    public void treeNodesRemoved(TreeModelEvent e) {
        updateTree();
    }

    public void treeNodesInserted(TreeModelEvent e) {
        updateTree();
    }

    public void treeNodesChanged(TreeModelEvent e) {
        updateTree();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pm_tree = new javax.swing.JPopupMenu();
        mi_addHost = new javax.swing.JMenuItem();
        sp_main = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        sp_tree = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        cmb_add = new javax.swing.JComboBox();
        b_add = new javax.swing.JButton();
        b_remove = new javax.swing.JButton();
        p_content = new javax.swing.JPanel();

        mi_addHost.setText("add Host");
        mi_addHost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_addHostActionPerformed(evt);
            }
        });
        pm_tree.add(mi_addHost);

        setMinimumSize(new java.awt.Dimension(700, 500));

        sp_main.setDividerLocation(180);
        sp_main.setDividerSize(5);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        sp_tree.setMinimumSize(new java.awt.Dimension(180, 25));
        sp_tree.setPreferredSize(new java.awt.Dimension(620, 322));

        tree.setEditable(true);
        tree.setMaximumSize(new java.awt.Dimension(600, 480));
        tree.setMinimumSize(new java.awt.Dimension(180, 0));
        tree.setPreferredSize(new java.awt.Dimension(150, 300));
        tree.setRootVisible(false);
        tree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                treeMouseReleased(evt);
            }
        });
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
        sp_tree.setViewportView(tree);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(sp_tree, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(cmb_add, gridBagConstraints);

        b_add.setText("add");
        b_add.setMaximumSize(new java.awt.Dimension(32767, 26));
        b_add.setPreferredSize(new java.awt.Dimension(590, 26));
        b_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_addActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(b_add, gridBagConstraints);

        b_remove.setText("remove");
        b_remove.setEnabled(false);
        b_remove.setMaximumSize(new java.awt.Dimension(32767, 26));
        b_remove.setPreferredSize(new java.awt.Dimension(590, 26));
        b_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_removeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(b_remove, gridBagConstraints);

        sp_main.setLeftComponent(jPanel1);

        javax.swing.GroupLayout p_contentLayout = new javax.swing.GroupLayout(p_content);
        p_content.setLayout(p_contentLayout);
        p_contentLayout.setHorizontalGroup(
            p_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        p_contentLayout.setVerticalGroup(
            p_contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        sp_main.setRightComponent(p_content);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_main, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp_main, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void mi_addHostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_addHostActionPerformed
        RSC.getInstance().addHost(new HostImpl(new SSHConnection(), dtm));
    }//GEN-LAST:event_mi_addHostActionPerformed

    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_treeValueChanged
        sp_main.setRightComponent(((ContentPanelProvider) tree.getLastSelectedPathComponent()).getContentPanel());
    }//GEN-LAST:event_treeValueChanged

    private void treeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeMouseReleased
        TreePath tp;
        if (/*evt.isPopupTrigger()*/evt.getButton() == evt.BUTTON3) {
            tp = tree.getPathForLocation(evt.getX(), evt.getY());
            if (tp != null) {
                ((ContentPanelProvider) tp.getLastPathComponent()).getPopupMenu().show(evt.getComponent(), evt.getX(), evt.getY());
            } else {
                pm_tree.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_treeMouseReleased

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed
        Object item = cmb_add.getSelectedItem();
        if (item != null && item instanceof Add) {
            ((Add) item).add();
        }
    }//GEN-LAST:event_b_addActionPerformed

    private void b_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_removeActionPerformed
        Object selected=tree.getSelectionPath().getLastPathComponent();
        if(selected instanceof HostImpl) {
            RSC.getInstance().removeHost((HostImpl)selected);
        } else if(selected instanceof Plugin) {
            RSC.getInstance().removePlugin((Plugin)selected);
        }
    }//GEN-LAST:event_b_removeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_add;
    private javax.swing.JButton b_remove;
    private javax.swing.JComboBox cmb_add;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mi_addHost;
    private javax.swing.JPanel p_content;
    private javax.swing.JPopupMenu pm_tree;
    private javax.swing.JSplitPane sp_main;
    private javax.swing.JScrollPane sp_tree;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
    private class TreeRenderer extends JLabel implements TreeCellRenderer {

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            if (value instanceof TreeElement) {
                if (expanded) {
                    this.setIcon(((TreeElement) value).getOpenIcon());
                } else {
                    this.setIcon(((TreeElement) value).getClosedIcon());
                }
            } else {
                this.setIcon(null);
            }
            this.setText(value.toString());
            return this;
        }
    }

    private class EditableDefaultTreeModel extends DefaultTreeModel {

        public EditableDefaultTreeModel(TreeNode root) {
            super(root);
        }

        public void valueForPathChanged(TreePath path, Object newValue) {
            if (path.getLastPathComponent() instanceof TreeElement) {
                ((TreeElement) path.getLastPathComponent()).setName(newValue.toString());
            }
        }
    }
    
    private class Add {

        private PluginContainer container;

        public Add() {
            container = null;
        }

        public Add(PluginContainer plugin) {
            container = plugin;
        }

        public String toString() {
            if (container != null) {
                return container.toString();
            }
            return "Host";

        }

        public void add() {
            if (container == null) {
                RSC.getInstance().addHost(new HostImpl(new SSHConnection(), dtm));
            } else {
                try {
                    RSC.getInstance().addPlugin(container.newInstance(RSC.getInstance().getHosts()));
                } catch (Exception ex) {
                    RSC.log(Level.SEVERE, "can't load plugin " + container.toString(), ex);
                }
            }
        }
    }

    public void valueChanged(TreeSelectionEvent e) {
        Object selected=tree.getSelectionPath().getLastPathComponent();
        if(selected instanceof HostImpl || selected instanceof Plugin) {
            b_remove.setEnabled(true);
        } else {
            b_remove.setEnabled(false);
        }
    }
}