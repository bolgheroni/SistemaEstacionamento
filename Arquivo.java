package Dados;

/**
 * Created by john on 25/06/2017.
 */
import dominio.Timer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Arquivo {
    
    
    public static boolean verificarDiretorio(String texto) throws IOException{
        try{
            ler(texto);
        }catch(FileNotFoundException ex){
            return false;
        }
        return true;
    }
    
    public static void criarDiretorio(String texto) {
      try {
          FileWriter arq = new FileWriter(texto);
          PrintWriter gravaArq = new PrintWriter(arq);
          gravaArq.print("");
          gravaArq.close();   
          
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static ArrayList <String[]> ler(String caminho) throws IOException {
        ArrayList <String[]> Estrutura = new ArrayList <> ();
        Scanner scanner = new Scanner(new File(caminho));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] linha;
            linha = line.split(";");
            Estrutura.add(linha);
        }
        return Estrutura;
    }
    //adiciona um texto formatado na forma de CSV ao arquivo no caminho indicado
    public static void adicionar(String texto,String caminho) throws IOException{
        texto+="\n";
        try {
            Files.write(Paths.get(caminho), texto.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void salvarNovoDiretorio(ArrayList<String[]> listaCarros, String placaSaiu) throws IOException {
        String texto = "";
        criarDiretorio("movimento.txt");
        for(String[] linha:listaCarros){
           // if(Timer.verificarSaida(linha[0])){
             //   texto+="\n"+linha[0] + linha[1] + linha[2];
            //}else{
                if(!linha[0].equals(placaSaiu)){
                    texto+=linha[0] +";"+ linha[1];
                    System.out.println(texto);
                    adicionar(texto, "movimento.txt");
                }
                //else{
                  //  texto+="";
                //}
            }
        }
    }
//}
    
    
