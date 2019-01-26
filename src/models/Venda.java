package models;

public class Venda {
    
    private double valorTotal;
    private int id;
    private String created_at;
    private String login;
    private int quantidadeTotal;
    private int usuarioId;

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
    
}
