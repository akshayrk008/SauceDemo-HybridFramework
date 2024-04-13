package com.saucedemo.configurations;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadMethodFromXML {

	static String filePath = "E:/Hybrid-Framework/Sauce_demo_scripts/testng.xml";
    public static List<String> extractMethodNamesFromXML() throws Exception {
        List<String> methodNames = new ArrayList<>();
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        doc.getDocumentElement().normalize();

        NodeList classList = doc.getElementsByTagName("class");

        for (int i = 0; i < classList.getLength(); i++) {
            Element classNode = (Element) classList.item(i);
            NodeList methodList = classNode.getElementsByTagName("include");

            for (int j = 0; j < methodList.getLength(); j++) {
                Element methodNode = (Element) methodList.item(j);
                String methodName = methodNode.getAttribute("name");
                methodNames.add(methodName);
            }
        }
        return methodNames;
    }
}

