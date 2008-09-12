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
