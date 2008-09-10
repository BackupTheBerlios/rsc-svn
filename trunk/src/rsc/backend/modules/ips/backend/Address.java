package rsc.backend.modules.ips.backend;

/**
 *
 * @author marcel richter
 */
public class Address implements Addr {

    private String ip;
    private String subnet;
    private boolean negator;

    public Address(boolean negator, String ip) {

        String b[] = ip.split("/");
        this.ip = b[0];
        if (b.length > 1) {
            this.subnet = b[1];
        }
        this.negator = negator;
    }

    public void parseState(String state) {
    //grammar auf input ansetzen und objektvariablen neu setzen
    }

    public void setNegator(boolean negator) {
        this.negator = negator;
    }

    public String toString() {
        return (negator ? "!" : "") + ip + (subnet != null ? "/" + subnet : "");
    }
}
