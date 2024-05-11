package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel lus,ln;
    JComboBox jid;
    JTextField tnum,tco,tad,temail,tpn;
    JRadioButton rgm,rgf;
    JButton add,back;
    AddCustomer(String un) {
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel us = new JLabel("Username");
        us.setBounds(30, 50, 150, 25);
        add(us);
        lus = new JLabel();
        lus.setBounds(220, 50, 150, 25);
        add(lus);

        JLabel id = new JLabel("Id");
        id.setBounds(30, 90, 150, 25);
        add(id);
        jid = new JComboBox(new String[]{"Passport", "Adhar Card", "Pan Card", "Ratian card"});//you can use choice also
        jid.setBounds(220, 90, 150, 25);
        jid.setBackground(Color.WHITE);
        add(jid);

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
        rgm = new JRadioButton("Male");
        rgm.setBounds(220, 210, 70, 25);
        rgm.setBackground(Color.white);
        add(rgm);
        rgf = new JRadioButton("Female");
        rgf.setBounds(300, 210, 70, 25);
        rgf.setBackground(Color.white);
        add(rgf);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rgm);
        bg.add(rgf);

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

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel j = new JLabel(i3);
        j.setBounds(400, 10, 450, 420);
        add(j);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select *from account where username='"+un+"'");
            while (rs.next()) {
                lus.setText(rs.getString("username"));
                ln.setText(rs.getString("name"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==add)
            {
                 String username=lus.getText();
                 String id=(String)jid.getSelectedItem();
                 String number=tnum.getText();
                 String name=ln.getText();
                 String gender=null;
                 if(rgm.isSelected())
                 {
                     gender="Male";
                 }
                 else {
                     gender="female";
                 }
                 String country=tco.getText();
                 String address=tad.getText();
                 String phone=tpn.getText();
                 String email=temail.getText();
                 try{
                     Conn c=new Conn();
                     String query="insert into customer values('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
                     c.s.executeUpdate(query);

                     JOptionPane.showMessageDialog(null,"Customer detail added successfully");


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
        new AddCustomer("");
    }
}
