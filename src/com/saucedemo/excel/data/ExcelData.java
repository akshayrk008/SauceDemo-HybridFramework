package com.saucedemo.excel.data;

public class ExcelData {
	
	static String[] userData = ExcelDataReader.getUserData(XMLMethodName.readMethodName());
	
	public static String getUserID() {
		String userid = null;
		try {
			if (userData != null) {
			   userid = userData[0];
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userid;
	}
	
	public static String getUserPasswordD() {
		String userpassword = null;
		try {
			if (userData != null) {
				userpassword = userData[1];
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userpassword;
	}
	
	public static String getUserFirstname() {
		String firstname = null;
		try {
			if (userData != null) {
				firstname = userData[2];
			
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstname;
	}
	
	
	
}
