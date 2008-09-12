/*
 * DefaultContentPanel.java
 *
 * Created on January 28, 2007, 5:50 PM
 *
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

package rsc.frontend;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * abstrakte Klasse die die DefaultMutableTreeNode als Implementierung fuer 
 * ContentPanelProvider includiert.
 * @author  marcel richter
 */
abstract public class DefaultContentPanelProvider extends DefaultMutableTreeNode implements ContentPanelProvider {
    
}
