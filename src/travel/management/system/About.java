
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame implements ActionListener{
    About(){
        setBounds(600,200,500,550);
        setLayout(null);
        setBackground(Color.WHITE);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 10, 100, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
       add(l1);
       
       TextArea area=new TextArea("Hello",10,40,Scrollbar.VERTICAL);
       area.setEditable(false);
       area.setBounds(20,100,450,300);
       add(area);
       
       JButton  back=new JButton("back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);
        setVisible(true);
       
       
    }
    public static void main(String[] args) {
        new About();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
    }
}
