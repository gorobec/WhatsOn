import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parsing.KinoTheatreXMLParser;
import parsing.XMLLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by gorobec on 29.01.16.
 */
public class Test {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//        XMLLoader.loadXML();
        HashMap<Integer, String> gen = new HashMap<>(52);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("src/resources/afisha.xml"));

        Element root = document.getDocumentElement();
        NodeList genres = null;


//        System.out.println(root.getTagName());
        NodeList children = root.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                if (child.getNodeName().equals("genres")) {
                    genres = child.getChildNodes();
                    for (int j = 0; j < genres.getLength(); j++) {
                        Node genre = genres.item(j);
                        if (genre.getNodeType() == Node.ELEMENT_NODE) {
                            gen.put(Integer.parseInt(genre.getAttributes().item(0).getNodeValue()), genre.getTextContent());
                        }
                    }
                }

            }


        }

        Set<Map.Entry<Integer, String>> entrySet = gen.entrySet();
        for (Map.Entry<Integer, String> integerStringEntry : entrySet) {
            System.out.printf("Index - %d, value - %s\n", integerStringEntry.getKey(), integerStringEntry.getValue());
        }

    }
}
