/*
 * AbstractModul.java
 *
 * Created on January 24, 2007, 11:51 PM
 *
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
