package Programs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> userarr = new ArrayList<String>();
		ArrayList<String> passarr = new ArrayList<String>();
		String user = "user4";
		String passwordToHash = "java";
		String generatedPassword = null;

		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");

			// Add password bytes to digest
			md.update(passwordToHash.getBytes());

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

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab", "root",
					"athi3154");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM password ");
			while (rs.next()) {
				userarr.add(rs.getString(1));
				passarr.add(rs.getString(2));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		if (userarr.contains(user) && passarr.contains(generatedPassword)) {
			if ((userarr.indexOf(user)) == (passarr.indexOf(generatedPassword)))
				System.out.println("Authentication Provided");
			else
				System.out.println("Wrong Username or Password");

		} else if (userarr.contains(user) && (!(passarr.contains(generatedPassword)))) {
			System.out.println("Wrong Password");
		} else if (passarr.contains(generatedPassword) && (!(userarr.contains(user)))) {
			System.out.println("Wrong Username");
		} else {
			System.out.println("LOGIN FAILED!!!!");
		}

	}

}
