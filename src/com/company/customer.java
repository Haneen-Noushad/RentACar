package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class customer {
   public void addCus()
    {
        JFrame frameCusAdd = new JFrame("Add Customer");
        JPanel panelCusAdd = new JPanel();
        JLabel namelabelCusAdd = new JLabel("Name");
        JLabel idlabelCusAdd = new JLabel("ID");
        JLabel passlabelCusAdd = new JLabel("Password");
        JButton CusAdd = new JButton(new ImageIcon("PROCEED.png"));
        JLabel info = new JLabel("");
        JLabel BgCusAdd=new JLabel(new ImageIcon("bg.jpg"));
        JTextField namecustext = new JTextField(20);
        JTextField idcustext = new JTextField(20);
        JTextField passcustext = new JTextField(20);
        JButton backAddCus=new JButton(new ImageIcon("Back.png"));


        BgCusAdd.setBounds(0,0,800,450);
        panelCusAdd.setBounds(0,0,800,450);
        backAddCus.setBounds(725,365,47,32);
        panelCusAdd.add(backAddCus);

        frameCusAdd.setSize(800,450);
        frameCusAdd.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCusAdd.add(panelCusAdd);
        panelCusAdd.setLayout(null);

        idlabelCusAdd.setBounds(10, 50, 150, 25);
        panelCusAdd.add(idlabelCusAdd);
        idlabelCusAdd.setForeground(Color.white);
        idlabelCusAdd.setFont(new Font("SansSerif",Font.PLAIN,20));
        namelabelCusAdd.setBounds(10, 110, 150, 25);
        panelCusAdd.add(namelabelCusAdd);
        namelabelCusAdd.setForeground(Color.white);
        namelabelCusAdd.setFont(new Font("SansSerif",Font.PLAIN,20));
        passlabelCusAdd.setBounds(10,170,150,25);
        panelCusAdd.add(passlabelCusAdd);
        passlabelCusAdd.setForeground(Color.white);
        passlabelCusAdd.setFont(new Font("SansSerif",Font.PLAIN,20));

        namecustext.setBounds(150, 110, 250, 25);
        panelCusAdd.add(namecustext);
        idcustext.setBounds(150, 50, 250, 25);
        panelCusAdd.add(idcustext);
        passcustext.setBounds(150,170,250,25);
        panelCusAdd.add(passcustext);

        CusAdd.setBounds(350,325,100,40);
        panelCusAdd.add(CusAdd);

        info.setBounds(10,380,500,25);
        panelCusAdd.add(info);
        frameCusAdd.setVisible(true);

        CusAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkname = namecustext.getText();
                String checkId = idcustext.getText();
                String checkpass = passcustext.getText();
                int flag = 0;
                ArrayList<String> tempArray1 = new ArrayList<String>();
                String line;
                String[] arr;
                String carNo="NIL";

                if (checkname.trim().isEmpty() || checkId.trim().isEmpty() || checkpass.trim().isEmpty()) {
                    info.setText("MORE INFORMATION TO BE ENTERED");
                } else {

                    try {
                        FileReader fr = new FileReader("customer.txt");
                        Scanner reader1 = new Scanner(fr);


                        while (reader1.hasNextLine()) {
                            line = reader1.nextLine();
                            arr = line.split(",");
                            if (arr[0].equals(checkId))
                            {
                                info.setText("Customer record exist");
                                flag = 1;
                            }
                            else
                            {
                                tempArray1.add(line);
                            }
                        }
                        fr.close();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1 + "");
                    } finally {
                        try {
                            FileWriter file2 = new FileWriter("customer.txt");
                            PrintWriter pw1 = new PrintWriter(file2);


                            for (String str : tempArray1) {
                                file2.write(str);
                                pw1.println();

                            }
                            file2.write(checkId + "," + checkname + "," + checkpass + "," +carNo);

                            file2.close();
                            if (flag==0)
                            {
                                JOptionPane.showMessageDialog(null, "File saved successfully");
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex + "");
                        }

                    }
                }
            }
        });

        backAddCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCusAdd.dispose();
                new adminMenu();

            }
        });

        panelCusAdd.add(BgCusAdd);
        frameCusAdd.setLocationRelativeTo(null);
        frameCusAdd.setResizable(false);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));
    }

    public void modifyCus()
    {
        JFrame frameCusModify = new JFrame("Modify Customer");
        JPanel panelCusModify = new JPanel();
        JLabel BgCusModify=new JLabel(new ImageIcon("bg.jpg"));
        JLabel namelabelCusModify = new JLabel("Customer Name");
        JLabel idlabelCusModify = new JLabel("Customer ID");
        JLabel passlabelCusModify = new JLabel("Password");
        JLabel info = new JLabel("");
        JTextField nametext = new JTextField(20);
        JTextField idtext = new JTextField(20);
        JTextField passtext = new JTextField(20);
        JButton CusModify = new JButton(new ImageIcon("PROCEED.png"));
        JButton backModifyCus=new JButton(new ImageIcon("Back.png"));

        BgCusModify.setBounds(0,0,800,450);
        panelCusModify.setBounds(0,0,800,450);
        backModifyCus.setBounds(725,365,47,32);
        panelCusModify.add(backModifyCus);


        frameCusModify.setSize(800,450);
        frameCusModify.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCusModify.add(panelCusModify);
        panelCusModify.setLayout(null);


        idlabelCusModify.setBounds(10, 30, 150, 25);
        panelCusModify.add(idlabelCusModify);
        idlabelCusModify.setForeground(Color.white);
        idlabelCusModify.setFont(new Font("SansSerif",Font.PLAIN,20));
        namelabelCusModify.setBounds(10, 90, 150, 25);
        panelCusModify.add(namelabelCusModify);
        namelabelCusModify.setForeground(Color.white);
        namelabelCusModify.setFont(new Font("SansSerif",Font.PLAIN,20));
        passlabelCusModify.setBounds(10, 150, 150, 25);
        panelCusModify.add(passlabelCusModify);
        passlabelCusModify.setForeground(Color.white);
        passlabelCusModify.setFont(new Font("SansSerif",Font.PLAIN,20));

        idtext.setBounds(150, 30, 250, 25);
        panelCusModify.add(idtext);
        nametext.setBounds(150, 90, 250, 25);
        panelCusModify.add(nametext);
        passtext.setBounds(150, 150, 250, 25);
        panelCusModify.add(passtext);

        CusModify.setBounds(350,325,100,40);
        panelCusModify.add(CusModify);
        info.setBounds(10,380,500,25);
        panelCusModify.add(info);

        JFrame frameCusModify2 = new JFrame("Modify Custumer");
        JPanel panelCusModify2 = new JPanel();
        JLabel idlabelCusModify2 = new JLabel("Enter ID");
        JButton CusModify2 = new JButton(new ImageIcon("PROCEED.png"));
        JLabel BgCusModify2=new JLabel(new ImageIcon("bg.jpg"));
        JButton backModifyCus2=new JButton(new ImageIcon("Back.png"));


        frameCusModify2.setSize(800,450);
        frameCusModify2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCusModify2.add(panelCusModify2);
        panelCusModify2.setLayout(null);
        frameCusModify2.setLocationRelativeTo(null);
        JTextField idCustextModify = new JTextField();
        backModifyCus2.setBounds(725,365,47,32);
        panelCusModify2.add(backModifyCus2);

        idlabelCusModify2.setBounds(10, 50, 80, 25);
        panelCusModify2.add(idlabelCusModify2);
        idlabelCusModify2.setForeground(Color.white);
        idlabelCusModify2.setFont(new Font("SansSerif",Font.PLAIN,20));
        idCustextModify.setBounds(150, 50, 250, 25);
        panelCusModify2.add(idCustextModify);

        CusModify2.setBounds(350,325,100,40);
        panelCusModify2.add(CusModify2);
        panelCusModify2.setBounds(0,0,800,450);
        BgCusModify2.setBounds(0,0,800,450);
        panelCusModify2.add(BgCusModify2);
        frameCusModify2.setVisible(true);

        CusModify2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId = idCustextModify.getText();
                String line;
                int flag = 0;
                String[] arr;

                try{
                    FileReader fr=new FileReader("customer.txt");
                    Scanner reader=new Scanner(fr);
                    while(reader.hasNextLine()){
                        line=reader.nextLine();
                        arr = line.split(",");
                        if (arr[0].equals(checkId))
                        {
                            frameCusModify2.dispose();
                            frameCusModify.setVisible(true);
                            idtext.setText(checkId);
                            idtext.setEditable(false);
                            flag=1;


                        }
                    }
                    fr.close();
            }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                finally {
                    if(flag==0){
                        JOptionPane.showMessageDialog(null,"RECORD NOT FOUND");
                    }
                }
            }
        });

        CusModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId2 = idtext.getText();
                String checkname = nametext.getText();
                String checkpass = passtext.getText();

                ArrayList<String> tempArray = new ArrayList<String>();
                String line;
                int flag = 0;
                String[] arr;

                if (checkname.trim().isEmpty() || checkId2.trim().isEmpty() || checkpass.trim().isEmpty()) {
                    info.setText("MORE INFORMATION TO BE ENTERED");
                } else {

                    try {
                        FileReader fr = new FileReader("customer.txt");
                        Scanner reader = new Scanner(fr);

                        while (reader.hasNextLine()) {
                            line = reader.nextLine();
                            arr = line.split(",");
                            if (arr[0].equals(checkId2)) {
                                tempArray.add(arr[0] +  "," + checkname + "," + checkpass + "," + arr[3]);
                                JOptionPane.showMessageDialog(null, "RECORD MODIFIED");
                            } else {
                                tempArray.add(line);
                            }

                        }
                        fr.close();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1 + "");
                    } finally {
                        try {
                            FileWriter file1 = new FileWriter("customer.txt");
                            PrintWriter pw = new PrintWriter(file1);

                            for (String str : tempArray) {
                                file1.write(str);
                                pw.println();

                            }
                            pw.close();
                            file1.close();
                            if (flag == 0) {
                                JOptionPane.showMessageDialog(null, "FILE SAVED SUCCESSFULLY");
                            }


                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex + "");
                        }
                    }
                }
            }
        });

        backModifyCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCusModify.dispose();
                new adminMenu();

            }
        });

        backModifyCus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCusModify2.dispose();
                new adminMenu();

            }
        });

        panelCusModify.add(BgCusModify);
        frameCusModify.setLocationRelativeTo(null);
        frameCusModify.setResizable(false);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));



    }

    public void dispCus()
    {
        JFrame dispCusFrame = new JFrame("Customer Details");
        JPanel dispCusPanel = new JPanel();
        JLabel dispCusBg=new JLabel();
        JButton backDispCus=new JButton(new ImageIcon("Back.png"));

        dispCusPanel.setBounds(0,0,800,450);
        dispCusBg.setIcon(new ImageIcon("bg.jpg"));
        dispCusBg.setBounds(0,0,800,450);

        dispCusFrame.add(dispCusPanel);

        backDispCus.setBounds(725, 365, 47, 32);
        dispCusPanel.add(backDispCus);

        dispCusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispCusFrame.setSize(800,450);
        dispCusFrame.setLayout(null);
        dispCusPanel.setLayout(null);
        dispCusFrame.setVisible(true);
        dispCusFrame.setLocationRelativeTo(null);
        dispCusFrame.setResizable(false);

        DefaultTableModel model = new DefaultTableModel();
        JTable table=new JTable(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Password");
        model.addColumn("Car No");

        JTableHeader tableheader = table.getTableHeader();
        table.setRowHeight(35);
        table.setBackground(new Color(0,0,0,0));
        table.setForeground(Color.white);
        tableheader.setForeground(Color.white);
        tableheader.setFont(new Font("Serif", Font.BOLD, 20));
        tableheader.setBackground(Color.black);
        table.setSelectionBackground(Color.gray);
        table.setShowGrid(false);

        table.setFont(new Font("Serif", Font.PLAIN, 15));

        JScrollPane sp=new JScrollPane(table);
        sp.getViewport().setBackground(Color.darkGray);


        sp.setBounds(35,20,700,300);
        dispCusPanel.add(sp);
        table.setOpaque(false);


        dispCusPanel.add(dispCusBg);

        String line;
        String[] arr;

        try{
            FileReader fr=new FileReader("customer.txt");
            Scanner reader=new Scanner(fr);
            while(reader.hasNextLine()){
                line=reader.nextLine();
                arr = line.split(",");
                model.addRow(arr);

            }
            fr.close();
        }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}

        backDispCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispCusFrame.dispose();
                new adminMenu();

            }
        });




    }

    public void delCus()
    {
        JFrame frameCusDel = new JFrame("Delete Customer");
        JPanel panelCusDel = new JPanel();
        JLabel idlabelCusDel = new JLabel("Enter ID");
        JButton cusDEL = new JButton(new ImageIcon("PROCEED.png"));
        JLabel BgCusDel=new JLabel(new ImageIcon("bg.jpg"));
        JButton backDelCus=new JButton(new ImageIcon("Back.png"));

        frameCusDel.setSize(800,450);
        frameCusDel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCusDel.add(panelCusDel);
        panelCusDel.setLayout(null);
        JTextField idCustextDel = new JTextField();

        idlabelCusDel.setBounds(10, 50, 80, 25);
        panelCusDel.add(idlabelCusDel);
        idlabelCusDel.setForeground(Color.white);
        idlabelCusDel.setFont(new Font("SansSerif",Font.PLAIN,20));
        idCustextDel.setBounds(150, 50, 250, 25);
        panelCusDel.add(idCustextDel);

        cusDEL.setBounds(350,325,100,40);
        panelCusDel.add(cusDEL);
        panelCusDel.setBounds(0,0,800,450);
        backDelCus.setBounds(725,365,47,32);
        panelCusDel.add(backDelCus);
        BgCusDel.setBounds(0,0,800,450);
        panelCusDel.add(BgCusDel);

        cusDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId = idCustextDel.getText();
                ArrayList<String> tempArray=new ArrayList<String>();
                String line;
                int flag = 0;
                String[] arr;

                try{
                    FileReader fr=new FileReader("customer.txt");
                    Scanner reader=new Scanner(fr);


                    while(reader.hasNextLine()){
                        line=reader.nextLine();
                        arr = line.split(",");
                        if (arr[0].equals(checkId))
                        {
                            JOptionPane.showMessageDialog(null,"RECORD DELETED");
                            flag=1;
                        }
                        else
                        {
                            tempArray.add(line);
                        }
                    }
                    fr.close();
                }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                finally {
                    try {
                        FileWriter file1 = new FileWriter("customer.txt");
                        PrintWriter pw = new PrintWriter(file1);

                        for(String str: tempArray){
                            file1.write(str);
                            pw.println();

                        }
                        pw.close();
                        file1.close();
                        if (flag == 0)
                        {
                            JOptionPane.showMessageDialog(null,"RECORD NOT FOUND");
                        }


                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, ex+"");
                    }

                }
            }
        });

        backDelCus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCusDel.dispose();
                new adminMenu();

            }
        });

        frameCusDel.setVisible(true);
        frameCusDel.setLocationRelativeTo(null);
        frameCusDel.setResizable(false);





    }
}
