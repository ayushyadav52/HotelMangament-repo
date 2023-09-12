package project1;

import javax.swing.*;
import javax.swing.table.*;

import com.mysql.cj.result.Row;
import com.mysql.cj.x.protobuf.MysqlxCrud.Column;
import com.mysql.cj.xdevapi.CreateIndexParams.IndexField;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import java.util.jar.Attributes.Name;

public class em_details extends JFrame {
    JLabel image;
    JTable table;
    
   
    
    
    
    
    public em_details(){
       
        setSize(1200, 500);
        setLocation(20, 150);
        setResizable(false);
        

        ImageIcon icon = new ImageIcon("D:/icons/tenth.jpg");
        Image i3 = icon.getImage().getScaledInstance(400, 700, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(i3);

        image = new JLabel(icon2);
        add(image,BorderLayout.LINE_END);
        
        
        DefaultTableModel model = new DefaultTableModel(0,0);
        table = new JTable(model);

        String[] header = {"NAME","ADRESS","CONTACT NO ","GENDER","JOB ROLE","DOB","ADHARCARD"};
        model.setColumnIdentifiers(header);
        table.setFont(new Font("serif",Font.BOLD,12));
        


        try {
            JD_data con =  new JD_data();
            String q = "select * from employee";

            ResultSet rs = con.s.executeQuery(q);
            while(rs.next()){
                String name = rs.getString(2);
                String adress = rs.getString(3);
                String contact = rs.getString(4);
                String gender = rs.getString(5);
                String jobrole = rs.getString(6);
                String dob = rs.getString(7);
                String card = rs.getString(8);
                model.addRow(new Object[] {name,adress,contact,gender,jobrole,dob,card});

            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        add(new JScrollPane(table));




       
        
            
        
       
        
 
        
    
        




        
       



        setVisible(true);
    }
    
    
}
