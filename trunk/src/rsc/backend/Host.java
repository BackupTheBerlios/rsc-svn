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
