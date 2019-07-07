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

    public Window(int width, int height) {
        this.window_size_width = width;
        this.window_size_height = height;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Color background_color = new Color(229, 255, 255);
        //Draw Background
        g.setColor(background_color);
        g.fillRect(0, 0, this.window_size_width, this.window_size_height);
    }
}
