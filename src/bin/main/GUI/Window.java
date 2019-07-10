package bin.main.GUI;

import javax.swing.*;
import java.awt.*;


/*
Color Theme:
#b2dfdb
#e5ffff
#82ada9
 */

public class Window extends JPanel {

    private int window_size_height;
    private int window_size_width;

    Color background_color = new Color(229, 255, 255);

    public Window(int width, int height) {
        this.window_size_width = width;
        this.window_size_height = height;
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponents(g);
        //Draw Background
        g.setColor(background_color);
        g.fillRect(0, 0, this.window_size_width, this.window_size_height);
        System.out.println("Done");
        g.setColor(Color.BLACK);
        g.drawString("Author: Adam Stogsdill", 10, 15);
        System.out.println("Done");
    }
}
