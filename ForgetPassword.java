package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tus,tn,tp,tans,tsq;
    JButton search,retrieve,back;

    ForgetPassword()
    {
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(585,70,200,200);
        add(image);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);

        JLabel us=new JLabel("Username");
        us.setBounds(40,20,100,25);
        us.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(us);
        tus=new JTextField();
        tus.setBounds(220,20,150,25);
        tus.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tus);
        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.BLACK);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);


        JLabel n=new JLabel("Name");
        n.setBounds(40,60,100,25);
        n.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(n);
        tn=new JTextField();
        tn.setBounds(220,60,150,25);
        tn.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tn);

        JLabel sq=new JLabel("Secutity question");
        sq.setBounds(40,100,150,25);
        sq.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(sq);
        tsq=new JTextField();
        tsq.setBounds(220,100,150,25);
        tsq.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tsq);

        JLabel ans=new JLabel("Answer");
        ans.setBounds(40,140,150,25);
        ans.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(ans);
        tans=new JTextField();
        tans.setBounds(220,140,150,25);
        tans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tans);
        retrieve=new JButton("retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.BLACK);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);

        JLabel p=new JLabel("password");
        p.setBounds(40,180,150,25);
        p.setFont(new Font("Tahoma", Font.BOLD,14));
        p1.add(p);
        tp=new JTextField();
        tp.setBounds(220,180,150,25);
        tp.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tp);

        back=new JButton("back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.BLACK);
        back.setBounds(80,230,100,25);
        back.addActionListener(this);
        p1.add(back);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            try{
                String query="select *from account where username='"+tus.getText()+"'";
                Conn c=new Conn();
              ResultSet rs= c.s.executeQuery(query);
              while(rs.next())
              {
                  tn.setText(rs.getString("name"));
                  tsq.setText(rs.getString("security"));
              }
            }catch (Exception e)
            {
            }
        }
        else if(ae.getSource()==retrieve)
        {
            try{
                String query="select *from account where answer='"+tans.getText()+"'AND username='"+tus.getText()+"'" ;
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next())
                {
                    tp.setText(rs.getString("password"));
                }
            }catch (Exception e)
            {
            }
        }
        else if(ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String args[])
    {
         new ForgetPassword();
    }


}
