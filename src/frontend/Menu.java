package frontend;
//Testar o turn player no loop game
import backend.Seas;
import console.Console;
import console.Tecla;
import backend.Colors;
import backend.Boat;

public class Menu {
    boolean found = false;
    int boardPlayer1Selection;
    int boardPlayer2Selection;
    int column = 0;
    int row = 0;
    byte count = 0;
    byte flag = 0;
    Tecla key;
    Seas boardPlayer1Default;
    Seas boardPlayer2Default;
    Seas boardPlayer1Action;
    Seas boardPlayer2Action;

    //TOOLS
    public void InvalidKey(Tecla key){
        Console.println("You can't go to " + key + " now!");
        Console.println("Click ENTER to continue");
    }
    
    private void SelectBoard(int playerNumber, Seas boardPlayerDefault, int boardPlayerSelection){
        do{
                    do{
                        Console.println("Player " + playerNumber + " are you ready to choose your ship board?");
                        Console.println("Click ENTER to continue:");
                    } while(Console.getTecla() != Tecla.ENTER);
                    
                    do{
                        boardPlayerDefault.BoardOptions(column, new Seas("BOARD0"), new Seas("BOARD1"));
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
    
    private void TurnPlayer(Seas boardPlayerDefault, Seas boardPlayerAction){
        do{
                    do{
                        Console.println("Player 1 are you ready to game?");
                        Console.println("Click ENTER to continue:");
                    }while(Console.getTecla() != Tecla.ENTER);
                    
                    BoardGame(boardPlayerDefault, boardPlayerAction, row, column);
                    key = Console.getTecla();
                    switch(key){
                        case UP:
                            row = boardPlayerAction.RowMovementUp(row, key);
                            break;
                        case DOWN:
                            row = boardPlayerAction.RowMovementDown(row, key);
                            break;
                        case LEFT:
                            column = boardPlayerDefault.ColumnMovementLeft(column, key);
                            break;
                        case RIGHT:
                            column = boardPlayerDefault.ColumnMovementRight(column, key, 10);
                            break;
                        case ENTER:
                            flag = 1;
                            boardPlayerAction.PlayerAttack(boardPlayer1Selection, boardPlayerDefault, boardPlayerAction, column, row);
                            break;
                        case P:
                            PauseMenu();
                            Tecla keyPause = Console.getTecla();
                            switch(keyPause){
                                case B:
                                    flag = 0;
                                    row = 0;
                                    column = 0;
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
                             row = 0;
                             column = 0;
                    }
                    //Tela de que ganhou o jogo
                    WinGame();
                    
                    Console.limpaTela();
                }while(flag != 1);
    }
    
    
    //MENUS
    public void MainMenu(){
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
    
    private void BoardGame(Seas boardPlayerDefault, Seas boardPlayerAction, int rowCountPlayer, int columnCountPlayer){
         Console.println("\tClick P to Pause");
         Console.print(boardPlayerDefault);
         Console.println(boardPlayerAction);
         Console.print("ARROWS: Move\t");
         Console.print("ENTER: Attack \t");
         Console.println(" Position:(" + rowCountPlayer + "," + columnCountPlayer + ")");
    }
    
    private void WinGame(){
        if(count == 30){
            WinMenu();
            Tecla keyPause = Console.getTecla();
            switch(keyPause){
                case M:
                    flag = 1;
                    break;
                case S:
                    break;
            }
        }
    }
    
    //PHASES
    public void ChooseBoard(){
        boardPlayer1Default = new Seas("BOARD0");
        boardPlayer2Default = new Seas("BOARD1");
        
        SelectBoard(1, boardPlayer1Default, boardPlayer1Selection);
        SelectBoard(2, boardPlayer2Default, boardPlayer2Selection);
    }
    
    public void LoopGame(){
        
        do{
            
                
                //loop game
                //player 1 attack
                TurnPlayer(boardPlayer1Default, boardPlayer2Action);
                //player 1 win?
                WinGame();

                //player 2 attack
                TurnPlayer(boardPlayer2Default, boardPlayer1Action);
        }while(flag != 9);
        
    }
    
    
}
