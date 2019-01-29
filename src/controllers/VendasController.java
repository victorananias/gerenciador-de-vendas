/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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

    public ArrayList<Venda> buscarVendasUsuario(Usuario usuario) throws SQLException {
        if (usuario.isAdmin()) {
            return Venda.all();
        } else {
            return usuario.getVendas();
        }
    }
    
}
