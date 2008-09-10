/*
 * Modul.java
 *
 * Created on November 1, 2006, 8:52 PM
 *
 */
package rsc.backend.modules;

import rsc.Exportable;
import rsc.backend.Host;
import rsc.backend.connections.Connection;
import rsc.backend.connections.ConnectionListener;
import rsc.frontend.ContentPanelProvider;

/**
 * Schnittstelle fuer interne und externe Module
 * 
 * cave! - es muss AbstractModule erweitert werden um ein Modul zu implementieren
 * 
 * @author  marcel richter
 */
public interface Module extends ContentPanelProvider, Exportable, ConnectionListener {

    /**
     * gibt Auskunft darueber ob das Modul 1 oder mehrmals geladen werden kann
     * 
     * todo: lieber anzahl zurueck geben
     * @return ein oder mehrere Instanzen
     */
    boolean isMultiple();

    /**
     * diese Methode gibt auskunft ob das Modul auf dem Host benutzbar ist. hierfuer
     * wird eine Verbindung uebergeben mit der dies getestet werden kann
     * @param c Verbindung die zum Test genutzt werden soll
     * @return true - wenn das Modul benutzbar ist
     * false - sonst
     */
    boolean isUseable(Connection c);
    
}
