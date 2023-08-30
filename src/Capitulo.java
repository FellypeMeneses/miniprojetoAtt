import java.util.Scanner;
import java.util.ArrayList;
import java.util.Map;


class Capitulo {
    private String texto;
    protected ArrayList<Escolha> escolhas;
    private Personagem personagem1;
    private int variacaoEnergiapersonagem1;
    private Scanner escaneador = new Scanner(System.in);

    protected Capitulo() {
        this.texto = "";
        this.escolhas = new ArrayList<Escolha>();
    }

    public Capitulo(String texto, Personagem personagem1, int variacaoEnergiairmao1, Scanner escaneador) {
        this.texto = texto;
        this.personagem1 = personagem1;
        this.variacaoEnergiapersonagem1 = variacaoEnergiairmao1;
        this.escaneador = escaneador;
        this.escolhas = new ArrayList<Escolha>();  
    }
    public Capitulo(Map<String, Personagem> personagens, Scanner escaneadorconsole, Scanner escaneadorarquivos)  
    {    
        this.lerCapitulo(personagens, escaneadorarquivos);
        this.escaneador = escaneadorconsole;
        this.escolhas = new ArrayList<Escolha>();
      
    }
        protected void lerCapitulo(Map<String, Personagem> personagens, Scanner escaneadorarquivos) {
        
            escaneadorarquivos.nextLine();
            String idpersonagem1 = escaneadorarquivos.nextLine();
            this.personagem1 = personagens.get(idpersonagem1);
        
            escaneadorarquivos.nextLine();
            String linha = escaneadorarquivos.nextLine();
            this.texto = "";
            while (!linha.equals("VARIACOES")) {
        
              if (linha.equals(idpersonagem1)) {
                texto = texto + personagem1.getNome();
              } else {
                texto = texto + linha;
              }
              linha = escaneadorarquivos.nextLine();
        
            }
            this.variacaoEnergiapersonagem1= Integer.parseInt(escaneadorarquivos.nextLine());
    }
    public void adicionarEscolha(Escolha escolha) {
      escolhas.add(escolha);

    }
    protected void mostrar(){
        System.out.println(texto);
        personagem1.setEnergia(variacaoEnergiapersonagem1);
    
        for (int i = 0; i < escolhas.size(); i++) {
            System.out.println(" - " + escolhas.get(i).getTextoDigitado());
        }
    
        System.out.print("Escolha: ");
    }
    public void executar() {
        mostrar();
    
        if (escolhas.size() > 0) {
            int idCapituloEscolhido = escolher();
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            escolhas.get(idCapituloEscolhido).getProximo().executar();
        } else {
            System.out.println("FIM");
        }
    }
    

    public int escolher() {

    int opcaoEscolhida = 0;
    String escolha;
    boolean escolhaValida = false;

    while (!escolhaValida) {

      escolha = escaneador.nextLine();
      for (int i = 0; i < escolhas.size(); i++) {
        if (escolha.equalsIgnoreCase(escolhas.get(i).getTextoDigitado())) {
          escolhaValida = true;
          opcaoEscolhida = i;
        }
      }

      if (!escolhaValida) {

        System.out.println("Escolha inválida");
      }
    }

    return opcaoEscolhida;
  }

}