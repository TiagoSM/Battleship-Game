package frontend;

import backend.Boats;
import backend.Seas;
import backend.Colors;
import console.Console;
import console.Tecla;


public class Main {
    public static void main(String[] args){
        int rowCount = 0;
        int columnCount = 0;
        int rowAmount = 10;
        int columnAmount = 10;
        Colors string = new Colors("⚪");
        Boats boat = new Boats(string);
        Seas board = new Seas(rowAmount,columnAmount,boat);
        //do{ //loop game
            Console.println("MAIN MENU");
            Console.println("Click in ENTER to create a new game or click in S to load a saved game:");
            if(Console.getTecla() == Tecla.ENTER){ //New Game
                do{
               /*Enquanto está rodando deixar na  tela a opção de pausar com a tecla P, mostrando a tela de pause
                onde se o usuário digitar B ele volta para o jogo, se ele digitar ele S ele salva o jogo em outro arquivo, 
                se digitar M ele volta para o menu principal e se digitar ESC ele sai do jogo
                */
               Console.println("\tClick P to Pause");
               //Show the board, colocando os navios distintos em posições distintas
               Console.println(board);
               //Pedir uma jogada, se a jogada for inválida mostrar para o usuário e voltar o cursor para a posição 1
               Console.print("Use the ARROWS for select the position and the ENTER for attack!\t");
               Console.println("Attual position: (" + rowCount + ", " + columnCount + ").");
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
                       board.Attack(rowCount, columnCount);
                       break;
                       
                   default:
               
               }
               //board.Attack();
               /*Verificar se o jogo terminou
                 Mostre uma mensagem de vitória com quem que ganhou
                 volte para o menu principal com a tecla M
               //salvar o jogo
               */
               Console.limpaTela();
                }while(Console.getTecla() != Tecla.M); //quando o usuário quiser voltar para o menu principal
            } else{ //Saved Game
                
            }
            
        //}while(Console.getTecla() != Tecla.ESC); //quando o usuário clicar ESC ele sai do jogo
        Console.saiDoPrograma();
        
    }
}
