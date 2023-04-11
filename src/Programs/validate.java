package Programs;

import java.util.regex.Pattern;

public class validate {
	
	public static boolean isValidUsername(String username) {
		String match_2 = "[[a-z]+[0-9]+]{8,20}";
		if (Pattern.matches(match_2, username)) {
			return true;
		}
		return false;
	}

	public static boolean isValidEmail(String email) {
		String match = "^[a-zA-Z0-9_\\-\\.]+@[a-z]+[\\.][a-z]{2,3}$";
		if (Pattern.matches(match, email)) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidPassword(String password) {
		String match_1 = "[[A-Z]+[a-z]+[@$!_%&]+[0-9]+]{8,14}";
		if(Pattern.matches(match_1,password)) {
			return true;
		}
		return false;
	}
}
