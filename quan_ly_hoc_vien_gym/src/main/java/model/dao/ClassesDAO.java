package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDatabase.ConnectDatabase;
import model.bean.Classes;

public class ClassesDAO {
	private ConnectDatabase connectDatabase;
	
	private Connection conn;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	public ClassesDAO() {
		connectDatabase = new ConnectDatabase();
	}
	
	//Hàm thêm một đối tượng mới
	public boolean addItem(Classes objClass) {
		String sql = "INSERT INTO classes(RoomID, PTID, ClassName, StartTime, EndTime, DateCreate)" + 
				"VALUES(?,?,?,?,?,?)";
		conn = connectDatabase.getConnectMySQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objClass.getRoomId());
			pst.setInt(2, objClass.getPtId());
			pst.setString(3, objClass.getClassName());
			pst.setString(4, objClass.getClassName());
			pst.setString(5, objClass.getClassName());
			pst.setString(5, objClass.getDateCreate());
			
			int rowsAffected = pst.executeUpdate();
			
			return rowsAffected > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
	        try {
	            if (pst != null) pst.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
