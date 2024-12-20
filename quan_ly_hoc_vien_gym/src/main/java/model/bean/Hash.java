package model.bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Hash {
	public StringBuilder hashPassword(String pass) {
		String salt = "d1a2y3l4a5s6a7l8t9!";
		try {
			// Tạo ra một đối tượng với thuật toán SHA-26
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			String saltPass = salt + pass;
			// Chuyển mật khẩu thành mảng byte
			byte[] hashedBytes = md.digest(saltPass.getBytes());
			
			//Chuyển đổi mảng byte thành dạng hex để lưu trữ và sử dụng
			StringBuilder hexString = new StringBuilder();
			for(byte b : hashedBytes) {
				String hex = Integer.toHexString(0xff & b);
				if(hex.length() == 1 ) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString;
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error hashing password", e);
		}
	}
}
