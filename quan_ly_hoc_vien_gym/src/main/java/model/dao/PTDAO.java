package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ConnectDatabase.ConnectDatabase;
import model.bean.PT;


public class PTDAO {
	
	private ConnectDatabase connectDatabase;
	
	private Connection conn;
	
	private PreparedStatement pst;
	
	private ResultSet rs;
	
	public PTDAO() {
		connectDatabase = new ConnectDatabase();
	}
	// Lấy tất cả đối tượng
		public ArrayList<PT> getItems() {
		    ArrayList<PT> listPT = new ArrayList<PT>();
		    conn = connectDatabase.getConnectMySQL();
		    String sql = "SELECT * FROM pt "; // Truy vấn 

		    try {
		        pst = conn.prepareStatement(sql); // Thực hiện câu lệnh sql
		        rs = pst.executeQuery(); // Lấy giá trị của sql

		        while (rs.next()) {
		        	PT objPT = new PT(
		        		    rs.getInt("PTID"),
		        		    rs.getString("FullName"),
		        		    rs.getString("Email"),
		        		    rs.getString("Phone"),
		                    rs.getString("CreatedAt")
		        		    );
		        	listPT.add(objPT);
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
		    return listPT;
		}
		// Thêm đối tượng 
		public boolean addPT(PT newPT) {
		    
		    String sql = "INSERT INTO pt ( FullName, Email, Phone) VALUES (?, ?, ?)";

		    try {
		        conn = connectDatabase.getConnectMySQL(); // Kết nối database
		        pst = conn.prepareStatement(sql);

		        pst.setString(1, newPT.getFullName());
		        pst.setString(2, newPT.getEmail());
		        pst.setString(3, newPT.getPhone());

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
		public PT getItemByID(int ID) {
			PT pt = null;
			String sql = "SELECT * FROM users WHERE PTID = ?";
			conn = connectDatabase.getConnectMySQL();
			
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, ID);
				rs = pst.executeQuery();
				if(rs.next()) {
					pt = new PT(
		                    rs.getInt("PTID"),
		                    rs.getString("FullName"),
		                    rs.getString("Email"),
		                    rs.getString("Phone"),
		                    rs.getString("CreatedAt")
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
			
			return pt;
		}
		// Xóa PT 
		public boolean DeleteItem (int ptID) {
			String sql = "DELETE Users WHERE PTID = ?";
			try {
				conn = connectDatabase.getConnectMySQL();
				pst = conn.prepareStatement(sql);
				
				pst.setInt(1, ptID); 
		        
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
		// Chỉnh sửa thông tin PT
		public boolean UpdateItem(PT objPT) {
			String sql = "UPDATE PT SET FullName = ?, Email = ? WHERE PTID = ?";
			
			try {
				conn = connectDatabase.getConnectMySQL();
				pst = conn.prepareStatement(sql);
				
				pst.setString(1, objPT.getFullName());
				pst.setString(2,objPT.getEmail());
				pst.setInt(3, objPT.getPtId());
				
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

