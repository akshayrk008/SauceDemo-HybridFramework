package com.saucedemo.configurations;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BrowserTypeReader {
    private static final String filePath = "E:/Hybrid-Framework/Sauce_demo_Library/InputConfig.xml";
    private static File xmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;

    public static String getBrowserType() {
        String browserType = "";
        try {
            xmlFile = new File(filePath);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Reading browser type
            NodeList browserNodes = doc.getElementsByTagName("browser");
            browserType = browserNodes.item(0).getTextContent().toLowerCase();

            // Convert browser type to lowercase for better matching
           
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Switch to determine the browser type
        switch (browserType) {
            case "firefox":
                return "firefox";
            case "chrome":
                return "chrome";
            default:
                return "Unknown";
        }
    }
}
