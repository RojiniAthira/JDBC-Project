package Programs;

import java.util.Scanner;

public class information {
	
	public static String[] getInformation() {
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
	
}
