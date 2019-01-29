package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.DB;

public class Venda {

    private double valorTotal = 0;
    private int id;
    private String created_at;
    private String login;
    private int quantidadeTotal = 0;
    private int usuarioId;
    private ArrayList<ItemVenda> itens = new ArrayList<>();

    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @return the created_at
     */
    public String getCreatedAt() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(int quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getUsuarioId() {
        return this.usuarioId;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String nomeUsuaro) {
        this.login = nomeUsuaro;
    }

    public static Venda make(ResultSet resultSet) throws SQLException {
        Venda venda = new Venda();
        venda.setId(resultSet.getInt("id"));
        venda.setQuantidadeTotal(resultSet.getInt("quantidade_total"));
        venda.setValorTotal(resultSet.getInt("valor_total"));
        venda.setCreatedAt(resultSet.getString("created_at"));
        venda.setLogin(resultSet.getString("login"));
        return venda;
    }
    
    public static ArrayList<Venda> all() throws SQLException {
        ArrayList<Venda> vendas = new ArrayList<>();

        DB db = new DB();

        String sql = "SELECT v.*, "
                + " (SELECT login FROM usuarios AS u WHERE u.id = v.usuario_id LIMIT 1) AS login"
                + " FROM vendas AS v";

        db.select(sql);

        while (db.nextResult()) {
            vendas.add(Venda.make(db.result()));
        }

        db.closeConnection();

        return vendas;
    }
    
    public ArrayList<ItemVenda> getItens() throws SQLException {
        if (this.itens.size() > 0) {
            return this.itens;
        }
        
        this.itens = new ArrayList<>();

        DB db = new DB();

        String sql = "SELECT produto_id AS iv_produto_id, "
                    + "iv.id AS iv_id, "
                    + "venda_id AS iv_venda_id, "
                    + "iv.valor AS iv_valor, "
                    + "iv.quantidade AS iv_quantidade, "
                    + "p.nome, "
                    + "p.id, "
                    + "p.quantidade, "
                    + "p.valor, "
                    + "p.tipo "
                    + "FROM itens_venda AS iv "
                    + "JOIN produtos AS p ON p.id = iv.produto_id "
                    + "WHERE venda_id = ?";

        db.select(sql, this.getId());

        while (db.nextResult()) {
            this.itens.add(ItemVenda.make(db.result()));
        }

        db.closeConnection();

        return this.itens;
    }
    
    public void save() throws SQLException {
        if (this.getId() != 0) return;

        String sql = "INSERT INTO vendas(quantidade_total, valor_total, usuario_id)  VALUES(?,?,?)";

        DB db = new DB();
        
        db.insert(
            sql,
            this.getQuantidadeTotal(),
            this.getValorTotal(),
            this.getUsuarioId()
        );

        this.setId(db.getLastInsertedId());

        this.itens.forEach((item) -> {
            try {
                item.setVendaId(this.getId());
                item.save();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void addItem(int produtoId, int quantidade, double valor) {
        ItemVenda item = new ItemVenda();

        item.setProdutoId(produtoId);
        item.setQuantidade(quantidade);
        item.setValor(valor);

        this.itens.add(item);
        
        this.setQuantidadeTotal(this.getQuantidadeTotal() + quantidade);
        this.setValorTotal(this.getValorTotal() + valor);
    }
    
}
