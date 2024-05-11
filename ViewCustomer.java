package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;

    ViewCustomer(String un)
    {

        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel us=new JLabel("Username");
        us.setBounds(30,50,150,25);
        add(us);
        JLabel lus=new JLabel();
        lus.setBounds(220,50,150,25);
        add(lus);

        JLabel id=new JLabel("Id");
        id.setBounds(30,110,150,25);
        add(id);
        JLabel lid=new JLabel();
        lid.setBounds(220,110,150,25);
        add(lid);

        JLabel n=new JLabel("Number");
        n.setBounds(30,170,150,25);
        add(n);
        JLabel ln=new JLabel();
        ln.setBounds(220,170,150,25);
        add(ln);

        JLabel na=new JLabel("Name");
        na.setBounds(30,230,150,25);
        add(na);
        JLabel lna=new JLabel();
        lna.setBounds(220,230,150,25);
        add(lna);

        JLabel g=new JLabel("Gender");
        g.setBounds(30,290,150,25);
        add(g);
        JLabel lg=new JLabel();
        lg.setBounds(220,290,150,25);
        add(lg);


        JLabel co=new JLabel("Country");
        co.setBounds(500,50,150,25);
        add(co);
        JLabel lco=new JLabel();
        lco.setBounds(690,50,150,25);
        add(lco);

        JLabel ad=new JLabel("Address");
        ad.setBounds(500,110,150,25);
        add(ad);
        JLabel lad=new JLabel();
        lad.setBounds(690,110,150,25);
        add(lad);

        JLabel pn=new JLabel("phone");
        pn.setBounds(500,170,150,25);
        add(pn);
        JLabel lpn=new JLabel();
        lpn.setBounds(690,170,150,25);
        add(lpn);

        JLabel em=new JLabel("Email");
        em.setBounds(500,230,150,25);
        add(em);
        JLabel lem=new JLabel();
        lem.setBounds(690,230,150,25);
        add(lem);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j=new JLabel(i3);
        j.setBounds(20,400,600,200);
        add(j);
        setVisible(true);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5=i4.getImage().getScaledInstance(600,200, Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel jj=new JLabel(i6);
        jj.setBounds(600,400,600,200);
        add(jj);
        try{
            Conn c=new Conn();
           ResultSet rs= c.s.executeQuery("select *from customer where username='"+un+"'");
           while(rs.next())
            {
                  lus.setText(rs.getString("username"));
                  lid.setText(rs.getString("id"));
                  ln.setText(rs.getString("number"));
                  lna.setText(rs.getString("name"));
                  lg.setText(rs.getString("gender"));
                  lco.setText(rs.getString("country"));
                  lad.setText(rs.getString("address"));
                  lpn.setText(rs.getString("phone"));
                  lem.setText(rs.getString("email"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);

        }
    }

    public  static void main(String[]args)
    {
        new ViewCustomer("maryam1234");
    }
}
