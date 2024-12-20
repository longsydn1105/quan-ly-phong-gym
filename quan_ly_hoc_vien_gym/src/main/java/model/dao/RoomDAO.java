package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDatabase.ConnectDatabase;
import model.bean.PT;
import model.bean.Room;
import model.bean.User;

public class RoomDAO {
	private ConnectDatabase connectDatabase;
	
	private Connection conn;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	public RoomDAO() {
		connectDatabase = new ConnectDatabase();
	}
	
	// Lấy tất cả đối tượng
		public ArrayList<Room> getItems() {
		    ArrayList<Room> listRoom = new ArrayList<Room>();
		    conn = connectDatabase.getConnectMySQL();
		    String sql = "SELECT * FROM Rooms "; // Truy vấn 

		    try {
		        pst = conn.prepareStatement(sql); // Thực hiện câu lệnh sql
		        rs = pst.executeQuery(); // Lấy giá trị của sql

		        while (rs.next()) {
		        	Room objRoom = new Room(rs.getInt("RoomID"), 
		        			rs.getString("RoomName"), 
		        			rs.getInt("Capacity"), 
		        			rs.getString("CreatedAt"));
		        	listRoom.add(objRoom);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (pst != null) pst.close();
		            if (conn != null) conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    return listRoom;
		}
		
		// Lấy đối tượng theo ID
		public Room getItemByID(int ID) {
			Room objRoom = null;
			String sql = "SELECT * FROM Rooms WHERE RoomID = ?";
			conn = connectDatabase.getConnectMySQL();
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, ID);
				rs = pst.executeQuery();
				if(rs.next()) {
					objRoom = new Room(rs.getInt("RoomID"), 
							rs.getString("RoomName"), 
							rs.getInt("Capacity"), 
							rs.getString("CreatedAt"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
		        try {
		            if (pst != null) pst.close(); 
		            if (conn != null) conn.close();   
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
			
			return objRoom;
		}
}	
