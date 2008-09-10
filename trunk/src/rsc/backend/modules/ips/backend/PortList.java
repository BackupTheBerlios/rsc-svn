package rsc.backend.modules.ips.backend;

import java.util.Vector;

/**
 *
 * @author marcel richter
 */
public class PortList extends Vector<Prt> implements Prt {

    private boolean negator;
    private PortVar var;

    public PortList(boolean negator, PortList ports) {
        super();
        this.negator = negator;
        addAll(ports);
    }

    public PortList(boolean negator, Port port) {
        super();
        this.negator = negator;
        add(port);
    }

    public PortList(Port port) {
        super();
        add(port);
    }

    public PortVar getVar() {
        return var;
    }

    public void setVar(PortVar var) {
        this.var = var;
    }

    public void setNegator(boolean negator) {
        this.negator = negator;
    }

    public String printList() {
        String ret = (negator ? "!" : "") + "[";
        boolean first = true;
        for (Prt x : this) {
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
