package com.minds.client;

import org.junit.Test;
import org.springframework.http.HttpHeaders;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class TestClient {

	@Test
	public void testConnection() {
		String username = "test";
		String password = "test";

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/login?username=" + username + "&password=" + password);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String token = response.getHeaders().get("Authorization").get(0);
		System.out.println(token);
	}

	@Test(expected = RuntimeException.class)
	public void testfFailureConnection() {
		String username = "test2";
		String password = "test";

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/login?username=" + username + "&password=" + password);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testfFailureConnection2() {

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/example/sayHello");

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
	}
	
	@Test
	public void testConnection2() {
		String username = "test";
		String password = "test";

		Client client = Client.create();

		WebResource webResource = client
				.resource("http://localhost:8080/login?username=" + username + "&password=" + password);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String token = response.getHeaders().get("Authorization").get(0);
		System.out.println(token);
		
		Builder builder = client.resource("http://localhost:8080/example/sayHello").header(HttpHeaders.AUTHORIZATION, token);
		response = builder.accept("application/json").get(ClientResponse.class);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		
		String output = response.getEntity(String.class);
		System.out.println("output: " + output);
	}	

}
