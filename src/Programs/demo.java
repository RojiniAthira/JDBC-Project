package Programs;

import java.io.Console;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Console cons = System.console();
		 char[] passwd = cons.readPassword("[%s]", "Password:");
		 if ((cons !=null) && (passwd != null )) {
		     java.util.Arrays.fill(passwd, '*');
		 }
		 String n = new String(passwd);
		 System.out.println(n);
	  
	

	}

}
