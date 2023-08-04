import java.util.Scanner;

class Capitulo {
    String texto;
    String[] escolhas;
    Personagem irmao1;
    Personagem irmao2;
    int energia;
    Scanner scanner = new Scanner(System.in);

    public Capitulo(String texto, String[] escolhas, Personagem irmao1, Personagem irmao2, int energia) {
        this.texto = texto;
        this.escolhas = escolhas;
        this.irmao1 = irmao1;
        this.irmao2 = irmao2;
        this.energia = energia;
    }

    void mostrarCapitulo() {
        System.out.println(this.texto);
        if (escolhas != null) {
            System.out.println("As escolhas são:");
            for (String escolha : escolhas) {
                System.out.println(escolha);
            }
        }
    }

    int escolha() {
        int resultado = -1;
        boolean escolhaInvalida = true;

        while (escolhaInvalida) {
            String resposta = scanner.nextLine().toLowerCase();
            if (resposta.equals("a")) {
                resultado = 0;
                escolhaInvalida = false;
            } else if (resposta.equals("b")) {
                resultado = 1;
                escolhaInvalida = false;
            } else if (resposta.equals("c")) {
                resultado = 2;
                escolhaInvalida = false;
            } else {
                for (int i = 0; i < escolhas.length; i++) {
                    if (resposta.equals(escolhas[i].substring(0, 1).toLowerCase())) {
                        resultado = i;
                        escolhaInvalida = false;
                        break;
                    }
                }
            }

            if (escolhaInvalida) {
                System.out.println("Você não digitou uma opção válida, digite novamente:");
            }
        }

        return resultado;
    }
}
