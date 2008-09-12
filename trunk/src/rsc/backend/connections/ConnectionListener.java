/*
 * ConnectionListener.java
 *
 * Created on January 20, 2007, 5:05 PM
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
