package helpers;
import java.text.NumberFormat;

public class MascaraMonetaria {
    
    public static String add(Double numero){
        // Locale meuLocal = new Locale( "pt", "BR" );
        NumberFormat formato = NumberFormat.getCurrencyInstance();

        String saida = formato.format(numero);

        if (numero < 0) {
            saida = saida.replace("(","");
            saida = saida.replace(")","");
            saida = "-" + saida;
        }

        return saida;
    }
//
    public static double rm(String num){
        double valor = Double.parseDouble(num.replaceAll("[^\\d]", ""));
        valor = valor/100;
        return valor;
    }
}
