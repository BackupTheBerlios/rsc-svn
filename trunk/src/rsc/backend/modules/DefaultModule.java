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

import javax.swing.tree.DefaultTreeModel;
import org.jdom.Element;
import rsc.backend.Host;

/**
 * Standardimplementierung fuer Module.
 * 
 * todo:
 * Geplant ist ein Interface um die Konfiguration der meisten Module auf dem
 * Host zu speichern. Diese Algorithmen koennen mit dem Namen und einem XML-Baum
 * problemlos abstrhiert vom konkreten Modul implementiert werden
 * @author  marcel richter
 */
public abstract class DefaultModule extends AbstractModule {
    /**
     * Host auf dem das Modul arbeitet
     */
    protected Host host;
    /**
     * DefaultTreeModel um den Baum zu aktualisieren
     * 
     * todo: moeglicherweise ist auch nur ein interface mit den aktualisierungsmethoden
     * noetig / bzw die aktualisierungsmethoden koennten auch im Host stehen.
     * der moeglichkeiten gibt es viele nur ist die richtige noch zu erwaehlen
     */
    protected DefaultTreeModel dtm;
    
    /**
     * Kostruiert ein neues Modul.
     * @param host Host auf dem das Modul arbeiten soll
     */
    public DefaultModule(Host host) {
        super(host);
        this.host=host;
        this.dtm=host.getDTM();
    }
    
    /**
     * Konstruiert ein neues Modul auf Basis der Konfiguration innerhalb eines 
     * XML-Elements.
     * @param host Host auf dem das Modul ausgefuehrt werden soll
     * @param e XML-Element welches die Konfiguration des Moduls enthaellt
     */
    public DefaultModule(Host host, Element e) {
        super(host,e);
        this.host=host;
        this.dtm=host.getDTM();
    }
    
    /**
     * exportiert die aktuelle Konfiguration in ein XML-Element. Dies ist nur 
     * erforderlich wenn der Standardweg der Speicherung auf dem Host wegen
     * Verbindungsunterbrechung unmoeglich ist. 
     * 
     * Bzw. beim Export einer Modul-Konfiguration in eine Datei
     * @param e XML-Element in das exportiert wird
     */
    public void export(Element e) {
        
    }

    /**
     * durch Aufruf dieser Methode wird ein disconnect-Event ausgeloest
     */
    public void fireDisconnectEvent() {
    }
}
