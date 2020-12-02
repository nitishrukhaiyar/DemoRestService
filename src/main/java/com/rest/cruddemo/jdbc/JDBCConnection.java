package com.rest.cruddemo.jdbc;

import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(FAILOVER=on)(LOAD_BALANCE=off)(ADDRESS= (PROTOCOL=tcp)(HOST=10.5.99.76)(PORT=1521))(ADDRESS= (PROTOCOL=tcp)(HOST=10.5.99.78)(PORT=1521))(ADDRESS= (PROTOCOL=tcp)(HOST=10.5.99.80)(PORT=1521)))(CONNECT_DATA=(SERVICE_NAME=PDBILL_ACTIVE)))", "PN_USER", "PDBILL_PN_USER");
            Statement statement = connection.createStatement();
            System.out.println("connected to database");
            ResultSet rs=statement.executeQuery("select * from xx_employee");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex);
        }
    }

}
