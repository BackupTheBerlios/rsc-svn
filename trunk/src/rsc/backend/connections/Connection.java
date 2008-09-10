/*
 * Connection.java
 *
 * Created on November 1, 2006, 8:22 PM
 *
 */

package rsc.backend.connections;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JPanel;
import org.apache.commons.vfs.FileSystem;
import rsc.Exportable;

/**
 * Das Connection-Interface abstrahiert von der physischen Verbindung zum zu
 * konfigurierenden Host. Es ermoeglicht die Uebertragung von Dateien und das
 * Ausfuehren von Kommandos (Programmen) auf dem verbundenen Rechner.
 * 
 * todo: aufteilen des Connection-Interfaces um Modulen etwas Macht zu entziehen?
 * moeglicherweise kann die Aufteilung durch AbstractConnection realisiert werden
 * in dem noch einige methoden in sie ausgelagert werden
 * @author  marcel richter
 */
public interface Connection extends Exportable {
    /**
     * um eine Connection zu konfigurieren wird im Host-Panel ein Konfigurations-Panel
     * der ausgewaehlten Verbindung dargestellt welches diese Methode verfuegbar macht.
     * @return JPanel des Verbindungs-Konfigurators
     */
    public JPanel getConfigurationPanel();
    /**
     * Methode wird primaer vom Host aufgerufen um die Connection zu verbinden.
     */
    public void connect() throws ConnectionException;
    /**
     * Methode wird primaer vom Host aufgerufen
     */
    public void disconnect();
    /**
     * gibt den Verbindungsstatus der Connection zurueck
     * @return true - wenn verbunden
     * false - sonst
     */
    public boolean isConnected();
    /**
     * diese Methode fuehrt ein Kommando(Programm) auf dem Host aus und gibt dessen
     * Ausgabe zurueck.
     * 
     * todo: der Rueckgabewert wird nicht mituebergeben!!! implementieren!!!!
     * @param command Kommandostring der auf dem Host ausgefuehrt werden soll
     * @return Ausgabe des Programms
     */
    //public String execute(String command, int timeout) throws Exception;
    
    public Streams execute(String command) throws IOException;
    
    interface Streams {
        public InputStream getInputStream();
        public OutputStream getOutputStream();
        public InputStream getErrorStream();
    }
    
    public FileSystem getFileSystem();
    /**
     * entfernt unbenoetigte ConnectionListener
     * @param listener zu entfernender Listener
     */
    public void removeConnectionListener(ConnectionListener listener);
    /**
     * fuegt neue ConnectionListener hinzu
     * @param listener hinzuzufuegender Listener
     */
    public void addConnectionListener(ConnectionListener listener);
}