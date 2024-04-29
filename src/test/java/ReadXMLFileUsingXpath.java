import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class ReadXMLFileUsingXpath {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("C://Users//VZ724WP//Downloads//laptops.xml");

        XPath xp = XPathFactory.newInstance().newXPath();
        NodeList nl = (NodeList) xp.compile("//laptop").evaluate(document, XPathConstants.NODESET);
        System.out.println("No of laptops: " + nl.getLength());
        System.out.println("List Laptop Information....");
        for(int i=0;i<nl.getLength();i++){
            System.out.println("Name: " + xp.compile("./@name").evaluate(nl.item(i)));
            System.out.println("Price: " + xp.compile("./price/@value").evaluate(nl.item(i)));
            System.out.println("Ram: " + xp.compile("./ram/@value").evaluate(nl.item(i)));
            System.out.println("HardDrive: " + xp.compile("./hardDrive/@value").evaluate(nl.item(i)));
            System.out.println("......................");
        }


    }
}
