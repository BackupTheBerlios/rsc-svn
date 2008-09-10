/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Rule implements Command {

    private AddressList fromA,  toA;
    private PortList fromP,  toP;
    private String options;
    private String rule;

    public Rule(String rule, AddressList fromA, PortList fromP, AddressList toA, PortList toP, String options) {
        this.rule = rule;
        this.fromA = fromA;
        this.fromP = fromP;
        this.toA = toA;
        this.toP = toP;
        this.options = options.replace("\\\n", "");
    }

    public String toString() {
        return rule + " " + fromA + " " + fromP + " -> " + toA + " " + toP + " (" + options + ")";
    }
}
