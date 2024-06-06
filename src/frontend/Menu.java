package frontend;

import backend.Seas;
import console.Console;
import console.Tecla;

public class Menu {
    int i;
    boolean found = false;
    int boardPlayer1Selection;
    int boardPlayer2Selection;
    int column = 0;
    int row = 0;
    byte countPlayer1 = 0;
    byte countPlayer2 = 0;
    byte flag = 0;
    Tecla key;
    Seas boardShip0;
    Seas boardShip1;
    Seas boardPlayer1Default;
    Seas boardPlayer2Default;
    Seas boardPlayer1Action;
    Seas boardPlayer2Action;

    public Menu(){
        boardPlayer1Default = new Seas();
        boardPlayer2Default = new Seas();
        boardPlayer1Action = new Seas();
        boardPlayer2Action = new Seas();
        
        boardShip0 = boardPlayer1Default.InitializeBoard("BOARD0");
        boardShip1 = boardPlayer2Default.InitializeBoard("BOARD1");
    }
     
    //TOOLS
    public void resetBoards(){
        boardPlayer1Default = new Seas();
        boardPlayer2Default = new Seas();
        boardPlayer1Action = new Seas();
        boardPlayer2Action = new Seas();
        
        boardShip0 = boardPlayer1Default.InitializeBoard("BOARD0");
        boardShip1 = boardPlayer2Default.InitializeBoard("BOARD1");
        
        countPlayer1 = 0;
        countPlayer2 = 0;
        flag = 0;
    }
    
    private void SelectBoard(int playerNumber, Seas boardPlayerDefault, int boardPlayerSelection){
        do{
                    do{
                        Console.limpaTela();
                        Console.println("Player " + playerNumber + " are you ready to choose your ship board?");
                        Console.println("Click ENTER to continue:");
                    } while(Console.getTecla() != Tecla.ENTER);
                    
                    do{
                        
                        
 
                        
                        
                       
                        
                        Console.limpaTela();
                        Console.println("Player " + playerNumber + " choice");
                        boardPlayerDefault.BoardOptions(column, boardShip0, boardShip1);
                        Console.println("Click LEFT or RIGHT to see the boards");
                        Console.println("Click ENTER to select the board");
                        key = Console.getTecla();
                        switch(key){
                            case LEFT:
                                column = boardPlayerDefault.ColumnMovementLeft(column, key);
                                break;
                            case RIGHT:
                                column = boardPlayerDefault.ColumnMovementRight(column, key, 1);
                                break;
                            case ENTER:
                                boardPlayerDefault = boardPlayerDefault.ChoosedBoard(column, boardPlayerDefault, boardPlayerSelection);
                                break;
                            case ESC:
                                Console.saiDoPrograma();
                                break;
                        }
                        
                    }while(key != Tecla.ENTER);
                }while(key != Tecla.ENTER);
    }
    
    public void PlayerAttack(int PlayerNumber, int boardPlayerSelection, Seas boardPlayerDefault, Seas boardPlayerAction, int rowCountPlayer, int columnCountPlayer){
        if (boardPlayerSelection == 0) {
            found = false;
            for (i = 0; i < boardShip0.amountBoard0[0].length; i++) {
                if (rowCountPlayer == boardShip0.amountBoard0[0][i] && columnCountPlayer == boardShip0.amountBoard0[1][i]) {
                    found = true;
                    break;
                    }
                }
            if(PlayerNumber == 1){
                if (found) {
                    // Ataque bem-sucedido
                    boardPlayerAction.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer2Default.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    if(PlayerNumber == 1){
                       countPlayer1++;
                       WinGame(countPlayer1);
                    } else{
                        countPlayer2++;
                        WinGame(countPlayer2);
                    }

                } else {
                    // Ataque falhou
                    System.out.println("errou");
                    boardPlayerAction.MissedAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer2Default.MissedAttack(rowCountPlayer, columnCountPlayer);
                }
            } else if(PlayerNumber == 2){
                if (found) {
                    // Ataque bem-sucedido
                    boardPlayerAction.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer1Default.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    if(PlayerNumber == 1){
                       countPlayer1++;
                       WinGame(countPlayer1);
                    } else{
                        countPlayer2++;
                        WinGame(countPlayer2);
                    }

                } else {
                    System.out.println("errou");
                    boardPlayerAction.MissedAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer1Default.MissedAttack(rowCountPlayer, columnCountPlayer);
                }
            }
                
        } else if(boardPlayerSelection == 1){
            found = false;
            for (i = 0; i < boardShip1.amountBoard1[0].length; i++) {
                if (rowCountPlayer == boardShip1.amountBoard1[0][i] && columnCountPlayer == boardShip1.amountBoard0[1][i]) {
                    found = true;
                    break;
                    }
                }
            if(PlayerNumber == 1){
                if (found) {
                    // Ataque bem-sucedido
                    boardPlayerAction.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer2Default.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    if(PlayerNumber == 1){
                       countPlayer1++;
                       WinGame(countPlayer1);
                    } else{
                        countPlayer2++;
                        WinGame(countPlayer2);
                    }

                } else {
                    // Ataque falhou
                    System.out.println("errou");
                    boardPlayerAction.MissedAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer2Default.MissedAttack(rowCountPlayer, columnCountPlayer);
                }
            } else if(PlayerNumber == 2){
                if (found) {
                    // Ataque bem-sucedido
                    boardPlayerAction.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer1Default.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                    if(PlayerNumber == 1){
                       countPlayer1++;
                       WinGame(countPlayer1);
                    } else{
                        countPlayer2++;
                        WinGame(countPlayer2);
                    }

                } else {
                    System.out.println("errou");
                    boardPlayerAction.MissedAttack(rowCountPlayer, columnCountPlayer);
                    boardPlayer1Default.MissedAttack(rowCountPlayer, columnCountPlayer);
                }
            }
        }
    }
    
    private void TurnPlayer(int PlayerNumber, Seas boardPlayerDefault, Seas boardPlayerAction){
        row = 0;
        column = 0;
        do{
            Console.limpaTela();
            Console.println("Player " + PlayerNumber + " are you ready to game?");
            Console.println("Click ENTER to continue:");
        }while(Console.getTecla() != Tecla.ENTER);
        
        do{       
            BoardGame(PlayerNumber, boardPlayerDefault, boardPlayerAction, row, column);
        
            key = Console.getTecla();
            switch(key){
                case UP:
                    row = boardPlayerAction.RowMovementUp(row, key);
                    break;
                case DOWN:
                    row = boardPlayerAction.RowMovementDown(row, key);
                    break;
                case LEFT:
                    column = boardPlayerAction.ColumnMovementLeft(column, key);
                    break;
                case RIGHT:
                    column = boardPlayerAction.ColumnMovementRight(column, key, 9);
                    break;
                case ENTER:
                    if(PlayerNumber == 1){
                        PlayerAttack(PlayerNumber, boardPlayer1Selection, boardPlayerDefault, boardPlayerAction, row, column);
                    } else if(PlayerNumber == 2){
                        PlayerAttack(PlayerNumber, boardPlayer2Selection, boardPlayerDefault, boardPlayerAction, row, column);
                    }
                    break;
                case P:
                    do{
                        PauseMenu();
                        Tecla keyPause = Console.getTecla();
                        switch(keyPause){
                            case B:
                                flag = 0;
                                row = 0;
                                column = 0;
                                break;
                            case S:
                                break;
                            case M:
                                flag = 9;
                                break;
                            case ESC:
                                Console.saiDoPrograma();
                                break;
                        }
                    } while(key != Tecla.B && key != Tecla.M && key != Tecla.S && key != Tecla.ESC);
                    break;

                default:
                    row = 0;
                    column = 0;
            }
            
                    
            if (flag == 9) {
                break;  // Saia do loop se a flag for definida como 9
            }
        
            Console.limpaTela();
        }while(key != Tecla.ENTER);
    }
    
    
    //MENUS
    public void MainMenu(){
        Console.limpaTela();
        Console.println("MAIN MENU");
        Console.println("ENTER: New game");
        Console.println("S: Saved game");
        Console.println("ESC: Exit game");
    }
    
    private void WinMenu(){
        Console.limpaTela();
        Console.println("\\\\\\\\\\\\YOU WIN/////////////");
        Console.println("M: Main Menu");
        Console.println("S: Save Game");
    }
    
    private void PauseMenu(){
        Console.limpaTela();
        Console.println("Choose a option: ");
        Console.println("B: Continue");
        Console.println("S: Save Game");
        Console.println("M: Main Menu");
        Console.println("ESC: Exit Game");
    }
    
    private void BoardGame(int PlayerNumber, Seas boardPlayerDefault, Seas boardPlayerAction, int rowCountPlayer, int columnCountPlayer){
        Console.limpaTela();
        Console.println("Player " + PlayerNumber + " turn");
        Console.println("\tClick P to Pause");
        Console.print(boardPlayerDefault);
        Console.println("");
        Console.println("----------------");
        Console.println("");
        Console.println(boardPlayerAction);
        Console.print("ARROWS: Move\t");
        Console.print("ENTER: Attack \t");
        Console.println(" Position:(" + rowCountPlayer + "," + columnCountPlayer + ")");
    }
    
    private void WinGame(int count){
        if(count == 30){
            
        do {
            WinMenu();
            key = Console.getTecla();
            switch(key){
                case M:
                    flag = 9;
                    break;
                case S:
                    
                    break;
                case ESC:
                    Console.saiDoPrograma();
                    break;
                default:
                    Console.println("Invalid input!");
            }
        } while(key != Tecla.M && key != Tecla.S && key != Tecla.ESC);
            countPlayer1 = 0;
            countPlayer2 = 0;
        }
    }
    
    //PHASES
    public void ChooseBoard(){        
        SelectBoard(1, boardPlayer1Default, boardPlayer1Selection);
        SelectBoard(2, boardPlayer2Default, boardPlayer2Selection);
    }
    
    public void LoopGame(){
        do{
                //player 1 attack
                if(countPlayer2 < 30 && countPlayer1 < 30){
                    TurnPlayer(1, boardPlayer1Default, boardPlayer2Action);
                }
                if(flag == 9){
                    break;
                }
                //player 2 attack
                if(countPlayer1 < 30 && countPlayer2 < 30){
                    TurnPlayer(2, boardPlayer2Default, boardPlayer1Action);
                }
                
        }while(flag != 9);
        
    }
    
    
}