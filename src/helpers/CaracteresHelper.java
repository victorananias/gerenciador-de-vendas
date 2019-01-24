package helpers;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author victor
 */
public class CaracteresHelper {
    
    public static String addMascaraMonetaria(Double numero){
//        Locale meuLocal = new Locale( "pt", "BR" );
        NumberFormat formato = NumberFormat.getCurrencyInstance();

        String saida = formato.format(numero);

        if(numero < 0) {
            saida = saida.replace("(","");
            saida = saida.replace(")","");
            saida = "-" + saida;
        }

        return saida;
    }
//
    public static double rmMascaraMonetaria(String num){
        double valor = Double.parseDouble(num.replaceAll("[^\\d]", ""));
        valor = valor/100;
        return valor;
    }
    
    public static String formatarData(String dat) throws Exception { 
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data;
        data = formato.parse(dat);
        formato.applyPattern("dd/MM/yyyy");
        String dataFormatada = formato.format(data);
        
        return dataFormatada;
    }
}
