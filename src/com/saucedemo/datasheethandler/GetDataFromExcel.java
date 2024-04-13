package com.saucedemo.datasheethandler;

import java.io.IOException;
import java.util.List;

import com.saucedemo.configurations.ReadMethodFromXML;
import com.saucedemo.generic.Generals;

public class GetDataFromExcel {
	
	public static ExcelReader excelReader;
	public static String input;
	
	public static String getData(String Header) {
		try {
			excelReader = new ExcelReader(Generals.EXCEL_PATH);
			List<String> methodname = ReadMethodFromXML.extractMethodNamesFromXML();
			input = excelReader.getDataByTestCaseNameAndHeader(methodname.get(0), Header);
			
			
			
			
		} catch (IOException e) {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return input;
		
	}
	
	//excelReader = new ExcelReader(Generals.EXCEL_PATH);
	//
	

}
