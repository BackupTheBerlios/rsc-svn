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
public class AddressVar implements Command {

    private String name;
    private AddressList addr;

    public AddressVar(String name, AddressList addr) {
        this.name = name;
        this.addr = addr;
        addr.setVar(this);
    }

    public String getName() {
        return name;
    }

    public AddressList getAddresses() {
        return addr;
    }

    public String toString() {
        return "ipvar " + name + " " + addr.printList();
    }
}
