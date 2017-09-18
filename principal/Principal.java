package principal;

import Dados.Arquivo;
import Tela.*;
import java.io.IOException;
import java.text.ParseException;
import dominio.Timer;

/**
 *
 * @author John
 */
public class Principal {
  // public static String  caminhoPlanos = "E:\\Programacao\\Java\\Projetos\\TempoEstacionameto\\test\\carrosplanos.txt";
  // public static String movimento =  "C:\\Users\\aluno\\Desktop\\movimento.txt";
   public static String  caminhoPlanos = "carrosplanos.txt";
   public static String movimento =  "movimento.txt"; 
   public static void main(String[] args) throws IOException, ParseException {
       int opcao;
       Tela tela = new Tela();
       Timer timer = new Timer();
       if(!Arquivo.verificarDiretorio(movimento)){
           Arquivo.criarDiretorio(movimento);
       }
       if(!Arquivo.verificarDiretorio(caminhoPlanos)){
           Arquivo.criarDiretorio(caminhoPlanos);
       }
       
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
