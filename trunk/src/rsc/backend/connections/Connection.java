/*
 * Connection.java
 *
 * Created on November 1, 2006, 8:22 PM
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
 * modul/plugin - entwickler:
 * die wichitigsten methoden fuer modul und plugin programmierer sind
 * "execute" und "getFileSystem" weiterhin gibt die "isConnected" methode
 * auskunft ueber den aktuellen status der verbindung. mit der registrierung eines
 * connection-listeners wird einem sofort bei verbindungsverlust oder aufbau eine
 * nachricht geschickt.
 * 
 * connection - entwickler:
 * die methode "getConfigurationPanel" gibt ein JPanel zurueck das im HostPanel
 * bei auswahl der Connection angezeigt wird und es dem anwender ermoeglichen soll
 * die verbindung zu konfigurieren.
 * !cave - zur erstellung einer conncetion bitte AbstractConnection erweitern
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
     * diese Methode fuehrt ein Komando(Programm) auf dem Host aus und gibt
     * Streams zur Ein- und Ausgabe zurueck.
     * 
     * todo: der Rueckgabewert wird nicht mituebergeben!!! implementieren!!!!
     * @param command Kommandostring der auf dem Host ausgefuehrt werden soll
     * @return die ein- und ausgabe-streams des aufgerufenen komandos
     */
    //public String execute(String command, int timeout) throws Exception;
    
    public Streams execute(String command) throws IOException;
    
    interface Streams {
        public InputStream getInputStream();
        public OutputStream getOutputStream();
        public InputStream getErrorStream();
    }
    
    /**
     * um entfernte Rechner zu konfigurieren ist es auch noetig deren 
     * konfigurationsdateien zu lesen/editieren. dafuer wird das 
     * Commons-VFS aus dem jakarta-projekt von apache verwendet.
     * jede connection stellt ein solches vfs zur verfuegung.
     * 
     * @return virtuelles dateisystem auf dem operiert werden kann
     */
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
