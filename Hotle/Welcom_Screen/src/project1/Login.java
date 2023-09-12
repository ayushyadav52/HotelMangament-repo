package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel label1, label2, label3, label4;
    JTextField tField;
    JPasswordField tPasswordField;
    JButton button, button2;
    JPanel panel, panel2;

    Login() {
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        Container c = getContentPane();
        c.setBackground(Color.white);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(640, 720);
        panel.setLocation(0, 0);
        panel.setBackground(Color.white);

        Font font = new Font("serif", Font.BOLD, 35);

        ImageIcon icon = new ImageIcon("D:/icons/second.jpg");
        label1 = new JLabel(icon);
        label1.setBounds(0, 0, 640, 720);
        panel.add(label1);
        add(panel);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(650, 100, 400, 430);
        panel2.setBackground(Color.black);

        label2 = new JLabel("LOGIN");
        label2.setSize(280, 50);
        label2.setLocation(130, 10);
        label2.setFont(font);
        label2.setForeground(Color.white);

        panel2.add(label2);

        label3 = new JLabel("User ID");
        label3.setForeground(Color.white);
        label3.setFont(new Font("serif", Font.BOLD, 15));
        label3.setSize(100, 50);
        label3.setLocation(40, 140);

        panel2.add(label3);

        tField = new JTextField();
        tField.setSize(200, 30);
        tField.setLocation(100, 150);

        panel2.add(tField);

        label4 = new JLabel("Password");
        label4.setForeground(Color.white);
        label4.setFont(new Font("serif", Font.BOLD, 15));
        label4.setSize(100, 50);
        label4.setLocation(35, 220);

        panel2.add(label4);

        tPasswordField = new JPasswordField();
        tPasswordField.setSize(200, 30);
        tPasswordField.setLocation(100, 230);

        panel2.add(tPasswordField);

        button = new JButton("SING IN");

        button.setBackground(Color.white);
        button.setFont(new Font("serif", Font.CENTER_BASELINE, 20));
        button.setForeground(Color.RED);
        button.setBounds(80, 350, 120, 30);
        button.addActionListener(this);

        panel2.add(button);

        button2 = new JButton("SING UP");
        button2.setBackground(Color.white);
        button2.setFont(new Font("serif", Font.CENTER_BASELINE, 20));
        button2.setForeground(Color.RED);
        button2.setBounds(220, 350, 120, 30);

        button2.addActionListener(this);

        panel2.add(button2);

        add(panel2);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == button) {
            String u = tField.getText();
            String p = tPasswordField.getText();

            try {
                JD_data con = new JD_data();
                String q = "select * from login_details where id ='" + u + "'and pass ='" + p + "'";
                ResultSet rs = con.s.executeQuery(q);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Succesfully login");
                    setVisible(false);
                    new Dashbord();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        } else {
            setVisible(false);
            JFrame window = new JFrame();
            window.setSize(800, 500);
            window.setLocationRelativeTo(null);
            window.setLayout(null);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);

            Font fonts = new Font("serif", Font.BOLD, 15);

            JLabel l = new JLabel("ENTER USER NAME");
            l.setBounds(200, 100, 200, 30);
            l.setFont(fonts);
            window.add(l);

            JTextArea t = new JTextArea();
            t.setBounds(400, 100, 200, 30);
            t.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            window.add(t);

            JLabel l2 = new JLabel("ENTER EMAIL");
            l2.setBounds(200, 150, 200, 30);
            l2.setFont(fonts);
            window.add(l2);

            JTextArea t1 = new JTextArea();
            t1.setBounds(400, 150, 200, 30);
            t1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            window.add(t1);

            JLabel l3 = new JLabel("ENTER PASSWORD");
            l3.setBounds(200, 200, 200, 30);
            l3.setFont(fonts);
            window.add(l3);

            JPasswordField f = new JPasswordField();
            f.setBounds(400, 200, 200, 30);
            f.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            window.add(f);

            JLabel l4 = new JLabel("CONFORM PASSWORD");
            l4.setBounds(200, 250, 200, 30);
            l4.setFont(fonts);
            window.add(l4);

            JPasswordField f1 = new JPasswordField();
            f1.setBounds(400, 250, 200, 30);
            f1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            window.add(f1);

            JButton b = new JButton("SUBMIT");
            b.setBounds(350, 400, 170, 30);
            b.setBackground(Color.black);
            b.setForeground(Color.white);
            b.setFont(new Font("serif", Font.BOLD, 20));
            window.add(b);

            JButton b2 = new JButton("BACK");
            b2.setBounds(150, 400, 170, 30);
            b2.setForeground(Color.white);
            b2.setBackground(Color.black);
            b2.setFont(new Font("serif", Font.BOLD, 20));
            window.add(b2);
            window.setVisible(true);

            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    String username = t.getText();
                    String email = t1.getText();
                    String password1 = f1.getText();
                    String password = f.getText();

                    if (username.isEmpty() || email.isEmpty() || password.isEmpty() || password1.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter All The Fields");
                    }
                    else if(password.equals(password1)){
                        try {

                            String qurry = "insert into login_details values('" + username + "','" + password1 + "','"+ email + "')";

                            JD_data conn1 = new JD_data();
                            conn1.s.execute(qurry);
                            JOptionPane.showMessageDialog(null, "SING UP SUCCESFULLY");
                            window.setVisible(false);
                            setVisible(true);
                        }
                        catch (Exception el) {
                            JOptionPane.showMessageDialog(null, "Somthing Worng");
                            el.printStackTrace();

                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Password Not Macth", "Error", JOptionPane.ERROR_MESSAGE);
                    

                    }

                }

            });

            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    window.setVisible(false);
                    setVisible(true);
                }

            });

        }
    }

}
