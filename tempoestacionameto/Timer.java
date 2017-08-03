
package tempoestacionameto;

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
    
    public void movimento (String placa) throws IOException{
        String texto = "";
        if(!verifica(placa,Principal.movimento)){
            
            texto = placa+";"+LocalDate.now()+" "+LocalTime.now();          
            System.out.println("entrou: " + texto);
            Arquivo.adicionar(texto, Principal.movimento);
        } else {
            System.out.println("saiu");
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
