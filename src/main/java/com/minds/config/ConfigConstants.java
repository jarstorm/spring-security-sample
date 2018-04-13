package com.minds.config;

/**
 * Configuration constants
 */
public class ConfigConstants {
	
	/**
	 * Spring security login url
	 */
	public static final String LOGIN_URL = "/login";
	
	/**
	 * Spring security token prefix
	 */
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	/**
	 * Spring security secret key
	 */
	public static final String SECRET_KEY = "1234";
	
	/**
	 * Spring security token expiration
	 */
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

}
