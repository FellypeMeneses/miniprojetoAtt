import java.util.Scanner;

class Capitulo {
    String texto;
    Escolha[] escolhas;
    Personagem irmao1;
    Personagem irmao2;
    int energia;
    Scanner scanner = new Scanner(System.in);

    public Capitulo(String texto, Personagem irmao1, Personagem irmao2, int energia) {
        this.texto = texto;
        this.irmao1 = irmao1;
        this.irmao2 = irmao2;
        this.energia = energia;
    }
public void setEscolhas(Escolha[] escolhas) {
   this.escolhas=escolhas;

}
    void mostrar() {
        System.out.println(this.texto);
        if (escolhas != null) {
            System.out.println("As escolhas são: ");
            for (Escolha escolha : escolhas) {
                System.out.println(escolha.getTexto());
            }
        }
    }

    public void escolher() {
        boolean escolhaInvalida = true;
        while (escolhaInvalida) {
            String resposta = scanner.nextLine();
            for (Escolha escolha : escolhas) {
                if (resposta.equalsIgnoreCase(escolha.getTexto())) {
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
