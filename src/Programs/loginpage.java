package Programs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class loginpage {

	private static final String DB_URL = "jdbc:mysql://localhost/javalab";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "athi3154";

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome to login and user registration");
			System.out.println("Please choose an option:");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice:");
			String ch = in.nextLine();
			switch (ch) {
			case "1":
				registeruser();
				break;
			case "2":
				loginuser();
				break;
			case "3":
				System.out.println("Goodbye!");
				return;
			default:
				System.out.println("!!!!Wrong Entry!!!!");
			}
		}
		
	}

	public static void registeruser() {
		
		System.out.println("---------------------------------------------------------User Registration"
				+ "------------------------------------------------------------");
		System.out.println("# Enter your informations correctly.");
		System.out.println("# Check your informations twice before submission.");
		System.out.println("---------------------------------------------------------------------------"
				+ "------------------------------------------------------------");
		String[] info = getinformation();
		if (info == null) {
			System.out.println("!!! User Resgistration Failed.Try it next time. !!!");
			
			return;
		}
		
		try {
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement pst = con.prepareStatement("INSERT INTO password VALUES(?,?,?)");
			pst.setString(1, info[0]);
			pst.setString(2, info[1]);
			pst.setString(3, getMA5(info[1]));
			pst.execute();
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
			//System.out.println("!!! Either username already exsists OR Your password size is out of range. !!!");
		}
		System.out.println("---------------------------------------------------------------------------"
				+ "------------------------------------------------------------");
		
	}

	public static String getMA5(String s) {
		
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(s.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
		
	}

	public static String[] getinformation() {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Username:");
		String user = in.nextLine();
		System.out.print("Enter Your Password(Size-8):");
		String password = in.nextLine();
		System.out.print("Confirm Your Password:");
		String password_1 = in.nextLine();
		boolean t = password_1.equals(password);
		while (!t) {
			System.out.print("!!! Password Doesn't Match !!!");
			return null;
		}
		String[] temp = { user, password };
		return temp;
		
	}

	public static void loginuser() {
		
		System.out.println("--------------------------------------------------------------------------Login"
				+ "------------------------------------------------------------");
		Scanner in = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			PreparedStatement st = con.prepareStatement("SELECT * FROM password WHERE username = ? AND password_encrypted = ?");
			System.out.print("Enter Username:");
			String user = in.nextLine();
			System.out.print("Enter Your Password:");
			String password = in.nextLine();
			st.setString(1, user);
            st.setString(2, getMA5(password));
            ResultSet rs = st.executeQuery();
			if (rs.next()) {
				System.out.println("Login successful!");
			} else {
				System.out.println("Invalid username or password, please try again.");
			}
			System.out.println("---------------------------------------------------------------------------"
					+ "------------------------------------------------------------");
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
