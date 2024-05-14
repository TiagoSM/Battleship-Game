package frontend;

import console.Console;
import mecanicas.Tabuleiro;
import mecanicas.Carta;
import cores.Cor;

public class Main {
    public static void main(String[] args){
        byte flag = 1;
        do{ //loop game
            System.out.println("MAIN MENU");
            Console.input("Enter 1 to create a new game or enter 2 to load a saved game:");
            do{
               /*Enquanto está rodando deixar na  tela a opção de pausar com a tecla Z, mostrando a tela de pause
                onde se o usuário digitar B ele volta para o jogo, se ele digitar ele S ele salva o jogo em outro arquivo, 
                se digitar M ele volta para o menu principal e se digitar ESC ele sai do jogo
                */
               //Show the board, colocando os navios em posições distintas
               //Pedir uma jogada, se a jogada for inválida mostrar para o usuário e voltar o cursor para a posição 1
               /*Verificar se o jogo terminou
                 Mostre uma mensagem de vitória com quem que ganhou
                 volte para o menu principal com a tecla M
               //salvar o jogo
               */
            }while(flag != 1); //quando o usuário 
        }while(flag != 1); //quando o usuário clicar ESC ele sai do jogo
    }
}
