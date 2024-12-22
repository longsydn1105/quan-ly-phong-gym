package ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	private Connection conn;
	
	private String user;
	
	private String pass;
	
	private String url;
	
	private String db;
	
	public ConnectDatabase() {
		this.db = "ql_phong_gym";
		this.url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=true&characterEncoding=UTF-8";
		this.user = "root";
		this.pass= "TNH_hung2402";
	}
	
	public Connection getConnectMySQL() {
		// Nạp driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(url,user,pass);
			//System.out.println("Kết nối Databse thành công");
		}catch (ClassNotFoundException e) {
            System.err.println("Không tìm thấy driver MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Kết nối tới MySQL thất bại.");
            e.printStackTrace();
        }
		return conn;		
	}
	
	public static void main(String[] args) {
		ConnectDatabase connectDatabase = new ConnectDatabase();
		System.out.println("Kết nối data "+connectDatabase.getConnectMySQL());
	}
}
