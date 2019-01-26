package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Database {
	private Connection connection;
    public ResultSet resultSet = null;
    public String error = null;
    private String sql = "";
    private String where = "";
    private ArrayList<String> columnsToPrepare = new ArrayList();
    private ArrayList args = new ArrayList();
    private int lastId;
    private PreparedStatement pStmt;

	
	public Database(Connection connection) {
		this.connection = connection;
	}
    
    public ResultSet getResult() {
    	return this.resultSet;
    }
    
    public Database select(String columns, String table) {
        this.sql = "SELECT " + columns + " FROM " + table;
        return this;
    }

    public Database where(String column, String operator, int value) {

        this.checkWhere();

        this.args.add(value);
        
        this.where += " " + column + " "  + operator + " ? ";

        return this;
    }

    public boolean get() {
        try {
        	this.resultSet = this.getStatement().executeQuery(this.sql + this.where);
            return true;
            
        } catch (Exception error) {
        	this.resultSet = null;
            this.error = error.toString();
            return false;
        }
    }

    public Database addToInsert(String column, Object param) {
        this.columnsToPrepare.add(column);
        this.args.add(param);
        
        return this;
    }

    public void insertInto(String table) throws SQLException {
        this.prepareInsertSql(table);

        this.pStmt = this.connection.prepareStatement(this.sql, Statement.RETURN_GENERATED_KEYS);

        this.pStmt = this.mapParams(pStmt, this.args);

        pStmt.executeUpdate();

        this.resultSet = pStmt.getGeneratedKeys();

        this.lastId = this.next() ? this.getResult().getInt(1) : null;

        pStmt.close();
    }

    public void update(String table) throws SQLException {
        this.prepareUpdateSql(table);

        this.pStmt = this.connection.prepareStatement(this.sql);

        this.pStmt = this.mapParams(this.pStmt, this.args);
        
        pStmt.executeUpdate();
        
        pStmt.close();
    }

    public Database addToUpdate(String column, Object param) {
        this.columnsToPrepare.add(column);
        this.args.add(param);
        
        return this;
    }

    public Statement getStatement() {
		try {
            this.stmt = this.connection.createStatement();
		} catch (SQLException e) {
			this.error = e.toString();
		}
        return stmt;
    }
    
    public boolean next() {
        try {
            return this.resultSet.next();
            
        } catch (SQLException e) {
            this.error = e.toString();
            return false;
        }
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

    private void prepareInsertSql(String table) {
        String columns = String.join(", ", this.columnsToPrepare);
        
        String values = strRepeat("?, ", this.columnsToPrepare.size());
        values = values.substring(0, values.length() - 2);

        this.sql = "INSERT INTO " + table + "(" +columns + ") VALUES(" + values + ")";
    }

    private void prepareUpdateSql(String table) {
        String columns = String.join(" = ?, ", this.columnsToPrepare) + " = ? ";
        this.sql = "UPDATE " + table + " set " + columns + where;
    }

    private void checkWhere() {
        if (!this.where.contains("WHERE")) {
            this.where += " WHERE ";
        } else {
            this.where += " AND ";
        }
    }
    
    private PreparedStatement mapParams(PreparedStatement ps, ArrayList args) throws SQLException {
        int i = 1;
        
        for (Object arg : args) {         
            if (arg instanceof Date) {
                ps.setTimestamp(i++, new Timestamp(((Date) arg).getTime()));
            } else if (arg instanceof Integer) {
                ps.setInt(i++, (Integer) arg);
            } else if (arg instanceof Long) {
                ps.setLong(i++, (Long) arg);
            } else if (arg instanceof Double) {
                ps.setDouble(i++, (Double) arg);
            } else if (arg instanceof Float) {
                ps.setFloat(i++, (Float) arg);
            } else {
                ps.setString(i++, (String) arg);
            }
        }

        return ps;

    }
    

    public static String strRepeat(String str, int count) {
        return new String(new char[count]).replace("\0", str);
    }

    public void printSql() {
        System.out.println(this.sql);
        System.out.println("\nparams: \n");
        this.args.forEach(a -> System.out.println(a));
    }
}
