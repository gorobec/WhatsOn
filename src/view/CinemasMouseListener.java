package view;

import model.Cinema;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by gorobec on 13.06.16.
 */
class CinemasMouseListener implements MouseListener {
    private Cinema cinema;
    CinemasMouseListener(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFrame cinemaFrame = new JFrame(cinema.getName());
        cinemaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cinemaFrame.add(new JTextArea(cinema.toString()));
        cinemaFrame.setLocationRelativeTo(MainFrame.getFrames()[0]);
        cinemaFrame.setSize(600, 400);

        cinemaFrame.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
