import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Personagem irmao1 = new Personagem("", 100);
        System.out.println("Digite o nome do personagem:");
        String personagem1 = scanner.nextLine();
        irmao1.setNome(personagem1);
        irmao1.setEnergia(100);

        Personagem irmao2 = new Personagem("", 100);
        System.out.println("Digite o nome do segundo personagem:");
        String personagem2 = scanner.nextLine();
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

        String cap1P1 = "Surgiram duas propostas de agenciamento para " + personagem1 + " fez uma breve pesquisa sobre eles para poder gerir sua carreira\ne fazer as melhores escolhas para sua carreira";
        String cap2P1 = personagem1 + " evoluiu muito seu jogo e seu agente conseguiu propostas de tres grandes universidades:";
        String cap3P1 = personagem1 + " jogou muito pouco durante a primeira temporada mas evoluiu bem e parece ter sido a melhor escolha pois o time" +
                " tem  um otimo tecnico e que vai dar mais minutos durante as proximas temporada no time.(FINAL3)";
        String cap4P1 = personagem1 + " iniciou seu primeiro jogo com uma otima pontuação e conseguindo distribuir bem o jogo,mas seu treinador pediu para voce" +
                "descançar faltando um quarto e voltar no fim do jogo qual a sua decisão?";
        String cap5P1 = "Voce decidiu descansar assim seu treinador lhe colocou no fim do jogo e voce fez a bola do jogo(FINAL1)";
        String cap6P1 = "Voce decidiu continuar,o que te lesionou para o resto da temporada(FINAL2)";
        String cap7P1 = personagem1 + " jogou bem até o meio da temporada onde teve uma seria lesao o que afastou ele \ndas quadras e so " +
                "possibilitando dele voltar a jogar na proxima temporada do time.(FINAL4)";
        String cap8P1 = personagem1 + " nao evoluiu bem seu jogo e o seu agente nao conseguiu nenhuma proposta de nenhum time,\nisso te deixou bem triste e desmotivado" +
                "o tempo foi passando e voce nao consegiu mais essa oportunidade de jogar em uma universidade\n e isso acabou com sua carreira(FINAL1)";

        //Arrays de escolhas
        String[] escolhacap1P1 = new String[2];
        String textcap1esc1= "a) Hugo Mallis:Um agenciador que já conseguiu colocar varios jogadores na liga principal, \nmas parece ser um cara muito rigido e tem uma personalidade bem forte";
        escolhacap1P1[0]=textcap1esc1;        
        String textcap1esc2="b) John Sneider:ele agencia poucos jogadores,nenhum com muito destaque,mas consegue ajudar a \nconseguir evoluir jogadores novos, e é uma ótima pessoa de se lidar";
        escolhacap1P1[1]=textcap1esc2;
        
        String[] escolhacap2P1 = new String[3];
        String textcap2esc1="a)Alabama,Voce vai ser sexto homem e vai entrar apenas durante alguns momentos do jogo";
        escolhacap2P1[0]=textcap2esc1;      
        String textcap2esc2="b)Baylor;Voce vai ser a estrela time";
        escolhacap2P1[1]=textcap2esc2;                                       
        String textcap2esc3= "c)Duke;Voce vai ser bastante usado nos jogos mas ainda teria que buscar seu espaço no time";
        escolhacap2P1[2]=textcap2esc3;
        
        String[] escolhacap5e6P1 = new String[2];
        String textcap3esc1="a)Descançar";
        escolhacap5e6P1[0]=textcap3esc1;
        String textcap3esc2="b)Continuar jogando";
        escolhacap5e6P1[1]=textcap3esc2;

        //Chamada de capitulos 
        Capitulo capitulo1 = new Capitulo(cap1P1, escolhacap1P1, irmao1, irmao2, 100);
        Capitulo capitulo2 = new Capitulo(cap2P1, escolhacap2P1, irmao1, irmao2, 100);
        Capitulo capitulo3 = new Capitulo(cap3P1, null, irmao1, irmao2, 100);
        Capitulo capitulo4 = new Capitulo(cap4P1, escolhacap5e6P1, irmao1, irmao2, 100);
        Capitulo capitulo5 = new Capitulo(cap5P1, null, irmao1, irmao2, 110);
        Capitulo capitulo6 = new Capitulo(cap6P1, null, irmao1, irmao2, 50);
        Capitulo capitulo7 = new Capitulo(cap7P1, null, irmao1, irmao2, 100);
        Capitulo capitulo8 = new Capitulo(cap8P1, null, irmao1, irmao2, 100);
 
        //IFs e
        capitulo1.mostrarCapitulo();
       
        if (capitulo1.escolha() == 1) {
            capitulo2.mostrarCapitulo();
          
          
          if (capitulo2.escolha() == 1) {
            capitulo3.mostrarCapitulo();
              //Final 2
          
          if (capitulo2.escolha()== 1) {
                capitulo4.mostrarCapitulo();
                
            }else if (capitulo4.escolha() == 0){
                    capitulo5.mostrarCapitulo();
                    irmao1.mudarEnergia(+10);
             // FINAL 3
            }else if (capitulo4.escolha() == 1){
                    capitulo6.mostrarCapitulo();
                    irmao1.mudarEnergia(-50);
             // FINAL 4
                    
         }else if(capitulo2.escolha() == 0) 
            capitulo7.mostrarCapitulo();
            //Final 4

          
            }
        }else if (capitulo1.escolha()== 0) {
            capitulo8.mostrarCapitulo();
            ;
            // FINAL 1
        }
    }
}

