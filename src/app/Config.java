package app;

import java.sql.Connection;

public class Config {
    // public static final String DBNAME = "gerenciamento_vendas";
    // public static final String URL = "jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=true";
    // public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static final String DBNAME = System.getProperty("user.dir")+"/vendas-demo.db";
    public static final String URL = "jdbc:sqlite:" + DBNAME;
    public static final String DRIVER_CLASS = "org.sqlite.JDBC";
    public static final String USER = "";
    public static final String PASSWORD = "";

    public static Connection getConnection() {
        return new CustomConnection().getConnection();
    }
}
