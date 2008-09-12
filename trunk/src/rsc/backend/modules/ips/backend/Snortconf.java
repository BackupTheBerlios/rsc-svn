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

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author marcel richter
 */
public class Snortconf extends AbstractCollection<Snortelement> {

    private Vector<Snortelement> elements;
    private Map<Class, Vector<Snortelement>> subElements;

    public Snortconf() {
        elements = new Vector<Snortelement>();
        subElements = new HashMap<Class, Vector<Snortelement>>();
    }

    public boolean add(Snortelement element) {
        if (getElements(element.getClass()).add(element)) {
            if (elements.add(element)) {
                return true;
            } else {
                if (getElements(element.getClass()).remove(element)) {
                    return false;
                } else {
                    return false;
                    //throw new Exception("inconsistent Snortelement vectors (fatal-error)");
                }
            }
        } else {
            return false;
        }
    }

    public boolean remove(Snortelement element) {
        if (getElements(element.getClass()).remove(element)) {
            if (elements.remove(element)) {
                return true;
            } else {
                if (getElements(element.getClass()).add(element)) {
                    return false;
                } else {
                    return false;
                    //throw new Exception("inconsistent Snortelement vectors (fatal-error)");
                }
            }
        } else {
            return false;
        }
    }

    private Snortelement lastElement() {
        return elements.lastElement();
    }

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

    @Override
    public int size() {
        return elements.size();
    }

    public int size(Class t) {
        return getElements(t).size();
    }

    public Vector<Snortelement> getElements(Class t) {
        Vector<Snortelement> s = subElements.get(t);
        if (s == null) {
            subElements.put(t, s = new Vector<Snortelement>());
        }
        return s;
    }

    public String toString() {
        String ret = "";
        for (Snortelement x : this) {
            ret += x + "\n";
        }
        return ret;
    }

    @Override
    public Iterator<Snortelement> iterator() {
        return elements.iterator();
    }

    /*private class ConfIterator implements Iterator<Snortelement> {

        private Class t;
        int position, globalPosition;

        public ConfIterator(Class t) {
            this.t = t;
            position = 0;
            globalPosition = 0;
        }

        public boolean hasNext() {
            if (position < size(t)) {
                return true;
            }
            return false;
        }

        public Snortelement next() {
            Snortelement ret = null;
            for (; globalPosition < elements.size() && ret == null; globalPosition++) {
                if (t.isInstance(elements.get(globalPosition))) {
                    ret = elements.get(globalPosition);
                }
            }
            position++;
            return ret;
        }

        public void remove() {
            elements.remove(globalPosition);
        }
    }*/
}
