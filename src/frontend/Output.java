package frontend;

import console.Console;
import console.Tecla;

public class Output {
    public void InvalidKey(Tecla key){
        Console.println("You can't go to " + key + " now!");
        Console.println("Click ENTER to continue");
    }
}
