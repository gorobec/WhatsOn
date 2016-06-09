package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 09.03.16.
 */
public class MainFrame extends JFrame {
    JMenuBar menuBar;

    GridBagLayout gridLayout;
    GridBagConstraints gbs;
    public MainFrame(){
        super("WhatsOn");
        gridLayout = new GridBagLayout();
        gbs = new GridBagConstraints();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        menuBar = new MenuBar();
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(gridLayout);
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setVisible(true);
    }
}
