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

package rsc.backend.plugins;

import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jdom.Element;
import rsc.backend.Host;

/**
 *
 * @author marcel richter
 * 
 * Klasse muss ueberschrieben werden wenn ein Plugin erstellt werden soll
 * beim Aufruf des Konstruktors werden alle verwalteten Hosts des Programms uebergeben
 * diese koennen dann vom Plugin gesteuert werden
 */
abstract public class AbstractPlugin extends DefaultMutableTreeNode implements Plugin {

    protected Vector hosts;

    /**
     * konstruktor speichert die in der protected hosts-eigenschaft
     * implementierer dieser klasse koennen auf diese hosts zugreifen
     * 
     * die signatur des konstruktors sollte nicht geaendert werden da
     * die software diese signatur verwenden wird
     * 
     * @param hosts alle vom rsc verwalteten hosts
     */
    public AbstractPlugin(Vector<Host> hosts) {
        this.hosts = hosts;
    }

    /**
     * mit diesem konstruktor wird zusaetzlich zu den hosts auch ein xml-element
     * mitgegeben in das sich ein frueheres objekt persistiert hat
     * 
     * diese daten sollen vom ueberschreibenden konstruktor so ausgewertet werden
     * koennen das dieser mit der alten konfiguration starten kann
     * 
     * @param hosts alle vom rsc verwalteten hosts
     * @param e xml-element mit persistierten daten
     */
    public AbstractPlugin(Vector<Host> hosts, Element e) {
        this.hosts = hosts;
    }

    /**
     * plugin-programmierer sollten diese methode ueberschreiben
     * sie stellt statisch den namen des plugins zur verfuegung
     * wird im baum/kombobox(add) angezeigt
     * 
     * @return name des plugins
     */
    public static String getName() {
        return "";
    }
}
