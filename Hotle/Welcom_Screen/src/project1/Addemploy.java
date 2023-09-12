package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Group;
import javax.swing.event.ChangeListener;

import java.sql.*;

import java.time.*;

public class Addemploy extends JPanel implements ActionListener {
    JLabel image, l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField t1, t2, t3, t4;
    JSpinner s1, s2, s3;
    SpinnerModel m1, m2, m3;
    JRadioButton box1, box2, box3;
    JComboBox work;
    JButton b1, b2;
    JSeparator sp;

    public Addemploy() {
        setLayout(null);
        setSize(800, 500);
        setLocation(400, 100);
        setBackground(Color.white);

        ImageIcon icon = new ImageIcon("D:/icons/tenth.jpg");
        Image i3 = icon.getImage().getScaledInstance(350, 500, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(i3);

        image = new JLabel(icon2);
        image.setBounds(450, 0, 350, 500);
        add(image);

        l1 = new JLabel("NAME ");
        l1.setBounds(50, 50, 100, 20);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(100, 50, 200, 20);
        add(t1);

        l2 = new JLabel("ADRESS ");
        l2.setBounds(40, 100, 100, 20);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(100, 100, 200, 20);
        add(t2);

        l3 = new JLabel("PHONE NO ");
        l3.setBounds(30, 150, 100, 20);
        add(l3);

        t3 = new JTextField();
        t3.setBounds(100, 150, 200, 20);
        add(t3);

        l4 = new JLabel("GENDER");
        l4.setBounds(40, 200, 100, 20);
        add(l4);

        box1 = new JRadioButton("MEN");
        box1.setBounds(100, 200, 80, 20);
        box1.setBackground(Color.white);
        add(box1);

        box2 = new JRadioButton("FEMALE");
        box2.setBounds(190, 200, 80, 20);
        box2.setBackground(Color.white);
        add(box2);

        box3 = new JRadioButton("OTHER");
        box3.setBounds(300, 200, 80, 20);
        box3.setBackground(Color.white);
        add(box3);

        ButtonGroup group = new ButtonGroup();
        group.add(box1);
        group.add(box2);
        group.add(box3);

        l5 = new JLabel("JOB ROLE ");
        l5.setBounds(40, 250, 100, 20);
        add(l5);

        String[] role = { "DRIVER", "COOK", "RESECPTNIST", "WORKER", "MANGER" };
        work = new JComboBox<>(role);
        work.setBounds(150, 250, 100, 20);
        add(work);

        l6 = new JLabel("DOB");
        l6.setBounds(40, 300, 100, 20);
        add(l6);

        m1 = new SpinnerNumberModel(1, 1, 31, 1);
        s1 = new JSpinner(m1);
        s1.setBounds(100, 300, 50, 20);
        add(s1);

        String[] month = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AGU", "SEP", "OCT", "NOV", "DEC" };

        m2 = new SpinnerListModel(month);
        s2 = new JSpinner(m2);
        s2.setBounds(200, 300, 50, 20);
        add(s2);

        String year = String.valueOf(java.time.Year.now());
        int y = Integer.parseInt(year);
        m3 = new SpinnerNumberModel(y - 10, y - 100, y, 1);
        s3 = new JSpinner(m3);
        s3.setBounds(300, 300, 50, 20);
        add(s3);

        l4 = new JLabel("ADHAR NO ");
        l4.setBounds(30, 350, 100, 20);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(100, 350, 200, 20);
        add(t4);

        b1 = new JButton("CANCLE");
        b1.setBounds(20, 420, 150, 30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        add(b1);

        b2 = new JButton("SUBMIT");
        b2.setBounds(250, 420, 150, 30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        add(b2);
        b2.addActionListener(this);
        b1.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {

            String gender = null;

            if(box1.isSelected()){
                gender = "MEN";
            }
            else if(box2.isSelected()){
                gender = "FEMALE";
            }
            else if(box3.isSelected()){
                gender = "OTHER";
            }
            

            if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty() || gender == null) {
            
                JOptionPane.showMessageDialog(null, "Enter All Details","ERROR",JOptionPane.ERROR_MESSAGE);
            }

            else 
            {
             try{ 
                 String name = t1.getText();
                 String adress = t2.getText();
                 String contact = t3.getText();
                 
                 String rolee =  work.getSelectedItem().toString();
                 String d = String.valueOf(s1.getValue());
                 String m = String.valueOf(s2.getValue());
                 String ye = String.valueOf(s3.getValue());
                 String adharcard = t4.getText();

                 JD_data conn1 = new JD_data();
                 String str = "INSERT INTO employee (name,adress,contact,gender,jobrole,dob,adharcaard) values( '"+ name + "', '" + adress + "', '" + contact + "','" + gender + "', '" + rolee + "', '" + d+ "-" + m + "-" + ye + "','" + adharcard + "')";
                 conn1.s.executeUpdate(str);
                 JOptionPane.showMessageDialog(null, "Add Employee Succesfully","Done",JOptionPane.PLAIN_MESSAGE);
                 setVisible(false);
                }catch(Exception ele){
                    ele.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Somthin Worng");
                }

            }
            

        } else {
            setVisible(false);
        }
    }

}