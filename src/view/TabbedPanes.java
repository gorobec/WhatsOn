package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by gorobec on 10.06.16.
 */
public class TabbedPanes extends JTabbedPane {
    JComponent affiche;
    JComponent cinemas;
    JComponent soon;
    public TabbedPanes() {
        ImageIcon icon = new ImageIcon("/home/gorobec/Java/development/WhatsOn/src/resources/35px-Applications-multimedia.svg.png");
        JComponent affiche = new JPanel();
        JComponent cinemas = new JPanel();
        JComponent soon = new JPanel();
        addTab("Афиша", icon, affiche, "Афиша фиьмов в прокате");
        addTab("Кинотеатры", icon, cinemas, "Кинотеатры города");
        addTab("Скоро в прокате", icon, soon, "Афиша фиьмов, который выйдут скоро в прокат");
        setOpaque(true);
    }


}
