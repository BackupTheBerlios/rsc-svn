/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

import java.util.Vector;

/**
 *
 * @author marcel richter
 */
public class Snortconf extends Vector<Snortelement> {

    public AddressVar getAddressVar(String name) {
        for (Snortelement x : this) {
            if (x instanceof AddressVar) {
                return ((AddressVar) x);
            }
        }
        return null;
    }

    public PortVar getPortVar(String name) {
        for (Snortelement x : this) {
            if (x instanceof PortVar) {
                return ((PortVar) x);
            }
        }
        return null;
    }

    public void addComment(String comment) {
        if (!isEmpty() && lastElement() instanceof Comment) {
            ((Comment) lastElement()).add(comment);
        } else {
            add(new Comment(comment));
        }
    }

    public void addComment() {
        if (!isEmpty() && lastElement() instanceof Comment) {
            ((Comment) lastElement()).add();
        } else {
            add(new Comment());
        }
    }

    public Vector<Snortelement> getConfs(Class t) {
        Vector<Snortelement> ret = new Vector<Snortelement>();
        for (Snortelement x : this) {
            if (t.isInstance(x)) {
                ret.add((Include)x);
            }
        }
        return ret;
    }

    public String toString() {
        String ret = "";
        for (Snortelement x : this) {
            ret += x + "\n";
        }
        return ret;
    }
}
