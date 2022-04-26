package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Set;

import util.DBConnection;

public class AuthifiationUser {


	 public static boolean is_User_Allowed_Access(final String username, final String password, final Set<String> rolesSet)
     {
		 
			DBConnection dbObj = new DBConnection();
		 
         boolean is_Allowed_Access = false;
         
         String userrole = "" , user_name = "", uesrpw = "" ;
         
         try {
     		Connection connection = dbObj.connect();
     		
     		if (connection == null) {
     			
     			
     		}
     		// create a prepared statement
     		String query = "SELECT * FROM AuthUser where username='"+username+"' and password='"+password+"'";
     		
     		PreparedStatement preparedStatement = connection.prepareStatement(query);
     		
     	
     		preparedStatement.execute();
     //execute the statement
     		  ResultSet resultSet = preparedStatement.executeQuery(query);
     		 
     		  if(resultSet.next()) {
     			 user_name  = resultSet.getString("username");
     			 uesrpw = resultSet.getString("password");
     			 userrole=resultSet.getString("user_role");
     			 
     		  }
     		 connection.close();
     		  
     		  
     	} catch (Exception e) {
     				
     				System.err.println(e.getMessage());
     			}
         
         if(username.equals(user_name) && password.equals(uesrpw))
         {
              
             //Step 2. Verify user role
             if(rolesSet.contains(userrole))
             {
            	 
            	 is_Allowed_Access  = true;
                 System.out.println(username +" "+password );
             }
         }
         return is_Allowed_Access ;
         
     }

	

}