package Models;

public class Venda {
    
    private double valorTotal;
    private int id;
    private String data;
    private String hora;
    private String nomeUsuaro;
    private int quantidadeTotal;
    private int idUsuario;
    
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

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public String getNomeUsuario() {
        return this.nomeUsuaro;
    }

    public void setNomeUsuario(String nomeUsuaro) {
        this.nomeUsuaro = nomeUsuaro;
    }
    
}
