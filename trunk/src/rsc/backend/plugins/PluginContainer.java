/*
 * ConnectionContainer.java
 *
 * Created on January 22, 2007, 8:16 PM
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
