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

public class Car {
    public void addCar()
    {
        JFrame frameCAdd = new JFrame("Add car");
        JPanel panelCAdd = new JPanel();
        JLabel BgCAdd=new JLabel(new ImageIcon("bg.jpg"));
        JLabel namelabelCAdd = new JLabel("Car name");
        JLabel colorlabelCAdd = new JLabel("Car color");
        JLabel yearlabelCAdd = new JLabel("year");
        JLabel idlabelCAdd = new JLabel("Car ID");
        JLabel pricelabelCAdd = new JLabel("Price");
        JLabel info = new JLabel("");
        JTextField nametext = new JTextField(20);
        JTextField idtext = new JTextField(20);
        JTextField colortext = new JTextField(20);
        JTextField yeartext = new JTextField(20);
        JTextField pricetext = new JTextField(20);
        JButton cAdd = new JButton(new ImageIcon("PROCEED.png"));
        JButton backAddCar=new JButton(new ImageIcon("Back.png"));

        BgCAdd.setBounds(0,0,800,450);
        panelCAdd.setBounds(0,0,800,450);
        backAddCar.setBounds(725,365,47,32);
        panelCAdd.add(backAddCar);

        frameCAdd.setSize(800,450);
        frameCAdd.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCAdd.add(panelCAdd);
        panelCAdd.setLayout(null);
        idlabelCAdd.setBounds(10, 30, 150, 25);
        panelCAdd.add(idlabelCAdd);
        idlabelCAdd.setForeground(Color.white);
        idlabelCAdd.setFont(new Font("SansSerif",Font.PLAIN,20));
        namelabelCAdd.setBounds(10, 90, 150, 25);
        panelCAdd.add(namelabelCAdd);
        namelabelCAdd.setForeground(Color.white);
        namelabelCAdd.setFont(new Font("SansSerif",Font.PLAIN,20));
        colorlabelCAdd.setBounds(10, 150, 150, 25);
        panelCAdd.add(colorlabelCAdd);
        colorlabelCAdd.setForeground(Color.white);
        colorlabelCAdd.setFont(new Font("SansSerif",Font.PLAIN,20));
        yearlabelCAdd.setBounds(10, 210, 150, 25);
        panelCAdd.add(yearlabelCAdd);
        yearlabelCAdd.setForeground(Color.white);
        yearlabelCAdd.setFont(new Font("SansSerif",Font.PLAIN,20));
        pricelabelCAdd.setBounds(10, 270, 150, 25);
        panelCAdd.add(pricelabelCAdd);
        pricelabelCAdd.setForeground(Color.white);
        pricelabelCAdd.setFont(new Font("SansSerif",Font.PLAIN,20));

        idtext.setBounds(150, 30, 250, 25);
        panelCAdd.add(idtext);
        nametext.setBounds(150, 90, 250, 25);
        panelCAdd.add(nametext);
        colortext.setBounds(150, 150, 250, 25);
        panelCAdd.add(colortext);
        yeartext.setBounds(150, 210, 250, 25);
        panelCAdd.add(yeartext);
        pricetext.setBounds(150, 270, 250, 25);
        panelCAdd.add(pricetext);

        cAdd.setBounds(350,325,100,40);
        panelCAdd.add(cAdd);
        info.setBounds(10,380,500,25);
        panelCAdd.add(info);

        cAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkname = nametext.getText();
                String checkId = idtext.getText();
                String checkColor = colortext.getText();
                String checkYear = yeartext.getText();
                String checkPrice = pricetext.getText();
                ArrayList<String> tempArray=new ArrayList<String>();
                String line;
                String checktoken="No";
                int flag = 0;
                String[] arr;


                if (checkname.trim().isEmpty() || checkId.trim().isEmpty() || checkColor.trim().isEmpty() || checkYear.trim().isEmpty() || checkPrice.trim().isEmpty())
                {
                    info.setText("MORE INFORMATION TO BE ENTERED");
                }
                else {
                    info.setText("");

                    try{
                        FileReader fr=new FileReader("car.txt");
                        Scanner reader=new Scanner(fr);


                        while(reader.hasNextLine()){
                            line=reader.nextLine();
                            arr = line.split(",");
                            if (arr[0].equals(checkId))
                            {
                                info.setText("RECORD EXIST");
                                flag = 1;
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
                            FileWriter file1 = new FileWriter("car.txt");
                            PrintWriter pw = new PrintWriter(file1);

                            for(String str: tempArray){
                                file1.write(str);
                                pw.println();

                            }
                            file1.write(checkId + "," + checkname + "," + checkColor + "," + checkYear + "," + checkPrice+ "," +checktoken);

                            file1.close();
                            pw.close();
                            if (flag == 0)
                            {
                                JOptionPane.showMessageDialog(null,"FILE SAVED SUCCESSFULLY");
                            }


                        }catch (Exception ex) {JOptionPane.showMessageDialog(null, ex+"");
                        }

                    }



                }
            }
        });

        backAddCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCAdd.dispose();
                new adminMenu();

            }
        });

        frameCAdd.setVisible(true);
        panelCAdd.add(BgCAdd);
        frameCAdd.setLocationRelativeTo(null);
        frameCAdd.setResizable(false);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));




    }
    public  void modifyCar(){
        JFrame frameCModify = new JFrame("Modify car");
        JPanel panelCModify = new JPanel();
        JLabel BgCModify=new JLabel(new ImageIcon("bg.jpg"));
        JLabel namelabelCModify = new JLabel("Car name");
        JLabel colorlabelCModify = new JLabel("Car color");
        JLabel yearlabelCModify = new JLabel("year");
        JLabel idlabelCModify = new JLabel("Car ID");
        JLabel pricelabelCModify = new JLabel("Price");
        JLabel info = new JLabel("");
        JTextField nametext = new JTextField(20);
        JTextField idtext = new JTextField(20);
        JTextField colortext = new JTextField(20);
        JTextField yeartext = new JTextField(20);
        JTextField pricetext = new JTextField(20);
        JButton cModify = new JButton(new ImageIcon("PROCEED.png"));
        JButton backModifyCar=new JButton(new ImageIcon("Back.png"));

        BgCModify.setBounds(0,0,800,450);
        panelCModify.setBounds(0,0,800,450);
        backModifyCar.setBounds(725,365,47,32);
        panelCModify.add(backModifyCar);


        frameCModify.setSize(800,450);
        frameCModify.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCModify.add(panelCModify);
        panelCModify.setLayout(null);


        idlabelCModify.setBounds(10, 30, 150, 25);
        panelCModify.add(idlabelCModify);
        idlabelCModify.setForeground(Color.white);
        idlabelCModify.setFont(new Font("SansSerif",Font.PLAIN,20));
        namelabelCModify.setBounds(10, 90, 150, 25);
        panelCModify.add(namelabelCModify);
        namelabelCModify.setForeground(Color.white);
        namelabelCModify.setFont(new Font("SansSerif",Font.PLAIN,20));
        colorlabelCModify.setBounds(10, 150, 150, 25);
        panelCModify.add(colorlabelCModify);
        colorlabelCModify.setForeground(Color.white);
        colorlabelCModify.setFont(new Font("SansSerif",Font.PLAIN,20));
        yearlabelCModify.setBounds(10, 210, 150, 25);
        panelCModify.add(yearlabelCModify);
        yearlabelCModify.setForeground(Color.white);
        yearlabelCModify.setFont(new Font("SansSerif",Font.PLAIN,20));
        pricelabelCModify.setBounds(10, 270, 150, 25);
        panelCModify.add(pricelabelCModify);
        pricelabelCModify.setForeground(Color.white);
        pricelabelCModify.setFont(new Font("SansSerif",Font.PLAIN,20));

        idtext.setBounds(150, 30, 250, 25);
        panelCModify.add(idtext);
        nametext.setBounds(150, 90, 250, 25);
        panelCModify.add(nametext);
        colortext.setBounds(150, 150, 250, 25);
        panelCModify.add(colortext);
        yeartext.setBounds(150, 210, 250, 25);
        panelCModify.add(yeartext);
        pricetext.setBounds(150, 270, 250, 25);
        panelCModify.add(pricetext);

        cModify.setBounds(350,325,100,40);
        panelCModify.add(cModify);
        info.setBounds(10,380,500,25);
        panelCModify.add(info);

        JFrame frameCarModify2 = new JFrame("Modify Car");
        JPanel panelCarModify2 = new JPanel();
        JLabel idlabelCarModify2 = new JLabel("Enter ID");
        JButton cModify2 = new JButton(new ImageIcon("PROCEED.png"));
        JLabel BgCModify2=new JLabel(new ImageIcon("bg.jpg"));
        JButton backModifyCar2=new JButton(new ImageIcon("Back.png"));

        frameCarModify2.setSize(800,450);
        frameCarModify2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCarModify2.setLocationRelativeTo(null);
        frameCarModify2.add(panelCarModify2);
        panelCarModify2.setLayout(null);
        JTextField idCartextModify = new JTextField();
        backModifyCar2.setBounds(725,365,47,32);
        panelCarModify2.add(backModifyCar2);



        idlabelCarModify2.setBounds(10, 50, 80, 25);
        panelCarModify2.add(idlabelCarModify2);
        idlabelCarModify2.setForeground(Color.white);
        idlabelCarModify2.setFont(new Font("SansSerif",Font.PLAIN,20));
        idCartextModify.setBounds(150, 50, 250, 25);
        panelCarModify2.add(idCartextModify);

        cModify2.setBounds(350,325,100,40);
        panelCarModify2.add(cModify2);
        panelCarModify2.setBounds(0,0,800,450);
        BgCModify2.setBounds(0,0,800,450);
        panelCarModify2.add(BgCModify2);
        frameCarModify2.setVisible(true);

        cModify2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId = idCartextModify.getText();
                String line;
                int flag = 0;
                String[] arr;

                try{
                    FileReader fr=new FileReader("car.txt");
                    Scanner reader=new Scanner(fr);
                    while(reader.hasNextLine()){
                        line=reader.nextLine();
                        arr = line.split(",");
                        if (arr[0].equals(checkId))
                        {
                            frameCarModify2.dispose();
                            frameCModify.setVisible(true);
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


        cModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId2  = idtext.getText();
                String checkname = nametext.getText();
                String checkColor = colortext.getText();
                String checkYear = yeartext.getText();
                String checkPrice = pricetext.getText();
                ArrayList<String> tempArray=new ArrayList<String>();
                String line;
                int flag = 0;
                String[] arr;

                if (checkname.trim().isEmpty() || checkColor.trim().isEmpty() || checkYear.trim().isEmpty() || checkPrice.trim().isEmpty())
                {
                    info.setText("MORE INFORMATION TO BE ENTERED");
                }
                else {
                    info.setText("");

                    try{
                        FileReader fr=new FileReader("car.txt");
                        Scanner reader=new Scanner(fr);

                        while(reader.hasNextLine()){
                            line=reader.nextLine();
                            arr = line.split(",");
                            if (arr[0].equals(checkId2))
                            {
                                tempArray.add(arr[0] + "," + checkname + "," + checkColor + "," + checkYear + "," + checkPrice+ "," +arr[5]);
                                JOptionPane.showMessageDialog(null,"RECORD MODIFIED");
                            }
                            else{
                                tempArray.add(line);
                            }

                        }
                        fr.close();
                    }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                    finally {
                        try {
                            FileWriter file1 = new FileWriter("car.txt");
                            PrintWriter pw = new PrintWriter(file1);

                            for(String str: tempArray){
                                file1.write(str);
                                pw.println();

                            }
                            pw.close();
                            file1.close();
                            if (flag == 0)
                            {
                                JOptionPane.showMessageDialog(null,"FILE SAVED SUCCESSFULLY");
                            }


                        }catch (Exception ex) {JOptionPane.showMessageDialog(null, ex+"");
                        }

                    }



                }
            }
        });

        backModifyCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCModify.dispose();
                new adminMenu();

            }
        });

        backModifyCar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCarModify2.dispose();
                new adminMenu();

            }
        });

        panelCModify.add(BgCModify);
        frameCModify.setLocationRelativeTo(null);
        frameCModify.setResizable(false);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));




    }

    public void dispCar(){
        JFrame dispCarFrame = new JFrame("Car Details");
        JPanel dispCarPanel = new JPanel();
        JLabel dispCarBg=new JLabel();
        JButton backdispCar=new JButton(new ImageIcon("Back.png"));


        dispCarPanel.setBounds(0,0,800,450);
        dispCarBg.setIcon(new ImageIcon("bg.jpg"));
        dispCarBg.setBounds(0,0,800,450);

        dispCarFrame.add(dispCarPanel);


        backdispCar.setBounds(725, 365, 47, 32);
        dispCarPanel.add(backdispCar);

        dispCarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispCarFrame.setSize(800,450);
        dispCarFrame.setLayout(null);
        dispCarPanel.setLayout(null);
        dispCarFrame.setVisible(true);
        dispCarFrame.setLocationRelativeTo(null);
        dispCarFrame.setResizable(false);

        DefaultTableModel model = new DefaultTableModel();
        JTable table=new JTable(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Color");
        model.addColumn("Year");
        model.addColumn("RentPrice");
        model.addColumn("CarRented");
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
        dispCarPanel.add(sp);
        table.setOpaque(false);

        dispCarPanel.add(dispCarBg);


        String line;
        String[] arr;

        try{
            FileReader fr=new FileReader("car.txt");
            Scanner reader=new Scanner(fr);
            while(reader.hasNextLine()){
                line=reader.nextLine();
                arr = line.split(",");
                model.addRow(arr);

            }
            fr.close();
        }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}

        backdispCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispCarFrame.dispose();
                new adminMenu();

            }
        });




    }



    public void delCar()
    {
        JFrame frameCarDel = new JFrame("Delete Car");
        JPanel panelCarDel = new JPanel();
        JLabel idlabelCarDel = new JLabel("Enter ID");
        JButton cDEL = new JButton(new ImageIcon("PROCEED.png"));
        JLabel BgCDel=new JLabel(new ImageIcon("bg.jpg"));
        JButton backDelCar=new JButton(new ImageIcon("Back.png"));


        frameCarDel.setSize(800,450);
        frameCarDel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameCarDel.add(panelCarDel);
        panelCarDel.setLayout(null);
        JTextField idCartextDel = new JTextField();

        idlabelCarDel.setBounds(10, 50, 80, 25);
        panelCarDel.add(idlabelCarDel);
        idlabelCarDel.setForeground(Color.white);
        idlabelCarDel.setFont(new Font("SansSerif",Font.PLAIN,20));
        idCartextDel.setBounds(150, 50, 250, 25);
        panelCarDel.add(idCartextDel);

        cDEL.setBounds(350,325,100,40);
        panelCarDel.add(cDEL);
        panelCarDel.setBounds(0,0,800,450);
        backDelCar.setBounds(725,365,47,32);
        panelCarDel.add(backDelCar);
        BgCDel.setBounds(0,0,800,450);
        panelCarDel.add(BgCDel);



        cDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String checkId = idCartextDel.getText();
                ArrayList<String> tempArray=new ArrayList<String>();
                String line;
                int flag = 0;
                String[] arr;

                try{
                    FileReader fr=new FileReader("car.txt");
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
                        FileWriter file1 = new FileWriter("car.txt");
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

        backDelCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frameCarDel.dispose();
                new adminMenu();

            }
        });


        frameCarDel.setVisible(true);
        frameCarDel.setLocationRelativeTo(null);
        frameCarDel.setResizable(false);
    }
}
