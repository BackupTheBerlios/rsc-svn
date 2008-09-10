/*
 * ConnectionContainer.java
 *
 * Created on January 22, 2007, 8:16 PM
 *
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
