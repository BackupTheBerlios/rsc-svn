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
