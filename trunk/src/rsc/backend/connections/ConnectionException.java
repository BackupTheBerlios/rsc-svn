/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rsc.backend.connections;

/**
 *
 * @author wariin
 */
public class ConnectionException extends Exception {

    /**
     * Creates a new instance of <code>ConnectionException</code> without detail message.
     */
    public ConnectionException() {
    }


    /**
     * Constructs an instance of <code>ConnectionException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ConnectionException(String msg) {
        super(msg);
    }
}
