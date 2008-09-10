/*
 * TreeElement.java
 *
 * Created on January 20, 2007, 2:59 PM
 *
 */

package rsc.frontend;

import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.tree.MutableTreeNode;

/**
 * all ContentPanelProviders are represented in the Tree
 * this interface requieres methods to display the elements
 * 
 * todo: isRenameable()-Methode hinzufuegen um ein umbennen von nicht umbenennbaren
 * Knoten zu vermeiden
 * @author  marcel richter
 */
public interface TreeElement extends MutableTreeNode {
    /**
     * this method enables the to change names of Tree elements
     * @param name the new name of the TreeNode
     */
    public void setName(String name);
    
    /**
     * this icon is displayed then the TreeNode is closed
     * @return Icon representing this node or null
     */
    public Icon getClosedIcon();
    
    /**
     * this icon is displayed then the TreeNode is opened
     * @return Icon representing this node or null
     */
    public Icon getOpenIcon();
    
    /**
     * you place some general functions here
     * if the user clicks with the right mouse to the tree this menu is displayed
     * @return PopupMenu for this Node
     */
    public JPopupMenu getPopupMenu();
}
