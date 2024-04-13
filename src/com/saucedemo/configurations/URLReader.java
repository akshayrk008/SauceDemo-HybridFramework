package com.saucedemo.configurations;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class URLReader {
	private static final String filePath = "E:/Hybrid-Framework/Sauce_demo_Library/InputConfig.xml";
    private static File xmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;
    private static String appURL;

    public static String getApplicationURL() {
        try {
            xmlFile = new File(filePath);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Reading application URL
            NodeList appURLNode = doc.getElementsByTagName("applicationURL");
            appURL = appURLNode.item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appURL;
    }
}

