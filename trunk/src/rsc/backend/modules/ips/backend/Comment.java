/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Comment implements Snortelement {

    String comment;

    public Comment() {
        comment = "\n";
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public void add(String comment) {
        this.comment += comment;
    }

    public void add() {
        comment += "\n";
    }

    public String getComment() {
        return comment;
    }

    public String toString() {
        return comment;
    }
}
