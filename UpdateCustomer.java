package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel lus,ln;
    JComboBox jid;
    JTextField tnum,tco,tad,temail,tpn,tid,tg;
    JRadioButton rgm,rgf;
    JButton update,back;
    UpdateCustomer(String un) {
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Update Customer Detail");
        text.setBounds(50,0,300,25);
        text.setFont(new Font("Tamoha",Font.PLAIN,20));
        add(text);

        JLabel us = new JLabel("Username");
        us.setBounds(30, 50, 150, 25);
        add(us);
        lus = new JLabel();
        lus.setBounds(220, 50, 150, 25);
        add(lus);

        JLabel id = new JLabel("Id");
        id.setBounds(30, 90, 150, 25);
        add(id);
        tid = new JTextField();
        tid.setBounds(220, 90, 150, 25);
        add(tid);

        JLabel num = new JLabel("Number");
        num.setBounds(30, 130, 150, 25);
        add(num);
        tnum = new JTextField();
        tnum.setBounds(220, 130, 150, 25);
        add(tnum);

        JLabel n = new JLabel("Name");
        n.setBounds(30, 170, 150, 25);
        add(n);
        ln = new JLabel();
        ln.setBounds(220, 170, 150, 25);
        add(ln);

        JLabel g = new JLabel("Gender");
        g.setBounds(30, 210, 150, 25);
        add(g);
        tg = new JTextField();
        tg.setBounds(220, 210, 150, 25);
        add(tg);

        JLabel co = new JLabel("Country");
        co.setBounds(30, 250, 150, 25);
        add(co);
        tco = new JTextField();
        tco.setBounds(220, 250, 150, 25);
        add(tco);

        JLabel ad = new JLabel("Address");
        ad.setBounds(30, 290, 150, 25);
        add(ad);
        tad = new JTextField();
        tad.setBounds(220, 290, 150, 25);
        add(tad);

        JLabel pn = new JLabel("Phone");
        pn.setBounds(30, 330, 150, 25);
        add(pn);
        tpn = new JTextField();
        tpn.setBounds(220, 330, 150, 25);
        add(tpn);

        JLabel email = new JLabel("Email");
        email.setBounds(30, 370, 150, 25);
        add(email);
        temail = new JTextField();
        temail.setBounds(220, 370, 150, 25);
        add(temail);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 430, 100, 25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j = new JLabel(i3);
        j.setBounds(400, 100, 450, 500);
        add(j);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from customer where username='"+un+"'");
            while (rs.next()) {
                lus.setText(rs.getString("username"));
                ln.setText(rs.getString("name"));
                tnum.setText(rs.getString("number"));
                tg.setText(rs.getString("gender"));
                tpn.setText(rs.getString("phone"));
                tad.setText(rs.getString("address"));
                tco.setText(rs.getString("country"));
                temail.setText(rs.getString("email"));
                tid.setText(rs.getString("id"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==update)
        {
            String username=lus.getText();
            String id=tid.getText();
            String number=tnum.getText();
            String name=ln.getText();
            String gender=tg.getText();
            String country=tco.getText();
            String address=tad.getText();
            String phone=tpn.getText();
            String email=temail.getText();
            try{
                Conn c=new Conn();
                String query="update customer set username='"+username+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Customer detail updated successfully");


            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new UpdateCustomer("");
    }
}
