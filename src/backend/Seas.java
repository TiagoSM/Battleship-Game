package backend;

import frontend.Menu;
import console.Console;
import console.Tecla;
import mecanicas.Carta;
import mecanicas.Tabuleiro;

public class Seas extends Tabuleiro {
    boolean found = false;
    byte count = 0;
    byte flag = 0;
    int i;
    byte rowCountPlayer = 0;
    byte columnCountPlayer = 0;
    byte rowAmount = 10;
    byte columnAmount = 10;
    Menu menu = new Menu();
    Tecla key;
    Colors bottomChar = new Colors("⚪"); //Ainda não está usando
    Colors sunkenChar = new Colors("❌");
    Colors emptyChar = new Colors("⚫");
    Colors boatChar = new Colors("");
    Boat sunkenBoat = new Boat(sunkenChar);
    Boat emptySea = new Boat(emptyChar);
    Boat solidBoat = new Boat(boatChar);
    int amountBoard0 [] [] = new int[2][];
    int amountBoard1[][] = new int[2][];
    
    
    
    static Boat part = new Boat(new Colors("⚪"));
    
    
    //INICIALIZATION
    public Seas(String board){
        super(10, 10, part);
        
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
    
    //TOOLS
    public void SucesfullAttack(int row, int column){
        setFundo(row, column, sunkenBoat);
    }
    
    public void MissedAttack(int row, int column){
        setFundo(row, column, emptySea);
    }
    
    public void Boat(int row, int column){
        setFundo(row, column, solidBoat);
    }
    
    public int RowMovementUp(int row, Tecla key){
        if(row == 0){
            do{
                menu.InvalidKey(key);
            }while(Console.getTecla() != Tecla.ENTER);
        } else{
            row--;
        }
        return row;
    }
    
    public int RowMovementDown(int row, Tecla key){
        if(row == 10){
            do{
                menu.InvalidKey(key);
            }while(Console.getTecla() != Tecla.ENTER);
        } else{
            row++;
        }
        return row;
    }
    
    public int ColumnMovementLeft(int column, Tecla key){
        if(column == 0){
            do{
                menu.InvalidKey(key);
            }while(Console.getTecla() != Tecla.ENTER);
        } else{
            column--;
        }
        return column;
    }
    
    public int ColumnMovementRight(int column, Tecla key, int columnAmount){
        if(column == columnAmount){
            do{
                menu.InvalidKey(key);
            }while(Console.getTecla() != Tecla.ENTER);
        } else{
            column++;
        }
        return column;
    }
    
    public void PlayerAttack(int boardPlayerSelection, Seas boardPlayerDefault, Seas boardPlayerAction, int columnCountPlayer, int rowCountPlayer){
        if (boardPlayerSelection == 0) {
            found = false;
            for (i = 0; i < boardPlayerAction.amountBoard0[0].length; i++) {
                if (rowCountPlayer == boardPlayerDefault.amountBoard0[0][i] && columnCountPlayer == boardPlayerDefault.amountBoard0[1][i]) {
                    found = true;
                    break;
                    }
                }

            if (found) {
                // Ataque bem-sucedido
                boardPlayerAction.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                boardPlayerDefault.SucesfullAttack(rowCountPlayer, columnCountPlayer);
                count++;
            } else {
                // Ataque falhou
                System.out.println("errou");
                boardPlayerAction.MissedAttack(rowCountPlayer, columnCountPlayer);
                boardPlayerDefault.MissedAttack(rowCountPlayer, columnCountPlayer);
            }
        } else{
            // Condição inicial falhou
            System.out.println("tudo errado");
        }
    }
    
    
    //PHASES
    public void BoardOptions(int columnCountPlayer, Seas boardShip0, Seas boardShip1){
        if(columnCountPlayer == 0){
        Console.println("Board 1");
        Console.println(boardShip0);
       } else if(columnCountPlayer == 1){
            Console.println("Board 2");
            Console.println(boardShip1);
        }
    }
    
    public Seas ChoosedBoard(int columnCountPlayer, Seas boardPlayerDefault, int boardPlayerSelection){
        if(columnCountPlayer == 0){
            boardPlayerSelection = 0;
            return boardPlayerDefault = new Seas("BOARD0");
        } else if(columnCountPlayer == 1){
            boardPlayerSelection = 1;
            return boardPlayerDefault = new Seas("BOARD1");
        }
        return null;
    }
    
}
