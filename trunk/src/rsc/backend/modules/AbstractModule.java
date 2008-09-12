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

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import org.jdom.Element;
import rsc.backend.Host;

/**
 * abstrakte Klasse die die Konstruktoren defniert und einen statischen Zugang zum
 * Namen des Moduls erlaubt (benoetigt fuer den Programmbaum)
 * @author  marcel richter
 */
public abstract class AbstractModule extends DefaultMutableTreeNode implements Module {

    private boolean changed;

    /**
     * Konstruktor um neues Modul zu konstruieren
     * @param host Host auf dem das Modul arbeitet
     */
    public AbstractModule(Host host) {
        host.getConnection().addConnectionListener(this);
    }

    /**
     * mit diesem Konstruktor wird ein Modul inklusive XML-Element erzeugt.
     * Dieser Konstruktor wird benoetigt wenn das Modul nicht die Konfiguration 
     * die auf dem Host speichert benutzen soll. Dies ist zum beispiel dann noetig
     * wenn eine Verbindung unerwartet abbricht nicht wieder aufgebaut werden kann und
     * das Modul andersweitige serialisiert werden soll.
     * @param host Host auf dem das Modul arbeiten soll
     * @param e XML-Element aus dem das Modul seine Konfiguration laden soll
     */
    public AbstractModule(Host host, Element e) {
        host.getConnection().addConnectionListener(this);
    }

    /**
     * diese Methode erlaubt einen Zugriff auf den Modulnamen ohne dieses zu 
     * instanzieren
     * @return Modulname
     */
    public static String getName() {
        return "";
    }

    protected void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void connectionDisconnecting() {
        if (changed) {
            int result = JOptionPane.showConfirmDialog(null, "You are disconnecting from the Host and your module is not saved\nsave it now?", "Save Module?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION) {
                    
            }
        }
    }

    public void connectionDisconnect() {
    }
}
