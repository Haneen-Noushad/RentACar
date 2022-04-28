package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMenu implements ActionListener {
    Car c = new Car();
    customer cus = new customer();
    JFrame frame5= new JFrame("Admin Menu");
    JPanel panel5=new JPanel();
    JButton createA = new JButton(new ImageIcon("create.png"));
    JButton createC = new JButton(new ImageIcon("create.png"));
    JButton dispC = new JButton(new ImageIcon("display.png"));
    JButton dispA = new JButton(new ImageIcon("display.png"));
    JButton modifyA = new JButton(new ImageIcon("modify.png"));
    JButton modifyC = new JButton(new ImageIcon("modify.png"));
    JButton delA = new JButton(new ImageIcon("delete.png"));
    JButton delC = new JButton(new ImageIcon("delete.png"));
    JButton backAdminMenu = new JButton(new ImageIcon("Back.png"));
    JLabel l2=new JLabel();
    ImageIcon bg2=new ImageIcon("bg.jpg");

    ImageIcon icon=new ImageIcon("label1.png");
    ImageIcon icon2=new ImageIcon("label2.png");
    JLabel label1=new JLabel(icon,JLabel.CENTER);
    JLabel label2=new JLabel(icon2,JLabel.CENTER);


    adminMenu()
    {
        panel5.setBounds(0,0,800,450);
        createA.setBounds(100,70,150,75);
        modifyA.setBounds(100,145,150,75);
        dispA.setBounds(100,220,150,75);
        delA.setBounds(100,295,150,75);
        createC.setBounds(500,70,150,75);
        modifyC.setBounds(500,145,150,75);
        dispC.setBounds(500,220,150,75);
        delC.setBounds(500,295,150,75);
        label1.setBounds(40,0,300,100);
        label2.setBounds(440,0,300,100);
        l2.setBounds(0,0,800,450);
        l2.setIcon(bg2);

        createA.setBackground(new Color(0,0,0,0));
        createA.setOpaque(false);
        createA.setBorderPainted(false);
        createC.setBackground(new Color(0,0,0,0));
        createC.setOpaque(false);
        createC.setBorderPainted(false);
        modifyA.setBackground(new Color(0,0,0,0));
        modifyA.setOpaque(false);
        modifyA.setBorderPainted(false);
        modifyC.setBackground(new Color(0,0,0,0));
        modifyC.setOpaque(false);
        modifyC.setBorderPainted(false);
        dispA.setBackground(new Color(0,0,0,0));
        dispA.setOpaque(false);
        dispA.setBorderPainted(false);
        dispC.setBackground(new Color(0,0,0,0));
        dispC.setOpaque(false);
        dispC.setBorderPainted(false);
        delA.setBackground(new Color(0,0,0,0));
        delA.setOpaque(false);
        delA.setBorderPainted(false);
        delC.setBackground(new Color(0,0,0,0));
        delC.setOpaque(false);
        delC.setBorderPainted(false);


        backAdminMenu.setBounds(725, 365, 47, 32);
        backAdminMenu.addActionListener(this);
        panel5.add(backAdminMenu);

        frame5.add(panel5);
        panel5.add(createA);
        panel5.add(modifyA);
        panel5.add(dispA);
        panel5.add(delA);
        panel5.add(createC);
        panel5.add(modifyC);
        panel5.add(dispC);
        panel5.add(delC);
        panel5.add(label1);
        panel5.add(label2);
        panel5.add(l2);



        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setSize(800,450);
        frame5.setLayout(null);
        panel5.setLayout(null);
        frame5.setVisible(true);
        frame5.setLocationRelativeTo(null);
        frame5.setResizable(false);

        createA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame5.dispose();
                c.addCar();
            }
        });

        createC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame5.dispose();
                cus.addCus();
            }
        });

        modifyA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
                c.modifyCar();
            }
        });

        modifyC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
                cus.modifyCus();
            }
        });

        delC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
                cus.delCus();
            }
        });

        delA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
                c.delCar();
            }
        });
        dispA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
                c.dispCar();
            }
        });

        dispC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame5.dispose();
                cus.dispCus();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backAdminMenu){
            frame5.dispose();
            new menu();
        }
    }


}
