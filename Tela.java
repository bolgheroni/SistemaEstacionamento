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
import javax.swing.ImageIcon;
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
        if(placa.getText().matches("[\\a-zA-Z]{3}-[0-9]{4}")) {
            status = placa.getText();
        return status;
        }
        else {
            JOptionPane.showMessageDialog(null, "\\_(ツ)_/ ERROOOOOOOOU","Fez caquinha", JOptionPane.PLAIN_MESSAGE);
            return null;
        }
    }
    
   
    
    public void recibos() throws IOException{
        String texto = "";
        ArrayList<String[]> recibos;
        recibos = Arquivo.ler(Principal.movimento);
        ArrayList<String[]>recibosSaida;
        recibosSaida = Arquivo.ler(Principal.saida);
        for(String[]reciboSaida:recibosSaida){
            String[] nice1;
            nice1 = reciboSaida[1].split(" ");
            String[]nice2;
            nice2 = reciboSaida[2].split(" ");
            texto+= "Placa :"+reciboSaida[0]+"\n"+"Entrada: "+ nice1[0].substring(0, 5) +" as " +nice1[1].substring(0, 5)+"\n"+"Saida : "+nice2[0].substring(0, 5) +
                        " as " + nice2[1].substring(0, 5) +"\n_____________________\n";
        }
        
        for (String[] recibo : recibos) {
            System.out.println(recibo.length);
            String[] nice;
            nice = recibo[1].split(" ");
            for(String s : nice) {
                System.out.println(s);
            }
            texto += "Placa :"+recibo[0]+"\n"+"Entrada: "+ nice[0].substring(0, 5) +" as " +nice[1].substring(0, 5)+"\n"+"_____________________\n";
        }
        JOptionPane.showMessageDialog(null, texto, "Recibos", PLAIN_MESSAGE);
    }
}
