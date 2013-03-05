package vn.com.magrabbit.helloworld;

import org.apache.log4j.Logger;

import vn.com.magrabbit.helloworld.action.HelloWorldAction;

import com.jivesoftware.base.event.v2.EventListenerRegistry;
import com.jivesoftware.base.plugin.Plugin;

public class HelloWorldPlugin implements Plugin {

	Logger log = Logger.getLogger(HelloWorldPlugin.class);
	private EventListenerRegistry eventListenerRegistry;
	private HelloWorldAction helloWorldAction;
	public void setEventListenerRegistry(EventListenerRegistry eventListenerRegistry) {
	        this.eventListenerRegistry = eventListenerRegistry;
	    }
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		if ( null != helloWorldAction )
		{
            eventListenerRegistry.unregister(helloWorldAction);
		}
		log.info("Stopping the HelloWorld Plugin...");
	}

	@Override
	public void initPlugin() {
		// TODO Auto-generated method stub
		 helloWorldAction = new HelloWorldAction();
		eventListenerRegistry.register(helloWorldAction);
		log.info("Starting the HelloWorld Plugin...");
	}
}
