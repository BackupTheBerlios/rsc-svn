/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Config implements Command {

    private String name,  options;

    public Config(String name) {
        this.name = name;
    }

    public Config(String name, String options) {
        this.name = name;
        this.options = options;
    }

    public String toString() {
        if (options != null) {
            return "config " + name + " :" + options;
        } else {
            return "config " + name;
        }
    }
}
