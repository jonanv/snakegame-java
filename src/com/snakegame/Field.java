package com.snakegame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Field extends JPanel implements ActionListener {
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
    boolean left = false;
    boolean right = true;
    boolean up = false;
    boolean down = false;
    Timer timer;
    boolean inGame = true;

    void createApple() {
        appleX = new Random().nextInt(WIDTH/DOT_SIZE) * DOT_SIZE;
        appleY = new Random().nextInt(WIDTH/DOT_SIZE) * DOT_SIZE;
    }

    void intGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        createApple();
        timer = new Timer(150, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        checkCollisions();
        checkApple();
        move();
        repaint();
    }

    void checkApple() {
        if(x[0] == appleX && y[0] == appleY) {
            dots++;
            createApple();
        }
    }

    void checkCollisions() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }
        if (y[0] > WIDTH){
            inGame = false;
        }
        if (x[0] > WIDTH){
            inGame = false;
        }
        if (y[0] < 0){
            inGame = false;
        }
        if (x[0] < 0){
            inGame = false;
        }
        if (!inGame) {
            timer.stop();
        }
    }

    void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if (left) {
            x[0] = x[0] - DOT_SIZE;
        }
        if (right) {
            x[0] = x[0] + DOT_SIZE;
        }
        if (up) {
            y[0] = y[0] - DOT_SIZE;
        }
        if (down) {
            y[0] = y[0] + DOT_SIZE;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }
        }
    }

    public Field() {
        setBackground(Color.black);
        loadImage();
        intGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public void loadImage() {
        ImageIcon iia = new ImageIcon("apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
    }

    class FieldKeyListener extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_UP && !down) {
                left = false;
                up = true;
                right = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                left = false;
                right = false;
                down = true;
            }
        }
    }
}
