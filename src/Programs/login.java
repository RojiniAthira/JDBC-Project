package Programs;

//import java.io.Console;
import java.sql.ResultSet;
import java.util.Scanner;

public class login extends loginpage {
	
	public void loginuser() {
		
		System.out.println("--------------------------------------------------------------------------Login"
				+ "------------------------------------------------------------");
		Scanner in = new Scanner(System.in);
//		Console console = System.console();
		try {
			pst = con.prepareStatement("SELECT * FROM password WHERE username = ? AND password_encrypted = ?");
			System.out.print("Enter Username:");
			String user = in.nextLine();
			System.out.print("Enter Password:");
			String password = in.nextLine();
//			char[] passwordArray = console.readPassword("Enter your password: ");
//	        String password = new String(passwordArray);
			pst.setString(1, user);
            pst.setString(2, encryption.encrypt(password));
            ResultSet rs = pst.executeQuery();
            System.out.println();
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
