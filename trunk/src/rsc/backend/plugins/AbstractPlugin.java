package rsc.backend.plugins;

import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;
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
        this.hosts=hosts;
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
