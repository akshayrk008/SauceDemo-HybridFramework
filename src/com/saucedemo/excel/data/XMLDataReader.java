package com.saucedemo.excel.data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.saucedemo.consts.Constants;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLDataReader {
	

	public static List<TestMethodInfo> parseTestNGXML(String File_Path) {
		List<TestMethodInfo> testMethods = new ArrayList<>();
		try {
			File inputFile = new File(File_Path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			NodeList classNodes = doc.getElementsByTagName("class");
			for (int i = 0; i < classNodes.getLength(); i++) {
				Element classElement = (Element) classNodes.item(i);
				String className = classElement.getAttribute("name");

				NodeList methodNodes = classElement.getElementsByTagName("include");
				for (int j = 0; j < methodNodes.getLength(); j++) {
					Element methodElement = (Element) methodNodes.item(j);
					String methodName = methodElement.getAttribute("name");
					testMethods.add(new TestMethodInfo(className, methodName));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testMethods;
	}
}

class TestMethodInfo {
	private String className;
	private String methodName;

	public TestMethodInfo(String className, String methodName) {
		this.className = className;
		this.methodName = methodName;
	}

	public String getClassName() {
		return className;
	}

	public String getMethodName() {
		return methodName;
	}
	

	

}
