package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;
    Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//register the driver 1
            c= DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","MYSQL");//creating connection string 2
            s=c.createStatement();//creating statements 3


        }catch(Exception E)
        {
           E.printStackTrace();
        }
    }
}
