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

package rsc.backend.connections;

import java.io.InvalidClassException;
import org.jdom.Element;
import rsc.ClassContainer;

/**
 * ClassContainer der auf "Connection" getypt wurde.
 * @author  marcel richter
 */
public class ConnectionContainer extends ClassContainer<Connection> {
    
    /**
     * Instanzierung mit ungetyptem Class-Objekt um den Code der collector-Methoden im
     * RSC-Objekt zu vereinfachen.
     * 
     * todo: anstatt Connection sollte AbstactConnection verwaltet werden?
     * @param connection zu verwaltene Klasse vom Typ Connection
     */
    public ConnectionContainer(Class connection) throws InvalidClassException {
        super((Class<Connection>)connection);
        if(!Connection.class.isAssignableFrom(connection))
            throw new InvalidClassException(connection.getName(),"class is no subclass of Connection");
    }
}
