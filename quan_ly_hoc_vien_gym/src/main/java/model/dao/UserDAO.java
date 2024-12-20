package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDatabase.ConnectDatabase;
import model.bean.User;

public class UserDAO {
	private ConnectDatabase connectDatabase;
	
	private Connection conn;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	public UserDAO() {
		connectDatabase = new ConnectDatabase();
	}
	
	// Lấy tất cả đối tượng
	public ArrayList<User> getItems() {
	    ArrayList<User> listUser = new ArrayList<User>();
	    conn = connectDatabase.getConnectMySQL();
	    String sql = "SELECT * FROM users "; // Truy vấn 

	    try {
	        pst = conn.prepareStatement(sql); // Thực hiện câu lệnh sql
	        rs = pst.executeQuery(); // Lấy giá trị của sql

	        while (rs.next()) {
	        	User objUser = new User(
	        		    rs.getInt("UserID"),
	        		    rs.getString("FullName"),
	        		    rs.getString("Email"),
	        		    rs.getString("Password"),
	        		    rs.getString("Phone") ,
	        		    rs.getString("CreatedAt"),
	        		    rs.getString("Role"));
	        	listUser.add(objUser);
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
	    return listUser;
	}
	
	// Thêm đối tượng 
	public boolean addUser(User newUser) {
	    
	    String sql = "INSERT INTO users (FullName, Email, Password, Phone) VALUES (?, ?, ?, ?)";
	    Boolean check = isEmailRegistered(newUser.getEmail());
	    if(check) {
	    	System.out.println("Email đã tồn tại");
	    	return false;
	    }else {
	    	System.out.println("Email chưa tồn tại");
	    }
	    try {
	        conn = connectDatabase.getConnectMySQL(); // Kết nối database
	        pst = conn.prepareStatement(sql);

	        pst.setString(1, newUser.getFullName());
	        pst.setString(2, newUser.getEmail());
	        pst.setString(3, newUser.getPassword());
	        pst.setString(4, newUser.getPhone());

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
	
	
	
	//Lấy đối tượng theo ID 
	public User getItemByID(int ID) {
		User user = null;
		String sql = "SELECT * FROM Users WHERE UserID = ?";
		conn = connectDatabase.getConnectMySQL();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ID);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User(
	                    rs.getInt("UserID"),
	                    rs.getString("FullName"),
	                    rs.getString("Email"),
	                    rs.getString("Password"),
	                    rs.getString("Phone"),
	                    rs.getString("CreatedAt"),
	                    rs.getString("Role")
						);
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
		
		return user;
	}

	// Chỉnh sửa thông tin đối tượng 
	public boolean UpdateItem(User objUser) {
		String sql = "UPDATE Users SET FullName = ?, Phone = ? WHERE UserID = ?";
		
		try {
			conn = connectDatabase.getConnectMySQL();
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, objUser.getFullName());
			pst.setString(2,objUser.getPhone());
			pst.setInt(3, objUser.getUserID());
			
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
	
	//Xóa User
	public boolean DeleteItem (int userID) {
		String sql = "DELETE FROM Users WHERE UserID = ?";
		try {
			conn = connectDatabase.getConnectMySQL();
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, userID); 
	        
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
	
	//Kiểm tra email đã đăng ký chưa
	public boolean isEmailRegistered(String email) {
		String sql = "SELECT COUNT(*) FROM Users WHERE Email = ?";
		
		try {
			conn = connectDatabase.getConnectMySQL();
			pst = conn.prepareStatement(sql);
			pst.setString(1,email);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt(1); // Lấy kết quả từ COUNT(*)
				return count > 0;
			}
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
		return false;
	}
	
	// lấy ra những User đăng ký lịch
	public ArrayList<User> getUserByIDClass(int idClass) {
		ArrayList<User> listUser = new ArrayList<User>();
		String sql = "SELECT u.UserID, u.FullName, u.Email, u.Phone, r.RegisteredAt "
		           + "FROM Users u "
		           + "JOIN Registrations r ON u.UserID = r.UserID "
		           + "WHERE r.ClassID = ?";
		
		try {
			conn = connectDatabase.getConnectMySQL();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idClass);
			rs = pst.executeQuery();
			while(rs.next()) {
				User objUser = new User(
	        		    rs.getInt("UserID"),
	        		    rs.getString("FullName"),
	        		    rs.getString("Email"),
	        		    rs.getString("Phone") ,
	        		    rs.getString("RegisteredAt"));
	        	listUser.add(objUser);
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
		
		return listUser;
	}
}
