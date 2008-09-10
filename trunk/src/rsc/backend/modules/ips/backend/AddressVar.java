/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class AddressVar implements Command {

    private String name;
    private AddressList addr;

    public AddressVar(String name, AddressList addr) {
        this.name = name;
        this.addr = addr;
        addr.setVar(this);
    }

    public String getName() {
        return name;
    }

    public AddressList getAddresses() {
        return addr;
    }

    public String toString() {
        return "ipvar " + name + " " + addr.printList();
    }
}
