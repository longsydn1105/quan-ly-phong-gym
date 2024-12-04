package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    private static Connection con;
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    public static Connection getConnection() {
        con = null;
        Properties properties = new Properties();
        
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("DBConnection.properties")) {
            if (input == null) {
                LOGGER.log(Level.SEVERE, "Không tìm thấy file info.properties trong classpath");
                return null;
            }

            // Tải các cặp key-value từ tệp properties
            properties.load(input);

            // Lấy các thông tin cấu hình từ properties
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");

            // Đăng ký driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            LOGGER.log(Level.INFO, "Kết nối thành công với cơ sở dữ liệu.");
        } catch (SQLException | IOException | ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi kết nối cơ sở dữ liệu: ", ex);
        }
        return con;
    }

    public static void closeConnection(Connection connection) {
        if (con != null) {
            try {
                con.close();
                LOGGER.log(Level.INFO, "Đã đóng kết nối cơ sở dữ liệu.");
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, "Lỗi khi đóng kết nối: ", e);
            }
        }
    }
    
    public static void freeConnection() {
        if (con != null) {
            try {
                con.close();
                LOGGER.log(Level.INFO, "Đã đóng kết nối cơ sở dữ liệu.");
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, "Lỗi khi đóng kết nối: ", ex);
            }
        }
    }

    public static void main(String[] args) {
        // Kiểm tra kết nối
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            System.out.println("Kết nối đã thành công.");
        } else {
            System.out.println("Kết nối không thành công.");
        }
        DBConnection.freeConnection();
    }
}
