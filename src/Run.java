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
    }

    private static boolean needUpdate() {
//        todo nio
        Instant instant = Instant.ofEpochMilli(new File("src/resources/afisha.xml").lastModified());
        long lastUpdate = ChronoUnit.DAYS.between(LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        return lastUpdate > 0;
    }
}
