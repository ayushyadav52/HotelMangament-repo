package project1;

import javax.swing.*;
import javax.xml.crypto.Data;

import com.mysql.cj.Query;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.sql.*;

public class guest extends JFrame implements ActionListener {
    JLabel label, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    JButton button, button2;
    JTextField textField, textField2, textField3, textField4, textField5;
    JComboBox box, xBox;
    JRadioButton button3, button4, button5;
    String arr1[] = new String[50];

    guest() {

        try {
            int index = 0;
            JD_data de = new JD_data();
            String r = "select id from rooms";

            ResultSet s = de.s.executeQuery(r);
            while (s.next()) {
                arr1[index] = s.getString(1);
                index++;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        setSize(1200, 700);
        setResizable(false);
        setLocation(100, 40);
        setLayout(null);

        getContentPane().setBackground(Color.white);

        ImageIcon icon = new ImageIcon("D:/icons/cos.png");
        Image i = icon.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);

        label = new JLabel(i2);
        label.setBounds(700, 0, 500, 450);

        Font f = new Font("serif", Font.BOLD, 18);

        add(label);

        label = new JLabel("Full Name");
        label.setFont(f);
        label.setBounds(150, 50, 100, 30);
        add(label);

        textField = new JTextField();
        textField.setBounds(300, 50, 300, 30);
        add(textField);

        String arr[] = { "Adharcard", "Driving licence", "Voter id", "Passport" };

        label2 = new JLabel("Document");
        label2.setFont(f);
        label2.setBounds(150, 100, 100, 30);

        add(label2);

        box = new JComboBox<>(arr);
        box.setBounds(300, 100, 300, 30);

        add(box);

        label3 = new JLabel("Document No");
        label3.setFont(f);
        label3.setBounds(150, 150, 150, 30);
        add(label3);

        textField2 = new JTextField();
        textField2.setBounds(300, 150, 300, 30);
        add(textField2);

        label4 = new JLabel("Adress");
        label4.setBounds(150, 200, 100, 30);
        label4.setFont(f);

        add(label4);

        textField3 = new JTextField();
        textField3.setBounds(300, 200, 300, 30);
        add(textField3);

        label6 = new JLabel("Gender");
        label6.setFont(f);
        label6.setBounds(150, 250, 100, 30);
        add(label6);

        button3 = new JRadioButton("Men");
        button3.setBackground(Color.white);
        button3.setBounds(300, 250, 50, 30);
        add(button3);

        button4 = new JRadioButton("Female");
        button4.setBackground(Color.white);
        button4.setBounds(400, 250, 100, 30);
        add(button4);

        button5 = new JRadioButton("Other");
        button5.setBackground(Color.white);
        button5.setBounds(500, 250, 100, 30);
        add(button5);

        ButtonGroup b = new ButtonGroup();
        b.add(button3);
        b.add(button4);
        b.add(button5);

        label5 = new JLabel("contact no");
        label5.setFont(f);
        label5.setBounds(150, 300, 100, 30);
        add(label5);

        textField4 = new JTextField();
        textField4.setBounds(300, 300, 300, 30);
        add(textField4);

        LocalDateTime d = LocalDateTime.now();
        String date = d.toString();
        label7 = new JLabel("Check in Time");
        label7.setFont(f);
        label7.setBounds(150, 350, 200, 30);

        add(label7);

        label8 = new JLabel(date);
        label8.setFont(f);
        label8.setBounds(310, 350, 200, 30);
        add(label8);

        label9 = new JLabel("Pay");
        label9.setFont(f);
        label9.setBounds(150, 400, 100, 30);
        add(label9);

        textField5 = new JTextField();
        textField5.setBounds(300, 400, 200, 30);
        add(textField5);

        label10 = new JLabel("Room");
        label10.setFont(f);
        label10.setBounds(150, 450, 100, 30);
        add(label10);

        xBox = new JComboBox(arr1);
        xBox.setBounds(300, 450, 100, 30);
        add(xBox);

        button = new JButton("BACK");
        button.setForeground(Color.white);
        button.setFont(f);
        button.setBackground(Color.black);
        button.setBounds(90, 600, 200, 40);
        add(button);

        button2 = new JButton("SUBMIT");
        button2.setForeground(Color.white);
        button2.setFont(f);
        button2.setBackground(Color.black);
        button2.setBounds(600, 600, 200, 40);
        add(button2);

        button.addActionListener(this);
        button2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            setVisible(false);
        }
        else if (e.getSource() == button2) {
            try {
                String name = textField.getText();
                String documents = box.getSelectedItem().toString();
                String documentno = textField2.getText();
                String adress = textField3.getText();
                String contact = textField4.getText();
                String gender = null;
                String date = label8.getText();
                int money = Integer.parseInt(textField5.getText());
                String rom = xBox.getSelectedItem().toString();
                

                if (button3.isSelected()) {
                    gender = "Men";
                } else if (button4.isSelected()) {
                    gender = "Female";
                } else {
                    gender = "Other";
                }

                JD_data d = new JD_data();
                String querry = "insert into customer values('" + name + "','" + documents + "','" + documentno + "','"
                        + gender + "','" + adress + "','" + contact + "','"+date+"',"+money+",'"+rom+"')";

                if (textField.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty() || gender == null || textField4.getText().isEmpty()){
                    
                    JOptionPane.showMessageDialog(null, "Please Fill All Fields", "Error",JOptionPane.ERROR_MESSAGE);


                }
                else{
                    d.s.executeUpdate(querry);
                    JOptionPane.showMessageDialog(null, "Add Customer Succesfully", "Succesfully",
                            JOptionPane.PLAIN_MESSAGE);

                }

            }catch(Exception e3) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "Some problem Acoured", "Error", JOptionPane.ERROR_MESSAGE);
                e3.printStackTrace();
                
            }
            

        }

    }

    public static void main(String[] args) {
        guest g = new guest();
    }

}
