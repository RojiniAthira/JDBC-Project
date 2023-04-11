package Programs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class md5 {

	public static void main(String[] args) {
		String user = "user2";
		String passwordToHash = "j_a_v_a";
		

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab","root",
					"athi3154");
			PreparedStatement pst = con.prepareStatement("INSERT INTO password VALUES(?,?,?,?)");
			pst.setString(1, user);
			pst.setString(2, getMA5(passwordToHash));
			pst.setString(3, passwordToHash);
			pst.setString(4, "MA5");
			pst.execute();
			con.close();

		} 
		catch (SQLException e) {
			System.out.println(e);
		}

	}
	public static String getMA5(String s) {
		String generatedPassword = null;

		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// Add password bytes to digest
			md.update(s.getBytes());

			// Get the hash's bytes
			byte[] bytes = md.digest();

			// This bytes[] has bytes in decimal format. Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

}
