/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class PortVar implements Command {

    private String name;
    private PortList ports;

    public PortVar(String name, PortList ports) {
        this.name = name;
        this.ports = ports;
        ports.setVar(this);
    }

    public String getName() {
        return name;
    }

    public PortList getPorts() {
        return ports;
    }

    public String toString() {
        return "portvar " + name + " " + ports.printList();
    }
}
