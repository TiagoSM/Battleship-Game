package frontend;

import backend.Boats;
import backend.Seas;
import backend.Colors;
import console.Console;
import console.Tecla;
import  mecanicas.Carta;
import cores.Cor;
import cores.StringColorida;

public class Main {
    public static void main(String[] args){
        byte flag = 1;
        String key = "";
        Colors string = new Colors("⚪");
        Boats boat = new Boats(string);
        Seas board = new Seas(10,10,boat);
        do{ //loop game
            Console.println("MAIN MENU");
            Console.input("Click in ENTER to create a new game or click in S to load a saved game:");
            Console.getTecla();
            //New Game
            if(Console.getTecla() == Tecla.ENTER){
                do{
               /*Enquanto está rodando deixar na  tela a opção de pausar com a tecla P, mostrando a tela de pause
                onde se o usuário digitar B ele volta para o jogo, se ele digitar ele S ele salva o jogo em outro arquivo, 
                se digitar M ele volta para o menu principal e se digitar ESC ele sai do jogo
                */
               Console.println("\tClick P to Pause");
               //Show the board, colocando os navios em posições distintas
               Console.println(board);
               //Pedir uma jogada, se a jogada for inválida mostrar para o usuário e voltar o cursor para a posição 1
               Console.println("Use the arrows for attack!");
               //switch(Console.getTecla()){
                   //COMO USAR ENUM NO SWITCH CASE PARA PODER ADICIONAR UM A CASA ATUAL ATÉ O JOGADOR ENFIM CLICAR NO ENTER
                   //case Tecla.ESC:
               board.Attack();
               //}
               
               /*Verificar se o jogo terminou
                 Mostre uma mensagem de vitória com quem que ganhou
                 volte para o menu principal com a tecla M
               //salvar o jogo
               */
               Console.limpaTela();
                }while(Console.getTecla() != Tecla.M); //quando o usuário 
            }
            
        }while(Console.getTecla() != Tecla.ESC); //quando o usuário clicar ESC ele sai do jogo
        Console.saiDoPrograma();
        
    }
}
