/*
 * ConnectionContainer.java
 *
 * Created on January 22, 2007, 8:16 PM
 *
 */

package rsc.backend.plugins;

import rsc.backend.modules.*;
import java.io.InvalidClassException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;
import org.jdom.Element;
import rsc.ClassContainer;
import rsc.backend.HostImpl;

/**
 * ClassContainer der auf Modul-Klassen getypt wurde.
 * 
 * todo: anstatt Modul sollte AbstractModul verwaltet werden
 * @author  marcel richter
 */
public class PluginContainer extends ClassContainer<Plugin> {
    
    /**
     * Instanzierung mit ungetyptem Class-Objekt um den Code der collector-Methoden im
     * RSC-Objekt zu vereinfachen.
     * @param modul Objekt der Modul-Klasse die in diesem Container verwaltet werden soll
     */
    public PluginContainer(Class plugin) throws InvalidClassException {
        super((Class<Plugin>)plugin);
        if(!Plugin.class.isAssignableFrom(plugin))
            throw new InvalidClassException(plugin.getName(),"class is no subclass of Connection");
    }
    
    /**
     * instanzieren eines neuen Plugins
     * @param host Host zu dem das Modul gehoert
     * @return instanziertes Modul
     */
    public Plugin newInstance(Vector<HostImpl> hosts) throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Constructor<Plugin> co=cl.getConstructor(Vector.class);
        return co.newInstance(hosts);
    }
    
    /**
     * Instanzierung eines Plugins aus einem XML-Objekt
     * @param host Host zu dem das Modul gehoert
     * @param e XML-Element aus dem das Modul erstellt wird
     * @return instanziertes Modul
     */
    public Plugin newInstance(Vector<HostImpl> hosts, Element e) throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Constructor<Plugin> co=cl.getConstructor(Vector.class, Element.class);
        return co.newInstance(hosts, e);
    }
}
