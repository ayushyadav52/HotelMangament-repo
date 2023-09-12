package project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addrooms extends JPanel implements ActionListener {
    
    JLabel label,label2,label3,label4,label5,label6,label7;
    JTextField textField,textField2;
    JComboBox box,box2,box3;
    JButton button,button2;


    public Addrooms(){
        setLayout(null);
        setSize(800, 500);
        setLocation(400, 100);

        ImageIcon icon = new ImageIcon("D:/icons/twelve.jpg");
        Image i3 = icon.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(i3);

        label = new JLabel(icon2);
        label.setBounds(370,80,400,350);
        add(label);

        Font font = new Font("serif",Font.BOLD,15);

        label2 = new JLabel("ADD ROOMS");
        label2.setFont(new Font("serif",Font.BOLD,23));
        label2.setBounds(280,0,150,60);
        add(label2);

        label3 = new JLabel("ROOM NO: ");
        label3.setBounds(20,80,100,20);
        label3.setFont(font);
        add(label3);

        textField = new JTextField();
        textField.setBounds(120,80,200,20);
        add(textField);

        label4 = new JLabel("STUTUS: ");
        label4.setBounds(20,130,100,20);
        label4.setFont(font);
        add(label4);

        String [] st = {"DIRTY","CLEAN"};
        box = new JComboBox<>(st);
        box.setBounds(100,130,200,20);
        add(box);

        label5 = new JLabel("AVALABLE: ");
        label5.setBounds(20,180,120,20);
        label5.setFont(font);
        add(label5);

        String[] av = {"AVALABLE","NOT AVALABLE"};
        box2 = new JComboBox<>(av);
        box2.setBounds(120,180,200,20);
        add(box2);

        label6 = new JLabel("TYPE: ");
        label6.setBounds(20,230,100,20);
        label6.setFont(font);
        add(label6);

        String [] tp = {"SINGLE BED","DOUBLE BED"};
        box3 = new JComboBox<>(tp);
        box3.setBounds(100,230,200,20);
        add(box3);

        label7 = new JLabel("PRIZE: ");
        label7.setBounds(20,280,100,20);
        label7.setFont(font);
        add(label7);

        textField2 = new JTextField();
        textField2.setBounds(100,280,200,20);
        add(textField2);

        button = new JButton("BACK");
        button.setForeground(Color.white);
        button.setBackground(Color.black);
        button.setFont(font);
        button.setBounds(60,350,100,40);
        add(button);

        button2 = new JButton("SUBMIT");
        button2.setForeground(Color.white);
        button2.setBackground(Color.black);
        button2.setFont(font);
        button2.setBounds(200,350,100,40);
        add(button2);

        button.addActionListener(this);
        button2.addActionListener(this);




        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        
       

        if(e.getSource() == button){
            setVisible(false);
        }
        else if(textField.getText().isEmpty()||textField2.getText().isEmpty()){     
            JOptionPane.showMessageDialog(null, "FILL ALL THE FIELDS","FAILD",JOptionPane.ERROR_MESSAGE);

        }
        else{
            try {
                int id1 = Integer.parseInt(textField.getText());
                String s = box.getSelectedItem().toString();
                String a = box2.getSelectedItem().toString();
                String t = box3.getSelectedItem().toString();
                int pirce = Integer.parseInt(textField2.getText());
                

                JD_data conn = new JD_data();
                String qurry =  "insert into rooms values('"+id1+"','"+s+"','"+a+"','"+t+"','"+pirce+"')";
                conn.s.execute(qurry);
                JOptionPane.showMessageDialog(null, "ROOM ADDED SUCCESFULLY");
                setVisible(false);
                
                
            } catch (Exception ele) {
                
                JOptionPane.showMessageDialog(null,"ROOM IS ALREADY EXIST ENTER DIFRENT ROOM NO","FAILED",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
