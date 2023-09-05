import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Capitulo {
    private String texto;
    private ArrayList<Escolha> escolhas;
    private Personagem personagem1;
    private int variacaoEnergiaPersonagem1;
    private Scanner escaneador;
    protected Capitulo() {
        this.texto = "";
        this.escolhas = new ArrayList<Escolha>();
    }
    public Capitulo(String texto, Personagem personagem1,int variacaoEnergiaPersonagem1, Scanner escaneador)  {
        this.texto=texto;
        this.personagem1=personagem1;
        this.variacaoEnergiaPersonagem1=variacaoEnergiaPersonagem1;
        this.escaneador=escaneador;
        this.escolhas=new ArrayList<Escolha>();
    }
    public Capitulo(Map<String, Personagem> personagens, Scanner escaneadordoconsole,Scanner escaneadordearquivo) 
    {
        this.LerCapitulo(personagens,escaneadordearquivo);
        this.escaneador=escaneadordoconsole;
        this.escolhas=new ArrayList<Escolha>();
    }
    protected void LerCapitulo(Map<String,Personagem> personagens, Scanner escaneadordearquivo){ 
        escaneadordearquivo.nextLine();
        String idPersonagem1 = escaneadordearquivo.nextLine();
        this.personagem1 = personagens.get(idPersonagem1);
        escaneadordearquivo.nextLine();
        String linha = escaneadordearquivo.nextLine();
        this.texto = "";
        while (!linha.equals("VARIACOESHabilidade")) {
            
            if (linha.equals(idPersonagem1)) {
                texto = texto + personagem1.getNome();
            } else {
                texto = texto + linha;
            }
            linha = escaneadordearquivo.nextLine();
        }
        this.variacaoEnergiaPersonagem1 = Integer.parseInt(escaneadordearquivo.nextLine());
    }
    public void adicionarescolha(Escolha escolha) {
        escolhas.add(escolha);
    }
    public void executar() {
        mostrar();
        if (escolhas.size() > 0) {
            int idcapituloescolhido = escolher();
            System.out.println();
            System.out.println("Ação sendo executada...");
            System.out.println();
            escolhas.get(idcapituloescolhido).getProximo().executar();
        } else {
            System.out.println("FIM");
        }
    }
    protected void mostrar() {
        System.out.println(texto);
        personagem1.setEnergia(variacaoEnergiaPersonagem1);

        for (int i = 0; i < escolhas.size(); i++) {
            System.out.println("- " + escolhas.get(i).getTextoMostrado());
        }
    }
    public int escolher() {
        int opcaoescolhida = 0;
        String escolha;
        boolean escolhavalida = false;
        while (!escolhavalida) {
        escolha = escaneador.nextLine();
        for (int i = 0; i < escolhas.size(); i++) {
            if (escolha.equalsIgnoreCase(escolhas.get(i).getTextoDigitado())) {
                escolhavalida = true;
                opcaoescolhida = i;
            }
        }
        if (!escolhavalida) {
            System.out.println("Essa escolha não é possivel");
        }
    }
    return opcaoescolhida;
  }
}