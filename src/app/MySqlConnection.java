package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {
    Connection conexao;
    Statement stmt;
    PreparedStatement prStmt;
    
    public Connection getConnection() {
        try {
        	
            System.out.println("Connecting to db.");
            
            Class.forName(Config.DRIVER_CLASS);
            
            return DriverManager.getConnection(
    			this.getURL(), 
    			Config.USER, 
    			Config.PASSWORD
			);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    
    public String getURL() {
    	return Config.HOST + "/" + Config.DATABASE + "?useSSL=true";
    }
}

