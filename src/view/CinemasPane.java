package view;

import controller.Controller;
import model.Cinema;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import java.util.TreeSet;

import static java.awt.FlowLayout.*;

/**
 * Created by gorobec on 13.06.16.
 */
class CinemasPane extends JPanel {
GridBagConstraints gbc = new GridBagConstraints();
    CinemasPane() {
        setBackground(Color.WHITE);
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        Map<Integer, Cinema> cinemas = Controller.getCinemas();

        TreeSet<Cinema> sortedCinemas = new TreeSet<>();
        for (Cinema cinema : cinemas.values()) {
            if(cinema.getCityId() == 1){
                sortedCinemas.add(cinema);
            }
        }

        int size = sortedCinemas.size();
        int columns = 3;
//        int rows = Math.round(size / 3);
        int rows = (int)Math.ceil(size * 1.0 / columns);
        /*layout.columnWidths = new int[columns];
        layout.rowHeights = new int[600 / rows];*/


        gbc.gridx = 0;
        gbc.gridy = 0;
        for (Cinema sortedCinema : sortedCinemas) {
            JLabel cinemaLink = new JLabel(sortedCinema.getName());
            cinemaLink.setFont(new Font("Arial", Font.ITALIC, 16));
            cinemaLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            cinemaLink.addMouseListener(new CinemasMouseListener(sortedCinema));

            /*gbc.gridwidth = numConstaints[i][2];
            gbc.gridheight = numConstaints[i][3];*/
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(15, 30, 15, 30);
            add(cinemaLink, gbc);
            gbc.gridy++;
            if(gbc.gridy == rows){
                gbc.gridy = 0;
                gbc.gridx++;
            }
        }

    }
}
