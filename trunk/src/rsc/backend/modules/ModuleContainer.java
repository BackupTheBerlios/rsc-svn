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
