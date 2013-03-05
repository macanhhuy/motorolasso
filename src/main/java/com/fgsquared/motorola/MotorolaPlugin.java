package com.fgsquared.motorola;

import org.apache.log4j.Logger;

import com.fgsquared.motorola.action.MotorolaAction;
import com.jivesoftware.base.event.v2.EventListenerRegistry;
import com.jivesoftware.base.plugin.Plugin;

public class MotorolaPlugin implements Plugin{
	Logger log = Logger.getLogger(MotorolaPlugin.class);
	private EventListenerRegistry eventListenerRegistry;
	private MotorolaAction motorolaAction;
	public void setEventListenerRegistry(EventListenerRegistry eventListenerRegistry) {
	        this.eventListenerRegistry = eventListenerRegistry;
	    }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		if ( null != motorolaAction )
		{
            eventListenerRegistry.unregister(motorolaAction);
		}
		log.info("Stopping the MotorolaSSO Plugin...");
	}

	@Override
	public void initPlugin() {
		motorolaAction = new MotorolaAction();
		eventListenerRegistry.register(motorolaAction);
		log.info("Starting the MotorolaSSO Plugin...");
	}
}
