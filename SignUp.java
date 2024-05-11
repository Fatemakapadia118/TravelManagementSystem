package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {
    JButton cr,b;
    JTextField tus,tn,tp,tans;
    Choice security;
    SignUp()
    {
        setSize(900,400);
        setLocation(450,200);

        setLayout(null);
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,500,400);
        p1.setBackground(new Color(131,193,233));
        add(p1);

        JLabel us=new JLabel("Username");
        us.setBounds(50,20,125,25);
        us.setFont(new Font("BAN SERIF",Font.BOLD,14));
        p1.add(us);
        tus=new JTextField();
        tus.setBounds(190,20,200,25); // Set bounds for JTextField
        tus.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tus);

        JLabel n=new JLabel("Name");
        n.setBounds(50,60,125,25);
        n.setFont(new Font("BAN SERIF",Font.BOLD,14));
        p1.add(n);
        tn=new JTextField();
        tn.setBounds(190,60,200,25); // Set bounds for JTextField
        tn.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tn);

        JLabel p=new JLabel("Password");
        p.setBounds(50,100,125,25);
        p.setFont(new Font("BAN SERIF",Font.BOLD,14));
        p1.add(p);
        tp=new JTextField();
        tp.setBounds(190,100,200,25); // Set bounds for JTextField
        tp.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tp);

        JLabel sq=new JLabel("Security question");
        sq.setBounds(50,140,125,25);
        sq.setFont(new Font("BAN SERIF",Font.BOLD,14));
        p1.add(sq);
        security=new Choice();
        security.add("fav character from the boys");
        security.add("fav marvel superhero");
        security.add("your lucky no.");
        security.setBounds(190,140,200,25);
        p1.add(security);

        JLabel ans=new JLabel("Answer");
        ans.setBounds(50,180,125,25);
        ans.setFont(new Font("BAN SERIF",Font.BOLD,14));
        p1.add(ans);
        tans=new JTextField();
        tans.setBounds(190,180,200,25); // Set bounds for JTextField
        tans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tans);

        cr=new JButton("Create");
        cr.setBounds(80,250,130,30);
        cr.setBackground(Color.white);
        cr.setForeground(new Color(131,193,233));
        cr.setBorder(BorderFactory.createEmptyBorder());
        cr.addActionListener(this);
        p1.add(cr);

        b=new JButton("Back");
        b.setBounds(270,250,130,30);
        b.setBackground(Color.white);
        b.setForeground(new Color(131,193,233));
        b.setBorder(BorderFactory.createEmptyBorder());
        b.addActionListener(this);
        p1.add(b);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j=new JLabel(i3);
        j.setBounds(600,80,250,200);
        add(j);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cr)
        {
           String username=tus.getText();
           String name=tn.getText();
           String password=tp.getText();
           String question=security.getSelectedItem();
           String answer=tans.getText();

           String query= "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
           try{
               Conn c=new Conn();
               c.s.executeUpdate(query);

               JOptionPane.showMessageDialog(null,"account created succesfully");
               setVisible(false);
               new Login();
           }catch (Exception e)
           {

           }

        }
        else if (ae.getSource()==b)
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String [] args)
    {
        new SignUp();
    }

}
