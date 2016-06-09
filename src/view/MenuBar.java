package view;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gorobec on 09.03.16.
 */
public class MenuBar extends JMenuBar {
    JMenu file;
    JMenu edit;
    JMenu help;
    JMenuItem close;
    JMenuItem changeCity;
    JMenuItem about;
    JMenuItem howToUse;
    Font menuFont;
    public MenuBar(){
        file = new JMenu(" File ");
        edit = new JMenu(" Edit ");
        help = new JMenu(" Help ");
        menuFont = new Font("Arial", Font.ITALIC, 14);
        file.setFont(menuFont);
        edit.setFont(menuFont);
        help.setFont(menuFont);
        close = new JMenuItem(" Close ");
        changeCity = new JMenuItem(" Change city ");
        about = new JMenuItem(" About ");
        howToUse = new JMenuItem(" How to use ");
        close.setFont(menuFont);
        changeCity.setFont(menuFont);
        about.setFont(menuFont);
        howToUse.setFont(menuFont);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        changeCity.addActionListener(e ->  {
            String str = "Hello";
            Clipboard clbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection strsel = new StringSelection(str);
            clbrd.setContents(strsel, null);


        });
        file.add(close);
        edit.add(changeCity);
        help.add(about);
        help.add(new JSeparator(JPopupMenu.Separator.HORIZONTAL));
        help.add(howToUse);
        add(file);
        add(edit);
        add(help);
    }
}
