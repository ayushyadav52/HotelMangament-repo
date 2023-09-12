package project1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.nio.file.FileAlreadyExistsException;

public class resecption extends JPanel implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    JLabel label;
  
    
    
   
    public resecption(){

        setLayout(null);
        setSize(800, 500);
        setLocation(300, 100);

      

        ImageIcon icon = new ImageIcon("D:/icons/fourth.jpg");
        Image i3 = icon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(i3);

        label = new JLabel(icon2);
        label.setBounds(350,50,400,400);
        add(label);

        b1 = new JButton("EMPLOYEE DETAILS");
        b1.setBounds(0,0,349,50);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        add(b1);
        
        b2 = new JButton("ROOMS DETAILS");
        b2.setBounds(0,50,349,50);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        add(b2);



        b3 = new JButton("SEARCH ROOMS ");
        b3.setBounds(0,100,349,50);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        add(b3);



        b4 = new JButton("SEARCH EMPLOYEE ");
        b4.setBounds(0,150,349,50);
        b4.setBackground(Color.black);
        b4.setForeground(Color.white);
        add(b4);

        b5 = new JButton("NEW COSTUMER FORM");
        b5.setBounds(0,200,349,50);
        b5.setBackground(Color.black);
        b5.setForeground(Color.white);
        add(b5);
        
        b6 = new JButton("COSTUMER DETAILS");
        b6.setBounds(0,250,349,50);
        b6.setBackground(Color.black);
        b6.setForeground(Color.white);
        add(b6);

        b7 = new JButton("UPDATE ROOM");
        b7.setBounds(0,300,349,50);
        b7.setBackground(Color.black);
        b7.setForeground(Color.white);
        add(b7);

        b8 = new JButton("UPDATE EMPLOYE");
        b8.setBounds(0,350,349,50);
        b8.setBackground(Color.black);
        b8.setForeground(Color.white);
        add(b8);

        b9 = new JButton("CHECK IN");
        b9.setBounds(0,400,349,50);
        b9.setBackground(Color.black);
        b9.setForeground(Color.white);
        add(b9);

        b10 = new JButton("LOGOUT");
        b10.setBounds(0,450,349,50);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);
        add(b10);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b10.addActionListener(this);

    
        setVisible(true);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){

            setVisible(false);
            
            em_details em = new em_details();

         

        }
        else if(e.getSource()==b2){
            setVisible(false);
            Rooms_details rm = new Rooms_details();
        }
        else if(e.getSource() == b4){
            setVisible(false);
            se_em em = new se_em();
        }
        else if(e.getSource() == b5){
            setVisible(false);
            guest gt = new guest();
        }
        else if(e.getSource() == b6){
            setVisible(false);
            customerdt dt = new customerdt();
        }
        else if(e.getSource()== b10){
            new Login();
            
            
           

        }
        else if(e.getSource() == b3){
            setVisible(false);
            new Searchroom();
        }

    }

}