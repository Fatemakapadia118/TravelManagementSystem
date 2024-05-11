package travel.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener {
    Paytm()
    {
        setBounds(500,200,800,600);
        JEditorPane pane=new JEditorPane();
        setLayout(null);
        pane.setEditable(false);

        try {
            pane.setPage("https://paytm.com/rent-payment");

        }catch (Exception e)
        {
           pane.setContentType("text/html");
           pane.setText("<html> could not load 404</html>");
        }
        JScrollPane sp=new JScrollPane(pane);
        getContentPane().add(sp);

        JButton back=new JButton("Back");
        back.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Payment();
    }
    public  static void main(String [] args)
    {
        new Paytm();
    }
}
