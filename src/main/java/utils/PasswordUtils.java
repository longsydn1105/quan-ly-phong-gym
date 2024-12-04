package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Iterator;

public class PasswordUtils {

    // Tạo salt ngẫu nhiên
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16]; // 16 bytes = 128-bit salt
        random.nextBytes(saltBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : saltBytes) {
			sb.append(String.format("%02x", b));
		}
        return sb.toString();
    }

    // Hàm băm mật khẩu với SHA-256
    public static String hashPassword(String password, String salt) {
    	try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes()); // Kết hợp salt
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

    public static boolean checkPassword(String inputPassword, String storedHashedPassword, String salt) {
        String hashedInputPassword = hashPassword(inputPassword, salt);
        return hashedInputPassword.equals(storedHashedPassword);
    }
}