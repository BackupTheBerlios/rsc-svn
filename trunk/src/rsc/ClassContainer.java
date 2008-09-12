/*
 * ClassContainer.java
 *
 * Created on January 23, 2007, 9:24 PM
 *
 */

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

package rsc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.jdom.Element;
import rsc.backend.connections.ConnectionContainer;

/**
 * der ClassContainer stellt ein vom Typ abstrahiertes (Template) Objekt dar mit
 * dem sich interne sowie vom Programm nachgeladene Klassen verwalten lassen.
 * Erfunden wurde er fuer die nachzuladenen Connections und Module um diese Objekte
 * uninstanziert anzeigen zu koennen (static getName()-Methode wird genutzt).
 * Ausserdem wird von der Instanzierung abstrahiert.
 * @author  marcel richter
 */
public class ClassContainer<T> {
    /**
     * die vom ClassContainer-Objekt verwaltette Klasse
     */
    protected Class<T> cl;
    private T instance;
    
    /**
     * Creates a new instance of ClassContainer
     * @param cl ein Class-Objekt der zu verwaltenen Klasse
     */
    protected ClassContainer(Class<T> cl) {
        this.cl=cl;
    }
    
    /**
     * Diese Methode hilft die verwaltete KLasse mit persistenten Objekten zu 
     * vergleichen. Ergebnis der Methode ist ob das Persistente Objekt (XML) eine 
     * Instanz der verwalteten Klasse ist. Dies wird ueber den nach xML exportierten
     * Namen des Objekts realisiert. Benoetigt wird diese Funktion vor allem wenn
     * die Module und Connections geladen wurden und man die Konfiguration des 
     * Programms wiederherstellen moechte. So koennen fuer die in XML serialisierten 
     * Objekte die korrekten Klassenpedanten gefunden werden.
     * @param e zu testendes XML-Elemnent
     * @return true - wenn das XML-Objekt eine instanz der verwalteten Klasse ist
     */
    public boolean isContainerOf(Element e) {
        if(cl.getName().compareTo(e.getAttributeValue("name"))==0)
            return true;
        return false;                
    }
    
    /**
     * Klassenname der verwalteten Klasse
     * @return Klassenname der verwalteten Klasse
     */
    public String getClassName() {
        return cl.getName();
    }
    
    /**
     * mit dieser Methode kann man einen ClassContainer persistent machen.
     * Dies macht Sinn da nicht nur instanzen gespeichert werden soll.
     * @param e Element in dem ein ClassConatiner-Element erzeugt wird
     */
    public void export(Element e) {
        Element ee=new Element("connection");
        ee.setAttribute("name",getClassName());
        e.addContent(ee);
    }
    
    //todo: check getName must static
    /**
     * Methode wird vor allem verwendet um ClassContainer in graphischen Objekten
     * darzustellen. Ausgegben wird der Name der verwalteten Klasse.
     * 
     * todo: Signatur der Methode sollte vor deren aufruf ueberprueft werden
     * @return Name der verwalteten Klasse
     */
    public String toString() {
        Method m;
        try {
            m = cl.getMethod("getName");
            return (String)m.invoke(null);
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    
    /**
     * Instanziert genau ein Objekt der verwalteten Klasse (Singleton).
     * @return Objekt der verwalteten Klasse
     * @deprecated Methode wird eigentlich nicht mehr benoetigt
     */
    public T getInstnace() throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        if(instance==null)
            instance=cl.newInstance();
        return instance;
    }
    
    /**
     * zu getInstance gehoerende Methode um mit der Brechstange die Singleton-instanz
     * zu aendern
     * @param instance neue Instanz fuer getInstance()
     * @deprecated Methode wird eigentlich nicht mehr benoetigt
     */
    public void setInstance(T instance) {
        this.instance=instance;
    }
    
    /**
     * erzeugt eine neue Instanz der verwalteten Klasse
     * @return Instanz der verwalteten Klasse
     */
    public T newInstance() throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        return cl.newInstance();
    }
    
    /**
     * Um ein Objekt eines ClassConatiners zu instanzieren das serialisiert wurde
     * dient diese Methode.
     * @param e XML-Element in das das zu instanzierende Objekt serialisiert wurde
     * @return instanziertes Objekt
     */
    public T newInstance(Element e) throws InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException {
        Constructor<T> c=cl.getConstructor(e.getClass());
        return c.newInstance(e);
    }
    
    /**
     * Methode prueft ob der Object-Parameter eine instanz der verwalteten Klasse ist
     * @return true - wenn instance instanz der Klasse ist
     * @param instance instanz der zu pruefenden Klasse
     */
    public boolean isInstance(Object instance) {
        return cl.isInstance(instance);
    }
    
    /**
     * Methode sollte Singleton instanz und belibiges Objekt miteinander vergleichen
     * @deprecated gehoert zur Singleton implementierung die nicht mehr benoetigt wird
     * @param obj zu vergleichendes Objekt
     * @return true - wenn das Singleton und das uebergebene Objekt gleich sind
     * false - sonst
     */
    public boolean equals(Object obj) {
        try {
            if(obj instanceof ConnectionContainer && getInstnace().getClass().getCanonicalName().compareTo(((ConnectionContainer)obj).getInstnace().getClass().getCanonicalName())==0)
                return true;
            else
                return false;
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
