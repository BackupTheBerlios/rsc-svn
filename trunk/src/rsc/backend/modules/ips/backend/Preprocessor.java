/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Preprocessor implements Command {

    private String name,  options;

    public Preprocessor(String name) {
        this.name = name;
    }

    public Preprocessor(String name, String options) {
        this.name = name;
        this.options = options.replace("\\\n", "");
    }

    public String toString() {
        if (options != null) {
            return "preprocessor " + name + " :" + options;
        } else {
            return "preprocessor " + name;
        }
    }
}
