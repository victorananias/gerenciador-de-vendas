package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexaoBanco {
    Connection conexao;
    Statement stmt;
    PreparedStatement prStmt;

    //Atributos estáticos com os dados do Banco de Dados
    private static final String URL = 
            "jdbc:mysql://localhost:3306/padaria?useSSL=true";
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
    
    ////////////////////////
    
//    Abre uma conexão com o banco de dados
    public void abrirConexao() {
        this.conexao = null;
        try {
            this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar: "+ erroSql);
        }
    }
    
    
    public ResultSet buscarSql(String tabela, String colunas, String argumentos) {
        try{
            String query = "SELECT "+colunas+" from "+tabela+" "+argumentos;
            this.prStmt = this.conexao.prepareStatement(query);
            ResultSet resultado = this.prStmt.executeQuery();
            return resultado;
        }
        catch(SQLException erroSql){
            JOptionPane.showMessageDialog(null, "Erro ao Consultar: "+ erroSql);
            return null;
        }
    }
    
    public void executarSql(String sql) {
        try{
            this.stmt = this.conexao.createStatement();
            this.stmt.executeUpdate(sql);
        }
        catch(SQLException erroSql){
            JOptionPane.showMessageDialog(null, "Erro ao Consultar: "+ erroSql);
        }
    }
    
    
    public void fecharConexao() {
        try {
            this.prStmt.close();
            this.conexao.close();
        } catch (SQLException erroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao Consultar: "+ erroSql);
        }
    }
    
}

