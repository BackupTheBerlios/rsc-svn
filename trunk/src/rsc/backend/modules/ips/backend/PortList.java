/*
 * Copyright 2008 Marcel Richter
 * 
 * This file is part of RSC (Remote Service Configurator).
 *
 *  RSC is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  RSC is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 */

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
