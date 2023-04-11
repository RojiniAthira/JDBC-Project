package Programs;

import java.io.Console;
import java.util.regex.Pattern;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String match = "^[a-zA-Z0-9_\\-\\.]+@[a-z]+[\\.][a-z]{2,3}$";
//		System.out.println(Pattern.matches(match,"vickyclans3@gmail.com"));
//		
//		String match_1 = "[[A-Z]+[a-z]+[@$!_%&]+[0-9]+]{8,14}";
//		System.out.println(Pattern.matches(match_1,"At!314"));
		
		String match_2 = "[[a-z]+[0-9]+]{8,20}";
		System.out.println(Pattern.matches(match_2, "rojini3154"));
		
	  
	

	}

}
