import controller.Controller;
import model.Cinema;
import model.Movie;
import model.Person;
import org.xml.sax.SAXException;
import parsing.KinoTheatreXMLParser;
import parsing.XMLLoader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Map;


public class Run {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        start();
    }

    private static void start() throws IOException, SAXException, ParserConfigurationException {
        if(needUpdate()){
            try {
                XMLLoader.loadXML();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        KinoTheatreXMLParser.createDOM();
        /*Iterator<Map.Entry<Integer, String>> iterator = Controller.getGenres().entrySet().iterator();
        System.out.println("Genres:");
        System.out.println(Controller.getGenres().size());
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.printf("Id - %s, genre - %s\n", entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<Integer, String>> iterator2 = Controller.getProfessions().entrySet().iterator();
        System.out.println("Professions:");
        System.out.println(Controller.getProfessions().size());
        while (iterator2.hasNext()){
            Map.Entry<Integer, String> entry = iterator2.next();
            System.out.printf("Id - %s, Profession - %s\n", entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<Integer, String>> iterator3 = Controller.getCountries().entrySet().iterator();
        System.out.println("Countries:");
        System.out.println(Controller.getCountries().size());
        while (iterator3.hasNext()){
            Map.Entry<Integer, String> entry = iterator3.next();
            System.out.printf("Id - %s, Country - %s\n", entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<Integer, String>> iterator4 = Controller.getCities().entrySet().iterator();
        System.out.println("Cities:");
        System.out.println(Controller.getCities().size());
        while (iterator4.hasNext()){
            Map.Entry<Integer, String> entry = iterator4.next();
            System.out.printf("Id - %s, City - %s\n", entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<Integer, String>> iterator5 = Controller.getStudios().entrySet().iterator();
        System.out.println("Studios:");
        System.out.println(Controller.getStudios().size());
        while (iterator5.hasNext()){
            Map.Entry<Integer, String> entry = iterator5.next();
            System.out.printf("Id - %s, Studio - %s\n", entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<Integer, Cinema>> iterator6 = Controller.getCinemas().entrySet().iterator();
        System.out.println("Cinemas:");
        System.out.println(Controller.getCinemas().size());
        while (iterator6.hasNext()){
            Map.Entry<Integer, Cinema> entry = iterator6.next();
            System.out.printf("Id - %3s, %s\n", entry.getKey(), entry.getValue());
        }
        Iterator<Map.Entry<Integer, Person>> iterator7 = Controller.getPersons().entrySet().iterator();
        System.out.println("Persons:");
        System.out.println(Controller.getPersons().size());
        while (iterator7.hasNext()){
            Map.Entry<Integer, Person> entry = iterator7.next();
            System.out.printf("Id - %3s, %s\n", entry.getKey(), entry.getValue());
        }*/
        Iterator<Map.Entry<Integer, Movie>> iterator8 = Controller.getMovies().entrySet().iterator();
        System.out.println("Movies:");
        System.out.println(Controller.getMovies().size());
        while (iterator8.hasNext()){
            Map.Entry<Integer, Movie> entry = iterator8.next();
            System.out.printf("Id - %3s, %s\n", entry.getKey(), entry.getValue());
        }
        /*Iterator<Map.Entry<Integer, String>> iterator9 = Controller.getHalls().entrySet().iterator();
        System.out.println("Halls:");
        System.out.println(Controller.getHalls().size());
        while (iterator9.hasNext()){
            Map.Entry<Integer, String> entry = iterator9.next();
            System.out.printf("Id - %3s, hall - %s\n", entry.getKey(), entry.getValue());
        }*/
    }

    private static boolean needUpdate() {
//        todo nio
        Instant instant = Instant.ofEpochMilli(new File("src/resources/afisha.xml").lastModified());
        long lastUpdate = ChronoUnit.DAYS.between(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return lastUpdate > 0;
    }
}
