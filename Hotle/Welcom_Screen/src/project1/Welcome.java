package project1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

public class Welcome extends JWindow{
    
    JProgressBar Bar;
    JLabel label,label2;
    JPanel panel;
    public Welcome()
    {
        setSize(590,550);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.black);

        ImageIcon icon = new ImageIcon("D:/icons/second.jpg");
        Bar = new JProgressBar(0,100);
        label = new JLabel(icon);
        label2 = new JLabel("Welcome To Hotle Mangment");
        label2.setFont(new Font("serif",Font.BOLD,25));
        label2.setForeground(Color.white);
        panel.add(label2,BorderLayout.PAGE_START);
        add(panel,BorderLayout.PAGE_START);
        add(label,BorderLayout.CENTER);
        Bar.setForeground(Color.yellow);
        add(Bar,BorderLayout.PAGE_END);
        setVisible(true);

        int i = 0;
        while (i<=100) {
            try {
                Thread.sleep(1000);
                Bar.setValue(i);
            } catch (Exception e) {
                // TODO: handle exception
            }
            i = i+25;

        }
        if (Bar.getValue() == 100) {
            setVisible(false);
            new Login();
        }

        
        

    }
    
    public static void main(String[] args) {
        Welcome ob = new Welcome();
       
        
        
    }
 
}
   