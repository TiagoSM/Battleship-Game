package frontend;

import backend.Boats;
import backend.Seas;
import backend.Colors;
import console.Console;
import console.Tecla;
import static console.Tecla.ESC;


public class Main {
    public static void main(String[] args){
        byte flag = 0;
        int rowCount = 0;
        int columnCount = 0;
        int rowAmount = 10;
        int columnAmount = 10;
        Colors string = new Colors("⚪");
        Boats boat = new Boats(string);
        Seas board = new Seas(rowAmount,columnAmount,boat);
        do{
            Console.limpaTela();
            Console.println("MAIN MENU");
            Console.println("Click in ENTER to create a new game or click in S to load a saved game:");
            Tecla key = Console.getTecla();
            if(key == Tecla.ENTER){ //New Game
                do{
               //Enquanto está rodando deixar na  tela a tecla P para pausar
               Console.println("\tClick P to Pause");
               //Show the board, colocando os navios distintos em posições distintas
               Console.println(board);
               //Pedir uma jogada, se a jogada for inválida mostrar para o usuário e voltar o cursor para a posição 1
               Console.print("ARROWS: Move\t");
               Console.print("ENTER: Attack \t");
               Console.println(" Position:(" + rowCount + "," + columnCount + ")");
               switch(Console.getTecla()){
                   case UP:
                       System.out.println("Clicou UP");
                       if(rowCount == 0){
                           Console.println("You can't go to UP now!");
                       } else{
                           rowCount--;
                       }
                       break;
                   case DOWN:
                       System.out.println("Clicou DOWN");
                       if(rowCount == rowAmount){
                           Console.println("You can't go to DOWN now!");
                       } else{
                           rowCount++;
                       }
                       break;
                   case LEFT:
                       System.out.println("Clicou LEFT");
                       if(columnCount == 0){
                           Console.println("You can't go to LEFT now!");
                       } else{
                           columnCount--;
                       }
                       break;
                   case RIGHT:
                       System.out.println("Clicou RIGHT");
                       if(columnCount == columnAmount){
                           Console.println("You can't go to RIGHT now!");
                       } else{
                           columnCount++;
                       }
                       break;
                   case ENTER:
                       int boatRowCount = 0;
                       int boatColumnCount = 0;
                       if(rowCount == boatRowCount && columnCount == boatColumnCount){
                           board.SucesfullAttack(rowCount, columnCount);
                       } else{
                           board.MissedAttack(rowCount, columnCount);
                       }
                       break;
                   case P:
                       //método que abre o menu de pausa
                       /*opção de pausar com a tecla P mostrando a tela de pause
                onde se o usuário digitar B ele volta para o jogo, se ele digitar ele S ele salva o jogo em outro arquivo, 
                se digitar M ele volta para o menu principal e se digitar ESC ele sai do jogo
                */
                       Console.limpaTela();
                       Console.println("Choose a option: ");
                       Console.println("B: Continue");
                       Console.println("S: Save Game");
                       Console.println("M: Main Menu");
                       Console.println("ESC: Exit Game");
                       Tecla keyPause = Console.getTecla();
                       switch(keyPause){
                           case B:
                               flag = 0;
                               rowCount = 0;
                               columnCount = 0;
                               break;
                           case M:
                                flag = 1;
                                break;
                           case ESC:
                                Console.saiDoPrograma();
                                break;
                       }
                       break;
                   
                   default:
                        Console.println("Enter a valid input!");
                        rowCount = 0;
                        columnCount = 0;
               }
               /*Verificar se o jogo terminou
                 Mostre uma mensagem de vitória com quem que ganhou
                 volte para o menu principal com a tecla M
               //salvar o jogo
               */
                }while(flag != 1); //quando o usuário quiser voltar para o menu principal
            } else if(key == Tecla.P){ //Saved Game
                
            } else{
                Console.limpaTela();
                Console.println("Enter a valid key!");
            }
            
        }while(flag != 0); //faz o usuário voltar para o menu principal quando ele clicar em M
    }
}
