package com.minds.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * This filter is used when REST calls are not using a token
 */
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	/**
	 * Authentication manager.
	 */
	private AuthenticationManager authenticationManager;

	/**
	 * Public constructor
	 * 
	 * @param authenticationManager
	 *            authentication manager
	 */
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// Get user name and password from POST call
		String username = obtainUsername(request);
		String password = obtainPassword(request);

		return authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		// Generate a token to send with the response
		String token = Jwts.builder().setIssuedAt(new Date()).setSubject(((User) auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + ConfigConstants.TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, ConfigConstants.SECRET_KEY).compact();

		// Add the header to the response
		response.addHeader(HttpHeaders.AUTHORIZATION, ConfigConstants.TOKEN_BEARER_PREFIX + " " + token);
	}
}
