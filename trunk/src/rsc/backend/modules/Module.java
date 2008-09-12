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
