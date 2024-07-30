

package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(50,20,100,25);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblusername);
        
         tfusername=new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname=new JLabel("Name");
        lblname.setBounds(50,60,100,25);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblname);
        
         tfname=new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(50,100,100,25);
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblpassword);
        
        tfpassword=new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblsecurity=new JLabel("Security ");
        lblsecurity.setBounds(50,140,120,25);
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        p1.add(lblsecurity);
        

         security=new Choice();
        security.add("Fav Character from The Boys");
        security.add("fav Marvel superhero");
        security.add("Your Lucky number");
        security.add("Your childhood superhero");
        security.setBounds(190,140,180,25);
        p1.add(security);
        
        JLabel lblanswer=new JLabel("Answer");
        lblanswer.setBounds(50,180,180,25);
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));     
        p1.add(lblanswer);
        
        tfanswer=new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        create=new JButton("Create");
        create.setBounds(80,250,100,30);
        create.setForeground(new Color(133,193,233));
        create.setBackground(Color.WHITE);
        create.setFont(new Font("Tahoma",Font.BOLD,14)); 
        create.addActionListener(this);
        p1.add(create);
        
        back=new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setForeground(new Color(133,193,233));
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14)); 
        back.addActionListener(this);
        p1.add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new Signup();
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==create){
           String username=tfusername.getText();
           String name=tfname.getText();
           String password=tfpassword.getText();
           String question =security.getSelectedItem(); 
           String answer=tfanswer.getText();
           String sql="insert into account values('"+username+"','"+name+"','"+password+"','"+security+"','"+answer+"')";
           try{
               Conn c=new Conn();
               c.s.executeUpdate(sql);
               JOptionPane.showMessageDialog(null,"Account Created Successfully");
              
               setVisible(false);
               new Login();
           }catch(Exception e){
               e.printStackTrace();
           }
       }else if(ae.getSource()==back){
           setVisible(false);
           new Login();
       }
    }
}
