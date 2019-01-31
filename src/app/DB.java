package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private int lastInsertedId;
    private Connection connection;
    private PreparedStatement pStmt;
    public ResultSet resultSet;
    private boolean closeConnection = true;

    public DB() {
        this.connection = Config.getConnection();
    }

    
    public void keepConnectionOpen() {
        this.closeConnection = false;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public int getLastInsertedId() {
        return lastInsertedId;
    }

    public void setLastInsertedId(int lastInsertedId) {
        this.lastInsertedId = lastInsertedId;
    }
    
    public void insert(String sql, Object... params) throws SQLException {
        pStmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        for (int i = 0; i < params.length; i++) {
            pStmt.setObject(i+1, params[i]);
        }
        
        pStmt.executeUpdate();
        
        this.resultSet = pStmt.getGeneratedKeys();
        
        if(this.nextResult()) {
            setLastInsertedId(this.resultSet.getInt(1));
        }
        
        if(this.closeConnection) {
            this.closeConnection();
        }
    }
    
    public void delete(String sql, Object... params) throws SQLException {
        this.update(sql, params);
    }
    
    public void update(String sql, Object... params) throws SQLException {
        pStmt = getConnection().prepareStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            pStmt.setObject(i+1, params[i]);
        }
        
        pStmt.executeUpdate();
        
        if(this.closeConnection) {
            this.closeConnection();
        }
    }

    public void select(String sql, Object... params) throws SQLException {
        this.pStmt = this.connection.prepareStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            this.pStmt.setObject(i+1, params[i]);
        }

        this.resultSet = this.pStmt.executeQuery();
    }

    public ResultSet result() {
        return this.resultSet;
    }

    public boolean nextResult() throws SQLException {
        return this.resultSet.next();
    }

    public void closeConnection() throws SQLException {
        if (this.pStmt != null) {
            System.out.println("PreparedStatement closed.");
            this.pStmt.close();
        }
        
        if (this.resultSet != null) {
            System.out.println("ResultSet closed.");
            this.resultSet.close();
        }
        
        if (this.connection != null) {
            System.out.println("Connection closed.");
            this.connection.close();
        }
    }
    
}
