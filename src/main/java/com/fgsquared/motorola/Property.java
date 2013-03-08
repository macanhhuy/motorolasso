package com.fgsquared.motorola;

import com.jivesoftware.community.JiveGlobals;

public class Property {
	public static final String customFieldID = "customFieldID";

	public static String getCustomfieldid() {
		return JiveGlobals.getJiveProperty( customFieldID);
	}
}
