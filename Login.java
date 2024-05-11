package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
   JButton login,fp,sp;
   JTextField tfun,tfps;
    Login()
    {
        setSize(900,400);
        setLocation(350,200);
        setLayout(null);//jab apna khudka layout banana ho to ye use karte hai kyuki swing by default border layout lagata hai

        getContentPane().setBackground(Color.black);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);//apna layout banane k liye
        p1.setLayout(null);
        add(p1);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
         Image i2=i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel j=new JLabel(i3);
         j.setBounds(100,100,200,200);
         p1.add(j);

         JPanel p2=new JPanel();
         p2.setLayout(null);
         p2.setBounds(400,30,450,300);
         add(p2);
         JLabel lblun=new JLabel("Username");
         lblun.setBounds(60,20,100,25);
         lblun.setFont(new Font("BAN SERIF",Font.PLAIN,20));
         p2.add(lblun);
         tfun=new JTextField();
         tfun.setBounds(60,50,300,25);
         tfun.setBorder(BorderFactory.createEmptyBorder());
         p2.add(tfun);

        JLabel lbps=new JLabel("Password");
        lbps.setBounds(60,80,100,25);
        lbps.setFont(new Font("BAN SERIF",Font.PLAIN,20));
        p2.add(lbps);
        tfps=new JTextField();
        tfps.setBounds(60,110,300,25);
        tfps.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfps);

        login=new JButton("Login");
        login.setBounds(60,150,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        p2.add(login);

        sp=new JButton("SignUp");
        sp.setBounds(200,150,130,30);
        sp.setBackground(new Color(133,193,233));
        sp.setForeground(Color.WHITE);
        sp.setBorder(BorderFactory.createEmptyBorder());
        sp.addActionListener(this);
        p2.add(sp);

        fp=new JButton("Forget Password");
        fp.setBounds(130,200,130,30);
        fp.setBackground(new Color(133,193,233));
        fp.setForeground(Color.WHITE);
        fp.setBorder(BorderFactory.createEmptyBorder());
        fp.addActionListener(this);
        p2.add(fp);

        JLabel text=new JLabel("forget password...");
        text.setBounds(280,200,130,30);
        text.setForeground(Color.RED);
        p2.add(text);

        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==login)
       {
           try{
               String username=tfun.getText();
               String password=tfps.getText();
               String query="select *from account where username='"+username+"' AND password='"+password+"'";
               Conn c=new Conn();
               ResultSet rs=c.s.executeQuery(query);
               if(rs.next())
               {
                   setVisible(false);
                   new Loading(username);
               }
               else {
                   JOptionPane.showMessageDialog(null,"incorrect username or password");
               }
           }
           catch (Exception e)
           {
           }
       }
        else if(ae.getSource()==sp)
        {
             setVisible(false);
             new SignUp();
        }
        else if(ae.getSource()==fp)
        {
            setVisible(false);
            new ForgetPassword();
        }

    }
    public static void main(String [] args)
    {
           new Login();
    }
}
