package vn.com.magrabbit.helloworld.action;

import org.apache.log4j.Logger;

import com.jivesoftware.base.Group;
import com.jivesoftware.base.User;
import com.jivesoftware.base.event.UserEvent;
import com.jivesoftware.base.event.v2.EventListener;
import com.jivesoftware.community.action.admin.AdminActionSupport;

public class HelloWorldAction extends AdminActionSupport implements EventListener<UserEvent>{

	Logger log = Logger.getLogger(HelloWorldAction.class);
	
	private String userName;
	
	@Override
	public String execute() {
		log.info("In the Action class for the HelloWorld Plugin");
		return SUCCESS;
	}
	
	public String getUserName() {
		log.debug("The user name is " + getUser().getUsername());
		return getUser().getUsername();
	}

	@Override
	public void handle(UserEvent userEvent) {
		// TODO Auto-generated method stub
		 if (userEvent.getType().equals(UserEvent.Type.CREATED)) {
			 userName = "CREATED";
			 log.info("USER CREATED!");
			 
			 
		 }
		 else if (userEvent.getType().equals(UserEvent.Type.LOGGED_IN)){
			 userName = "LOGGED_IN";
		
		Iterable<Group> iterable = getJiveContext().getGroupManager().getGroups();
				log.info(iterable.toString());
			 log.info("USER LOGGED IN!");
		 }
		 
		 else if (userEvent.getType().equals(UserEvent.Type.MODIFIED)){
			 log.info("USER MODIFIED!");
			 userName = "MODIFIED";
		 }
		 else {
			 userName = getUser().getUsername();
		 }
		
	}
}
