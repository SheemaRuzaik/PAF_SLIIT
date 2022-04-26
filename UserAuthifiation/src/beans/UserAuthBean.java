package beans;


import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class UserAuthBean {

	
	private int id ;
	private String user_role, username,password;
	
	public UserAuthBean() {
		
	}
	public int getId() {
		return id;
		
	}
	public UserAuthBean(int id, String username, String password, String user_role) {
		
		this.id = id;
		this.user_role = user_role;
		this.username = username;
		this.password = password;
	
	}
	
	public void setId(int id) {
		
		this.id = id;
	}
	
	public String getRole() {
		
		return user_role;
	}
	
	public void setRole(String user_role) {
		
		this.user_role = user_role;
	}
	
	
	public String getUsername() {
		
		return username;
	}
	
	
	public void setUsername(String username) {
		
		this.username = username;
	}
	
	
	public String getPassword() {
		
		return password;
	}
	
	
	public void setPassword(String password) {
		
		this.password = password;
	}
	
	
	
}
	
