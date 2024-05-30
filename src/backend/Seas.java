package backend;
import backend.Boat;
import console.Console;
import console.Tecla;
import mecanicas.Carta;
import mecanicas.Tabuleiro;

public class Seas extends Tabuleiro {
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
    Colors bottomChar = new Colors("⚪"); //Ainda não está usando
    Colors sunkenChar = new Colors("❌");
    Colors emptyChar = new Colors("⚫");
    Colors boatChar = new Colors("");
    Boat sunkenBoat = new Boat(sunkenChar);
    Boat emptySea = new Boat(emptyChar);
    Boat solidBoat = new Boat(boatChar);
    public int amountBoard0 [] [] = new int[2][];
    public int amountBoard1[][] = new int[2][];
    
    
    
    static Boat part = new Boat(new Colors("⚪"));
    
    public Seas(String board){
        super(10, 10, part);
        //SETAR TUDO AQUI ASSIM QUE EU FINALIZAR TODO O JOGO BASE, PARA GARANTIR A NOTA
        switch(board){
            case "BOARD0":                
                Seas boardShip0 = this;
                
                
                amountBoard0[0] = new int[]{/*Submarine*/0, 0, 7, 7, 5, 6, 2, 3, /*Destroyers*/0, 1, 2, 2, 2, 2, 5, 6, 7, /*Tankers*/2, 3, 4, 5, 0, 0, 0, 0, /*Aircraft Carrier*/9, 9, 9, 9, 9};
                amountBoard0[1] = new int[]{/*Submarine*/0, 1, 0, 1, 5, 5, 9, 9, /*Destroyers*/3, 3, 3, 5, 6, 7, 9, 9, 9, /*Tankers*/0, 0, 0, 0, 6, 7, 8, 9, /*Aircraft Carrier*/5, 6, 7, 8, 9};
                //Submarine
                int quantityPositionSubmarine0 = 8;
                for(i = 0; i < quantityPositionSubmarine0; i++){
                    boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
                }            
                //Destroyers
                int quantityPositionDestroyers0 = 9 + quantityPositionSubmarine0;
                for(i = 8; i < quantityPositionDestroyers0; i++){
                    boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
                }           
                //Tankers
                int quantityPositionTankers0 = 8 + quantityPositionDestroyers0;
                for(i = 8; i < quantityPositionTankers0; i++){
                    boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
                }                 
                //Aircraft Carrier
                int quantityPositionAircraftCarrier0 = 5 + quantityPositionTankers0;
                for(i = 8; i < quantityPositionAircraftCarrier0; i++){
                    boardShip0.Boat(amountBoard0[0][i], amountBoard0[1][i]);
                }
                break;
            case "BOARD1":
                Seas boardShip1 = this;
                
                
                amountBoard1[0] = new int[]{/*Submarine*/0, 0, 0, 0, 9, 9, 3, 4, /*Destroyers*/0, 0, 0, 7, 8, 9, 7, 8, 9, /*Tankers*/6, 6, 6, 6, 4, 4, 4, 4, /*Aircraft Carrier*/2, 2, 2, 2, 2};
                amountBoard1[1] = new int[]{/*Submarine*/0, 1, 8, 9, 3, 4, 0, 0, /*Destroyers*/4, 5, 6, 0, 0, 0, 8, 8, 8, /*Tankers*/3, 4, 5, 6, 6, 7, 8, 9, /*Aircraft Carrier*/3, 4, 5, 6, 7};
                //Submarine
                int quantityPositionSubmarine1 = 8;
                for(i = 0; i < quantityPositionSubmarine1; i++){
                    boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
                }            
                //Destroyers
                int quantityPositionDestroyers1 = 9 + quantityPositionSubmarine1;
                for(i = 8; i < quantityPositionDestroyers1; i++){
                    boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
                }           
                //Tankers
                int quantityPositionTankers1 = 8 + quantityPositionDestroyers1;
                for(i = 8; i < quantityPositionTankers1; i++){
                    boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
                }                 
                //Aircraft Carrier
                int quantityPositionAircraftCarrier1 = 5 + quantityPositionTankers1;
                for(i = 8; i < quantityPositionAircraftCarrier1; i++){
                    boardShip1.Boat(amountBoard1[0][i], amountBoard1[1][i]);
                }
                break;
            
        }
    }
    
    public Seas(int numLinhas, int numColunas, Carta fundo) {
        super(numLinhas, numColunas, fundo);
    }

    public Seas(Tabuleiro fundo) {
        super(fundo);
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
    
    public void ChooseBoard(int columnCountPlayer, Seas boardShip0, Seas boardShip1){
        if(columnCountPlayer == 0){
        Console.println("Board 1");
        Console.println(boardShip0);
       } else if(columnCountPlayer == 1){
            Console.println("Board 2");
            Console.println(boardShip1);
        }
    }
    
}
