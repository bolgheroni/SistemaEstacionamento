package principal;

import Tela.*;
import java.io.IOException;
import java.text.ParseException;
import dominio.Timer;

/**
 *
 * @author John
 */
public class Principal {
   public static String  caminhoPlanos = "E:\\Programacao\\Java\\Projetos\\TempoEstacionameto\\test\\carrosplanos.txt";
   public static String movimento =  "C:\\Users\\aluno\\Desktop\\movimento.txt";
   
   public static void main(String[] args) throws IOException, ParseException {
       int opcao;
       Tela tela = new Tela();
       Timer timer = new Timer();
       
       do{
            opcao = tela.menuPrincipal();
            
            if (opcao == 0){    //movimento
                String placa = tela.movimento();
                timer.movimento(placa);
            }
        
            if (opcao == 1){ //recibos
               
                tela.recibos();
            }
       
       
       
       }while(!(opcao == 2));
        
    }
}
