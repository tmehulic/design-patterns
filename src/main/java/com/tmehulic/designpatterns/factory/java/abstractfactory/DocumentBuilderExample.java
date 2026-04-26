package com.tmehulic.designpatterns.factory.java.abstractfactory;

import org.w3c.dom.Document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DocumentBuilderExample {

    public String getElementContent(String file, String elementId) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(file));
            return doc.getElementsByTagName("text").item(0).getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
