package view.start_window;

import javax.swing.*;
import java.awt.*;

/**
 * Created by gorobec on 09.03.16.
 */
class BgPanel extends JPanel {
    GridBagLayout layout;
    public BgPanel() {
    layout = new GridBagLayout();
    setLayout(layout);
    layout.columnWidths = new int[]{600};
    layout.rowHeights = new int[]{300, 5};
    }

    Image bg = new ImageIcon("src/resources/IMG_1886.JPG").getImage();
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}