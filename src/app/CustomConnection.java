package app;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomConnection  {
    Connection conn;
    
    public Connection getConnection() {
        try {
            Class.forName(Config.DRIVER_CLASS);

            this.conn = DriverManager.getConnection(
    			Config.URL, 
    			Config.USER, 
    			Config.PASSWORD
            );

            DatabaseMetaData meta = this.conn.getMetaData();
            System.out.println("Connected through " + meta.getDriverName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.conn;
    }
}

