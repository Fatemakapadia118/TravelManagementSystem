package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread thread;
    String un;
    JProgressBar bar;
    public void run()
    {
        try{
            for(int i=1;i<=101;i++)
            {
                int max=bar.getMaximum(); //100
                int value= bar.getValue();

                if(value<max)
                {
                    bar.setValue(bar.getValue()+1);
                }
                else {
                    setVisible(false);
                    new Dashboard(un);
                }
                Thread.sleep(100);
            }

        }catch (Exception e){

        }
    }

    Loading(String un)
    {
        this.un=un;
        thread=new Thread(this);

        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("Travel and Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        add(bar);
        bar.setStringPainted(true);

        JLabel loading =new JLabel("Loading, Please wait...");
        loading.setBounds(200,140,300,30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);

        JLabel us =new JLabel("welcome"+ un);
        us.setBounds(20,310,400,40);
        us.setForeground(Color.RED);
        us.setFont(new Font("Raleway",Font.BOLD,16));
        add(us);

        thread.start();

        setVisible(true);
    }

    public static void main(String []args)
    {
        new Loading("");
    }
}
