package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Scanner;

public class customerLogin implements ActionListener {
    JPanel panelCLogin = new JPanel();
    JFrame frameCLogin = new JFrame("Customer Login");
    JLabel userlabelCLogin = new JLabel("Username");
    JLabel passlabelCLogin = new JLabel("Password");
    JTextField usertextCLogin = new JTextField(20);
    JPasswordField passtextCLogin = new JPasswordField(20);
    JButton buttonCLogin = new JButton();
    JButton backCLogin= new JButton();
    JLabel l4=new JLabel();
    ImageIcon bg9=new ImageIcon("bg.jpg");

    customerLogin(){
        frameCLogin.setSize(350, 200);
        frameCLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCLogin.add(panelCLogin);
        panelCLogin.setLayout(null);
        userlabelCLogin.setBounds(10, 20, 80, 25);
        panelCLogin.add(userlabelCLogin);
        usertextCLogin.setBounds(100, 20, 165, 25);
        panelCLogin.add(usertextCLogin);
        panelCLogin.add(backCLogin);
        userlabelCLogin.setForeground(Color.white);
        passlabelCLogin.setForeground(Color.white);
        userlabelCLogin.setFont(new Font("SansSerif",Font.PLAIN,14));
        passlabelCLogin.setFont(new Font("SansSerif",Font.PLAIN,14));

        passlabelCLogin.setBounds(10, 50, 80, 25);
        panelCLogin.add(passlabelCLogin);

        passtextCLogin.setBounds(100, 50, 165, 25);
        panelCLogin.add(passtextCLogin);

        backCLogin.setIcon(new ImageIcon("Back.png"));
        backCLogin.setBounds(180, 100, 47, 32);
        backCLogin.addActionListener(this);
        panelCLogin.add(backCLogin);
        buttonCLogin.setIcon(new ImageIcon("login.png"));
        buttonCLogin.setBounds(100, 100, 47, 32);
        buttonCLogin.addActionListener(this);
        panelCLogin.add(buttonCLogin);
        panelCLogin.add(l4);

        frameCLogin.setVisible(true);

        l4.setBounds(0,0,350,200);
        l4.setIcon(bg9);
        frameCLogin.setLocationRelativeTo(null);
        frameCLogin.setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String checkUser = usertextCLogin.getText();
        String checkPass = passtextCLogin.getText();
        if(e.getSource()==buttonCLogin) {
            try {
                FileReader fr = new FileReader("customer.txt");
                Scanner reader1 = new Scanner(fr);
                String line;
                String[] arr;

                while (reader1.hasNextLine()) {
                    line = reader1.nextLine();
                    arr = line.split(",");
                    if (arr[0].equals(checkUser)&&arr[2].equals(checkPass))
                    {
                        JOptionPane.showMessageDialog(frameCLogin,"LOGIN SUCCESSFUL");
                        new customerMenu(checkUser);
                        frameCLogin.dispose();
                    }
                }
                fr.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1 + "");}

        }
        else
        if(e.getSource()==backCLogin){
            frameCLogin.dispose();
            new menu();
        }

    }
}
