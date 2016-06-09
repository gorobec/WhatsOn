package view.start_window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 18.02.16.
 */
public class StartFrame extends JFrame {
    JProgressBar progressBar;
    BgPanel backGround;
    GridBagConstraints gbc;

    public StartFrame() throws InterruptedException {
        gbc = new GridBagConstraints();
        gbc.gridy = 1;
        setLayout(new BorderLayout());
        setSize(600, 400);
        setUndecorated(true);
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        backGround = new BgPanel();
        progressBar = new ProgressBar();
        backGround.add(progressBar, gbc);
        add(backGround);
        setVisible(true);
        for (int i = progressBar.getMinimum(); i <= progressBar.getMaximum(); i++) {
            Thread.sleep(5);
            progressBar.setValue(i);
        }
        dispose();
    }
}