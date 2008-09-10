/*
 * AbstractConnection.java
 *
 * Created on January 24, 2007, 11:56 PM
 *
 */

package rsc.backend.connections;

import java.io.InputStream;
import java.io.OutputStream;
import javax.naming.ConfigurationException;
import org.jdom.Element;


/**
 * Diese abstrakte Klasse fordert 2 Konstruktoren die statische Methode getName()
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
