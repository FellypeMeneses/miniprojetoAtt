import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Leitordearquivos {
    public Map<String, Personagem> Lerpersonagens(String caminho) {
        Map<String, Personagem> personagens = new HashMap<String, Personagem>();
    
        File arquivo = new File(caminho);
        try {
          Scanner escaneador = new Scanner(arquivo, "UTF-8");
    
          System.out.println("Carregando personagens...");
          int i = 0;
          while (escaneador.hasNextLine()) {
            i++;
            
            String nome = escaneador.nextLine();
            
            escaneador.nextLine();
            int energia = Integer.parseInt(escaneador.nextLine());
            
            escaneador.nextLine();

            System.out.println("Personagem " + i);
    
            personagens.put(nome, new Personagem(nome, energia));
    
          }
          escaneador.close();
    
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }
    
        return personagens;
    }
    

    public Map<String, Capitulo> Lercapitulos(String caminho, Map<String, Personagem> personagens,
                                               Scanner escaneadordoconsole) {

        Map<String, Capitulo> capitulos = new HashMap<String, Capitulo>();

        File arquivo = new File(caminho);
        try {
            Scanner escaneadordearquivo = new Scanner(arquivo, "UTF-8");

            System.out.println("Carregando Capítulos...");
            while (escaneadordearquivo.hasNextLine()) {
                String linha = escaneadordearquivo.nextLine();

                if (linha.equals("CAPITULO") || linha.equals("CAPITULO_COM_IMAGEM")) {
                    escaneadordearquivo.nextLine(); // Pular linha em branco
                    String id = escaneadordearquivo.nextLine();

                    if (linha.equals("CAPITULO")) {
                        capitulos.put(id, new Capitulo(personagens, escaneadordoconsole, escaneadordearquivo));
                    } else if (linha.equals("ESCOLHA")) {
                        Lerescolha(capitulos, escaneadordearquivo);
                    }

                    System.out.println("Capítulo " + id);
                } else if (linha.equals("ESCOLHA")) {
                    Lerescolha(capitulos, escaneadordearquivo);
                }
            }
            escaneadordearquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return capitulos;
    }

    private void Lerescolha(Map<String, Capitulo> capitulos, Scanner escaneadordearquivo) {
        escaneadordearquivo.nextLine(); // Pular linha em branco
        String idCapituloDe = escaneadordearquivo.nextLine();
        escaneadordearquivo.nextLine(); // Pular linha em branco
        String idCapituloPara = escaneadordearquivo.nextLine();
        escaneadordearquivo.nextLine(); // Pular linha em branco
        String textoDigitado = escaneadordearquivo.nextLine();
        escaneadordearquivo.nextLine(); // Pular linha em branco
        String textoMostrado = escaneadordearquivo.nextLine();

        capitulos.get(idCapituloDe)
                .adicionarescolha(new Escolha(textoDigitado, textoMostrado, capitulos.get(idCapituloPara)));
    }
}
