/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Dados.Arquivo;
import dominio.Timer;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;
import javax.swing.text.MaskFormatter;
import principal.Principal;

/**
 *
 * @author John
 */
public class Tela {
    
    public int menuPrincipal () {

       return JOptionPane.showOptionDialog(null, 
                "",
                "Sistema estacionamento",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                
                
                new String[]{"Movimento", "Recibos","Sair"},
                "default");
   }
    public String movimento() throws ParseException{
        MaskFormatter mascaraPlaca = new MaskFormatter("UUU-####");
        String status;
        JFormattedTextField placa = new JFormattedTextField(mascaraPlaca);
        Object[] a = {"Placa",placa};
        JOptionPane.showConfirmDialog(null,  a, "Movimento", JOptionPane.OK_CANCEL_OPTION);
        status = placa.getText();
        return status;
        
    }
    
    public void recibos() throws IOException{
        String texto = "";
        ArrayList<String[]> recibos;
        recibos = Arquivo.ler(Principal.movimento);
        for (String[] recibo : recibos) {
            String[] nice;
            nice = recibo[1].split(" ");
            if(Timer.verificarSaida(recibo[0])){
                String nice2[] = recibo[2].split(" ");
                texto+= "Placa :"+recibo[0]+"\n"+"Entrada: "+ nice[0] +" as " +nice[1]+"\n"+"Saida : "+nice2[0] +
                        " as " + nice2[1] +"\n_____________________\n"; 
            }
            texto += "Placa :"+recibo[0]+"\n"+"Entrada: "+ nice[0] +" as " +nice[1]+"\n"+"_____________________\n";
        }
        JOptionPane.showMessageDialog(null, texto, "Recibos", PLAIN_MESSAGE);
    }
}
