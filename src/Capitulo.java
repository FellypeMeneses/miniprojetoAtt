import java.util.Scanner;

class Capitulo {
    private String texto;
    protected ArrayList<Escolha> escolhas;
    private Personagem irmao1;
    private Personagem irmao2;
    private int energia;
    private Scanner scanner = new Scanner(System.in);

    public Capitulo(String texto, Personagem irmao1, Personagem irmao2, int energia) {
        this.texto = texto;
        this.irmao1 = irmao1;
        this.irmao2 = irmao2;
        this.energia = energia;
        this.escolhas = new ArrayList<Escolha>();
    }

    protected Capitulo() {
        this.texto = "";
        this.escolhas = new ArrayList<Escolha>();
    }

    public void setEscolhas(Escolha[] escolhas) {
        this.escolhas = escolhas;

    }

    void mostrar() {
        System.out.println(this.texto);
        if (escolhas != null) {
            System.out.println("As escolhas são: ");
            for (Escolha escolha : escolhas) {
                System.out.println(escolha.textodigitado());
            }
        }
    }

int escolher(){
int opcaoEscolhida=0;
String escolha;
boolean escolhaValida = true;
}while(!escolhaInvalida)

    {
 escolha=escaneador.nextline();
    for (int i=0,i < escolhas.size();i++)  {
                if (escolha.equalsIgnoreCase(escolhas.textodigitado)) {
                    escolhaInvalida = false;
                    Capitulo proximoCapitulo = escolha.getProximo();
                    proximoCapitulo.executar();
                    return;
                }
            }
            if (escolhaInvalida) {
                System.out.println("Digite uma resposta válida:");
            }
        }
    }

    public void executar() {
        mostrar();
        escolher();
    }
}
