package com.paf.resources;

import java.lang.reflect.Method;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;


import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;

@Provider
public class AppointmentSecurity_Filter implements ContainerRequestFilter {
	public static final String AUTH_HEADER_KEY = "Authorization";
	public static final String AUTH_HEADER_PREFIX = "Basic ";

	@Context
	private ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub

		List<String> AUTHENTICATION_HEADER = requestContext.getHeaders().get(AUTH_HEADER_KEY);

		Method m = resourceInfo.getResourceMethod();

		if (!m.isAnnotationPresent(PermitAll.class)) {
			// Access denied for all
			if (m.isAnnotationPresent(DenyAll.class)) {
				Response unauthoriazedStatus = Response.status(Response.Status.UNAUTHORIZED)
						.entity("{\"Attention 2!\" : \"You are not authorized to Use this service\"}").build();

				requestContext.abortWith(unauthoriazedStatus);

			}
			if (AUTHENTICATION_HEADER != null && AUTHENTICATION_HEADER.size() > 0) {

				String AUTHENTICATION_TOKEN = AUTHENTICATION_HEADER.get(0);

				AUTHENTICATION_TOKEN = AUTHENTICATION_TOKEN.replaceFirst(AUTH_HEADER_PREFIX, "");

				String decodedString = "";

				try {
					byte[] decodedBytes = Base64.getDecoder().decode(AUTHENTICATION_TOKEN);
					decodedString = new String(decodedBytes, "UTF-8");

				} catch (IOException e) {

					e.printStackTrace();
				}
				final StringTokenizer stringtokenizer = new StringTokenizer(decodedString, ":");

				final String username = stringtokenizer.nextToken();

				final String password = stringtokenizer.nextToken();

				if (m.isAnnotationPresent(RolesAllowed.class)) {

					RolesAllowed rolesAnnotation = m.getAnnotation(RolesAllowed.class);

					Set<String> user_role = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

					// check weather the user is a valid user

					ClientConfig clientC = new ClientConfig();

					HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(username, password);
					clientC.register(feature);

					clientC.register(JacksonFeature.class);

					Client c = ClientBuilder.newClient(clientC);
					WebTarget wt;

					if (user_role.contains("admin")) {
						wt = c.target("http://localhost:8066/UserAuthifiation/Authifiation").path("usersAuth");
					} 
					else if (user_role.contains("user")) {
						wt = c.target("http://localhost:8066/UserAuthifiation/Authifiation").path("usersAuth");

					} else {
						wt = c.target("http://localhost:8066/UserAuthifiation/Authifiation").path("usersAuth/deny");
					}

					Invocation.Builder ib = wt.request(MediaType.APPLICATION_JSON);

					Response r = ib.get();

					if (r.getStatus() != 200) {
						Response unauthoriazedStatus = Response.status(Response.Status.UNAUTHORIZED)
								.entity("{\"Attention 2\" : \"You are not authorized to Use this service\"}").build();
						requestContext.abortWith(unauthoriazedStatus);
					}
					return;
				}

			}
		}

		Response unauthoriazedStatus = Response.status(Response.Status.UNAUTHORIZED)
				.entity("{\"Attention 1!\" : \"You are not authorized to Use this service\"}").build();

			requestContext.abortWith(unauthoriazedStatus);
	}
}
