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
public class Preprocessor implements Command {

    private String name,  options;

    public Preprocessor(String name) {
        this.name = name;
    }

    public Preprocessor(String name, String options) {
        this.name = name;
        this.options = options.replace("\\\n", "");
    }

    public String toString() {
        if (options != null) {
            return "preprocessor " + name + " :" + options;
        } else {
            return "preprocessor " + name;
        }
    }
    
    public String getName() {
        return "Preprocessor";
    }
}
