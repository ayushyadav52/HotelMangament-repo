package project1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.sql.*;
import java.awt.event.*;

public class Searchroom extends JFrame implements ActionListener {

   JTable table;
   JButton delete, update;
   JComboBox box;
   DefaultTableModel model = new DefaultTableModel();

   public Searchroom() {

      setSize(1000, 500);
      setLocation(100, 100);
      setResizable(false);
      setLayout(null);

      JPanel pa = new JPanel();

      pa.setLayout(new BorderLayout());
      pa.setSize(700, 500);
      pa.setLocation(0, 0);

      String arr[] = { "SINGLE BED", "DOUBLE BED" };
      box = new JComboBox<>(arr);
      box.setBounds(750, 100, 200, 40);

      update = new JButton("Search");
      update.setBounds(750, 300, 200, 40);
      update.setForeground(Color.white);
      update.setBackground(Color.black);

      delete = new JButton("DELETE");
      delete.setBounds(750, 400, 200, 40);
      delete.setForeground(Color.white);
      delete.setBackground(Color.black);

      add(box);
      add(update);
      add(delete);
      update.addActionListener(this);
      delete.addActionListener(this);

      String[] header = { "Room No", "Stutus", "Avilable", "Type", "Prize" };

      model.setColumnIdentifiers(header);
      table = new JTable(model);

      pa.add(new JScrollPane(table), BorderLayout.CENTER);
      add(pa);

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

            model.addRow(new Object[] { no, s, a, t, p });

         }
        

      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }
      setVisible(true);
   }

   public void actionPerformed(ActionEvent e) {
      
      if (e.getSource() == update) {
         
         String l = String.valueOf(box.getSelectedItem());
         String se = "select * from rooms where type ='" + l + "'";
         

         try {
            JD_data d = new JD_data();
            ResultSet s = d.s.executeQuery(se);
            
           

            while (s.next()) {
               String no1 = String.valueOf(s.getInt(1));
               String s1 = s.getString(2);
               String a1 = s.getString(3);
               String t1 = s.getString(4);
               String p1 = String.valueOf(s.getInt(5));
               
               
               model.addRow(new Object[] { no1, s1, a1, t1, p1 });
            }
           
            

         } catch (Exception ei) {

            // TODO: handle exception
         }

      }
      if (e.getSource() == delete) {

         if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "please select row");
         } else {
            int t = table.getSelectedRow();
            String index = String.valueOf(table.getValueAt(t, 0));
            int num = Integer.parseInt(index);
            try {
               JD_data d = new JD_data();
               String w = "delete from rooms where id ="+num+"";

               d.s.execute(w);
               JOptionPane.showMessageDialog(null, "succesfully");
               model.removeRow(t);

            } catch (Exception ee) {
               // TODO: handle exception
               JOptionPane.showMessageDialog(null, "somehting worng");
            }
            //System.out.println(num);
            System.out.println(t);
            System.out.println(index);
            System.out.println(num);
         }

      }
   }

   public static void main(String[] args) {
      Searchroom s = new Searchroom();
   }

}
