package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.DB;

public class Usuario {

    private int id;
    private String login;
    private String nome;
    private String senha;
    private char tipo;
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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAdmin() {
        return this.getTipo() == 'A';
    }

    public ArrayList<Venda> getVendas() throws SQLException {
        ArrayList<Venda> vendas = new ArrayList<>();

        DB db  = new DB();

        String sql = "SELECT * FROM vendas WHERE usuario_id = ?";

        db.select(sql, this.getId());
        
        while (db.nextResult()) {
            vendas.add(Venda.make(db.result()));
        }

        db.closeConnection();
        
        return vendas;
    }

    public void delete() throws SQLException {
        DB db = new DB();

        String sql = "DELETE FROM usuarios WHERE id = ?";

        db.delete(sql, this.getId());
    }

    public void save() throws SQLException {
        if (this.getId() != 0) {
            this.update();
        } else {
            this.insert();
        }
    }

    private void update() throws SQLException {
        String sql = "UPDATE usuarios SET login = ?, nome = ?, cpf = ?, senha = ?, tipo = ? WHERE id = ?";

        DB db = new DB();

        db.update(sql, this.getLogin(), this.getNome(), this.getCpf(), this.getSenha(), this.getTipo(), this.getId());
    }

    private void insert() throws SQLException {
        String sql = "INSERT INTO usuarios(login, nome, cpf, senha, tipo) VALUES(?, ?, ?, ?, ?)";

        DB db = new DB();

        db.insert(sql, this.getLogin(), this.getNome(), this.getCpf(), this.getSenha(), this.getTipo());
    }
    
    public static ArrayList<Usuario> all() throws SQLException {
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        
        String sql = "SELECT * FROM usuarios";
        DB db = new DB();

        db.select(sql);
        
        while (db.nextResult()) {
            list.add(Usuario.make(db.result()));
        }

        db.closeConnection();
            
        return list;
    }

    public static Usuario make(ResultSet result) throws SQLException {
        Usuario usuario = new Usuario();
        
	    usuario.setId(result.getInt("id"));
	    usuario.setLogin(result.getString("login"));
	    usuario.setNome(result.getString("nome"));
	    usuario.setTipo(result.getString("tipo").toCharArray()[0]);
	    usuario.setSenha(result.getString("senha"));
	    usuario.setCpf(result.getString("cpf"));
	    
    	return usuario;
    }
    
}
