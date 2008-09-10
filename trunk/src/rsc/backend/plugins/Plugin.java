package rsc.backend.plugins;

import rsc.Exportable;
import rsc.frontend.ContentPanelProvider;

/**
 * Plugins are program-extensions on the same level like a host
 * this extensions should use a couple of hosts and configure or doing something else with them
 * 
 * @author marcel richter
 */
public interface Plugin extends ContentPanelProvider, Exportable {

}
