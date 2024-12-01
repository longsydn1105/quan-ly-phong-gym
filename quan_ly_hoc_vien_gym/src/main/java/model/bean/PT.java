package model.bean;

public class PT {
    private int ptId;             
    
    private String fullName;       
    
    private String email;       
    
    private String phone;        
    
    private String createdAt;      


    public PT() {}


    public PT(int ptId, String fullName, String email, String phone, String createdAt) {
        this.ptId = ptId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.createdAt = createdAt;
    }

    public PT(String fullName, String email, String phone) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
	}


	public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    // Phương thức hiển thị thông tin PT
    public void displayInfo() {
        System.out.println("PT ID: " + ptId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + (phone != null ? phone : "N/A"));
        System.out.println("Created At: " + createdAt);
    }
}


