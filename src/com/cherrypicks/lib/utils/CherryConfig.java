package com.cherrypicks.lib.utils;

/**
 * CherryPreference contain all the global constant values throughout the
 * application.
 * 
 * @since 1.0.0
 * @author Jerry Zhang<jerryzhang@cherrypicks.com>
 */
public class CherryConfig {

	public static final String MEMBER_URL = "http://findyourmp.parliament.uk/api/search?q=bob&f=js";

	public static final int UPDATE_MEMBER = 0x1001;

	public static final int LOOPER_HTTP_REQUEST = 0;
	public static final int LOOPER_GCM = 1;
	public static final int LOOPER_DATABASE = 2;
	public static final int LOOPER_JSON = 3;
	public static final int LOOPER_UNZIP = 4;
	public static final int LOOPER_FACEBOOK = 5;
	public static final int LOOPER_LOCATION = 6;
}
