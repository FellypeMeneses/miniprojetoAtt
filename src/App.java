import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scaneador = new Scanner(System.in);
        Personagem irmao1 = new Personagem("", 100);
        System.out.println("Digite o nome do personagem:");
        String personagem1 = scaneador.nextLine();
        irmao1.setNome(personagem1);
        irmao1.setEnergia(100);

        Personagem irmao2 = new Personagem("", 100);
        System.out.println("Digite o nome do segundo personagem:");
        String personagem2 = scaneador.nextLine();
        irmao2.setNome(personagem2);
        irmao2.setEnergia(100);

        // Introdução do jogo
        System.out.println("\nOla, essa é carreira de base de basquete de dois jogadores chamados " + personagem1 + " e seu irmão gemeo " + personagem2 +
                " Voces sao dois jovens de 17 e se mudaram para os estados unidos\n com um sonho de jogar na NBA, a maior liga de basquete do mundo" +
                " Essa jornada é cheia de escolhas que podem determinar como essas carreiras vao acontecer e todo seu futuro" +
                " Voces,precisam de um agente para iniciar sua carreira no college, que e a faculdade, onde basicamente com\ndestaque voces podem chegar na NBA" +
                "" + personagem1 + " e " + personagem2 + " tem uma personalidade bem diferente " + personagem1 + " é um cara mais explosivo e precisa de bastante motivação \npara lidar com as coisas e evoluior" +
                "já " + personagem1 + "- é um cara mais calmo e consegue se adaptar a ambientes onde ele se sinta mais confortável de lidar");

        //Capitulo 1-Escolha de agentes("+pesonagem1")

 Capitulo capitulo1 = new Capitulo("Surgiram duas propostas de agenciamento para " + personagem1 + " fez uma breve pesquisa sobre eles para poder gerir sua carreira\ne fazer as melhores escolhas para sua carreira"+
 "Hugo Mallis:Um agenciador que já conseguiu colocar varios jogadores na liga principal, \nmas parece ser um cara muito rigido e tem uma personalidade bem forte e John Sneider:ele agencia poucos jogadores,nenhum com muito destaque,mas consegue ajudar a \nconseguir evoluir jogadores novos, e é uma ótima pessoa de se",irmao1,irmao2,100);
        
 Capitulo capitulo2= new Capitulo(personagem1 + " evoluiu muito seu jogo e seu agente conseguiu propostas de tres grandes universidades,são elas:Alabama:Voce vai ser sexto homem e vai entrar apenas durante alguns momentos do jogo"+
 ",Baylor:Voce vai ser a estrela time,Duke:Voce vai ser bastante usado nos jogos mas ainda teria que buscar seu espaço no time",irmao1,irmao2,100);
        
 Capitulo capitulo3= new Capitulo (personagem1 + " jogou muito pouco durante a primeira temporada mas evoluiu bem e parece ter sido a melhor escolha pois o time" +
" tem  um otimo tecnico e que vai dar mais minutos durante as proximas temporada no time.(FINAL2)",irmao1,irmao2,100);
 Capitulo capitulo4= new Capitulo (personagem1 + " iniciou seu primeiro jogo com uma otima pontuação e conseguindo distribuir bem o jogo,mas seu treinador pediu para voce" +
"descançar faltando um quarto e voltar no fim do jogo qual a sua decisão?",irmao1,irmao2,100);     
            
Capitulo capitulo5= new Capitulo("Voce decidiu descansar assim seu treinador lhe colocou no fim do jogo e voce fez a bola do jogo(FINAL3)",irmao1,irmao2,110);
        
Capitulo capitulo6= new Capitulo("Voce decidiu continuar,o que te lesionou para o resto da temporada(FINAL4)",irmao1,irmao2,50);
        
Capitulo capitulo7= new Capitulo (personagem1 + " jogou bem até o meio da temporada onde teve uma seria lesao o que afastou ele \ndas quadras e so " +
"possibilitando dele voltar a jogar na proxima temporada do time.(FINAL5)",irmao1,irmao2,100);
        
Capitulo capitulo8= new Capitulo (personagem1 + " nao evoluiu bem seu jogo e o seu agente nao conseguiu nenhuma proposta de nenhum time,\nisso te deixou bem triste e desmotivado" +
"o tempo foi passando e voce nao consegiu mais essa oportunidade de jogar em uma universidade\n e isso acabou com sua carreira(FINAL1)",irmao1,irmao2,100);

           

        //Adicionando capitulos as escolhas
        Escolha[] cap1P1=new Escolha[2]; 
        cap1P1[0]=new Escolha("Hugo Mallis", capitulo2);
        cap1P1[1]=new Escolha("John Sneider",capitulo8);

        Escolha[] cap2P1=new Escolha[3];
        cap2P1[0]=new Escolha("Alabama",capitulo3);
        cap2P1[1]=new Escolha("Baylor",capitulo4);
        cap2P1[2]=new Escolha("Duke",capitulo7);
        capitulo2.setEscolhas(cap2P1);

        Escolha[] cap4P1=new Escolha[2];
        cap4P1[0]=new Escolha("Descançar",capitulo5);
        cap4P1[1]=new Escolha("Continuar jogando",capitulo6);     
        capitulo4.setEscolhas(cap4P1);
        Escolha[] capFinal = new Escolha[0];

        capitulo1.setEscolhas(cap1P1);
        capitulo2.setEscolhas(cap2P1);
        capitulo4.setEscolhas(cap4P1);
        
        Capitulo raiz = capitulo1;
        raiz.executar();
        scaneador.close();
        }

        
    
}

