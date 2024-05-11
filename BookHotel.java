package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.Extension;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {
    String un;
    Choice ch,cac,cf;
    JTextField ttp,td;
    JLabel lus,lid,ln,lp,ltp;
    JButton back,checkprice,bookpakage;
    BookHotel(String un)
    {
        this.un=un;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("BOOK HOTEL");
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

        JLabel sp=new JLabel("Select Hotel");
        sp.setFont(new Font("Tahoma",Font.PLAIN,16));
        sp.setBounds(40,110,150,20);
        add(sp);
        ch=new Choice();
        ch.setBounds(250,110,200,20);
        add(ch);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select *from hotel");
            while(rs.next())
            {
                  ch.add(rs.getString("name"));
            }

        }catch(Exception e)
        {
               e.printStackTrace();
        }

        JLabel tp=new JLabel("Total Person");
        tp.setFont(new Font("Tahoma",Font.PLAIN,16));
        tp.setBounds(40,150,100,20);
        add(tp);
        ttp=new JTextField("1");
        ttp.setFont(new Font("Tahoma",Font.PLAIN,16));
        ttp.setBounds(250,150,200,25);
        add(ttp);

        JLabel d=new JLabel("No of days");
        d.setFont(new Font("Tahoma",Font.PLAIN,16));
        d.setBounds(40,190,100,20);
        add(d);
        td=new JTextField("1");
        td.setFont(new Font("Tahoma",Font.PLAIN,16));
        td.setBounds(250,190,200,25);
        add(td);

        JLabel ac=new JLabel("Ac/non-Ac");
        ac.setFont(new Font("Tahoma",Font.PLAIN,16));
        ac.setBounds(40,230,100,20);
        add(ac);
        cac=new Choice();
        cac.setBounds(250,230,200,20);
        cac.add("AC");
        cac.add("Non-AC");
        add(cac);

        JLabel f=new JLabel("Food Included");
        f.setFont(new Font("Tahoma",Font.PLAIN,16));
        f.setBounds(40,270,100,20);
        add(f);
        cf=new Choice();
        cf.setBounds(250,270,200,20);
        cf.add("yes");
        cf.add("no");
        add(cf);

        JLabel id=new JLabel("Id");
        id.setFont(new Font("Tahoma",Font.PLAIN,16));
        id.setBounds(40,310,100,20);
        add(id);
        lid=new JLabel();
        lid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lid.setBounds(250,310,200,20);
        add(lid);

        JLabel n=new JLabel("Number");
        n.setFont(new Font("Tahoma",Font.PLAIN,16));
        n.setBounds(40,350,100,20);
        add(n);
        ln=new JLabel();
        ln.setFont(new Font("Tahoma",Font.PLAIN,16));
        ln.setBounds(250,350,250,20);
        add(ln);

        JLabel p=new JLabel("Phone");
        p.setFont(new Font("Tahoma",Font.PLAIN,16));
        p.setBounds(40,390,100,20);
        add(p);
        lp=new JLabel();
        lp.setFont(new Font("Tahoma",Font.PLAIN,16));
        lp.setBounds(250,390,250,20);
        add(lp);

        JLabel top=new JLabel("Total Price");
        top.setFont(new Font("Tahoma",Font.PLAIN,16));
        top.setBounds(40,430,100,20);
        add(top);
        ltp=new JLabel();
        ltp.setFont(new Font("Tahoma",Font.PLAIN,16));
        ltp.setBounds(250,430,250,20);
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
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        bookpakage =new JButton("Book Hotel");
        bookpakage.setBackground(Color.BLACK);
        bookpakage.setForeground(Color.WHITE);
        bookpakage.setBounds(200,490,120,25);
        bookpakage.addActionListener(this);
        add(bookpakage);
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j=new JLabel(i3);
        j.setBounds(500,50,500,400);
        add(j);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==checkprice)
        {
            Conn c=new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select* from hotel where name='" + ch.getSelectedItem() + "'");
                while (rs.next())
                {
                    int cost=Integer.parseInt(rs.getString("costperperson"));
                    int food=Integer.parseInt(rs.getString("foodincluded"));
                    int ac=Integer.parseInt(rs.getString("acroom"));
                    int person=Integer.parseInt(ttp.getText());
                    int days=Integer.parseInt(td.getText());
                    String acselected=cac.getSelectedItem();
                    String foodSelected= cf.getSelectedItem();

                    if(person*days>0)
                    {
                        int total=0;
                        total+= acselected.equals("AC") ? ac:0;
                        total+=foodSelected.equals("yes")? food:0;
                        total+=cost;
                        total=total*person*days;
                        ltp.setText("Rs"+total);

                    }
                    else{
                        JOptionPane.showMessageDialog(null,"please enter Invalid no.");
                    }
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource()==bookpakage) {
            try{
                Conn c=new Conn();
               c.s.executeUpdate("insert into bookhotel values('"+lus.getText()+"','"+ch.getSelectedItem() +"','"+ttp.getText()+"','"+td.getText()+"','"+cac.getSelectedItem()+"','"+cf.getSelectedItem()+"','"+lid.getText()+"','"+ln.getText()+"','"+lp.getText()+"','"+ltp.getText()+"')");
                JOptionPane.showMessageDialog(null,"hotel booked successfully");
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
        new BookHotel("");
    }

}



