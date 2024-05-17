package backend;
import backend.Boats;
import mecanicas.Carta;
import mecanicas.Tabuleiro;

public class Seas extends Tabuleiro{
    Colors sunkenChar = new Colors("❌");
    Colors emptyChar = new Colors("⚫");
    Boats sunkenBoat = new Boats(sunkenChar);
    
    public Seas(int numLinhas, int numColunas, Carta fundo) {
        super(numLinhas, numColunas, fundo);
    }
    
    public void Attack(){
        setFundo(5, 5, sunkenBoat);
    }
    
}
