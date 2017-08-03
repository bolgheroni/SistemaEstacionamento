package Dados;

/**
 * Created by john on 25/06/2017.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class Arquivo {
    
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
}
