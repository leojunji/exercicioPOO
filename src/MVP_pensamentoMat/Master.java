package MVP_pensamentoMat;

import java.util.Scanner;

public class Master {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        boolean realista = false;
        boolean historias = false;
        boolean rpg = false;
        boolean terror = false;
        boolean fps = false;
        boolean mmo = false;
        boolean fps_tatico = false;
        int resposta;

        System.out.println("Qual jogo melhor se encaixa com seu perfil?");

        System.out.println("Voce da preferencia a jogos com graficos realistas? sim[1] nao[2]: ");
        resposta = input.nextInt();
        realista = resposta==1;

        System.out.println("Voce gosta de jogos com historias? sim[1] nao[2]: ");
        resposta = input.nextInt();
        historias = resposta==1;

        System.out.println("Voce gosta de RPG? sim[1] nao[2]: ");
        resposta = input.nextInt();
        rpg = resposta==1;

        System.out.println("Voce gosta de jogos de terror? sim[1] nao[2]");
        resposta = input.nextInt();
        terror = resposta==1;

        System.out.println("Voce gosta de jogos de fps? sim[1] nao[2]");
        resposta = input.nextInt();
        fps = resposta==1;

        System.out.println("Voce gosta de jogos de MMO? sim[1] nao[2]");
        resposta = input.nextInt();
        mmo = resposta==1;

        System.out.println("Jogos que você talvez goste de acordo com seu perfil:\n");


        if(fps) {
            System.out.println("FPS:");
            System.out.println("CS GO");
            System.out.println("\n");
        }

        if(terror) {
            System.out.println("Terror:");
            System.out.println("Dead by Daylight");
            System.out.println("Silent Hill\r\n"
                    + "Siren\r\n"
                    + "Fatal Frame");
            System.out.println("\n");
        }

        if(!historias) {
            System.out.println("Jogos sem historia:");
            System.out.println("Minecraft");
            System.out.println("Trove");
            System.out.println("\n");
        }

        if(mmo) {
            System.out.println("MMO:");
            System.out.println("World of Warcraft");
            System.out.println("Tibia");
            System.out.println("\n");
        }

        if(rpg) {
            System.out.println("Jogos de RPG:");
            System.out.println("Tibia");
            System.out.println("Final Fantasy\r\n"
                    + "Xenoblade Chronicles\r\n"
                    + "Dragon Quest\r\n"
                    + "Pokémon\r\n"
                    + "Dark Souls\r\n"
                    + "Persona\r\n"
                    + "The Elder Scrolls");
            System.out.println("\n");
        }

        if(realista) {
            System.out.println("Jogos Realistas:");
            System.out.println("The Last of Us\r\n"
                    + "Battlefield\r\n"
                    + "Uncharted");
            System.out.println("\n");
        }
        if(historias) {
            System.out.println("Jogos com Histórias:");
            System.out.println("The Legend of Zelda\r\n"
                    + "God of War\r\n"
                    + "Horizon: Zero Dawn\r\n");
            System.out.println("\n");
        }
    }
}
