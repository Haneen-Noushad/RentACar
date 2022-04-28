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

public class rentCar implements ActionListener {
    JFrame rentCarFrame = new JFrame("Rent Car");
    JPanel rentCarPanel = new JPanel();
    JLabel idLabelrentCar = new JLabel("Enter ID");
    JButton proceedRentCar = new JButton(new ImageIcon("PROCEED.png"));
    JLabel rentCarBg=new JLabel();
    JTextField idTextRentCar = new JTextField();
    JButton backRentCar=new JButton(new ImageIcon("Back.png"));
    String idRentCar;
    JLabel info=new JLabel();

    rentCar(String id){
        idRentCar= id;
        rentCarPanel.setBounds(0,0,800,450);
        rentCarBg.setIcon(new ImageIcon("bg.jpg"));
        rentCarBg.setBounds(0,0,800,450);
        idLabelrentCar.setBounds(10,310,80,25);
        rentCarPanel.add(idLabelrentCar);
        idLabelrentCar.setForeground(Color.white);
        idLabelrentCar.setFont(new Font("SansSerif",Font.PLAIN,20));
        idTextRentCar.setBounds(150, 310, 250, 25);
        rentCarPanel.add(idTextRentCar);


        rentCarFrame.add(rentCarPanel);
        info.setBounds(10,380,500,25);
        rentCarPanel.add(info);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));


        backRentCar.setBounds(725, 365, 47, 32);
        backRentCar.addActionListener(this);
        rentCarPanel.add(backRentCar);
        proceedRentCar.setBounds(350,350,100,40);
        rentCarPanel.add(proceedRentCar);
        proceedRentCar.addActionListener(this);

        rentCarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rentCarFrame.setSize(800,450);
        rentCarFrame.setLayout(null);
        rentCarPanel.setLayout(null);
        rentCarFrame.setVisible(true);
        rentCarFrame.setLocationRelativeTo(null);
        rentCarFrame.setResizable(false);

        DefaultTableModel model=new DefaultTableModel();
        JTable table=new JTable(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Color");
        model.addColumn("Year");
        model.addColumn("RentPrice");
        model.addColumn("CarRented");
        table.setRowHeight(35);
        table.setBackground(new Color(0,0,0,0));
        table.setForeground(Color.white);
        JTableHeader tableheader = table.getTableHeader();
        tableheader.setForeground(Color.white);
        tableheader.setFont(new Font("Serif", Font.BOLD, 20));
        tableheader.setBackground(Color.black);
        table.setSelectionBackground(Color.gray);
        table.setShowGrid(false);

        table.setFont(new Font("Serif", Font.PLAIN, 15));

        JScrollPane sp=new JScrollPane(table);
        sp.getViewport().setBackground(Color.darkGray);
        sp.setBounds(35,20,700,275);
        rentCarPanel.add(sp);
        table.setOpaque(false);
        rentCarPanel.add(rentCarBg);

        String line;
        String[] arr;


        try{
            FileReader fr=new FileReader("car.txt");
            Scanner reader=new Scanner(fr);
            while(reader.hasNextLine()){
                line=reader.nextLine();
                arr = line.split(",");
                if(!(line.equals(""))){
                    if (arr[5].equalsIgnoreCase("No")) {
                        model.addRow(arr);
                    }

                }
            }
            fr.close();
        }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
    }



    @Override
    public void actionPerformed(ActionEvent ea) {
        if(ea.getSource()==proceedRentCar){
            String checkCarId = idTextRentCar.getText();
            ArrayList<String> tempArray = new ArrayList<String>();
            ArrayList<String> tempArray2 = new ArrayList<String>();
            int flag=1;
            String line;
            String[] arr;

            if(checkCarId.trim().isEmpty()){
                info.setText("ENTER CAR ID");
            }
            else{
                info.setText("");
                try{
                    FileReader fr=new FileReader("customer.txt");
                    Scanner reader=new Scanner(fr);
                    while(reader.hasNextLine()){
                        line=reader.nextLine();
                        arr = line.split(",");
                        if (arr[0].equals(idRentCar))
                        {
                            if(arr[3].equals("NIL")){

                                tempArray.add(arr[0] +  "," + arr[1] + "," + arr[2] + "," + checkCarId);


                                String line2;
                                String[] arr2;
                                try{
                                    FileReader fr2=new FileReader("car.txt");
                                    Scanner reader2=new Scanner(fr2);

                                    while(reader2.hasNextLine()){
                                        line2=reader2.nextLine();
                                        arr2 = line2.split(",");

                                        if (arr2[0].equals(checkCarId))
                                        {
                                            if(arr2[5].equalsIgnoreCase("No")){
                                                tempArray2.add(arr2[0] + "," + arr2[1] + "," + arr2[2] + "," + arr2[3] + "," + arr2[4] + "," +"Yes");
                                                flag=0;
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "CAR NOT AVAILABLE");
                                            }



                                        }
                                        else{
                                            tempArray2.add(line2);

                                        }

                                    }
                                    fr2.close();
                                }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                                finally {
                                    try {
                                        FileWriter file2 = new FileWriter("car.txt");
                                        PrintWriter pw2 = new PrintWriter(file2);

                                        for(String str2: tempArray2){
                                            file2.write(str2);
                                            pw2.println();

                                        }

                                        pw2.close();
                                        file2.close();
                                        if(flag==0){
                                            JOptionPane.showMessageDialog(null, "CAR RENTED SUCCESSFULLY");
                                        }



                                    }catch (Exception ex) {JOptionPane.showMessageDialog(null, ex+"");
                                    }

                                }




                            }
                            else{
                                tempArray.add(line);
                                JOptionPane.showMessageDialog(null, "CAR ALREADY RENTED");
                            }
                        }
                        else{
                            tempArray.add(line);
                        }

                    }
                    fr.close();
                }catch(Exception e1){JOptionPane.showMessageDialog(null, e1+"");}
                finally {
                    try {
                        FileWriter file1 = new FileWriter("customer.txt");
                        PrintWriter pw = new PrintWriter(file1);

                        for (String str : tempArray) {
                            file1.write(str);
                            pw.println();

                        }
                        pw.close();
                        file1.close();


                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex + "");
                    }




                }
            }


        }
        else
        if(ea.getSource()==backRentCar){
            rentCarFrame.dispose();
            new customerMenu(idRentCar);
        }
    }

}
