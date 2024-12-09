package model.bean;

import java.sql.Timestamp;

public class Registration {
    private int registrationId;      // RegistrationID: Mã đăng ký
    private int userId;              // UserID: Mã người dùng
    private int classId;             // ClassID: Mã lớp học
    private Timestamp registeredAt;  // RegisteredAt: Thời gian đăng ký

    // Constructor mặc định
    public Registration() {}

    // Constructor đầy đủ tham số
    public Registration(int registrationId, int userId, int classId, Timestamp registeredAt) {
        this.registrationId = registrationId;
        this.userId = userId;
        this.classId = classId;
        this.registeredAt = registeredAt;
    }

    public Registration(int userId, int classId) {
		super();
		this.userId = userId;
		this.classId = classId;
	}

	public Registration(int registrationId, int userId, int classId) {
		super();
		this.registrationId = registrationId;
		this.userId = userId;
		this.classId = classId;
	}

	// Getters và Setters
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Timestamp getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Timestamp registeredAt) {
        this.registeredAt = registeredAt;
    }

    // Phương thức hiển thị thông tin đăng ký
    public void displayInfo() {
        System.out.println("Registration ID: " + registrationId);
        System.out.println("User ID: " + userId);
        System.out.println("Class ID: " + classId);
        System.out.println("Registered At: " + registeredAt);
    }
}

