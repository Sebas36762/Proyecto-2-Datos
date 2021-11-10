package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    Connection con;
    public connection(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("//localhost:8080");
        } catch (Exception e){
            System.err.println("Error" +e);
        }
    }
}
