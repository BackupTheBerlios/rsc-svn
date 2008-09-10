/*
 * Exportable.java
 *
 * Created on January 29, 2007, 12:27 AM
 *
 */

package rsc;

import org.jdom.Element;

/**
 * dieses Interface soll Objekte als XML-exportierbar markieren. durch die
 * implementierung der export-Methode ist es somit moeglich ihnen ein XML-Objekt
 * zur verfuegung zu stellen in das sie sich moeglichst als neues element 
 * eintragen sollen
 * @author  marcel richter
 */
public interface Exportable {
    /**
     * Methode wird vom uebergeordnetem Objekt aufgerufen wenn sich das aufgerufene
     * Objekt als XML-Unterknoten serialisieren soll
     * 
     * Das ruecklesen der XML-Daten erfolgt durch den Konstruktor der implementierenden
     * Klasse
     * @param e XML-Element des uebergeordneten Objekts
     */
    public void export(Element e);
}
