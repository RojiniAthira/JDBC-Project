package Programs;

import java.sql.SQLException;

public class register extends loginpage {
	
	public static void registeruser() {
		
		System.out.println("---------------------------------------------------------User Registration"
				+ "------------------------------------------------------------");
		System.out.println("# Enter your informations correctly.");
		System.out.println("# Check your informations twice before submission.");
		System.out.println("---------------------------------------------------------------------------"
				+ "------------------------------------------------------------");
		String[] info = information.getInformation();
		if (info == null) {	
			System.out.println("!!! User Resgistration Failed.Try it next time. !!!");
			
			return;
		}
		
		try {
			pst = con.prepareStatement("INSERT INTO password VALUES(?,?,?)");
			pst.setString(1, info[0]);
			pst.setString(2, info[1]);
			pst.setString(3, encryption.encrypt(info[1]));
			pst.execute();
			
		} catch (SQLException e) {
			System.out.println(e);
			//System.out.println("!!! Either username already exsists OR Your password size is out of range. !!!");
		}
		System.out.println("---------------------------------------------------------------------------"
				+ "------------------------------------------------------------");
		
	}
}
