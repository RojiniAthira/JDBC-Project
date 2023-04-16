package Programs;

import java.sql.SQLException;

public class register extends loginpage {
	
	public void registeruser() {
		
		System.out.println("---------------------------------------------------------User Registration"
				+ "------------------------------------------------------------");
		System.out.println("# Enter your informations correctly.");
		System.out.println("# Username should be of following format:");
		System.out.println("		1.Should contain maximum size of 10 characters and "
				+ "minimum of 8 characters.");
		System.out.println("		2.Can contain lower case characters and digits.");
		System.out.println("		3.Should not contain upper case characters.");
		System.out.println("		Format : aaa223");
		System.out.println("# Password should be of following format:");
		System.out.println("		1.Should contain maximum size 0f 14 characters and "
				+ "minimum of 8 characters.");
		System.out.println("		2.Can contain lower case&upper case characters,special characters and digits.");
		System.out.println("		3.Should start with upper case characters and end with digits.");
		System.out.println("		Format : AAaa@@123");
		System.out.println("---------------------------------------------------------------------------"
				+ "------------------------------------------------------------");
		String[] info = information.getInformation();
		if (info == null) {	
			System.out.println();
			System.out.println("!!! User Resgistration Failed.Try it next time. !!!");
			
			return;
		}
		
		try {
			pst = con.prepareStatement("INSERT INTO password VALUES(?,?,?,?)");
			pst.setString(1, info[0]);
			pst.setString(2, info[1]);
			pst.setString(3, info[2]);
			pst.setString(4, encryption.encrypt(info[2]));
			pst.execute();
			System.out.println();
			System.out.println("!!! USER REGISTRATION SUCCESSFUL !!!");
			System.out.println();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println("---------------------------------------------------------------------------"
				+ "------------------------------------------------------------");
		
	}
}
