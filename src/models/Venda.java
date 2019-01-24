package models;

public class Venda {
    
    private double valorTotal;
    private int id;
    private String data;
    private String hora;
    private String login;
    private int quantidadeTotal;
    private int usuarioId;
    
    public double getValorTotal() {
        return valorTotal;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
