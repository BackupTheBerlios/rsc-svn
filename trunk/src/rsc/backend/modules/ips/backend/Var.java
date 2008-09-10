/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Var implements Command {

    private String name,  element;

    public Var(String name, String element) {
        this.name = name;
        this.element = element;
    }

    public String toString() {
        return "var " + name + " " + element;
    }
}
