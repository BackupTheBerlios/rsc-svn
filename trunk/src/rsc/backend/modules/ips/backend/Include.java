/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Include implements Command {

    private String file;

    public Include(String file) {
        this.file = file;
    }

    public String toString() {
        return "include "+file;
    }
}
