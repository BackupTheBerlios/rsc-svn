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
