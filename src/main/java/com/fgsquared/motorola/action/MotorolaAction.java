package com.fgsquared.motorola.action;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import vn.com.magrabbit.helloworld.action.HelloWorldAction;

import com.jivesoftware.base.Group;
import com.jivesoftware.base.event.UserEvent;
import com.jivesoftware.base.event.v2.EventListener;

public class MotorolaAction implements EventListener<UserEvent> {

	Logger log = Logger.getLogger(MotorolaAction.class);
	private Set<String> lstFirstCharacter;

	@Override
	public void handle(UserEvent userEvent) {

		if (userEvent.getType().equals(UserEvent.Type.CREATED)) {
			log.info("USER CREATED!");

		} else if (userEvent.getType().equals(UserEvent.Type.LOGGED_IN)) {
			log.info("USER LOGGED IN!");
		}

		else if (userEvent.getType().equals(UserEvent.Type.MODIFIED)) {
			log.info("USER MODIFIED!");

		}

		else if (userEvent.getType().equals(UserEvent.Type.LOGGED_OUT)) {
			log.info("USER LOGGED_OUT!");

		}

		else if (userEvent.getType().equals(UserEvent.Type.PROFILE_VIEWED)) {
			log.info("USER PROFILE VIEWED!");

		}

	}

	public Set<String> getUserGroups(String stPartner){

		String[] stElement = stPartner.split(",");
		lstFirstCharacter = new HashSet<String>();
		for (int i = 0 ; i < stElement.length ; i++){

		String[] lstElement = stElement[i].trim().split(" ");
		 StringBuilder sbFirstCharacter = new StringBuilder();
		 for (int j= 0 ; j < lstElement.length ; j++){
		sbFirstCharacter.append(lstElement[j].charAt(0));
		}
		 	lstFirstCharacter.add(sbFirstCharacter.toString());
		}
		return lstFirstCharacter;
	}
}
