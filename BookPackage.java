package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.Extension;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {
    String un;
    Choice csp;
    JTextField ttp;
    JLabel lus,lid,ln,lp,ltp;
    JButton back,checkprice,bookpakage;
    BookPackage(String un)
    {
        this.un=un;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel us=new JLabel("Username");
        us.setFont(new Font("Tahoma",Font.PLAIN,16));
        us.setBounds(40,70,100,20);
        add(us);
        lus=new JLabel();
        lus.setFont(new Font("Tahoma",Font.PLAIN,16));
        lus.setBounds(250,70,100,20);
        add(lus);

        JLabel sp=new JLabel("Select Package");
        sp.setFont(new Font("Tahoma",Font.PLAIN,16));
        sp.setBounds(40,110,150,20);
        add(sp);
        csp=new Choice();
        csp.add("Gold package");
        csp.add("Silver package");
        csp.add("Bronze package");
        csp.setBounds(250,110,200,20);
        add(csp);

        JLabel tp=new JLabel("Total Person");
        tp.setFont(new Font("Tahoma",Font.PLAIN,16));
        tp.setBounds(40,150,100,20);
        add(tp);
        ttp=new JTextField("1");
        ttp.setFont(new Font("Tahoma",Font.PLAIN,16));
        ttp.setBounds(250,150,200,25);
        add(ttp);


        JLabel id=new JLabel("Id");
        id.setFont(new Font("Tahoma",Font.PLAIN,16));
        id.setBounds(40,190,100,20);
        add(id);
        lid=new JLabel();
        lid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lid.setBounds(250,190,200,20);
        add(lid);

        JLabel n=new JLabel("Number");
        n.setFont(new Font("Tahoma",Font.PLAIN,16));
        n.setBounds(40,230,100,20);
        add(n);
        ln=new JLabel();
        ln.setFont(new Font("Tahoma",Font.PLAIN,16));
        ln.setBounds(250,230,250,20);
        add(ln);

        JLabel p=new JLabel("Phone");
        p.setFont(new Font("Tahoma",Font.PLAIN,16));
        p.setBounds(40,270,100,20);
        add(p);
        lp=new JLabel();
        lp.setFont(new Font("Tahoma",Font.PLAIN,16));
        lp.setBounds(250,270,250,20);
        add(lp);

        JLabel top=new JLabel("Total Price");
        top.setFont(new Font("Tahoma",Font.PLAIN,16));
        top.setBounds(40,310,100,20);
        add(top);
        ltp=new JLabel();
        ltp.setFont(new Font("Tahoma",Font.PLAIN,16));
        ltp.setBounds(250,310,250,20);
        add(ltp);
        try{
            Conn c=new Conn();
            String query="select *from customer where username='"+ un+"'";
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next())
            {
                lus.setText(rs.getString("username"));
                lid.setText(rs.getString("id"));
                ln.setText(rs.getString("number"));
                lp.setText(rs.getString("phone"));

            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        checkprice =new JButton("Check price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        bookpakage =new JButton("Book package");
        bookpakage.setBackground(Color.BLACK);
        bookpakage.setForeground(Color.WHITE);
        bookpakage.setBounds(200,380,120,25);
        bookpakage.addActionListener(this);
        add(bookpakage);
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j=new JLabel(i3);
        j.setBounds(550,50,500,300);
        add(j);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==checkprice)
        {
            String pk=csp.getSelectedItem();
            int cost=0;
            if(pk.equals("Gold package")){
                cost=cost+1200;
            }
            else if(pk.equals("Silver package")) {
                cost=cost+2500;
            }
            else{
                 cost=cost+3200;
            }
            int person=Integer.parseInt(ttp.getText());
            cost=cost*person;
            ltp.setText("Rs"+cost);
        }
        else if (ae.getSource()==bookpakage) {
            try{
                Conn c=new Conn();
               c.s.executeUpdate("insert into bookpackage values('"+lus.getText()+"','"+csp.getSelectedItem() +"','"+ttp.getText()+"','"+lid.getText()+"','"+ln.getText()+"','"+lp.getText()+"','"+ltp.getText()+"')");
               JOptionPane.showMessageDialog(null,"package booked successfully");
               setVisible(false);

            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        else {
            setVisible(false);
        }
    }

    public static void main(String args[])
    {
        new BookPackage("");
    }

}
