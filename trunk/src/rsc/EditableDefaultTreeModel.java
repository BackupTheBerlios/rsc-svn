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

package rsc;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import rsc.frontend.TreeElement;

/**
 *
 * @author marcel richter
 */
public class EditableDefaultTreeModel extends DefaultTreeModel {

    public EditableDefaultTreeModel(TreeNode root) {
        super(root);
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
        if (path.getLastPathComponent() instanceof TreeElement) {
            ((TreeElement) path.getLastPathComponent()).setName(newValue.toString());
        }
    }
}
