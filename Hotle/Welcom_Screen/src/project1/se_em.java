package project1;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.util.TestUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class se_em extends JFrame implements ActionListener {
    JTable table;
    JLabel label, label2;
    JPanel panel;
    JButton button, button2;
    JTextField field;
    DefaultTableModel model = new DefaultTableModel();

    se_em() {
        setSize(1200, 650);
        setLocation(90, 50);
        setLayout(null);
        setResizable(false);

        panel = new JPanel();
        panel.setBounds(0, 0, 800, 650);

        panel.setLayout(new BorderLayout());

        String arr[] = { "Name", "Adress", "Contact", "Gender", "JobRole", "DOB", "Adharcard" };
        model.setColumnIdentifiers(arr);
        table = new JTable(model);

        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        add(panel);

        label = new JLabel("Enter Details");
        label.setFont(new Font("serif", Font.BOLD, 15));
        label.setBounds(820, 100, 100, 20);
        add(label);

        field = new JTextField();
        field.setBounds(920, 100, 200, 20);
        add(field);

        button = new JButton("SEARCH");
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(new Font("serif", Font.BOLD, 15));
        button.setBounds(940, 200, 150, 40);
        add(button);

        button2 = new JButton("DELETE");
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.setFont(new Font("serif", Font.BOLD, 15));
        button2.setBounds(940, 400, 150, 40);
        add(button2);

        button2.addActionListener(this);
        button.addActionListener(this);

        try {
            JD_data con = new JD_data();
            String q = "select * from employee";

            ResultSet rs = con.s.executeQuery(q);
            while (rs.next()) {
                String name = rs.getString(2);
                String adress = rs.getString(3);
                String contact = rs.getString(4);
                String gender = rs.getString(5);
                String jobrole = rs.getString(6);
                String dob = rs.getString(7);
                String card = rs.getString(8);
                model.addRow(new Object[] { name, adress, contact, gender, jobrole, dob, card });
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {
            if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "pleaseselectrow");
            } else {
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "please select row");
                } else {
                    int t = table.getSelectedRow();
                    String index = String.valueOf(table.getValueAt(t, 0));

                    try {
                        JD_data d = new JD_data();
                        String w = "delete from employee where name = '" + index + "'";

                        d.s.execute(w);
                        JOptionPane.showMessageDialog(null, "succesfully");
                        model.removeRow(t);

                    } catch (Exception ee) {
                        // TODO: handle exception
                        JOptionPane.showMessageDialog(null, "somehting worng");
                    }
                    // System.out.println(num);

                }
            }
        } else if (e.getSource() == button) {

            if (field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pease Fill Details", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String Sea = field.getText();

                try {
                    JD_data con = new JD_data();
                    String ser = "select * from employee where name = '" + Sea + "' or adress = '" + Sea
                            + "' or contact = '" + Sea + "' or gender = '" + Sea + "' or jobrole = '" + Sea
                            + "' or dob = '" + Sea + "' or adharcaard = '" + Sea + "'";
                    ResultSet rn = con.s.executeQuery(ser);

                    while (rn.next()) {
                        String name1 = rn.getString(2);
                        String adress1 = rn.getString(3);
                        String contact1 = rn.getString(4);
                        String gender1 = rn.getString(5);
                        String jobrole1 = rn.getString(6);
                        String dob1 = rn.getString(7);
                        String card1 = rn.getString(8);
                        model.addRow(new Object[] { name1, adress1, contact1, gender1, jobrole1, dob1, card1 });

                    }
                    rn = con.s.executeQuery(ser);
                    if(rn.next()==false){
                        JOptionPane.showMessageDialog(null,"Not Found","eroor",JOptionPane.ERROR_MESSAGE);
                    }

                } catch (Exception ele) {

                    ele.printStackTrace();
                }

            }

        }

    }

    
}
