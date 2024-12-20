package model.bean;

public class User {
	private int userID;
	
	private String fullName;
	
	private String email;
	
	private String password;
	
	private String phone;
	
	private String createAt;
	
	private String role;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	public User(int userID, String fullName, String email, String password, String phone, String createAt,
			String role) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createAt = createAt;
		this.role = role;
	}

	public User(int userID, String fullName, String email, String password, String phone, String createAt) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createAt = createAt;
	}

	public User(String fullName, String email, String password, String phone) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public User(int userID, String fullName, String email) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
	}

	public User(int userID, String fullName, String email, String phone) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
	}

	public User(int userID, String fullName, String email, String phone, String createAt) {
		super();
		this.userID = userID;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.createAt = createAt;
	}
	
	
}
