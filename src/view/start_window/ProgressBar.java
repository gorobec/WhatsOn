package view.start_window;

import parsing.XMLLoader;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by gorobec on 09.03.16.
 */
public class ProgressBar extends JProgressBar {
    public ProgressBar() {
        super(0, (int) XMLLoader.size);
        setPreferredSize(new Dimension(600, 5));
        setBorderPainted(true);
        setForeground(Color.DARK_GRAY);
        setOpaque(false);
        addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });
    }
}
