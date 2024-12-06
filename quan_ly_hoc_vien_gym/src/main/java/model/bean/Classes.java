package model.bean;

public class Classes {
    private int classId;            // ClassID: Mã lớp học
    private int roomId;             // RoomID: Mã phòng học
    private int ptId;               // PTID: Mã PT phụ trách
    private String className;       // ClassName: Tên lớp học
    private String startTime;       // StartTime: Thời gian bắt đầu
    private String endTime;         // EndTime: Thời gian kết thúc
    private String dateCreate;      // DateCreate: Ngày tạo lớp

    // Constructor mặc định
    public Classes() {}

    // Constructor đầy đủ tham số
    public Classes(int classId, int roomId, int ptId, String className, String startTime, String endTime, String dateCreate) {
        this.classId = classId;
        this.roomId = roomId;
        this.ptId = ptId;
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.dateCreate = dateCreate;
    }
    

    public Classes(int roomId, int ptId, String className, String startTime, String endTime, String dateCreate) {
		super();
		this.roomId = roomId;
		this.ptId = ptId;
		this.className = className;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dateCreate = dateCreate;
	}

	// Getters và Setters
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getPtId() {
        return ptId;
    }

    public void setPtId(int ptId) {
        this.ptId = ptId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    // Phương thức hiển thị thông tin lớp
    public void displayInfo() {
        System.out.println("Class ID: " + classId);
        System.out.println("Room ID: " + roomId);
        System.out.println("PT ID: " + ptId);
        System.out.println("Class Name: " + className);
        System.out.println("Start Time: " + startTime);
        System.out.println("End Time: " + endTime);
        System.out.println("Date Created: " + dateCreate);
    }
}

