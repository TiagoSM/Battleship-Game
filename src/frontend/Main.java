package frontend;
// Mudar condição do loop para que termine assim que for escolhido o tabuleiro
// Finalizado a parte de escolha do Player 1
// Boaed Player 2 funciona
import backend.Boats;
import backend.Seas;
import backend.Colors;
import console.Console;
import console.Tecla;
import static console.Tecla.ENTER;
import static console.Tecla.LEFT;
import static console.Tecla.RIGHT;
import java.time.Clock;

public class Main {
    public static void main(String[] args){
        byte flag = 0;
        int i = 0;
        byte rowCountPlayer1 = 0;
        byte columnCountPlayer1 = 0;
        byte rowCountPlayer2 = 0;
        byte columnCountPlayer2 = 0;
        byte rowAmount = 10;
        byte columnAmount = 10;
        Tecla key;
        Colors string = new Colors("⚪");
        Boats part = new Boats(string);
   
        
        //BOARD 1
        int amountBoard0 [] [] = new int[2][];
        amountBoard0[0] = new int[]{/*Submarine*/0, 0, 7, 7, 5, 6, 2, 3, /*Destroyers*/0, 1, 2, 2, 2, 2, 5, 6, 7, /*Tankers*/2, 3, 4, 5, 0, 0, 0, 0, /*Aircraft Carrier*/9, 9, 9, 9, 9};
        amountBoard0[1] = new int[]{/*Submarine*/0, 1, 0, 1, 5, 5, 9, 9, /*Destroyers*/3, 3, 3, 5, 6, 7, 9, 9, 9, /*Tankers*/0, 0, 0, 0, 6, 7, 8, 9, /*Aircraft Carrier*/5, 6, 7, 8, 9};
        Seas boardShip0 = new Seas(rowAmount,columnAmount,part);
        //Submarine
        int quantityPositionSubmarine0 = 8;
        for(i = 0; i < quantityPositionSubmarine0; i++){
            boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
        }            
        //Destroyers
        int quantityPositionDestroyers0 = 9 + quantityPositionSubmarine0;
        for(i = 8; i < quantityPositionDestroyers0; i++){
            boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
        }           
        //Tankers
        int quantityPositionTankers0 = 8 + quantityPositionDestroyers0;
        for(i = 8; i < quantityPositionTankers0; i++){
            boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
        }                 
        //Aircraft Carrier
        int quantityPositionAircraftCarrier0 = 5 + quantityPositionTankers0;
        for(i = 8; i < quantityPositionAircraftCarrier0; i++){
            boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
        } 

        
        //BOARD 2
        Seas boardShip1 = new Seas(rowAmount,columnAmount,part);
        int amountBoard1[][] = new int[2][];
        amountBoard1[0] = new int[]{/*Submarine*/0, 0, 0, 0, 9, 9, 3, 4, /*Destroyers*/0, 0, 0, 7, 8, 9, 7, 8, 9, /*Tankers*/6, 6, 6, 6, 4, 4, 4, 4, /*Aircraft Carrier*/2, 2, 2, 2, 2};
        amountBoard1[1] = new int[]{/*Submarine*/0, 1, 8, 9, 3, 4, 0, 0, /*Destroyers*/4, 5, 6, 0, 0, 0, 8, 8, 8, /*Tankers*/3, 4, 5, 6, 6, 7, 8, 9, /*Aircraft Carrier*/3, 4, 5, 6, 7};
        //Submarine
        int quantityPositionSubmarine1 = 8;
        for(i = 0; i < quantityPositionSubmarine1; i++){
            boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
        }            
        //Destroyers
        int quantityPositionDestroyers1 = 9 + quantityPositionSubmarine1;
        for(i = 8; i < quantityPositionDestroyers1; i++){
            boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
        }           
        //Tankers
        int quantityPositionTankers1 = 8 + quantityPositionDestroyers1;
        for(i = 8; i < quantityPositionTankers1; i++){
            boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
        }                 
        //Aircraft Carrier
        int quantityPositionAircraftCarrier1 = 5 + quantityPositionTankers1;
        for(i = 8; i < quantityPositionAircraftCarrier1; i++){
            boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
        }
    
        Seas boardPlayer1 = new Seas(rowAmount, columnAmount, part);
        Seas boardPlayer2 = new Seas(rowAmount, columnAmount, part);
        
        do{
            Console.println("MAIN MENU");
            Console.println("Click in ENTER to create a new game or click in S to load a saved game:");
            key = Console.getTecla();
            if(key == Tecla.ENTER){ //New Game
                //Choose Board Player1
                do{

                    do{
                        Console.println("Player 1 are you ready to choose your ship board?");
                        Console.println("Click ENTER to continue:");
                        key = Console.getTecla();
                    } while(key != Tecla.ENTER);
                    
                    do{
                        if(columnCountPlayer1 == 0){
                            Console.println("Board 1");
                            Console.println(boardShip0);
                        } else if(columnCountPlayer1 == 1){
                            Console.println("Board 2");
                            Console.println(boardShip1);
                        }
                        switch(Console.getTecla()){
                            case LEFT:
                                if(columnCountPlayer1 == 0){
                                    do{
                                        Console.println("You can't go to LEFT now!");
                                        Console.println("Click ENTER to continue");
                                    }while(Console.getTecla() != Tecla.ENTER);
                                } else{
                                    columnCountPlayer1--;
                                }
                                break;
                            case RIGHT:
                                if(columnCountPlayer1 == 1){
                                    do{
                                        Console.println("You can't go to RIGHT now!");
                                        Console.println("Click ENTER to continue");
                                    }while(Console.getTecla() != Tecla.ENTER);
                                } else{
                                    columnCountPlayer1++;
                                }
                                break;
                            case ENTER:
                                if(columnCountPlayer1 == 0){
                                    boardPlayer1 = boardShip0;
                                } else if(columnCountPlayer1 == 1){
                                    boardPlayer1 = boardShip1;
                                }
                                break;
                        }
                    }while(key != Tecla.ESC);
                }while(flag != 9); //Mudar condição para poder sair do loop infinito
          
                do{ //Choose Board Player 2

                    do{
                        Console.println("Player 2 are you ready to choose your ship board?");
                        Console.println("Click ENTER to continue:");
                        key = Console.getTecla();
                    } while(key != Tecla.ENTER);
                    

                    do{
                        if(columnCountPlayer2 == 0){
                            Console.println("Board 1");
                            Console.println(boardShip0);
                        } else if(columnCountPlayer2 == 1){
                            Console.println("Board 2");
                            Console.println(boardShip1);
                        }
                        switch(Console.getTecla()){
                            case LEFT:
                                if(columnCountPlayer2 == 0){
                                    do{
                                        Console.println("You can't go to LEFT now!");
                                        Console.println("Click ENTER to continue");
                                    }while(Console.getTecla() != Tecla.ENTER);
                                } else{
                                    columnCountPlayer2--;
                                }
                                break;
                            case RIGHT:
                                if(columnCountPlayer2 == 1){
                                    do{
                                        Console.println("You can't go to RIGHT now!");
                                        Console.println("Click ENTER to continue");
                                    }while(Console.getTecla() != Tecla.ENTER);
                                } else{
                                    columnCountPlayer2++;
                                }
                                break;
                            case ENTER:
                                if(columnCountPlayer2 == 0){
                                    boardPlayer2 = boardShip0;
                                } else if(columnCountPlayer2 == 1){
                                    boardPlayer2 = boardShip1;
                                }
                                break;
                        }
                    }while(key != Tecla.ESC);
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
                    Console.println(" Position:(" + rowCountPlayer1 + "," + columnCountPlayer1 + ")");
                    switch(Console.getTecla()){
                        case UP:
                            if(rowCountPlayer1 == 0){
                                Console.println("You can't go to UP now!");
                            } else{
                                rowCountPlayer1--;
                            }
                            break;
                        case DOWN:
                            if(rowCountPlayer1 == rowAmount){
                                Console.println("You can't go to DOWN now!");
                            } else{
                                rowCountPlayer1++;
                            }
                            break;
                        case LEFT:
                            if(columnCountPlayer1 == 0){
                                Console.println("You can't go to LEFT now!");
                            } else{
                                columnCountPlayer1--;
                            }
                            break;
                        case RIGHT:
                            if(columnCountPlayer1 == columnAmount){
                                Console.println("You can't go to RIGHT now!");
                            } else{
                                columnCountPlayer1++;
                            }
                            break;
                        case ENTER:
                            int boatRowCount = 0;
                            int boatColumnCount = 0;
                            if(rowCountPlayer1 == boatRowCount && columnCountPlayer1 == boatColumnCount){
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
                                    rowCountPlayer1 = 0;
                                    columnCountPlayer1 = 0;
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
                             rowCountPlayer1 = 0;
                             columnCountPlayer1 = 0;
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