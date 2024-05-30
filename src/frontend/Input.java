package frontend;

import console.Console;
import console.Tecla;
import backend.Seas;

public class Input {
    public Tecla key;
    
    public void chooseBoard(int playerNumber, Seas boardPlayerDefault){
        int column = 0;
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
                                column = boardPlayerDefault.ColumnMovementRight(column, key);
                                break;
                            case ENTER:
                                boardPlayerDefault.ChooseBoard(boardPlayerDefault);
                            break;
                            case ESC:
                                Console.saiDoPrograma();
                                break;
                        }
                        
                    }while(key != Tecla.ENTER);
                }while(key != Tecla.ENTER);
        
    }
    
}
