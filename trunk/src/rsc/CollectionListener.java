/*
 * CollectionListener.java
 *
 * Created on January 26, 2007, 7:45 PM
 *
 */

package rsc;

/**
 * collections gibts im programm einen ganzen berg und um die zu ueberwachen 
 * sollten sich objekte als collectionListener bei den Verwalter-Objekten 
 * registrieren.
 * @author marcel richter
 */
public interface CollectionListener {
    /**
     * Methode wird aufgerufen wenn der Collection ein neues Element hinzugefuegt wird
     * 
     * aufruf nach hinzufuegen
     * @param element hinzugefuegtes Objekt
     */
    public void elementAdded(Object element);
    /**
     * Methode wird aufgerufen wenn ein Element aus der Collection entfernt wird
     * 
     * aufruf nach entfernen
     * @param element entferntes Objekt
     */
    public void elementRemoved(Object element);
    /**
     * wenn sich ein Element in der Collection aendert werden registriete Listener
     * mithilfe dieser Methode darueber informiert
     * 
     * aufruf nach aenderung
     * 
     * todo: altes objekt mit geben?
     * @param element geaendertes Objekt
     */
    public void elementCanged(Object element);
}
