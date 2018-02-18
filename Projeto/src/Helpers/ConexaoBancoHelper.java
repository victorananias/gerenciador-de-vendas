package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoBancoHelper {
    Connection conexao;
    Statement stmt;
    PreparedStatement prStmt;

    //Atributos estáticos com os dados do Banco de Dados
    private static final String URL = 
            "jdbc:mysql://localhost:3306/gerenciamento_vendas?useSSL=true";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    
    public Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        try {
                Class.forName(DRIVER_CLASS);
                return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
        return null;
    }
}

