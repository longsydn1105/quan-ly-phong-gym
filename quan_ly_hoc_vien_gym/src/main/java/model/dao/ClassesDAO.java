package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			pst.setString(4, objClass.getStartTime());
			pst.setString(5, objClass.getEndTime());
			pst.setString(6, objClass.getDateCreate());
			
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
	
	//Hàm lấy ra tất cả đối tượng
	public ArrayList<Classes> getItems() {
		ArrayList<Classes> listItems = new ArrayList<Classes>();
		String sql = "SELECT * FROM classes";
		
		try {
			conn = connectDatabase.getConnectMySQL();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				Classes objClass = new Classes(
						rs.getInt("ClassID"), 
						rs.getInt("RoomID"), 
						rs.getInt("PTID"), 
						rs.getString("ClassName"), 
						rs.getString("StartTime"), 
						rs.getString("EndTime"), 
						rs.getString("DateCreate"));
				
				listItems.add(objClass);
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
		
		return listItems;
	}
	
	// Láy đối tượng theo ID
	public Classes getClassByID(int classID) {
		Classes objClass = null;
		String sql = "SELECT * FROM classes WHERE ClassID = ?";
		
		try {
			conn = connectDatabase.getConnectMySQL();
			pst = conn.prepareStatement(sql);
			pst.setInt(1, classID);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				objClass = new Classes(
						rs.getInt("ClassID"), 
						rs.getInt("RoomID"), 
						rs.getInt("PTID"), 
						rs.getString("ClassName"), 
						rs.getString("StartTime"), 
						rs.getString("EndTime"), 
						rs.getString("DateCreate"));
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
		
		return objClass;
	}
	
	// Xoá đối tượng theo ID
	public boolean DeleteClassByID (int classID) {
		String sql = "DELETE FROM classes WHERE ClassID = ?";
		try {
			conn = connectDatabase.getConnectMySQL();
			pst = conn.prepareStatement(sql);
			
			pst.setInt(1, classID); 
	        
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
	
		//Hàm lấy ra tất cả đối tượng có thời gian hiện tại và tương lai
		public ArrayList<Classes> getItemsUpComing() {
			ArrayList<Classes> listItems = new ArrayList<Classes>();
			String sql = "SELECT * FROM classes WHERE DateCreate >= CURRENT_DATE";
			
			try {
				conn = connectDatabase.getConnectMySQL();
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					Classes objClass = new Classes(
							rs.getInt("ClassID"), 
							rs.getInt("RoomID"), 
							rs.getInt("PTID"), 
							rs.getString("ClassName"), 
							rs.getString("StartTime"), 
							rs.getString("EndTime"), 
							rs.getString("DateCreate"));
					
					listItems.add(objClass);
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
			
			return listItems;
		}
		
		//Lấy ra những lớp mà user đã đăng ký( Có thời gian ở hiện tại và tương lai)
		public ArrayList<Classes> getUpcomingClassesByUser(int userId) {
		    ArrayList<Classes> listClasses = new ArrayList<>();
		    String sql = "SELECT C.* " +
		                 "FROM Classes C " +
		                 "JOIN Registrations R ON C.ClassID = R.ClassID " +
		                 "JOIN Users U ON R.UserID = U.UserID " +
		                 "WHERE U.UserID = ? AND C.DateCreate >= CURRENT_DATE";

		    try {
		        conn = connectDatabase.getConnectMySQL();
		        pst = conn.prepareStatement(sql);
		        pst.setInt(1, userId); // Thay thế tham số UserID

		        rs = pst.executeQuery();

		        while (rs.next()) {
		            Classes objClass = new Classes(
		                rs.getInt("ClassID"),
		                rs.getInt("RoomID"),
		                rs.getInt("PTID"),
		                rs.getString("ClassName"),
		                rs.getString("StartTime"),
		                rs.getString("EndTime"),
		                rs.getString("DateCreate")
		            );
		            listClasses.add(objClass);
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

		    return listClasses;
		}
		
		
		//Hàm xoá lớp theo ID(Xoá nhưng đăng ký trước khi xoá lớp)
		public boolean deleteClassWithRegistrations(int classID) {
		    Connection conn = null;
		    PreparedStatement pstDeleteRegistrations = null;
		    PreparedStatement pstDeleteClass = null;
		    boolean isDeleted = false;

		    try {
		        conn = connectDatabase.getConnectMySQL();

		        conn.setAutoCommit(false);

		        // Xóa các đăng ký liên quan trong bảng Registrations
		        String deleteRegistrationsSql = "DELETE FROM Registrations WHERE ClassID = ?";
		        pstDeleteRegistrations = conn.prepareStatement(deleteRegistrationsSql);
		        pstDeleteRegistrations.setInt(1, classID);
		        pstDeleteRegistrations.executeUpdate();

		        // Xóa lớp trong bảng Classes
		        String deleteClassSql = "DELETE FROM Classes WHERE ClassID = ?";
		        pstDeleteClass = conn.prepareStatement(deleteClassSql);
		        pstDeleteClass.setInt(1, classID);
		        int rowsAffected = pstDeleteClass.executeUpdate();

		        if (rowsAffected > 0) {
		            isDeleted = true;
		        }

		        // Commit transaction
		        conn.commit();

		    } catch (SQLException e) {
		        e.printStackTrace();
		        try {
		            if (conn != null) {
		                conn.rollback(); // Hoàn tác nếu có lỗi
		            }
		        } catch (SQLException rollbackEx) {
		            rollbackEx.printStackTrace();
		        }
		    } finally {
		        try {
		            if (pstDeleteRegistrations != null) pstDeleteRegistrations.close();
		            if (pstDeleteClass != null) pstDeleteClass.close();
		            if (conn != null) conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		    return isDeleted;
		}
		
}
