/*
 * ContentPanel.java
 *
 * Created on January 20, 2007, 2:32 PM
 *
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
