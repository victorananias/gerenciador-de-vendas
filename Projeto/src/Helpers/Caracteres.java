package Helpers;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author victor
 */
public class Caracteres {
    
    public static String converteDouble(double num){
        String resultado = String.format("%.2f", num);
        return resultado;
    }
    
    public static Double converterString(String num){
        String numero = num.replace(",",".");
        double convercao = Double.parseDouble(numero);
        return convercao;
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
