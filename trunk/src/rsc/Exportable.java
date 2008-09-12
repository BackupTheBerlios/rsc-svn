/*
 * Exportable.java
 *
 * Created on January 29, 2007, 12:27 AM
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
