
package travel.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class BookHotel extends JFrame implements ActionListener{
      Choice chotel,cac,cfood;
    JTextField tfperson,tfdays;
    String username;
    JLabel labelusername, labelid, labelphone, labelprice,labelnumber;
    JButton checkprice, bookpackage, back;

    BookHotel(String username) {
        this.username = username;
        setBounds(350, 200, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelusername.setBounds(250, 70, 100, 20);
        add(labelusername);

        JLabel lblhotel = new JLabel("Select Hotel");
        lblhotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblhotel.setBounds(40, 110, 100, 20);
        add(lblhotel);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblperson.setBounds(40, 150, 150, 25);
        add(lblperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 25);
        add(tfperson);

       
        JLabel lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbldays.setBounds(40, 190, 150, 25);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 150, 25);
        add(tfdays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblac.setBounds(40, 230, 150, 20);
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);
        
        JLabel lblfood = new JLabel("food Included");
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblfood.setBounds(40, 270, 150, 25);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);
        
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);
        
         JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblphone.setBounds(40,390, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 200, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltotal.setBounds(40, 430, 150, 25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250, 430, 150, 25);
        add(labelprice);


        try {
            Conn c = new Conn();
            String query = "select * from customer where username='" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBackground(Color.BLACK);
        checkprice.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setFont(new Font("Tahoma", Font.BOLD, 14));
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBounds(340, 490, 120, 25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 600, 300);
        add(l12);
        setVisible(true);

    }

    public static void main(String[] args) {
        new BookHotel("simranaroa08");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkprice) {
            try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost=Integer.parseInt(rs.getString("costperperson"));
                int food=Integer.parseInt(rs.getString("foodincluded"));
                int ac=Integer.parseInt(rs.getString("acroom"));
                int persons=Integer.parseInt(tfperson.getText());
                 int days=Integer.parseInt(tfdays.getText());
                 String acselected=cac.getSelectedItem();
                 String foodselected=cfood.getSelectedItem();
                 if(persons*days>0){
                     int total=0;
                     total +=acselected.equals("AC")?ac:0;
                     total +=foodselected.equals("Yes")?food:0;
                     total+= cost;
                     total=total*persons*days;
                     
                     labelprice.setText("Rst"+total);
                     
                 }else{
                     JOptionPane.showMessageDialog(null,"Please enter  a valid number");
                 }

                
            }
           
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } else if (e.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('" + labelusername.getText() + "','" + chotel.getSelectedItem() + "','" + tfperson.getText() + "','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','" + labelid.getText() + "','" + labelnumber.getText() + "','" + labelphone.getText() + "','" + labelprice.getText() + "')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }
}
