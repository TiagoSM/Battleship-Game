package frontend;

import console.Console;

public class Main {
    public static void main(String[] args){
        Menu display = new Menu();
        
        while(true){
            display.MainMenu();
            display.key = Console.getTecla();
            switch(display.key){
                case ENTER:
                    display.resetBoards();
                    display.ChooseBoard();
                    display.LoopGame();
                    break;
                case ESC:
                    Console.saiDoPrograma();
                    break;
                default:
                	Console.println("Invalid key!");         
             }
        }
    }
}
