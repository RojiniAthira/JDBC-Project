package Programs;

import java.util.Scanner;

public class information {
	
	public static String[] getInformation() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Email:");
		String email = in.nextLine();
		if(!(validate.isValidEmail(email))) {
			System.out.println();
			System.out.println("Email entered in wrong format.");
			return null;
		}
		System.out.print("Enter Username:");
		String user = in.nextLine();
		if(!(validate.isValidUsername(user))) {
			System.out.println();
			System.out.println("Username entered in wrong format.");
			return null;
		}
		System.out.print("Enter Your Password(Size-8):");
		String password = in.nextLine();
		if(!(validate.isValidPassword(password))) {
			System.out.println();
			System.out.println("Password entered in wrong format.");
			return null;
		}
		System.out.print("Confirm Your Password:");
		String password_1 = in.nextLine();
		boolean t = password_1.equals(password);
		while (!t) {
			System.out.print("!!! Password Doesn't Match !!!");
			return null;
		}
		String[] temp = { user, email, password };
		return temp;
	}
	
}
