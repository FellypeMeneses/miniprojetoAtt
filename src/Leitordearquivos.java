import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leitordearquivos {

    public HashMap<String, Personagem> lerPersonagens(String caminho) {
        HashMap<String, Personagem> personagens = new HashMap<String, Personagem>();

        File arquivo = new File(caminho);

        try {
            Scanner escaneador = new Scanner(arquivo);
            System.out.println("Carregando Personagens...");
            int i = 0;
            while (escaneador.hasNextLine()) {
                String nome = escaneador.nextLine();

                int energia = Integer.parseInt(escaneador.nextLine());

                String leitura = escaneador.nextLine();
                System.out.println("Linha" + i + ": " + leitura);

                personagens.put(nome, new Personagem(nome, energia));
                i++;
            }
            escaneador.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return personagens;
    }

    public HashMap<String, Capitulo> lerCapitulos(String caminho, Map<String, Personagem> personagens,
            Scanner escaneadorconsole) {
        HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();

        File arquivo = new File(caminho);

        try {
            Scanner escaneadorarquivo = new Scanner(arquivo, "UTF-8");

            System.out.println("Carregando capitulos...");
            String linha = escaneadorarquivo.nextLine();
            while (escaneadorarquivo.hasNextLine()) {
                if (linha.equals("CAPITULO") || linha.equals("CAPITULO_COM_IMAGEM")) {
                    escaneadorarquivo.nextLine();
                    String id = escaneadorarquivo.nextLine();
                    if (linha.equals("CAPITULO")) {
                        capitulos.put(id, new Capitulo(personagens, escaneadorconsole, escaneadorarquivo));
                    } else if (linha.equals("ESCOLHA")) {
                        lerEscolha(capitulos, escaneadorarquivo);
                    }
                    escaneadorarquivo.nextLine();
                } else if (linha.equals("ESCOLHA")) {
                    lerEscolha(capitulos, escaneadorarquivo);
                }
                linha = escaneadorarquivo.nextLine();
            }
            escaneadorarquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return capitulos;
    }

    private static void lerEscolha(HashMap<String, Capitulo> capitulos, Scanner escaneadorarquivo) {
        escaneadorarquivo.nextLine();
        String idCapituloDe = escaneadorarquivo.nextLine();
        escaneadorarquivo.nextLine();
        String idCapituloPara = escaneadorarquivo.nextLine();
        escaneadorarquivo.nextLine();
        String textoDigitado = escaneadorarquivo.nextLine();
        escaneadorarquivo.nextLine();
        String textoMostrado = escaneadorarquivo.nextLine();

        capitulos.get(idCapituloDe)
                .adicionarEscolha(new Escolha(textoDigitado, textoMostrado, capitulos.get(idCapituloPara)));
    }
}
