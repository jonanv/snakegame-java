package com.snakegame;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    int WIDTH = 320;
    int DOT_SIZE = 16;
    int FIELD_SIZE = 320 / 16 * (320 / 16);
    Image dot;
    Image apple;

    public Field() {
        setBackground(Color.black);
    }

    public void loadImage() {
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }
}
