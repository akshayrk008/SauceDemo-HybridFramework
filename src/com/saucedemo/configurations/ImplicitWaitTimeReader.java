package com.saucedemo.configurations;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ImplicitWaitTimeReader {
	private static final String filePath = "E:/Hybrid-Framework/Sauce_demo_Library/InputConfig.xml";
    private static File xmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;
    private static int implicitTime;

    public static int getImplicitWaitTime() {
        try {
            xmlFile = new File(filePath);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Reading implicit wait time
            NodeList implicitWaitNode = doc.getElementsByTagName("implicitWait");
            implicitTime = Integer.parseInt(implicitWaitNode.item(0).getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return implicitTime;
    }
}