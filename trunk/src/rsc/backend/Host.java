/*
 * Host.java
 *
 * Created on January 31, 2007, 8:15 PM
 *
 */

package rsc.backend;

import javax.swing.tree.DefaultTreeModel;
import rsc.backend.connections.Connection;
import rsc.frontend.TreeElement;

/**
 * Schnittstelle zum Host so das ein Programm-Modul oder -Plugin diesen
 * konfigurieren kann. Wichtigste Methode ist "getConnection()".
 * Die Connection kapselt die Verbindung zum Host mit der sowohl Befehle auf
 * dem entfernten Rechner ausgefuehrt werden koennen. Auch ist es moeglich damit
 * Dateien zu kopieren.
 * 
 * @author  marcel richter
 */
public interface Host extends TreeElement {
    /**
     * diese Methode gibt das DefaultTreeModel an das Modul so das dieses den 
     * Baum bei bedarf aktualisieren kann
     * @return DefaultTreeModel zur aktualisierung
     */
    public DefaultTreeModel getDTM();
    /**
     * ueber diese Methode wird dem Modul ein Zugang zur Verbindung mit dem Host
     * gegeben
     * @return Verbindung zum Host
     */
    public Connection getConnection();
    /**
     * Der Name des Hosts kann erfragt werden
     * @return Name des Hosts
     */
    public String getName();
}
