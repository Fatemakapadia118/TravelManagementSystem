package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String un;
    JButton addpd,vpd,udpd,cp,bp,vp,vh,d,bh,vbh,p,cal,n,ab,dpd;
    Dashboard(String un)
    {
        this.un=un;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //if you dont knw size of ur laptop
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5,0,70,60);
        p1.add(icon);
        JLabel hd=new JLabel("Dashboard");
        hd.setBounds(80,10,300,40);
        hd.setForeground(Color.white);
        hd.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(hd);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);

        addpd=new JButton("Add Personal Details ");
        addpd.setBounds(0,0,300,50);
        addpd.setBackground(new Color(0,0,102));
        addpd.setForeground(Color.WHITE);
        addpd.setFont(new Font("Tamoha",Font.PLAIN,20));
        addpd.setMargin(new Insets(0,0,0,60)); //margin chodega
        addpd.addActionListener(this);
        p2.add(addpd);

        udpd=new JButton("Update Personal Details ");
        udpd.setBounds(0,50,300,50);
        udpd.setBackground(new Color(0,0,102));
        udpd.setForeground(Color.WHITE);
        udpd.setFont(new Font("Tamoha",Font.PLAIN,20));
        udpd.setMargin(new Insets(0,0,0,30));
        udpd.addActionListener(this);
        p2.add(udpd);

        vpd=new JButton("View Details ");
        vpd.setBounds(0,100,300,50);
        vpd.setBackground(new Color(0,0,102));
        vpd.setForeground(Color.WHITE);
        vpd.setFont(new Font("Tamoha",Font.PLAIN,20));
        vpd.setMargin(new Insets(0,0,0,130));
        vpd.addActionListener(this);
        p2.add(vpd);

        dpd=new JButton("Delete personal Details ");
        dpd.setBounds(0,150,300,50);
        dpd.setBackground(new Color(0,0,102));
        dpd.setForeground(Color.WHITE);
        dpd.setFont(new Font("Tamoha",Font.PLAIN,20));
        dpd.setMargin(new Insets(0,0,0,40));
        dpd.addActionListener(this);
        p2.add(dpd);

       cp=new JButton("Check package");
        cp.setBounds(0,200,300,50);
        cp.setBackground(new Color(0,0,102));
        cp.setForeground(Color.WHITE);
        cp.setFont(new Font("Tamoha",Font.PLAIN,20));
        cp.setMargin(new Insets(0,0,0,120));
        cp.addActionListener(this);
        p2.add(cp);

        bp=new JButton("Book package");
        bp.setBounds(0,250,300,50);
        bp.setBackground(new Color(0,0,102));
        bp.setForeground(Color.WHITE);
        bp.setFont(new Font("Tamoha",Font.PLAIN,20));
        bp.setMargin(new Insets(0,0,0,120));
        bp.addActionListener(this);
        p2.add(bp);

        vp=new JButton("View package");
        vp.setBounds(0,300,300,50);
        vp.setBackground(new Color(0,0,102));
        vp.setForeground(Color.WHITE);
        vp.setFont(new Font("Tamoha",Font.PLAIN,20));
        vp.setMargin(new Insets(0,0,0,120));
        vp.addActionListener(this);
        p2.add(vp);

        vh=new JButton("View Hotels");
        vh.setBounds(0,350,300,50);
        vh.setBackground(new Color(0,0,102));
        vh.setForeground(Color.WHITE);
        vh.setFont(new Font("Tamoha",Font.PLAIN,20));
        vh.setMargin(new Insets(0,0,0,130));
        vh.addActionListener(this);
        p2.add(vh);

        bh=new JButton("Book Hotel");
        bh.setBounds(0,400,300,50);
        bh.setBackground(new Color(0,0,102));
        bh.setForeground(Color.WHITE);
        bh.setFont(new Font("Tamoha",Font.PLAIN,20));
        bh.setMargin(new Insets(0,0,0,140));
        bh.addActionListener(this);
        p2.add(bh);

        vbh=new JButton(" View Booked Hotel");
        vbh.setBounds(0,450,300,50);
        vbh.setBackground(new Color(0,0,102));
        vbh.setForeground(Color.WHITE);
        vbh.setFont(new Font("Tamoha",Font.PLAIN,20));
        vbh.setMargin(new Insets(0,0,0,80));
        vbh.addActionListener(this);
        p2.add(vbh);

        d=new JButton(" Destinations");
        d.setBounds(0,500,300,50);
        d.setBackground(new Color(0,0,102));
        d.setForeground(Color.WHITE);
        d.setFont(new Font("Tamoha",Font.PLAIN,20));
        d.setMargin(new Insets(0,0,0,125));
        d.addActionListener(this);
        p2.add(d);

        p=new JButton(" Payments");
        p.setBounds(0,550,300,50);
        p.setBackground(new Color(0,0,102));
        p.setForeground(Color.WHITE);
        p.setFont(new Font("Tamoha",Font.PLAIN,20));
        p.setMargin(new Insets(0,0,0,145));
        p.addActionListener(this);
        p2.add(p);

        cal=new JButton(" Calculator");
        cal.setBounds(0,600,300,50);
        cal.setBackground(new Color(0,0,102));
        cal.setForeground(Color.WHITE);
        cal.setFont(new Font("Tamoha",Font.PLAIN,20));
        cal.setMargin(new Insets(0,0,0,135));
        cal.addActionListener(this);
        p2.add(cal);

        n=new JButton(" Notepad");
        n.setBounds(0,650,300,50);
        n.setBackground(new Color(0,0,102));
        n.setForeground(Color.WHITE);
        n.setFont(new Font("Tamoha",Font.PLAIN,20));
        n.setMargin(new Insets(0,0,0,145));
        n.addActionListener(this);
        p2.add(n);

        ab=new JButton(" About");
        ab.setBounds(0,700,300,50);
        ab.setBackground(new Color(0,0,102));
        ab.setForeground(Color.WHITE);
        ab.setFont(new Font("Tamoha",Font.PLAIN,20));
        ab.setMargin(new Insets(0,0,0,165));
        ab.addActionListener(this);
        p2.add(ab);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,1650,1000); //panel k under chala jaayega
        add(image);

        JLabel text=new JLabel("Travel and Tourism Management System");
        text.setBounds(500,70,1000,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN,50));
        image.add(text);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addpd)
        {
            new AddCustomer(un);
        }
        else if(ae.getSource()==vpd)
        {
            new ViewCustomer(un);
        }
        else if(ae.getSource()==udpd)
        {
            new UpdateCustomer(un);
        }
        else if(ae.getSource()==cp)
        {
            new CheckPackage();
        }
        else if(ae.getSource()==bp)
        {
            new BookPackage(un);
        }
        else if(ae.getSource()==vp)
        {
            new BookPackage(un);
        }
        else if(ae.getSource()==vh)
        {
            new CheckHotels();
        }
        else if(ae.getSource()==d)
        {
            new Destination();
        }
        else if(ae.getSource()==bh)
        {
            new BookHotel(un);
        }
        else if(ae.getSource()==vbh)
        {
            new ViewHotel(un);
        }
        else if(ae.getSource()==p)
        {
            new Payment();
        }
        else if(ae.getSource()==cal)
        {
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==n)
        {
            try{
                Runtime.getRuntime().exec("notepad.exe");

            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==ab)
        {
            new About();
        }
        else if(ae.getSource()==dpd)
        {
            new DeleteDetails(un);
        }

    }

    public static void main(String[] args)
    {
        new Dashboard("");
    }
}
