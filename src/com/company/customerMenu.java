package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerMenu implements ActionListener {

    JFrame frame6= new JFrame("Customer Menu");
    JPanel panel6=new JPanel();
    JLabel l3=new JLabel();
    ImageIcon bg3=new ImageIcon("bg.jpg");
    ImageIcon r1=new ImageIcon("RENTACAR.png");
    ImageIcon r2=new ImageIcon("RETURNACAR.png");
    JButton rent = new JButton();
    JButton ret = new JButton();
    JButton backCusMenu = new JButton(new ImageIcon("Back.png"));
    String idCustomerMenu;


    customerMenu(String id)
    {
        idCustomerMenu = id;
        panel6.setBounds(0,0,800,450);
        rent.setBounds(150,70,500,100);
        ret.setBounds(150,220,500,100);
        rent.setIcon(r1);
        ret.setIcon(r2);
        l3.setBounds(0,0,800,450);
        l3.setIcon(bg3);
        rent.addActionListener(this);
        ret.addActionListener(this);

        rent.setBackground(new Color(0,0,0,0));
        rent.setOpaque(false);
        ret.setBackground(new Color(0,0,0,0));
        ret.setOpaque(false);
        rent.setBorderPainted(false);
        ret.setBorderPainted(false);

        backCusMenu.setBounds(725, 365, 47, 32);
        backCusMenu.addActionListener(this);
        panel6.add(backCusMenu);
        frame6.add(panel6);
        panel6.add(rent);
        panel6.add(ret);
        panel6.add(l3);


        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setSize(800,450);
        frame6.setLayout(null);
        panel6.setLayout(null);
        frame6.setVisible(true);
        frame6.setLocationRelativeTo(null);
        frame6.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rent) {
            frame6.dispose();
            new rentCar(idCustomerMenu);
        }
        else
        if(e.getSource()==ret){
            frame6.dispose();
            new returnCar(idCustomerMenu);
        }
        else
        if(e.getSource()==backCusMenu){
            frame6.dispose();
            new menu();
        }
    }
}
