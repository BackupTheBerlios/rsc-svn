/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    private Map<Class,Integer> count;

    public Snortconf() {
        elements = new Vector<Snortelement>();
        count=new HashMap<Class,Integer>();
    }
    
    public boolean add(Snortelement element) {
        count.put(element.getClass(), size(element.getClass())+1);
        return elements.add(element);
    }
    
    public boolean remove(Snortelement element) {
        count.put(element.getClass(), size(element.getClass())-1);
        return elements.remove(element);
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
        Integer ret=count.get(t);
        return ret==null?0:ret;
    }

    /*public Vector<Snortelement> getConfs(Class t) {
        Vector<Snortelement> ret = new Vector<Snortelement>();
        for (Snortelement x : this) {
            if (t.isInstance(x)) {
                ret.add((Include) x);
            }
        }
        return ret;
    }*/

    public String toString() {
        String ret = "";
        for (Snortelement x : this) {
            ret += x + "\n";
        }
        return ret;
    }
    
    public Iterator iterator(Class t) {
        return new ConfIterator(t);
    }

    @Override
    public Iterator<Snortelement> iterator() {
        return elements.iterator();
    }
    
    private class ConfIterator implements Iterator<Snortelement> {
        private Class t;
        int position,globalPosition;
        
        public ConfIterator(Class t) {
            this.t=t;
            position=0;
            globalPosition=0;
        }

        public boolean hasNext() {
            if(position<size(t)) {
                return true;
            }
            return false;
        }

        public Snortelement next() {
            Snortelement ret=null;
            for(;globalPosition<elements.size() && ret==null;globalPosition++) {
                if(t.isInstance(elements.get(globalPosition))) {
                    ret=elements.get(globalPosition);
                }
            }
            position++;
            return ret;
        }

        public void remove() {
            elements.remove(globalPosition);
        }
    }
}