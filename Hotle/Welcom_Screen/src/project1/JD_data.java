package project1;

import java.sql.*;


public class JD_data {
    Connection conn;
    Statement s;
    PreparedStatement p;
    public JD_data(){
        String url = "jdbc:mysql://localhost:3306/hotelmangment";
        String u = "root";
        String p = "@Ayush128";

        try {
          conn = DriverManager.getConnection(url, u, p);
          s = conn.createStatement();
          

        } catch (Exception e) {
            e.printStackTrace();
        }        
    }

}
