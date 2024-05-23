package frontend;
// Testar tabuleiro de seleções e corrigir erros de }
import backend.Boats;
import backend.Seas;
import backend.Colors;
import console.Console;
import console.Tecla;

public class Main {
    public static void main(String[] args){
        byte flag = 0;
        int i = 0;
        byte rowCount = 0;
        byte columnCount = 0;
        byte rowAmount = 10;
        byte columnAmount = 10;
        byte rowValuePlayer = 2;
        byte columnValuePlayer = 10;
        Tecla key;
        int amountBoard0 [] [] = new int[2] [30];
        int amountPlayer1 [] [] = new int[rowValuePlayer][columnValuePlayer];
        Colors string = new Colors("⚪");
        Boats part = new Boats(string);
        // Adicionar a uma array bidimensional as posições para salvar os valores e economizar linhas
        amountBoard0[0][] = {0, 0, 7, 7, 5, 6, 3, 3};
        
        Seas boardShip0 = new Seas(rowAmount,columnAmount,part);
        //Submarine                        }
            boardShip0.Boat(0, 0);
            boardShip0.Boat(0, 1);
                            
            boardShip0.Boat(7, 0);
            boardShip0.Boat(7, 1);
                            
            boardShip0.Boat(5, 5);
            boardShip0.Boat(6, 5);
                            
            boardShip0.Boat(2, 9);
            boardShip0.Boat(3, 9);
                            
        //destroyers
            boardShip0.Boat(0, 3);
            boardShip0.Boat(1, 3);
            boardShip0.Boat(2, 3);
                            
            boardShip0.Boat(2, 5);
            boardShip0.Boat(2, 6);
            boardShip0.Boat(2, 7);
                            
            boardShip0.Boat(5, 9);
            boardShip0.Boat(6, 9);
            boardShip0.Boat(7, 9);
                            
        //tankers
            boardShip0.Boat(2, 0);
            boardShip0.Boat(3, 0);
            boardShip0.Boat(4, 0);
            boardShip0.Boat(5, 0);
                            
            boardShip0.Boat(0, 6);
            boardShip0.Boat(0, 7);
            boardShip0.Boat(0, 8);
            boardShip0.Boat(0, 9);
                            
        //Aircraft Carrier
            boardShip0.Boat(9, 5);
            boardShip0.Boat(9, 6);
            boardShip0.Boat(9, 7);
            boardShip0.Boat(9, 8);
            boardShip0.Boat(9, 9);
        
        Seas boardShip1 = new Seas(rowAmount,columnAmount,part);
        Seas boardShip3 = new Seas(rowAmount,columnAmount,part);
        Seas boardPlayer1 = new Seas(rowAmount, columnAmount, part);
        
        do{
            Console.println("MAIN MENU");
            Console.println("Click in ENTER to create a new game or click in S to load a saved game:");
            key = Console.getTecla();
            if(key == Tecla.ENTER){ //New Game
                do{
                    //check
                    do{
                        Console.println("Player 1 are you ready to choose your ship board?");
                        Console.println("Click ENTER to continue:");
                        key = Console.getTecla();
                    } while(key != Tecla.ENTER);
                    
                    //check
                    do{
                        if(columnCount == 0){
                            
                            
                            Console.println(boardShip0);
                        }
                        switch(Console.getTecla()){
                            case LEFT:
                                if(columnCount == 0){
                                    Console.println("You can't go to LEFT now!");
                                } else{
                                    columnCount--;
                                }
                                break;
                            case RIGHT:
                                if(columnCount == columnAmount){
                                    Console.println("You can't go to RIGHT now!");
                                } else{
                                    columnCount++;
                                }
                                break;
                            case ENTER:
                                //condição de q quando o usuário escolher um número que já foi escolhido ele bloqueia; vou ter que usar um alg de busca de array para percorrer e comparar todo o vetor
                                flag = 2;
                                /*if(rowCo){
                                    amountPlayer1 [1][i] = rowCount;
                                    amountPlayer1 [2][i] = columnCount;
                                    i++;
                                */
                                break;
                        }
                    }while(key != Tecla.ENTER);
                }while(flag != 9);
          
                do{
                    Console.limpaTela();
                    //Enquanto está rodando deixar na  tela a tecla P para pausar
                    Console.println("\tClick P to Pause");
                    //Show the board, colocando os navios distintos em posições distintas
                    
                    Console.print(boardPlayer1);
                    //Pedir uma jogada, se a jogada for inválida mostrar para o usuário e voltar o cursor para a posição 1
                    Console.print("ARROWS: Move\t");
                    Console.print("ENTER: Attack \t");
                    Console.println(" Position:(" + rowCount + "," + columnCount + ")");
                    switch(Console.getTecla()){
                        case UP:
                            if(rowCount == 0){
                                Console.println("You can't go to UP now!");
                            } else{
                                rowCount--;
                            }
                            break;
                        case DOWN:
                            if(rowCount == rowAmount){
                                Console.println("You can't go to DOWN now!");
                            } else{
                                rowCount++;
                            }
                            break;
                        case LEFT:
                            if(columnCount == 0){
                                Console.println("You can't go to LEFT now!");
                            } else{
                                columnCount--;
                            }
                            break;
                        case RIGHT:
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
                                //board.SucesfullAttack(rowCount, columnCount);
                            } else{
                                //board.MissedAttack(rowCount, columnCount);
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
                                case P:
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
            
            } else{
                    
                    }
        }while(flag != 0); //faz o usuário voltar para o menu principal quando ele clicar em M
        }
}