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
