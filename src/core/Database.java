package core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Connection connection;
	private Statement stmt = null;
    public ResultSet resultSet = null;
    public String error = null;
	
	public Database(Connection connection) {
		this.connection = connection;
	}
    
    public ResultSet getResult() {
    	return this.resultSet;
    }
    
    public boolean select(String table) {
        return trySelect("SELECT * FROM `" + table + "`");
    }
    
    public boolean trySelect(String sqlString) {
//        lastString = sqlString;
        try {
        	
        	this.resultSet = this.getStatement().executeQuery(sqlString);
            
            return true;
            
        } catch (Exception ex) {
        	this.resultSet = null;
            this.error = ex.toString();
            return false;
        }
    }
    
    public boolean next() {
        try {
            return this.resultSet.next();
            
        } catch (SQLException e) {
            this.error = e.toString();
            return false;
        }
    }
    
    private void startConnection() {
		try {
			this.stmt = this.connection.createStatement();
		} catch (SQLException e) {
			this.error = e.toString();
		}
    }

    public Statement getStatement() {
    	this.startConnection();
        return stmt;
    }
    
    public boolean close() {
//        if (! online) return true;
        try {
            this.connection.close();
//            online = false;
            return true;
        } catch (SQLException e) {
            this.error = e.toString();
            return false;
        }
    }
	
}
