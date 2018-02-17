/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ItemVendaDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Models.ItemVenda;
import Models.Usuario;
import Models.Venda;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class VendasController {
    
    public void registrarVenda(Venda venda, ArrayList<ItemVenda> listaItens) {
        VendaDAO vendaDAO = new VendaDAO();
        vendaDAO.registrarVenda(venda);
        int idVenda = vendaDAO.getUltimoIdInserido();
        registrarItensVenda(listaItens, idVenda);
}
    
    public void registrarItensVenda(ArrayList<ItemVenda> listaItens, int idVenda) {
        System.out.println(idVenda);
        listaItens.stream().map((item) -> {
            item.setIdVenda(idVenda);
            return item;
        }).map((item) -> {
            new ItemVendaDAO().registrarItemVenda(item);
            return item;
        }).forEach((item) -> {
            new ProdutoDAO().diminuirQtdProduto(item.getIdProduto(), item.getQuantidade());
        });
    }
    
    public ArrayList<Venda> buscarVendasUsuario(Usuario usuario) {
        if(usuario.getTipo().equals("Admin")) {
            return new VendaDAO().buscarVendas();
        }
        else {
            return new VendaDAO().buscarVendasUsuario(usuario.getId());
        }
    }
    
    public ArrayList<ItemVenda> buscarItensVenda(int idVenda) {
        return new ItemVendaDAO().buscarItensVenda(idVenda);
    }
    
}
