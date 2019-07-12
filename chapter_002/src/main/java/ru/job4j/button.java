package ru.job4j;
import javax.swing.*;

public class button {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton button = new JButton("Click me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

}
