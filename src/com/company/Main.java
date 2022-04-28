package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    public static void main(String[] args) {
        JFrame introFrame=new JFrame("PLATINUM RentACar");
        JPanel introPanel=new JPanel();
        JButton introButton=new JButton(new ImageIcon("intro.png"));

        introPanel.setBounds(0,0,800,450);
        introFrame.add(introPanel);
        introButton.setBounds(0,0,800,450);
        introButton.setBorderPainted(false);
        introPanel.add(introButton);

        introButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                introFrame.dispose();
                new menu();
            }
        });

        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        introFrame.setSize(800,450);
        introFrame.setLayout(null);
        introPanel.setLayout(null);
        introFrame.setVisible(true);
        introFrame.setLocationRelativeTo(null);
        introFrame.setResizable(false);
    }
}
