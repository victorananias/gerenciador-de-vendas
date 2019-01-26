package models;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;

public class Usuario {

    private int id;
    private String login;
    private String nome;
    private String senha;
    private String tipo;
    private String cpf;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Venda> getVendas() throws SQLException {
        ArrayList<Venda> vendas = new ArrayList<>();

        DAO dao  = new DAO();

        String sql = "SELECT * FROM vendas WHERE usuario_id = ?";

        dao.select(sql, this.getId());
        
        while (dao.nextResult()) {
            vendas.add(Venda.make(dao.result()));
        }

        dao.closeConnection();
        
        return vendas;
    }
    
}
