
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
    

    
    public void adicionarSaida(String placa) throws IOException{
        ArrayList<String[]>listaCarros = Arquivo.ler(Principal.movimento);
            for (String[] carro : listaCarros) {  
            if(placa.equals(carro[0])){            
              //  System.out.println(carro[0]+carro[1]);   
                carro[1] += ";"+LocalDate.now()+" "+LocalTime.now();  
                System.out.println("Saiu :" + carro[0] + ";"+carro[1]);
                String texto = carro[0]+";" + carro[1];
                Arquivo.adicionar(texto, Principal.saida);
            //    System.out.println(carro[0]+carro[1]);
            }       
        }   
            Arquivo.salvarNovoDiretorio(listaCarros, placa);
    }
    
    public void movimento (String placa) throws IOException{
        String texto = "";
        if((!verifica(placa,Principal.movimento))){
            
            texto = placa+";"+LocalDate.now()+" "+LocalTime.now();          
            System.out.println("entrou: " + texto);
            Arquivo.adicionar(texto, Principal.movimento);
        
        } else if(verifica(placa, Principal.movimento)) {
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
