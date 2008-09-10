package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Port implements Prt {
    private String number;
    private boolean negator;

    public Port(boolean negator, String number) {
        this.number = number;
        this.negator = negator;
    }

    public String toString() {
        return (negator ? "!" : "") + number;
    }
}
