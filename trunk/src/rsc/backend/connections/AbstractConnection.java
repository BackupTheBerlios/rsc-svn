/*
 * AbstractConnection.java
 *
 * Created on January 24, 2007, 11:56 PM
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

import java.io.InputStream;
import java.io.OutputStream;
import javax.naming.ConfigurationException;
import org.jdom.Element;


/**
 * Diese abstrakte Klasse fordert 2 Konstruktoren und die statische Methode getName()
 * fuer den Baum
 * @author  marcel richter
 */
public abstract class AbstractConnection implements Connection {
    
    /**
     * Konstruktor um neue Verbindung zu instanzieren
     */
    public AbstractConnection() {
        
    }
    
    /**
     * Konstruktor um serialisierte Verbindung zu instanzieren
     * @param e XML-Element aus dem die Verbindung seine Konfiguration auslesen soll
     */
    public AbstractConnection(Element e) throws ConfigurationException {
        
    } 
    
    /**
     * Methode bietet Zugriff auf den Modul-Namen ohne das Modul zu instanzieren
     * @return Name des Moduls
     */
    public static String getName() {
        return "";
    }
    
    protected Streams createStreams(InputStream in, OutputStream out, InputStream err) { 
        return new StreamsImpl(in,out,err);
    }
    
    class StreamsImpl implements Streams {
        private InputStream in;
        private OutputStream out;
        private InputStream err;
        
        public StreamsImpl(InputStream in,OutputStream out, InputStream err) {
            this.in=in;
            this.out=out;
            this.err=err;
        }
        
        public InputStream getInputStream() {
            return in;
        }
        
        public OutputStream getOutputStream() {
            return out;
        }
        
        public InputStream getErrorStream() {
            return err;
        }
    }
    
}
