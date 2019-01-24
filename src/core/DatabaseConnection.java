package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    Connection conexao;
    Statement stmt;
    PreparedStatement prStmt;

    //Atributos estáticos com os dados do Banco de Dados
    private static final String DATABASE = "gerenciamento_vendas";
    private static final String HOST = "jdbc:mysql://localhost:3306";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "victor";
    private static final String SENHA = "victor";
    
    
    public Connection getConnection() {
        try {
            String url = HOST + "/" + DATABASE + "?useSSL=true";
            System.out.println("Conectando ao Banco de Dados");
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(url, USUARIO, SENHA);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

