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

package rsc.backend.plugins;

import rsc.Exportable;
import rsc.frontend.ContentPanelProvider;

/**
 * Plugins are program-extensions on the same level like a host
 * this extensions should use a couple of hosts and configure or doing something else with them
 * 
 * !cave - if you want to implement a plugin please extend AbstractPlugin and not this interface
 * 
 * this interface inherits Exporable to save the plugin configuration
 * and the ContentPanelProvider that is forces the plugin to provide a
 * JPanel for configuration purpose
 * 
 * @author marcel richter
 */
public interface Plugin extends ContentPanelProvider, Exportable {

}
