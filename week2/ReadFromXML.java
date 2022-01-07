import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

interface ReadData {
    String[][] items = new String[0][0];
    String[][] readData( String s);
}


// Read data from XML files:
public class ReadFromXML implements ReadData{
    public String[][] readData(String dir)  {
        String[][] items = new String[0][0];
        try{
            File file = new File(dir);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            document.getDocumentElement().normalize();
            // System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
            NodeList nList = document.getElementsByTagName("item");
            //write the data to String[][]
            items = new String[nList.getLength()][2];
            for(int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                // System.out.println("\ncurrent Element: " + nNode.getNodeName());
                Element eElement = (Element) nNode;
                // System.out.println(eElement.getElementsByTagName("name").item(0).getTextContent());
                items[i][0] = eElement.getElementsByTagName("name").item(0).getTextContent();
                items[i][1] = eElement.getElementsByTagName("weight").item(0).getTextContent();

            }
            // return(items);
        }catch(IOException e) {
            System.out.println(e);
        } catch(ParserConfigurationException e) {
            System.out.println(e);
        } catch(SAXException e) {
            System.out.println(e);
        }
    return(items);
    }
}
