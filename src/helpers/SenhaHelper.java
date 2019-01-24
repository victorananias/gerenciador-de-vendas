/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class SenhaHelper {
    
    public String criptografarSenha(String senhaDigitada) {
        String senha = "";
        
        try{
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte messageDigest[] = algorithm.digest(
                    senhaDigitada.getBytes("UTF-8"));
            
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            
            senha = hexString.toString();
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            JOptionPane.showMessageDialog(null, "Erro - "+e);
        }
        return senha;
    }
    
}
