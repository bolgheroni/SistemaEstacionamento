
package dominio;

import Dados.Arquivo;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import principal.Principal;



/**
 *
 * @author John
 */
public class Timer {

    public static boolean verificarSaida(String texto) throws IOException {
        try{
            ArrayList<String[]> recibos;
            recibos = Arquivo.ler(Principal.movimento);
            for (String[] recibo : recibos) {
                if(recibo[0].equals(texto)){
                    String nice;
                    nice = recibo[2];
                    
                }
            }
        }catch(ArrayIndexOutOfBoundsException ex){
            return false;
        }
        return true;
    }
    
    public void adicionarSaida(String placa) throws IOException{
        ArrayList<String[]>listaCarros = Arquivo.ler(Principal.movimento);
            for (String[] carro : listaCarros) {  
            if(placa.equals(carro[0])){            
              //  System.out.println(carro[0]+carro[1]);   
                carro[1] += ";"+LocalDate.now()+" "+LocalTime.now();  
            //    System.out.println(carro[0]+carro[1]);
                System.out.println("Saiu :" + carro[0] + ";"+carro[1]);
            }       
        }   
            Arquivo.salvarNovoDiretorio(listaCarros);
    }
    
    public void movimento (String placa) throws IOException{
        String texto = "";
        if((!verifica(placa,Principal.movimento))||(verifica(placa,Principal.movimento)&&verificarSaida(placa))){
            
            texto = placa+";"+LocalDate.now()+" "+LocalTime.now();          
            System.out.println("entrou: " + texto);
            Arquivo.adicionar(texto, Principal.movimento);
        
        } else if(verifica(placa, Principal.movimento)&&!verificarSaida(placa)) {
            adicionarSaida(placa);
        }
    }
    public static boolean verifica(String placa,String caminho) throws IOException{
      
       ArrayList<String[]> listaCarros;
       listaCarros = Arquivo.ler(caminho);
       for (String[] carro : listaCarros) {  
           if(placa.equals(carro[0])){            
               return true;
           }       
        }          
       return false;
    }
}
