package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2, b3;

    public Login() {

        setBackground(new Color(255, 255, 204));
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        panel = new JPanel();
        panel.setBackground(new Color(131, 193, 233));
        panel.setBounds(0, 0, 400, 400);
        getContentPane().setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);

        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = c1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(100, 120, 200, 200);
        panel.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(60, 20, 100, 25);
        l1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(l1);

        JLabel l2 = new JLabel("Password");
        l2.setBounds(60, 110, 100, 25);
        l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(l2);

        textField = new JTextField();
        textField.setBounds(60, 60, 300, 30);
        textField.setBorder(BorderFactory.createEmptyBorder());

        p2.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(60, 150, 300, 30);
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        p2.add(passwordField);

        JLabel l3 = new JLabel("");
        l3.setBounds(377, 79, 46, 34);
        panel.add(l3);

        JLabel l4 = new JLabel("");
        l4.setBounds(377, 124, 46, 34);
        panel.add(l3);

        JLabel l6 = new JLabel(i2);
        l6.setBounds(480, 70, 150, 150);
        add(l6);

        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(133, 193, 233));
        b1.setBounds(60, 200, 130, 30);
        b1.setBorder(new LineBorder(new Color(133, 193, 233)));
        p2.add(b1);

        b2 = new JButton("SignUp");
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(133, 193, 233));
        b2.setBorder(new LineBorder(new Color(133, 193, 233)));
        b2.setBounds(230, 200, 130, 30);
        p2.add(b2);

        b3 = new JButton("Forgot Password");
        b3.addActionListener(this);
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(133, 193, 233));
        b3.setBorder(new LineBorder(new Color(133, 193, 233)));
        b3.setBounds(130, 250, 130, 30);
        p2.add(b3);

        JLabel l5 = new JLabel("Trouble in Login?");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        l5.setForeground(Color.RED);
        l5.setBounds(300, 250, 150, 20);
        p2.add(l5);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            Boolean status = false;
            try {
                Conn con = new Conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new Loading(textField.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login or Password!");
                }

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);

            new Signup();

        }
        if (ae.getSource() == b3) {
            setVisible(false);

            new ForgotPassword();

        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
