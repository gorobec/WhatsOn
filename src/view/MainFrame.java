package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 09.03.16.
 */
public class MainFrame extends JFrame {
    public MainFrame(){
        super("WhatsOn");
        JTabbedPane tabbedPane = new JTabbedPane();
        JMenuBar menuBar = new MenuBar();
        setJMenuBar(menuBar);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
//        setExtendedState(Frame.MAXIMIZED_BOTH);
        ImageIcon icon = new ImageIcon("/home/gorobec/Java/development/WhatsOn/src/resources/35px-Applications-multimedia.svg.png");
        ImageIcon icon2 = new ImageIcon("/home/gorobec/Java/development/WhatsOn/src/resources/magnifying-glass.png");

        JComponent affiche = new JPanel();
        JScrollPane cinemas = new JScrollPane(new CinemasPane());

        cinemas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JComponent soon = new JPanel();
        JComponent search = new JPanel();
        tabbedPane.addTab("Афиша", icon, affiche, "Афиша фиьмов в прокате");
        tabbedPane.addTab("Кинотеатры", icon, cinemas, "Кинотеатры города");
        tabbedPane.addTab("Скоро в прокате", icon, soon, "Афиша фиьмов, который выйдут скоро в прокат");
        tabbedPane.addTab("Поиск", icon2, search, "Поиск фиьмов");
        getContentPane().add(tabbedPane);
        setResizable(false);
        setVisible(true);

    }
}
