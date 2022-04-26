package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import beans.UserAuthBean;
import util.DBConnection;
	
public class AuthUserProcess {


public Response insertUsers(UserAuthBean Authuser ) {
		
	DBConnection dbObj = new DBConnection();
	
	
		Response response;
		
		String output = " ";
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				
				
				return Response.status(Status.INTERNAL_SERVER_ERROR).entity(output).build();
			
			}
			// create a prepared statement
			
			String query = " insert into AuthUser"
					+ "(id,username,password,user_role)"
					+ " values (?, ?, ?, ?)";

			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setInt(1, Authuser.getId());
			preparedStmt.setString(2, Authuser.getUsername());
			preparedStmt.setString(3, Authuser.getPassword());
			preparedStmt.setString(4, Authuser.getRole());

//execute the statement
			preparedStmt.execute();
			output = "{\"status\":\"success\"}";
			response = Response.status(Status.CREATED)
			.entity(output).build();
			con.close();
		} catch (Exception e) {
			output = "{\"status\":"+e.getMessage()+"}";
			response=Response.status(Status.INTERNAL_SERVER_ERROR)
			.entity(output).build();
			System.err.println(e.getMessage());
		}
		
		
		return response;
	}

	public List<UserAuthBean> readUsers() {
		
				return	readUsers(0);
	
	}
	
	public UserAuthBean readUserById(int id) {
		List<UserAuthBean> list =readUsers(id);
			if(!list.isEmpty()) {
				return	list.get(0);
			}
			return null;
	}
	
	
	public List<UserAuthBean> readUsers(int id ) {
		
		DBConnection dbObj = new DBConnection();
		
		List<UserAuthBean> userList = new ArrayList<>();
		try {
			Connection con = dbObj.connect();
			if (con == null) {

				System.out.println("Error While reading from database");
				return userList;
			}
			String query;
			if ( id==0) {
			 
				query = "select * from AuthUser";
			 
			}else {
				
			 query = "select * from AuthUser where id="+id;
			
			}
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				
				UserAuthBean user = new UserAuthBean(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("user_role"));

				userList.add(user);

			}
			con.close();

		} catch (Exception e) {
			System.out.println("error wihile reading");
			System.err.println(e.getMessage());
		}
		return userList;
	}
	
	
	
	
}
