package helpers;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Senha {

    public static String encrypt(String senhaDigitada) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String senha = "";
        
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(
                senhaDigitada.getBytes("UTF-8"));
        
        StringBuilder hexString = new StringBuilder();

        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        
        senha = hexString.toString();

        return senha;
    }
    
}
