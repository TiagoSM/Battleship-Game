package frontend;
//Criar métodos dentro do Menu para chamar na Main
import console.Console;
import console.Tecla;

public class Main {
    public static void main(String[] args){
        Menu display = new Menu();
        
        while(true){
            display.MainMenu();
            display.key = Console.getTecla();
            if(display.key == Tecla.ENTER){ //New Game
                display.ChooseBoard();
                display.LoopGame();
                
            } else if(display.key == Tecla.S){
                
            } else if(display.key == Tecla.ESC){
                
            }
        }
    }
}