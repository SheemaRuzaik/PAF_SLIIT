package com;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONObject;
import beans.UserAuthBean;
import model.AuthifiationUser;
import model.AuthUserProcess;

@Path("/usersAuth")
public class AuthifiationService {


	AuthUserProcess authObject = new AuthUserProcess();
		
		@RolesAllowed({ "admin","user"})
		@GET
		@Path("/")
		@Produces(MediaType.APPLICATION_JSON)
		public Response readusers() {
			List <UserAuthBean> list;
			Response response;
			list =authObject.readUsers();
			 response=Response.ok(authObject.readUsers()).build();
			
			if (!list.isEmpty()) {
			return response;
			}
			return Response.noContent().build(); 
		}
		
		
		@RolesAllowed({"admin"})
		@GET
		@Path("/{userId}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response ViewUserById(@PathParam("userId") int id) {
			UserAuthBean user = authObject.readUserById(id);
			if (user !=null) {
				return	Response.ok().entity(authObject.readUserById(id)).build();
			}
			return	Response.noContent().build();
			}
		
		

		@RolesAllowed({"admin"})
		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response insertUsersCredentials(UserAuthBean user) {
			Response response =	authObject.insertUsers(user);
			return response;
			
			
		} 
	
	
		

}
