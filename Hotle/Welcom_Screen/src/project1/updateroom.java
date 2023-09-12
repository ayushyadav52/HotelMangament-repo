package project1;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.event.*;

public class updateroom extends JFrame implements ActionListener {
    JPanel panel;
    JTable table23;
    DefaultTableModel modele = new DefaultTableModel();
    JLabel label, label2, label3, label4, label5;
    JTextField field, field2, field3, field4, field5;
    JButton button, button2;

    updateroom() {
        setSize(1200, 600);
        setLocation(100, 80);
        setResizable(false);
        setLayout(null);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 600, 600);

        String arr[] = { "Room No", "Stutus", "Avlaible", "Type", "Prize" };
        modele.setColumnIdentifiers(arr);
        table23 = new JTable(modele);
        panel.add(new JScrollPane(table23), BorderLayout.CENTER);

        add(panel);

        Font f = new Font("serif", Font.BOLD, 15);

        label = new JLabel("Room No:");
        label.setFont(f);
        label.setBounds(650, 50, 100, 30);
        add(label);

        field = new JTextField();
        field.setBounds(800, 50, 200, 30);
        add(field);

        label2 = new JLabel("Stutus");
        label2.setFont(f);
        label2.setBounds(650, 100, 100, 30);
        add(label2);

        field2 = new JTextField();
        field2.setBounds(800, 100, 200, 30);
        add(field2);

        field3 = new JTextField();
        field3.setBounds(800, 150, 200, 30);
        add(field3);

        field4 = new JTextField();
        field4.setBounds(800, 200, 200, 30);
        add(field4);

        field5 = new JTextField();
        field5.setBounds(800, 250, 200, 30);
        add(field5);

        label3 = new JLabel("Avlable");
        label3.setFont(f);
        label3.setBounds(650, 150, 100, 30);
        add(label3);

        label4 = new JLabel("Type");
        label4.setFont(f);
        label4.setBounds(650, 200, 100, 30);
        add(label4);

        label5 = new JLabel("PRIZE");
        label5.setFont(f);
        label5.setBounds(650, 250, 100, 30);
        add(label5);

        button = new JButton("Submit");
        button.setFont(f);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setBounds(700, 500, 150, 30);
        add(button);

        button2 = new JButton("Copy");
        button2.setFont(f);
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.setBounds(900, 500, 150, 30);
        add(button2);

        button.addActionListener(this);
        button2.addActionListener(this);

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

                modele.addRow(new Object[] { no, s, a, t, p });
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            int f = Integer.parseInt(field.getText());
            String f2 = field2.getText();
            String f3 = field3.getText();
            String f4 = field4.getText();
            int f5 = Integer.parseInt(field5.getText());
            int in = table23.getSelectedRow();
            String goal = String.valueOf(modele.getValueAt(in, 0));

            int n = Integer.parseInt(goal);

            System.out.println(f);
            System.out.println(f2);
            System.out.println(f3);
            System.out.println(f4);
            System.out.println(f5);
            System.out.println(in);
            System.out.println(n);


           
           

            try {
                JD_data d = new JD_data();
                String Q = "update rooms set id = ?, stutus = ?, avilable = ?, type = ?, prize = ? where id = ?";
               
                
                PreparedStatement ps = d.conn.prepareStatement(Q);
                //d.p = d.conn.prepareStatement(Q);
                
                ps.setInt(1, f);
                ps.setString(2, String.valueOf(f2));
                ps.setString(3, String.valueOf(f3));
                ps.setString(4, String.valueOf(f4));
                ps.setInt(5, f5);

                ps.setInt(6, n);

              

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update succsesfully");
                
                
            } catch (Exception elo) {
                // TODO: handle exception
                elo.printStackTrace();
                JOptionPane.showMessageDialog(null, "somthing");
            }

            
        } else if (e.getSource() == button2) {

            if (table23.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Select row");
            } else {
                int rowindex = table23.getSelectedRow();

                String room1 = String.valueOf(modele.getValueAt(rowindex, 0));
                String stutus1 = String.valueOf(modele.getValueAt(rowindex, 1));
                String ablable1 = String.valueOf(modele.getValueAt(rowindex, 2));
                String type1 = String.valueOf(modele.getValueAt(rowindex, 3));
                String prize1 = String.valueOf(modele.getValueAt(rowindex, 4));

                field.setText(room1);
                field2.setText(stutus1);
                field3.setText(ablable1);
                field4.setText(type1);
                field5.setText(prize1);

            }

        }

    }

    public static void main(String[] args) {
        updateroom r = new updateroom();
    }

}
