package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu implements ActionListener {

    JFrame frame = new JFrame("Main Menu");
    JPanel panel = new JPanel();
    JButton admin = new JButton();
    JButton customer = new JButton();
    JLabel l=new JLabel();
    ImageIcon bg=new ImageIcon("bg.jpg");



    menu()
    {



        panel.setBounds(0,0,800,450);
        admin.setBounds(50,50,300,300);
        customer.setBounds(430,50,300,300);
        admin.setIcon(new ImageIcon("admin.png"));
        customer.setIcon(new ImageIcon("custumer.png"));
        admin.addActionListener(this);
        customer.addActionListener(this);
        l.setIcon(bg);
        l.setBounds(0,0,800,450);

        admin.setBackground(new Color(0,0,0,0));
        admin.setOpaque(false);
        customer.setBackground(new Color(0,0,0,0));
        customer.setOpaque(false);
        admin.setBorderPainted(false);
        customer.setBorderPainted(false);
        frame.add(panel);
        panel.add(admin);
        panel.add(customer);
        panel.add(l);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,450);
        frame.setLayout(null);
        panel.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);





    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==admin) {
            frame.dispose();
            new adminLogin();
        }
        else
        if(e.getSource()==customer){
            frame.dispose();
           new customerLogin();
        }
    }
}
