package chap04.model;

public class User {
	String user_id;
	String user_password;
	String profile_image_path;
	
	public User(String user_id, String user_password, String profile_image_path) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.profile_image_path = profile_image_path;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getProfile_image_path() {
		return profile_image_path;
	}
	public void setProfile_image_path(String profile_image_path) {
		this.profile_image_path = profile_image_path;
	}
	
	public boolean canLogin(User guest) {
		return this.user_id.equals(guest.user_id) 
				&& this.user_password.equals(guest.user_password);
	}
	
}
