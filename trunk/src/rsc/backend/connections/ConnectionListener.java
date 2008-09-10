/*
 * ConnectionListener.java
 *
 * Created on January 20, 2007, 5:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package rsc.backend.connections;


/**
 * ConnectionListener sollten vor allem von Modulen genutzt werden um den 
 * Verbindungsstatus zu ueberwachen und gegebenenfalls auf diesen zu reagieren.
 * 
 * todo: ereignis connectionGoesDown() oder ... sollte hinzugefuegt werden
 * @author  marcel richter
 */
public interface ConnectionListener {
    /**
     * Methode wird aufgerufen sobald eine Verbindung etabliert wurde
     */
    public void connectionConnect();
    
    public void connectionDisconnecting();
    /**
     * Methode wird aufgerufen sobald die Verbindung unterbrochen wurde
     */
    public void connectionDisconnect();
}
