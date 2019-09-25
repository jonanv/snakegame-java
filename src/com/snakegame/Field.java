package com.snakegame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Field extends JPanel {
    int WIDTH = 320;
    int DOT_SIZE = 16;
    int FIELD_SIZE = 320 / 16 * (320 / 16);
    Image dot;
    Image apple;
    int appleX;
    int appleY;
    int[] x = new int[FIELD_SIZE];
    int[] y = new int[FIELD_SIZE];
    int dots;

    void createApple() {
        appleX = new Random().nextInt(WIDTH/DOT_SIZE) * DOT_SIZE;
        appleY = new Random().nextInt(WIDTH/DOT_SIZE) * DOT_SIZE;
    }

    void intGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * DOT_SIZE;
            y[i] = 50;
        }
        createApple();
    }

    public Field() {
        setBackground(Color.black);
        loadImage();
        intGame();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(apple, appleX, appleY, this);
        for (int i = 0; i < dots; i++) {
            g.drawImage(dot, x[i], y[i], this);
        }
    }

    public void loadImage() {
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }
}
