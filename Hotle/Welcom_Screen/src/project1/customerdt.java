package project1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class customerdt extends JFrame {
    JTable table;
  

    customerdt(){
        setSize(900,600);
        setLocation(200,100);
        setResizable(false);

        DefaultTableModel model = new DefaultTableModel();
        String arr [] = {"Name","Document","Document no","Gender","Adresss","Contact"};
        model.setColumnIdentifiers(arr);

        table = new JTable(model);

        try {
            JD_data d = new JD_data();
            String q = "select * from customer";

            ResultSet set = d.s.executeQuery(q);

            while(set.next()){
                String name = set.getString(1);
                String document = set.getString(2);
                String no = set.getString(3);
                String gen = set.getString(4);
                String adress = set.getString(5);
                String cont = set.getString(6);

                model.addRow(new Object[] {name,document,no,gen,adress,cont});
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        
        
     
        table.setFont(new Font("serif",Font.BOLD,12));


        add(new JScrollPane(table));
        setVisible(true);

    }
   
    
}
