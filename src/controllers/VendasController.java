/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.ItemVendaDAO;
import models.ItemVenda;
import models.Produto;
import models.Usuario;
import models.Venda;
import services.AuthService;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class VendasController {

    public void registrarVenda(Venda venda) throws SQLException {
        venda.setUsuarioId(AuthService.getUser().getId());
        venda.save();
    }

    public void registrarItensVenda(ArrayList<ItemVenda> lista, int idVenda) {
        lista.forEach((item) -> {
            item.setVendaId(idVenda);
            
            try {
                Produto produto = new Produto();
                produto = item.getProduto();
                produto.setQuantidade(produto.getQuantidade() - item.getQuantidade());
                produto.save();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            new ItemVendaDAO().registrarItemVenda(item);

        });
    }

    public ArrayList<Venda> buscarVendasUsuario(Usuario usuario) throws SQLException {
        if (usuario.isAdmin()) {
            return Venda.all();
        } else {
            return usuario.getVendas();
        }
    }
    
    public ArrayList<ItemVenda> buscarItensVenda(int idVenda) {
        return new ItemVendaDAO().buscarItensVenda(idVenda);
    }
    
}
