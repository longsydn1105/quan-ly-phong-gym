package model.bean;

public class Room {
    private int roomId;            
    private String roomName;      
    private int capacity;          
    private String createdAt;      

    
    public Room() {}

    
    public Room(int roomId, String roomName, int capacity, String createdAt) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.createdAt = createdAt;
    }

    public Room(String roomName, int capacity) {
		super();
		this.roomName = roomName;
		this.capacity = capacity;
	}

	// Getters và Setters
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    
    public void displayInfo() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Name: " + roomName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Created At: " + createdAt);
    }
}
