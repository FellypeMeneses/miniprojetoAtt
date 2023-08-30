import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Leitordearquivos leitor = new Leitordearquivos();
        Map<String, Personagem> personagens = leitor.lerPersonagens("rsc/Personagem.txt");
        Map<String, Capitulo> capitulos = leitor.lerCapitulos("rsc/Capitulo.txt", personagens, new Scanner(System.in));

        Capitulo raiz = capitulos.get("a");
        raiz.executar();




        
    }

    
}