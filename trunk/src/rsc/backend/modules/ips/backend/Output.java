/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Output implements Command {

    private String name,  options;

    public Output(String name) {
        this.name = name;
    }

    public Output(String name, String options) {
        this.name = name;
        this.options = options;
    }

    public String toString() {
        if (options != null) {
            return "output " + name + " :" + options;
        } else {
            return "output " + name;
        }
    }
}
