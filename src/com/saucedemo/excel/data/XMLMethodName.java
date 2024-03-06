package com.saucedemo.excel.data;

import java.util.Iterator;
import java.util.List;

import com.saucedemo.consts.Constants;

public class XMLMethodName {
	
	public static String readMethodName() {
		String filePath = Constants.XML_Path;
		String xmlMethodName = null;
		// Replace this with the path to your TestNG XML file
        List<TestMethodInfo> testMethods = XMLDataReader.parseTestNGXML(filePath);

        System.out.println("Test methods extracted from TestNG XML:");
        for (TestMethodInfo method : testMethods) {
        	xmlMethodName = method.getMethodName();
        }
		return xmlMethodName;
		
	}
	
	


}
