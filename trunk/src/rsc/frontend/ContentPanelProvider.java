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

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 * ein ContentPanelProvider stellt ein JPanel fuer die rechte Seite des Programms
 * zur verfuegung in der der Benutzer seine eingaben taetigt. Des weiteren 
 * wird ein Popup-Menu fuer eine Kontextmenuanfrage im Baum bereit gestellt.
 * 
 * todo: moeglicherweise muss TreeElement von ContentPanelProvider abgeleitet 
 * werden
 * @author  marcel richter
 */
public interface ContentPanelProvider extends TreeElement {
    /**
     * stellt eine Konfigurationsoberflaeche zur Verfuegung
     * @return Eingabeinterface fuer den ausgewaehlten Knoten
     */
    public JPanel getContentPanel();
}
