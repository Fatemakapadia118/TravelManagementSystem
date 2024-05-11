package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewHotel extends JFrame implements ActionListener {
    JButton back;

    ViewHotel(String un)
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

        JLabel hn=new JLabel("Hotel Name");
        hn.setBounds(30,90,150,25);
        add(hn);
        JLabel lhn=new JLabel();
        lhn.setBounds(220,90,150,25);
        add(lhn);

        JLabel p=new JLabel("Total person");
        p.setBounds(30,130,150,25);
        add(p);
        JLabel lp=new JLabel();
        lp.setBounds(220,130,150,25);
        add(lp);

        JLabel d=new JLabel("Total days");
        d.setBounds(30,170,150,25);
        add(d);
        JLabel ld=new JLabel();
        ld.setBounds(220,170,150,25);
        add(ld);

        JLabel ac=new JLabel("AC included?");
        ac.setBounds(30,210,150,25);
        add(ac);
        JLabel lac=new JLabel();
        lac.setBounds(220,210,150,25);
        add(lac);

        JLabel f=new JLabel("Food included?");
        f.setBounds(30,250,150,25);
        add(f);
        JLabel lf=new JLabel();
        lf.setBounds(220,250,150,25);
        add(lf);


        JLabel id=new JLabel("id");
        id.setBounds(30,290,150,25);
        add(id);
        JLabel lid=new JLabel();
        lid.setBounds(220,290,150,25);
        add(lid);

        JLabel n=new JLabel("Number");
        n.setBounds(30,330,150,25);
        add(n);
        JLabel ln=new JLabel();
        ln.setBounds(220,330,150,25);
        add(ln);

        JLabel pn=new JLabel("phone");
        pn.setBounds(30,370,150,25);
        add(pn);
        JLabel lpn=new JLabel();
        lpn.setBounds(220,370,150,25);
        add(lpn);

        JLabel tc=new JLabel("Total cost");
        tc.setBounds(30,410,150,25);
        add(tc);
        JLabel ltc=new JLabel();
        ltc.setBounds(220,410,150,25);
        add(ltc);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(70,480,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(350,400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j=new JLabel(i3);
        j.setBounds(450,40,350,400);
        add(j);
        setVisible(true);

        try{
            Conn c=new Conn();
            ResultSet rs= c.s.executeQuery("select *from bookhotel where username='"+un+"'");
            while(rs.next())
            {
                lus.setText(rs.getString("username"));
                lid.setText(rs.getString("id"));
                ln.setText(rs.getString("number"));
                lhn.setText(rs.getString("hotelname"));
                ld.setText(rs.getString("days"));
                lac.setText(rs.getString("ac"));
                lf.setText(rs.getString("food"));
                lpn.setText(rs.getString("phone"));
                ltc.setText(rs.getString("price"));
                lp.setText(rs.getString("person"));
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
        new ViewHotel("");
    }
}
