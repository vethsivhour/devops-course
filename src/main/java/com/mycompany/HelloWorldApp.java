package com.mycompany;

import javax.swing.*;
import java.awt.*;

public class HelloWorldApp {
    public HelloWorldApp() {  // Changed from CounterApp to HelloWorldApp
        // Create the frame
        JFrame frame = new JFrame("Hello World App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create the hello world label
        JLabel helloLabel = new JLabel("Hello, World!");
        helloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(helloLabel);

        // Center the frame on screen
        frame.setLocationRelativeTo(null);
        
        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloWorldApp();  // Changed from CounterApp to HelloWorldApp
            }
        });
    }
}