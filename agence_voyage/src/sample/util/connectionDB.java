package sample.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionDB {
    public Connection connection;
    public Connection getConnection(){

        String dbname="agence_voyage";
        String username="root";
        String password="";
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
          connection= DriverManager.getConnection("jdbc:mysql://localhost/"+dbname,username,password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }



        return connection;
    }
}
