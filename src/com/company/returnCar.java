package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class returnCar implements ActionListener {
    JFrame retCarFrame = new JFrame("Return Car");
    JPanel retCarPanel = new JPanel();
    JLabel daysLabelretCar = new JLabel("Enter Number of Days Car Rented");
    JButton proceedRetCar = new JButton(new ImageIcon("PROCEED.png"));
    JLabel retCarBg=new JLabel();
    JTextField daysTextRetCar=new JTextField();
    JButton backRetCar=new JButton(new ImageIcon("Back.png"));
    String idRetCar;
    JLabel info=new JLabel("");

    returnCar(String id){
        idRetCar = id;
        retCarPanel.setBounds(0,0,800,450);
        retCarBg.setIcon(new ImageIcon("bg.jpg"));
        retCarBg.setBounds(0,0,800,450);
        daysLabelretCar.setBounds(10,50,350,25);
        retCarPanel.add(daysLabelretCar);
        daysLabelretCar.setForeground(Color.white);
        daysLabelretCar.setFont(new Font("SansSerif",Font.PLAIN,20));
        daysTextRetCar.setBounds(400, 50, 75, 25);
        retCarPanel.add(daysTextRetCar);


        retCarFrame.add(retCarPanel);
        info.setBounds(10,380,500,25);
        retCarPanel.add(info);
        info.setForeground(Color.white);
        info.setFont(new Font("SansSerif",Font.PLAIN,20));


        backRetCar.setBounds(725, 365, 47, 32);
        backRetCar.addActionListener(this);
        retCarPanel.add(backRetCar);
        proceedRetCar.setBounds(350,325,100,40);
        retCarPanel.add(proceedRetCar);
        proceedRetCar.addActionListener(this);
        retCarPanel.add(retCarBg);

        retCarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        retCarFrame.setSize(800,450);
        retCarFrame.setLayout(null);
        retCarPanel.setLayout(null);
        retCarFrame.setVisible(true);
        retCarFrame.setLocationRelativeTo(null);
        retCarFrame.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent ea) {
        if(ea.getSource()==proceedRetCar){
            String checkDays = daysTextRetCar.getText();
            ArrayList<String> tempArray = new ArrayList<String>();
            ArrayList<String> tempArray2 = new ArrayList<String>();
            int flag=1;
            String line;
            String[] arr;


            if(checkDays.trim().isEmpty()){

                info.setText("ENTER NO OF DAYS CAR RENTED");
            }
            else{
                info.setText("");
                try{
                    FileReader fr=new FileReader("customer.txt");
                    Scanner reader=new Scanner(fr);
                    while(reader.hasNextLine()){
                        line=reader.nextLine();
                        arr = line.split(",");
                        if (arr[0].equals(idRetCar))
                        {
                            if(!(arr[3].equals("NIL"))){
                                tempArray.add(arr[0] +  "," + arr[1] + "," + arr[2] + "," + "NIL");
                                String line2;
                                String[] arr2;
                                String checkCarId;
                                String checkPrice = null;

                                checkCarId = arr[3];
                                try{
                                    FileReader fr2=new FileReader("car.txt");
                                    Scanner reader2=new Scanner(fr2);
                                    while(reader2.hasNextLine()){
                                        line2=reader2.nextLine();
                                        arr2 = line2.split(",");

                                        if (arr2[0].equals(checkCarId))
                                        {
                                            if(arr2[5].equalsIgnoreCase("Yes")){
                                                tempArray2.add(arr2[0] + "," + arr2[1] + "," + arr2[2] + "," + arr2[3] + "," + arr2[4] + "," +"No");
                                                flag=0;
                                                checkPrice=arr2[4];
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "CAR NOT RENTED");
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

                                            int d=Integer.parseInt(checkDays);
                                            int p=Integer.parseInt(checkPrice);
                                            int tp=d*p;
                                            String msg=String.valueOf(tp);
                                            JOptionPane.showMessageDialog(null,"TOTAL PRICE : "+ msg );
                                            JOptionPane.showMessageDialog(null, "CAR RETURNED SUCCESSFULLY");
                                        }



                                    }catch (Exception ex) {JOptionPane.showMessageDialog(null, ex+"");
                                    }

                                }
                            }
                            else{
                                tempArray.add(line);
                                JOptionPane.showMessageDialog(null, "CAR NOT RENTED");

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
        if(ea.getSource()==backRetCar){
            retCarFrame.dispose();
            new customerMenu(idRetCar);
        }
    }
}

