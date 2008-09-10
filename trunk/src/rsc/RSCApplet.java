/*
 * RSCApplet.java
 *
 * Created on January 31, 2007, 9:27 PM
 *
 */

package rsc;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import rsc.frontend.MainPanel;

/**
 * 
 * @author marcel richter
 */
public class RSCApplet extends javax.swing.JApplet {

    /** Creates a new instance of RSCApplet */
    public RSCApplet() {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        RSC.runAsApplet(true);
        RSC.getInstance();
        this.add(new MainPanel());
    }
    
}
