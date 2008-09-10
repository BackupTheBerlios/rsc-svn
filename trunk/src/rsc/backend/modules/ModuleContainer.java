/*
 * ConnectionContainer.java
 *
 * Created on January 22, 2007, 8:16 PM
 *
 */

package rsc.backend.modules;

import java.io.InvalidClassException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.swing.tree.DefaultTreeModel;
import org.jdom.Element;
import rsc.ClassContainer;
import rsc.backend.Host;

/**
 * ClassContainer der auf Modul-Klassen getypt wurde.
 * 
 * todo: anstatt Modul sollte AbstractModul verwaltet werden
 * @author  marcel richter
 */
public class ModuleContainer extends ClassContainer<Module> {
    
    /**
     * Instanzierung mit ungetyptem Class-Objekt um den Code der collector-Methoden im
     * RSC-Objekt zu vereinfachen.
     * @param modul Objekt der Modul-Klasse die in diesem Container verwaltet werden soll
     */
    public ModuleContainer(Class module) throws InvalidClassException {
        super((Class<Module>)module);
        if(!Module.class.isAssignableFrom(module))
            throw new InvalidClassException(module.getName(),"class is no subclass of Connection");
    }
    
    /**
     * instanzieren eines neuen Moduls
     * @param host Host zu dem das Modul gehoert
     * @return instanziertes Modul
     */
    public Module newInstance(Host host) throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Constructor<Module> co=cl.getConstructor(Host.class);
        return co.newInstance(host);
    }
    
    /**
     * Instanzierung eines Moduls aus einem XML-Objekt
     * @param host Host zu dem das Modul gehoert
     * @param e XML-Element aus dem das Modul erstellt wird
     * @return instanziertes Modul
     */
    public Module newInstance(Host host, Element e) throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Constructor<Module> co=cl.getConstructor(Host.class, Element.class);
        return co.newInstance(host, e);
    }
}
