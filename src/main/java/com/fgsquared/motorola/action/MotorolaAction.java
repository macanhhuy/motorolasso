package com.fgsquared.motorola.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.docverse.frontend.web.SettingsAction;
import com.fgsquared.motorola.Property;
import com.jivesoftware.base.Group;
import com.jivesoftware.base.GroupManager;
import com.jivesoftware.base.User;
import com.jivesoftware.base.UserManager;
import com.jivesoftware.base.event.UserEvent;
import com.jivesoftware.base.event.v2.EventListener;
import com.jivesoftware.community.lifecycle.JiveApplication;
import com.jivesoftware.community.user.profile.ProfileField;
import com.jivesoftware.community.web.soy.functions.GetJivePropertyFunction;
import com.jivesoftware.community.web.soy.functions.map.Map;

public class MotorolaAction implements EventListener<UserEvent> {

	Logger log = Logger.getLogger(MotorolaAction.class);
	private Set<String> lstFirstCharacter;
	private UserManager userManager;
	private GroupManager groupManager;
	private String userGroupField;
	private Set<String> userGroup;
	@Override
	public void handle(UserEvent userEvent) {

		if (userEvent.getType().equals(UserEvent.Type.CREATED)) {
			log.info("USER CREATED!");

		} else if (userEvent.getType().equals(UserEvent.Type.LOGGED_IN)) {
			log.info("USER LOGGED IN!");
			User user = userEvent.getPayload();
			log.info("Username: " + user.getUsername());
			log.info("----------GROUP--------");
			for (Group g2 : JiveApplication.getContext().getGroupManager()
					.getUserGroups(user)) {
				log.info(g2.getName());
			}
			log.info("----------ALL GROUP--------");
			HashMap<Long, String> hashMap = new HashMap<Long, String>();
			for (Group g : JiveApplication.getContext().getGroupManager()
					.getGroups()) {
				hashMap.put(g.getID(), g.getName());
				log.info("ID:" + g.getID() + " - Name: " + g.getName());
			}
			log.info("----------------------");
			
			log.info("----------CUSTOM FIELDS--------");
			userGroupField = JiveApplication.getContext().getProfileManager()
					.getProfile(user)
					.get(new Long(Property.getCustomfieldid())).getValue();
			
			log.info(userGroupField);
			userGroup = getUserGroups(userGroupField);
			for(String grp : userGroup){
				log.info(grp);
				log.info(hashMap.toString());
			}

			
			// for (Group group :
			// getJiveContext().getGroupManager().getUserGroups(currentUser)) {
			// log.info("Group "+ group);
			// }

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

	public Set<String> getUserGroups(String stPartner) {

		String[] stElement = stPartner.split(",");
		lstFirstCharacter = new HashSet<String>();
		for (int i = 0; i < stElement.length; i++) {

			String[] lstElement = stElement[i].trim().split(" ");
			StringBuilder sbFirstCharacter = new StringBuilder();
			for (int j = 0; j < lstElement.length; j++) {
				sbFirstCharacter.append(lstElement[j].charAt(0));
			}
			lstFirstCharacter.add(sbFirstCharacter.toString());
		}
		return lstFirstCharacter;
	}
}
