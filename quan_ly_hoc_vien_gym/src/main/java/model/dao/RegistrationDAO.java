package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectDatabase.ConnectDatabase;
import model.bean.Registration;

public class RegistrationDAO {
	private ConnectDatabase connectDatabase;
	
	private Connection conn;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	public RegistrationDAO() {
		connectDatabase = new ConnectDatabase();
	}
	
	
	//Thêm đối tượng dựa trên IDUser Và IDClass
	public boolean addItem(Registration objRegis) {

		//Kiểm tra người dùng có đăng ký lịch trùng giờ không
	   if(isTimneConflict(objRegis)) {
	    	System.out.println("Không thể đăng ký trùng lịch");
	    	return false;
	    }
	   
		String sql = "INSERT INTO Registrations ( UserID, ClassID ) VALUES (?, ?)";

	    try {
	        conn = connectDatabase.getConnectMySQL(); // Kết nối database
	        pst = conn.prepareStatement(sql);

	        pst.setInt(1, objRegis.getUserId());
	        pst.setInt(2, objRegis.getClassId());

	        // Thực thi câu lệnh SQL
	        int rowsAffected = pst.executeUpdate();

	        return rowsAffected > 0; // Trả về true nếu thêm thành công
	    } catch (SQLException e) {
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
	
	//Kiểm tra người dùng có đăng ký trùng lịch không
	public boolean isTimneConflict(Registration objRegis) {
		 String sql = """
			        SELECT COUNT(*)
			        FROM Registrations R
			        JOIN Classes C1 ON R.ClassID = C1.ClassID
			        JOIN Classes C2 ON C2.ClassID = ?
			        WHERE R.UserID = ?
			          AND C1.DateCreate = C2.DateCreate
			          AND (
			              (C1.StartTime < C2.EndTime AND C1.EndTime > C2.StartTime)
			          )
			    """;
		 
		 try {
			 conn = connectDatabase.getConnectMySQL();
			 pst = conn.prepareStatement(sql);
			 
			 pst.setInt(1, objRegis.getClassId());
			 pst.setInt(2, objRegis.getUserId());
			 
			 rs = pst.executeQuery();
			 
			 if(rs.next()) {
				 return rs.getInt(1) > 0;
			 }
			 
		 } catch (SQLException e) {
		        e.printStackTrace();
		        return true; 
		    } finally {
		        try {
		            if (pst != null) pst.close(); 
		            if (conn != null) conn.close();   
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		 return false;
	}
	
	// Xoá đăng ký theo ID Lớp và ID người dùng
	public boolean deleteRegistrationByClassID(Registration objRegis) {
	    String sql = "DELETE FROM Registrations WHERE ClassID = ? AND UserID = ?";

	    try {
	        conn = connectDatabase.getConnectMySQL();

	        pst = conn.prepareStatement(sql);
	        pst.setInt(1, objRegis.getClassId());
	        pst.setInt(2, objRegis.getUserId());

	        int rowsAffected = pst.executeUpdate();
	        return rowsAffected > 0; 
	    } catch (SQLException e) {
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
