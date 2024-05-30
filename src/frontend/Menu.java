package frontend;

import backend.Seas;
import console.Console;
import console.Tecla;

public class Menu {
    public void InvalidKey(Tecla key){
        Console.println("You can't go to " + key + " now!");
        Console.println("Click ENTER to continue");
    }
    
    public void MainMenu(){
        Console.println("MAIN MENU");
        Console.println("ENTER: New game");
        Console.println("S: Saved game");
        Console.println("ESC: Exit game");
    }
    
    public void WinMenu(){
        Console.limpaTela();
        Console.println("\\\\\\\\\\\\YOU WIN/////////////");
        Console.println("M: Main Menu");
        Console.println("S: Save Game");
    }
    
    public void PauseMenu(){
        Console.limpaTela();
        Console.println("Choose a option: ");
        Console.println("B: Continue");
        Console.println("S: Save Game");
        Console.println("M: Main Menu");
        Console.println("ESC: Exit Game");
    }
    
    public void BoardGame(Seas boardPlayerDefault, Seas boardPlayerAction, int rowCountPlayer, int columnCountPlayer){
         Console.println("\tClick P to Pause");
         Console.print(boardPlayerDefault);
         Console.println(boardPlayerAction);
         Console.print("ARROWS: Move\t");
         Console.print("ENTER: Attack \t");
         Console.println(" Position:(" + rowCountPlayer + "," + columnCountPlayer + ")");
    }
    
}
