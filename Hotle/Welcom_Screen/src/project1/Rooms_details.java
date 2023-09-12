package project1;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import java.awt.Image;

import javax.swing.*;
import java.sql.*;
import java.awt.*;

public class Rooms_details extends JFrame{
    JLabel lable;
    JTable table;
    public Rooms_details(){
        setSize(1000,500);
        setLocation(100,100);
        setResizable(false);

        ImageIcon icon = new ImageIcon("D:/icons/twelve.jpg");
        Image i3 = icon.getImage().getScaledInstance(400,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);

        lable = new JLabel(i2);
        add(lable,BorderLayout.LINE_END);
        String[] header = {"Room No","Stutus","Avilable","Type","Prize"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(header);
        table = new JTable(model);
        add(new JScrollPane(table),BorderLayout.CENTER);

        try {
            JD_data con = new JD_data();
            String q = "select * from rooms";
            ResultSet set = con.s.executeQuery(q);
            while (set.next()) {
                String no = String.valueOf(set.getInt(1));
                String s = set.getString(2);
                String a = set.getString(3);
                String t = set.getString(4);
                String p = String.valueOf(set.getInt(5));

                model.addRow(new Object[]  {no,s,a,t,p});

            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        setVisible(true);
    }

    
}
