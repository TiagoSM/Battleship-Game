package backend;
import backend.Boats;
import mecanicas.Carta;
import mecanicas.Tabuleiro;

public class Seas extends Tabuleiro{
    Colors sunkenChar = new Colors("❌");
    Colors emptyChar = new Colors("⚫");
    Colors boat = new Colors("");
    Boats sunkenBoat = new Boats(sunkenChar);
    Boats emptySea = new Boats(emptyChar);
    Boats solidBoat = new Boats(boat);
    
    public Seas(int numLinhas, int numColunas, Carta fundo) {
        super(numLinhas, numColunas, fundo);
    }
    
    public void SucesfullAttack(int row, int column){
        setFundo(row, column, sunkenBoat);
    }
    
    public void MissedAttack(int row, int column){
        setFundo(row, column, emptySea);
    }
    
    public void Boat(int row, int column){
        setFundo(row, column, solidBoat);
    }
}
