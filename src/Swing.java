import controller.Controller;
import org.xml.sax.SAXException;
import parsing.KinoTheatreXMLParser;
import view.MainFrame;
import view.start_window.StartFrame;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Swing {
    public static void main(String[] args) throws InterruptedException, IOException, SAXException, ParserConfigurationException {
//    JFrame startFrame = new StartFrame();
        KinoTheatreXMLParser.parseXML();

//        Controller controller = new Controller();

        JFrame mainFrame = new MainFrame();
    }
}