package Programs;

import java.util.regex.Pattern;

public class validate {
	
	public boolean isValidUsername(String username) {
		String match_2 = "[[a-z]+[0-9]+]{8,20}";
		if (Pattern.matches(match_2, "rojini3154")) {
			return true;
		}
		return false;
	}

	public boolean isValidEmail(String email) {
		String match = "^[a-zA-Z0-9_\\-\\.]+@[a-z]+[\\.][a-z]{2,3}$";
		if (Pattern.matches(match, email)) {
			return true;
		}
		return false;
	}
	
	public boolean isValidPassword(String password) {
		String match_1 = "[[A-Z]+[a-z]+[@$!_%&]+[0-9]+]{8,14}";
		if(Pattern.matches(match_1,password)) {
			return true;
		}
		return false;
	}
}
