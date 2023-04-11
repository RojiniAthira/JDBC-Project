package Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class loginpage {

	private static final String DB_URL = "jdbc:mysql://localhost/javalab";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "athi3154";
	static Connection con;
	static PreparedStatement pst;

	public static void main(String[] args) throws SQLException {

		Scanner in = new Scanner(System.in);

		try {
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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
					register obj1 = new register();
					obj1.registeruser();
					break;
				case "2":
					login obj2 = new login();
					obj2.loginuser();
					break;
				case "3":
					System.out.println("Goodbye!");
					return;
				default:
					System.out.println("!!!!Wrong Entry!!!!");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.close();
		}

	}
}
