package rsc.backend.modules.ips.backend;

import java.util.Vector;

/**
 *
 * @author marcel richter
 */
public class AddressList extends Vector<Addr> implements Addr {

    private boolean negator;
    private AddressVar var;

    public AddressList(Address addr) {
        super();
        add(addr);
    }

    public void parseState(String state) {
    //grammar auf input ansetzen und objektvariablen neu setzen
    }

    public void setNegator(boolean negator) {
        this.negator = negator;
    }

    public AddressVar getVar() {
        return var;
    }

    public void setVar(AddressVar var) {
        this.var = var;
    }

    public String printList() {
        String ret = (negator ? "!" : "") + "[";
        boolean first = true;
        for (Addr x : this) {
            if (first) {
                ret += x;
                first = false;
            } else {
                ret += "," + x;
            }
        }
        return ret + "]";
    }

    public String toString() {
        if (var != null) {
            return var.getName();
        }
        return printList();
    }
}
