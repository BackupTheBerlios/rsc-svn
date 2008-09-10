package rsc.backend.plugins;

import java.util.Vector;
import rsc.backend.Host;

/**
 *
 * @author marcel richter
 */
abstract public class AbstractPlugin {
    private Vector hosts;
    
    public AbstractPlugin(Vector<Host> hosts) {
        this.hosts=hosts;
    }
    
    public static String getName() {
        return "";
    }
}
