package Helpers;

import java.text.NumberFormat;


public class MascaraMonetaria {
//public class MascaraMonetaria implements TextWatcher {
//    final EditText campo;
//    private boolean isUpdating = false;
//    // Pega a formatacao do sistema, se for brasil R$
//    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
//
//    public MascaraMonetaria(EditText campo) {
//        super();
//        this.campo = campo;
//    }
//
//
//    @Override
//    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        // Evita que o método seja executado varias vezes.
//        // Se tirar ele entre em loop
//        if(isUpdating) {
//            isUpdating = false;
//            return;
//        }
//
//        isUpdating = true;
//        String str = charSequence.toString();
//
////        Se houver máscara será removida
//        str = str.replaceAll("[^\\d]", "");
//
//        try {
////            Convertendo o número para formato monetário
//            str = numberFormat.format(Double.parseDouble(str) /100);
//            campo.setText(str);
//            campo.setSelection(campo.getText().length());
//        }
//        catch (NumberFormatException erro) {
//            charSequence = "";
//        }
//    }
//
//    @Override
//    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//        //
//    }
//
//    @Override
//    public void afterTextChanged(Editable editable) {
//        //
//    }
}
