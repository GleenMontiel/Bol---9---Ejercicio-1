package app;

import javax.swing.*;
    
public class App {

    public static void main(String[] args) throws Exception {

        Principal frame = new Principal();
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }
}