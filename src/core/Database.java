package core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Array;

public class Database {
	private Connection connection;
	private Statement stmt = null;
    public ResultSet resultSet = null;
    public String error = null;
    private String sql = "";
    private ArrayList insertArgs = new ArrayList();
    private ArrayList insertColumns = new ArrayList();

	
	public Database(Connection connection) {
		this.connection = connection;
	}
    
    public ResultSet getResult() {
    	return this.resultSet;
    }
    
    public Database select(String columns, String table) {
        this.sql = "SELECT "+columns+" FROM `" + table + "`";
        return this;
    }

    public Database where(String column, String operator, String value) {
        this.checkWhere();
        this.sql += " " + column + " "  + operator + " "  + value;
        return this;
    }

    public boolean get() {
        try {
        	this.resultSet = this.getStatement().executeQuery(sql);
            return true;
            
        } catch (Exception error) {
        	this.resultSet = null;
            this.error = error.toString();
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

    public Database addToInsert(String column, Object... params) {
        this.insertColumns.add(column);
        this.insertArgs.add(params[0]);
        
        return this;
    }

    public boolean insertInto(String table) {
        this.sql = "INSERT INTO " + table + "(";

        this.insertColumns.forEach((c) -> this.sql += c + ", ");

        this.sql = this.sql.substring(0, this.sql.length() - 2);

        this.sql += ") VALUES(";
        
        this.insertArgs.forEach((c) -> this.sql += "?, ");

        this.sql = this.sql.substring(0, this.sql.length() - 2);

        this.sql += ")";

        this.toSql();
        
        return true;
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

    private void checkWhere() {
        if (!this.sql.contains("WHERE")) {
            this.sql += " WHERE ";
        } else {
            this.sql += " AND ";
        }
    }
    
    private void toSql() {
        System.out.println(this.sql);
    }
	
}
