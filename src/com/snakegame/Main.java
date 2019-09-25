package com.snakegame;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        Main window = new Main();
    }

    public Main() {
        add(new Field());
        setTitle("Snake game");
        setLocation(300, 500);
        setSize(320, 345);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
