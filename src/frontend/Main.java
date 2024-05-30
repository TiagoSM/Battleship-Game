package frontend;
//Adicionar loop no Game dos players
//Tirar os switches e interações com os players para uma classe diferente? para ser mais orientado a objetos?
import backend.Boat;
import backend.Seas;
import backend.Colors;
import console.Console;
import console.Tecla;

public class Main {
    public static void main(String[] args){
        boolean found = false;
        byte count = 0;
        byte boardPlayer1Selection = 0;
        byte boardPlayer2Selection = 0;
        byte flag = 0;
        int i;
        byte rowCountPlayer1 = 0;
        byte columnCountPlayer1 = 0;
        byte rowCountPlayer2 = 0;
        byte columnCountPlayer2 = 0;
        byte rowAmount = 10;
        byte columnAmount = 10;
        Tecla key;
        Colors string = new Colors("⚪");
        Boat part = new Boat(string);
   
        Input interaction = new Input();
        Menu display = new Menu();
        Seas boardShip0 = new Seas("BOARD0");
        Seas boardShip1 = new Seas("BOARD1");
        Seas boardPlayerDefault1 = new Seas(rowAmount, columnAmount, part);
        Seas boardPlayerDefault2 = new Seas(rowAmount, columnAmount, part);
        Seas boardPlayerAction1 = new Seas(rowAmount, columnAmount, part);
        Seas boardPlayerAction2 = new Seas(rowAmount, columnAmount, part);
        
        do{
            display.MainMenu();
            key = Console.getTecla();
            if(key == Tecla.ENTER){ //New Game
                //Choose Board Player1
                interaction.chooseBoard(1, boardPlayerDefault1);
          
                //Choose Board Player 2
                interaction.chooseBoard(2, boardPlayerDefault2);
                
                do{  
                //Game Player 1
                do{
                    do{
                        Console.println("Player 1 are you ready to game?");
                        Console.println("Click ENTER to continue:");
                    }while(Console.getTecla() != Tecla.ENTER);
                    display.BoardGame(boardPlayerDefault2, boardPlayerAction2, rowCountPlayer1, columnCountPlayer1);
                    key = Console.getTecla();
                    switch(key){
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
                            flag = 1;
                            if(boardPlayer1Selection == 0){
                                if (boardPlayer1Selection == 0) {
                                    found = false;
                                    for (i = 0; i < boardShip0.amountBoard0[0].length; i++) {
                                        if (rowCountPlayer1 == boardShip0.amountBoard0[0][i] && columnCountPlayer1 == boardShip0.amountBoard0[1][i]) {
                                            found = true;
                                            break;
                                        }
                                    }

                                    if (found) {
                                        // Ataque bem-sucedido
                                        boardPlayerAction2.SucesfullAttack(rowCountPlayer1, columnCountPlayer1);
                                        boardPlayerDefault2.SucesfullAttack(rowCountPlayer1, columnCountPlayer1);
                                        count++;
                                    } else {
                                        // Ataque falhou
                                        
                                        System.out.println("errou");
                                        boardPlayerAction2.MissedAttack(rowCountPlayer1, columnCountPlayer1);
                                        boardPlayerDefault2.MissedAttack(rowCountPlayer1, columnCountPlayer1);
                                    }
                                } else {
                                    // Condição inicial falhou
                                    System.out.println("tudo errado");
                                }
                            }
                            break;
                        case P:
                            display.PauseMenu();
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
                    if(count == 30){
                        display.WinMenu();
                        Tecla keyPause = Console.getTecla();
                        switch(keyPause){
                            case M:
                                flag = 1;
                                    break;
                                case S:
                                    break;
                            }
                    }
                    
                    Console.limpaTela();
                }while(flag != 1); //quando o usuário quiser voltar para o menu principal
            
                // Player 2 Game
                do{
                    do{
                        Console.println("Player 2 are you ready to game?");
                        Console.println("Click ENTER to continue:");
                    }while(Console.getTecla() != Tecla.ENTER);
                   display.BoardGame(boardPlayerDefault2, boardPlayerAction1, rowCountPlayer2, columnCountPlayer1);
                    key = Console.getTecla();
                    switch(key){
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
                            flag = 1;
                                if (boardPlayer1Selection == 0){
                                    found = false;
                                    for (i = 0; i < boardShip0.amountBoard0[0].length; i++){
                                        if (rowCountPlayer1 == boardShip0.amountBoard0[0][i] && columnCountPlayer1 == boardShip0.amountBoard0[1][i]) {
                                            found = true;
                                            break;
                                        }
                                    }

                                    if (found){
                                        // Ataque bem-sucedido
                                        boardPlayerAction2.SucesfullAttack(rowCountPlayer1, columnCountPlayer1);
                                        boardPlayerDefault2.SucesfullAttack(rowCountPlayer1, columnCountPlayer1);
                                        count++;
                                    } else{
                                        // Ataque falhou
                                        System.out.println("errou");
                                        boardPlayerAction2.MissedAttack(rowCountPlayer1, columnCountPlayer1);
                                        boardPlayerDefault2.MissedAttack(rowCountPlayer1, columnCountPlayer1);
                                    }
                                } else{
                                    // Condição inicial falhou
                                    System.out.println("tudo errado");
                                }
                                break;
                            case P:
                                display.PauseMenu();
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
                            
                            
                    if(count == 30){
                        display.WinMenu();
                        Tecla keyPause = Console.getTecla();
                        switch(keyPause){
                            case M:
                                flag = 1;
                                    break;
                                case S:
                                    break;
                                    
                                    
                                    
                            }
                    }
                    
                    Console.limpaTela();
                }while(flag != 1); 
            }while(flag != 10); //loop game
            }
        }while(flag != 9);//quando o usuário quiser voltar para o menu principal
    }
}