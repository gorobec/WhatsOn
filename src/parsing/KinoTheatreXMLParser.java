package parsing;

import controller.Controller;
import model.Cinema;
import model.Movie;
import model.Person;
import model.Show;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


public class KinoTheatreXMLParser {
    private static final String SOURCE = "src/resources/afisha.xml";
    //    todo capacities
    private static final int initialMapCapacity = 52;

    public static void parseXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.parse(new File(SOURCE));
        Element root = document.getDocumentElement();
        NodeList children = root.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                switch (child.getNodeName()) {
                    case "genres":
                        Controller.setGenres(simpleParser(child.getChildNodes()));
                        break;
                    case "professions":
                        Controller.setProfessions(simpleParser(child.getChildNodes()));
                        break;
                    case "countries":
                        Controller.setCountries(simpleParser(child.getChildNodes()));
                        break;
                    case "cities":
                        Controller.setCities(twoAttributesParser(child.getChildNodes()));
                        break;
                    case "studios":
                        Controller.setStudios(simpleParser(child.getChildNodes()));
                        break;
                    case "shows":
                        showsParser(child.getChildNodes());
//                        todo parser
                        break;
                    case "films":
                        Controller.setMovies(moviesParser(child.getChildNodes()));
                        break;
                    case "cinemas":
                        Controller.setCinemas(cinemasParser(child.getChildNodes()));
                        break;
                    case "persons":
                        Controller.setPersons(personsParser(child.getChildNodes()));
                        break;
                }
            }
        }
    }

    private static void showsParser(NodeList showNodes) {
        Map<Integer, List<Show>> showsByCinema = new HashMap<>();
        Map<Integer, List<Show>> showsByMovie = new HashMap<>();
        for (int i = 0; i < showNodes.getLength(); i++) {
            Show seance = new Show();
            Node show = showNodes.item(i);
            if(show.getNodeType() == Node.ELEMENT_NODE) {
                NamedNodeMap showAttributes = show.getAttributes();
                int movieId = Integer.parseInt(showAttributes.item(1).getNodeValue());
                int cinemaId = Integer.parseInt(showAttributes.item(0).getNodeValue());
                seance.setCinemaID(cinemaId);
                seance.setMovieID(movieId);
                seance.setHallID(Integer.parseInt(showAttributes.item(2).getNodeValue()));
                NodeList showElements = show.getChildNodes();
                for (int j = 0; j < showElements.getLength(); j++) {
                    Node showElement = showElements.item(j);
                    if(showElement != null){
                        switch (showElement.getNodeName()){
                            case "begin":
                                seance.setDateBegin(LocalDate.parse(showElement.getTextContent()));
                                break;
                            case "end":
                                seance.setDateEnd(LocalDate.parse(showElement.getTextContent()));
                                break;
                            case "times":
                                seance.setSeancesTime3D(showTimesParser(showElement, seance));
                                break;

                        }
                    }
                }
                putShow(showsByCinema, cinemaId, seance);
                putShow(showsByMovie, movieId, seance);
            }
        }
        Controller.setShowsByCinema(showsByCinema);
        Controller.setShowsByMovie(showsByMovie);
    }

    private static void putShow(Map<Integer, List<Show>> shows, int Id, Show seance) {
        if(shows.containsKey(Id)){
            shows.get(Id).add(seance);
        }else {
            List<Show> seances = new ArrayList<>();
            seances.add(seance);
            shows.put(Id, seances);
        }
    }

    private static Map<LocalTime, Boolean> showTimesParser(Node times, Show seance) {
        List<Double> prices = new ArrayList<>();
        Map<LocalTime, Boolean> seancesTime3D = new TreeMap<>();
        NodeList timeNodes = times.getChildNodes();
        for (int i = 0; i < timeNodes.getLength(); i++) {
            Node time = timeNodes.item(i);
            if(time.getNodeType() == Node.ELEMENT_NODE) {
                LocalTime seanceTime = LocalTime.parse(time.getAttributes().item(1).getNodeValue());
                boolean is3D = time.getAttributes().item(0).getNodeValue().equals("1");
                seancesTime3D.put(seanceTime, is3D);
                NodeList timeElements = time.getChildNodes();
                for (int j = 0; j < timeElements.getLength(); j++) {
                    Node timeElement  = timeElements.item(j);
                    if(timeElement.getNodeType() == Node.ELEMENT_NODE &&
                            timeElement.getNodeName().equals("prices")){
                        String[] pricesString;
                        if(timeElement.getTextContent().contains(",")) {
                            pricesString = timeElement.getTextContent().split(", ");
                        } else {
                            pricesString = timeElement.getTextContent().split("-");
                        }
                        for (String price : pricesString) {
                            if(!price.equals("")) {
                                prices.add(Double.parseDouble(price));
                            }
                        }
                    }
                }
            }
        }
        seance.setPrice(prices);
        return seancesTime3D;
    }

    private static Map<Integer, Movie> moviesParser(NodeList moviesList) {
        Map<Integer, Movie> movies = new HashMap<>(initialMapCapacity);
        for (int i = 0; i < moviesList.getLength(); i++) {
            Node movieNode = moviesList.item(i);
            if (movieNode.getNodeType() == Node.ELEMENT_NODE) {
                NodeList movieElements = movieNode.getChildNodes();
                int movieId = Integer.parseInt(movieNode.getAttributes().item(0).getNodeValue());
                String title = null;
                String originalTitle = null;
                int year = 0;
                List<Integer> genres = null;
                Integer budget = null;
                Map<Integer, List<Integer>> persons = null;
                List<Integer> countries = null;
                int ageLimit = 0;
                int duration = 0;
                LocalDate wordPremiere = null;
                LocalDate uaPremiere = null;
                String description = null;
                List<Integer> studios = null;
                String posterURL = null;
                for (int j = 0; j < movieElements.getLength(); j++) {
                    Node movieElement = movieElements.item(j);
                    switch (movieElement.getNodeName()) {
                        case "title":
                            originalTitle = movieElement.getAttributes().item(0).getNodeValue();
                            title = movieElement.getTextContent();
                            break;
                        case "duration":
                            if (!isEmpty(movieElement))
                                duration = Integer.parseInt(movieElement.getTextContent());
                            break;
                        case "premiere":
                            if (!isEmpty(movieElement))
                                uaPremiere = LocalDate.parse(movieElement.getTextContent());
                            break;
                        case "worldpremiere":
                            if (!isEmpty(movieElement))
                                wordPremiere = LocalDate.parse(movieElement.getTextContent());
                            break;
                        case "age_limit":
                            if (!isEmpty(movieElement))
                                ageLimit = Integer.parseInt(movieElement.getTextContent());
                            break;
                        case "budget":
                            if (!isEmpty(movieElement))
                                budget = Integer.parseInt(movieElement.getTextContent());
                            break;
                        case "year":
                            if (!isEmpty(movieElement))
                                year = Integer.parseInt(movieElement.getTextContent());
                            break;
                        case "intro":
                            description = movieElement.getTextContent();
                            break;
                        case "posters":
                            posterURL = getPosterURL(movieElement);
                            break;
                        case "genres":
                            genres = getElementIds(movieElement);
                            break;
                        case "countries":
                            countries = getElementIds(movieElement);
                            break;
                        case "studios":
                            studios = getElementIds(movieElement);
                            break;
                        case "persons":
                            persons = getPersons(movieElement);
                            break;
                    }
                }
                movies.put(movieId,
                        new Movie.Builder().ageLimit(ageLimit).budget(budget).
                                countries(countries).description(description).
                                duration(duration).genres(genres).originalTitle(originalTitle).
                                persons(persons).posterURL(posterURL).studios(studios).title(title).
                                uaPremiere(uaPremiere).year(year).wordPremiere(wordPremiere).build());
            }
        }
        return movies;
    }

    private static Map<Integer, List<Integer>> getPersons(Node persons) {
        Map<Integer, List<Integer>> filmCrew = new HashMap<>();
        NodeList personNodes = persons.getChildNodes();
        for (int i = 0; i < personNodes.getLength(); i++) {
            Node personNode = personNodes.item(i);
            if (personNode.getNodeType() == Node.ELEMENT_NODE) {
                NamedNodeMap personAttributes = personNode.getAttributes();
                int professionId = Integer.parseInt(personAttributes.item(1).getNodeValue());
                int personId = Integer.parseInt(personAttributes.item(0).getNodeValue());
                putPerson(filmCrew, professionId, personId);
            }
        }
        return filmCrew;
    }

    private static void putPerson(Map<Integer, List<Integer>> filmCrew, int professionId, int personId) {
       if(filmCrew.containsKey(professionId)){
           filmCrew.get(professionId).add(personId);
       }else {
           List<Integer> personsId = new ArrayList<>();
           personsId.add(personId);
           filmCrew.put(professionId, personsId);
       }

    }

    private static boolean isEmpty(Node movieElement) {
        return movieElement.getTextContent().equals("");
    }

    private static List<Integer> getElementIds(Node movieElement) {
        List<Integer> id = new ArrayList<>();
        String idString = movieElement.getTextContent();
        if (!idString.equals("")) {
            String[] idArray = movieElement.getTextContent().split(",");
            for (int i = 0; i < idArray.length; i++) {
                id.add(Integer.parseInt(idArray[i]));
            }
        }
        return id;
    }

    private static String getPosterURL(Node posters) {
        NodeList postersElements = posters.getChildNodes();
        for (int i = 0; i < postersElements.getLength(); i++) {
            if (postersElements.item(i).getNodeType() == Node.ELEMENT_NODE && postersElements.item(i).getAttributes().getNamedItem("order").getNodeValue().equals("1")) {
                return postersElements.item(i).getAttributes().getNamedItem("src").getNodeValue();
            }

        }
        return null;
    }

    private static Map<Integer, Person> personsParser(NodeList personsList) {
        Map<Integer, Person> persons = new HashMap<>(initialMapCapacity);
        for (int i = 0; i < personsList.getLength(); i++) {
            Node personeNode = personsList.item(i);
            if (personeNode.getNodeType() == Node.ELEMENT_NODE) {
                NodeList personElements = personeNode.getChildNodes();
                int personId = Integer.parseInt(personeNode.getAttributes().item(0).getNodeValue());
                String lastnameOrigin = null;
                String lastname = null;
                String firstnameOrigin = null;
                String firstname = null;
                for (int j = 0; j < personElements.getLength(); j++) {
                    Node personElement = personElements.item(j);
                    switch (personElement.getNodeName()) {
                        case "lastname":
                            lastnameOrigin = personElement.getAttributes().item(0).getNodeValue();
                            lastname = personElement.getTextContent();
                            break;
                        case "firstname":
                            firstnameOrigin = personElement.getAttributes().item(0).getNodeValue();
                            firstname = personElement.getTextContent();
                    }
                }
                persons.put(personId, new Person(lastnameOrigin, lastname, firstnameOrigin, firstname));
            }
        }

        return persons;
    }

    private static Map<Integer, Cinema> cinemasParser(NodeList cinemasList) {
        Map<Integer, Cinema> cinemas = new HashMap<>(initialMapCapacity);
        Map<Integer, String> halls = new HashMap<>(initialMapCapacity);
        for (int j = 0; j < cinemasList.getLength(); j++) {
            Node cinemaNode = cinemasList.item(j);
            if (cinemaNode.getNodeType() == Node.ELEMENT_NODE && cinemaNode.hasChildNodes()) {
                int cityId = Integer.parseInt(cinemaNode.getAttributes().item(0).getNodeValue());
                int cinemaId = Integer.parseInt(cinemaNode.getAttributes().item(1).getNodeValue());
                String title = null;
                String address = null;
                String phone = null;
                String url = null;
                NodeList cinemaElements = cinemaNode.getChildNodes();
                for (int i = 0; i < cinemaElements.getLength(); i++) {
                    Node cinemaElement = cinemaElements.item(i);
                    switch (cinemaElement.getNodeName()) {
                        case "cinema":
                            break;
                        case "title":
                            title = cinemaElement.getTextContent();
                            break;
                        case "address":
                            address = cinemaElement.getTextContent();
                            break;
                        case "phone":
                            phone = cinemaElement.getTextContent();
                            break;
                        case "site":
                            url = cinemaElement.getTextContent();
                            break;
                        case "halls":
                            halls.putAll(hallsParser(cinemaElement));
                            break;
                    }
                }
                cinemas.put(cinemaId, new Cinema.Builder().cityId(cityId).name(title).address(address).phone(phone).url(url).build());
            }
        }
        Controller.setHalls(halls);
        return cinemas;
    }

    private static Map<Integer, String> hallsParser(Node hallsNode) {
        Map<Integer, String> halls = new HashMap<>(initialMapCapacity);
        NodeList hallNodes = hallsNode.getChildNodes();
        for (int i = 0; i < hallNodes.getLength(); i++) {
            Node hall = hallNodes.item(i);
            if (hall.getNodeType() == Node.ELEMENT_NODE) {
                int hallId = Integer.parseInt(hall.getAttributes().item(0).getNodeValue());
                NodeList hallElements = hall.getChildNodes();
                for (int j = 0; j < hallElements.getLength(); j++) {
                    Node hallElement = hallElements.item(j);
                    if (hallElement != null && hallElement.getNodeName().equals("title")) {
                        halls.put(hallId, hallElements.item(j).getTextContent());
                        break;
                    }
                }
            }
        }
        return halls;
    }

    /*
    * Parser for NodeList consist of only one Element with one (or item(0) meaningful) Attribute - id,
    *and one TextContent - String. They put to the corresponding Map data structure
    *for each NodeList in Controller class.
    *
    * */
    private static Map<Integer, String> simpleParser(NodeList list) {
        Map<Integer, String> map = new HashMap<>(initialMapCapacity);
        for (int j = 0; j < list.getLength(); j++) {
            Node node = list.item(j);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                map.put(Integer.parseInt(node.getAttributes().item(0).getNodeValue()), node.getTextContent());
            }
        }
        return map;
    }

    private static Map<Integer, String> twoAttributesParser(NodeList list) {
        Map<Integer, String> map = new HashMap<>(initialMapCapacity);
        for (int j = 0; j < list.getLength(); j++) {
            Node node = list.item(j);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                map.put(Integer.parseInt(node.getAttributes().item(1).getNodeValue()), node.getTextContent());
            }
        }
        return map;
    }

}
