package project1;
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashbord extends JFrame implements ActionListener{
    JLabel label,label2;
    JMenuBar bar;
    JMenu menu,menu2;
    JMenuItem item,item2,item3;
    Addemploy ob = new Addemploy();
    Addrooms obj = new Addrooms();
    resecption on = new resecption();
    Dashbord()
    {
        setSize(1366,720);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(Color.white);

        ImageIcon icon = new ImageIcon("D:/icons/dash.jpg");
        Image i3 = icon.getImage().getScaledInstance(1366, 720, Image.SCALE_DEFAULT);
        ImageIcon icon2  = new ImageIcon(i3);
        label = new JLabel(icon2);
        label.setBounds(0,0,1366,720);
        add(label);

        Font font = new Font("serif",Font.BOLD,20);

        bar = new JMenuBar();
        menu = new JMenu("Resecption");
        menu2 = new JMenu("Admin");

        menu.setFont(font);
        menu2.setFont(font);
        menu.setForeground(Color.red);
        menu2.setForeground(Color.blue);

        item = new JMenuItem("Add Employe");
        item2 = new JMenuItem("Add Room");
        item3 = new JMenuItem("Resecption");
        

        

        menu2.add(item);
        menu2.add(item2);
        menu.add(item3);
        

        bar.add(menu);
        bar.add(menu2);
        

        setJMenuBar(bar);

        label.add(on);
       
        item.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        on.b10.addActionListener(this);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == item){
            label.add(on).setVisible(false);
            label.add(obj).setVisible(false);
            label.add(ob).setVisible(true);;
            label.setVisible(false);
            label.setVisible(true);

           


           
           
            
            

        }
        else if(e.getSource() == item2){

            label.add(on).setVisible(false);
            label.add(ob).setVisible(false);

            label.add(obj).setVisible(true);;
            label.setVisible(false);
            label.setVisible(true);
           

        }
        else{
            label.add(ob).setVisible(false);
            label.add(obj).setVisible(false);
            label.add(on).setVisible(true);
            label.setVisible(false);
            label.setVisible(true);
            if(e.getSource()==on.b10){
                setVisible(false);

            }
          

            
        }
        
       
        
    }
    public static void main(String[] args) {
        Dashbord d = new Dashbord();
    }

   
}
