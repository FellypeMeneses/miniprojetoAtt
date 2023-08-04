class Personagem {
    private String nome;
    private int energia;

    public Personagem(String nome, int energia) {
        this.nome = nome;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void mudarEnergia(int mudanca) {
        energia += mudanca;

        if (energia <= 0) {
            energia = 0;
            System.out.println(nome + " mudou sua energia para " + energia+", assim voce lesionou e perdeu alguns jogos");
        } else if (energia > 100) {
            energia = 100;
            System.out.println(nome + " mudou sua energia para " + energia+", ele esta muito confiante e segue jogando");
        } else {
            System.out.println(nome + ", sua energia é " + energia);
        }
    }
}
    
