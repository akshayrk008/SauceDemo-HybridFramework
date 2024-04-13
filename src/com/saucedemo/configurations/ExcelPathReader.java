package com.saucedemo.configurations;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ExcelPathReader {
    private static final String filePath = "/Sauce_demo_Library/InputConfig.xml";
    private static File xmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;
    private static String excelPath;

    public static String getExcelSheetPath() {
        try {
            xmlFile = new File(filePath);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Reading Excel sheet path
            NodeList excelPathNode = doc.getElementsByTagName("excelSheetPath");
            excelPath = excelPathNode.item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelPath;
    }
}

