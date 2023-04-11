package Programs;

import java.sql.ResultSet;
import java.util.Scanner;

public class login extends loginpage {
	
	public static void loginuser() {
		
		System.out.println("--------------------------------------------------------------------------Login"
				+ "------------------------------------------------------------");
		Scanner in = new Scanner(System.in);
		try {
			pst = con.prepareStatement("SELECT * FROM password WHERE username = ? AND password_encrypted = ?");
			System.out.print("Enter Username:");
			String user = in.nextLine();
			System.out.print("Enter Your Password:");
			String password = in.nextLine();
			pst.setString(1, user);
            pst.setString(2, encryption.encrypt(password));
            ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				System.out.println("Login successful!");
			} else {
				System.out.println("Invalid username or password, please try again.");
			}
			System.out.println("---------------------------------------------------------------------------"
					+ "------------------------------------------------------------");

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
