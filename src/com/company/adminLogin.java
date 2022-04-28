package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminLogin implements ActionListener {
    JPanel panelALogin = new JPanel();
    JFrame frameALogin = new JFrame("Admin Login");
    JLabel userlabelALogin = new JLabel("Username");
    JLabel passlabelALogin = new JLabel("Password");
    JTextField usertextALogin = new JTextField(20);
    JPasswordField passtextALogin = new JPasswordField(20);
    JButton buttonALogin = new JButton();
    JButton backAdminLogin= new JButton();
    JLabel l4=new JLabel();
    ImageIcon bg4=new ImageIcon("bg.jpg");


    adminLogin() {
        frameALogin.setSize(350, 200);
        frameALogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameALogin.add(panelALogin);
        panelALogin.setLayout(null);
        userlabelALogin.setBounds(10, 20, 80, 25);
        panelALogin.add(userlabelALogin);
        usertextALogin.setBounds(100, 20, 165, 25);
        panelALogin.add(usertextALogin);
        panelALogin.add(backAdminLogin);
        userlabelALogin.setForeground(Color.white);
        passlabelALogin.setForeground(Color.white);
        userlabelALogin.setFont(new Font("SansSerif",Font.PLAIN,14));
        passlabelALogin.setFont(new Font("SansSerif",Font.PLAIN,14));

        passlabelALogin.setBounds(10, 50, 80, 25);
        panelALogin.add(passlabelALogin);

        passtextALogin.setBounds(100, 50, 165, 25);
        panelALogin.add(passtextALogin);

        backAdminLogin.setIcon(new ImageIcon("Back.png"));
        backAdminLogin.setBounds(180, 100, 47, 32);
        backAdminLogin.addActionListener(this);
        panelALogin.add(backAdminLogin);
        buttonALogin.setIcon(new ImageIcon("login.png"));
        buttonALogin.setBounds(100, 100, 47, 32);
        buttonALogin.addActionListener(this);
        panelALogin.add(buttonALogin);
        panelALogin.add(l4);

        frameALogin.setVisible(true);

        l4.setBounds(0,0,350,200);
        l4.setIcon(bg4);
        frameALogin.setLocationRelativeTo(null);
        frameALogin.setResizable(false);



    }

        @Override
        public void actionPerformed (ActionEvent e){

        String checkUser = usertextALogin.getText();
        String checkPass = passtextALogin.getText();
        if(e.getSource()==buttonALogin) {
            if ((checkUser.equals("Jasim")||checkUser.equals("Haneen")||checkUser.equals("Hirash")||checkUser.equals("Prithvi"))&& checkPass.equals("1234"))
            {
                JOptionPane.showMessageDialog(frameALogin,"LOGIN SUCCESSFUL");
                new adminMenu();
                frameALogin.dispose();
            }
        }
        else
        if(e.getSource()==backAdminLogin){
            frameALogin.dispose();
            new menu();
            }




    }

}