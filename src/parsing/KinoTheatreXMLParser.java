package parsing;

import model.Cinema;
import model.Movie;
import model.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class KinoTheatreXMLParser {
    private static final String SOURCE = "src/resources/afisha.xml";

    private static Map<Integer, Cinema> cinemas = new HashMap<>();
    private static Map<Integer, Movie> movies = new HashMap<>();
    private static Map<Integer, Person> persons = new HashMap<>();
    private static Map<Integer, String> genres = new HashMap<>(52);
    private static Map<Integer, String> halls = new HashMap<>(52);
    private static Map<Integer, String> professions = new HashMap<>(52);
    private static Map<Integer, String> countries = new HashMap<>(52);
    private static Map<Integer, String> cities = new HashMap<>(52);
    private static Map<Integer, String> studios = new HashMap<>(52);

    private static NodeList genresList = null;
    private static NodeList professionsList = null;
    private static NodeList countriesList = null;
    private static NodeList citiesList = null;
    private static NodeList studiosList = null;
    private static NodeList cinemasList = null;
    private static NodeList filmsList = null;
    private static NodeList showsList = null;
    private static NodeList personsList = null;

    public static void createDOM() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(SOURCE));
        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                switch (child.getNodeName()){
                    case "genre":
                        genresList = child.getChildNodes();
                        simpleParser(genresList, genres);
                        break;
                    case "professions":
                        professionsList = child.getChildNodes();
                        simpleParser(professionsList, professions);
                        break;
                    case "countries":
                        countriesList = child.getChildNodes();
                        simpleParser(countriesList, countries);
                        break;
                    case "cities":
                        citiesList = child.getChildNodes();
                        simpleParser(citiesList, cities);
                        break;
                    case "studios":
                        studiosList = child.getChildNodes();
                        simpleParser(studiosList, studios);
                        break;
                    case "shows":
                        studiosList = child.getChildNodes();
//                        todo parser
//                        must be the last
                        break;
                    case "films":
                        filmsList = child.getChildNodes();
//                        todo parser
                        break;

                    case "cinemas":
                        cinemasList = child.getChildNodes();
//                        todo parser
                        break;
                    case "persons":
                        personsList = child.getChildNodes();
//                        todo parser
                        break;
                }
            }
        }
    }
/*
* Parser for NodeList consist of only one (or first meaningful) Attribute - id,
*and one TextContent - String. They put to the corespounding Map data structure
*for each NodeList
* */
    private static void simpleParser(NodeList list, Map map) {
        for (int j = 0; j < list.getLength(); j++) {
            Node genre = list.item(j);
            if (genre.getNodeType() == Node.ELEMENT_NODE) {
                map.put(Integer.parseInt(genre.getAttributes().item(0).getNodeValue()), genre.getTextContent());
            }
        }
    }

}
