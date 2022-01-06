// read from XML files
import java.io.IOException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// DOM 方式解析xml

public class ReadFromXML {
    public static void main(String[] args) {
        //Create a DocumentBuilderFactory object.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //Build DocumentBuilder
        // try {
        //     DocumentBuilder db = dbf.newDocumentBuilder();
        //     Document document = db.parse("./input/flavors.xml");
        //     // catch all vegetables
        //     NodeList nodelist = document.getElementsByTagName("vegetable");
        //     // catch the length
        //     System.out.println(nodelist.getLength());
        // } catch (ParserConfigurationException e) {
        //     e.printStackTrace();
        // } catch (SAXException e) {
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse("./input/flavors.xml");
        // catch all vegetables
        NodeList nodelist = document.getElementsByTagName("vegetable");
        // catch the length
        System.out.println(nodelist.getLength());
    }
}