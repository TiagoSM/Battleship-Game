package backend;

import frontend.Output;
import console.Console;
import console.Tecla;
import mecanicas.Tabuleiro;

public class Seas extends Tabuleiro {
    int i;
    Output menu = new Output();
    Colors sunkenChar = new Colors("❌");
    Colors emptyChar = new Colors("⚫");
    Colors boatChar = new Colors("");
    Boat sunkenBoat = new Boat(sunkenChar);
    Boat emptySea = new Boat(emptyChar);
    Boat solidBoat = new Boat(boatChar);
    //Ajuda do ChatGPT para iniciar os arrays em cada linha para que eu nao tenha que informar cada coordenada em cada posição da matriz, assim posso apenas informar o valor sem ter que mudar as posiçoes no vetor ou pré-definir a quantidade que deve armazenar na matriz bidimensional. E também em tornar público essas matrizes, pois eu não estava conseguindo acessar esses valores na classe Menu, logo o ChatGPT me informou que eu devia deixar público para que funcionasse.
    public int[][] amountBoard0 = new int[2][];
    public int[][] amountBoard1 = new int[2][];
    static Boat bottomChar = new Boat(new Colors("⚪"));
    
    public Seas(){
        super(10, 10, bottomChar);
    }
    
    
    public Seas InitializeBoard(String board){
        switch(board){
            case "BOARD0":
                amountBoard0[0] = new int[]{/*Submarine*/0, 0, 7, 7, 5, 6, 2, 3, /*Destroyers*/0, 1, 2, 2, 2, 2, 5, 6, 7, /*Tankers*/2, 3, 4, 5, 0, 0, 0, 0, /*Aircraft Carrier*/9, 9, 9, 9, 9};
                amountBoard0[1] = new int[]{/*Submarine*/0, 1, 0, 1, 5, 5, 9, 9, /*Destroyers*/3, 3, 3, 5, 6, 7, 9, 9, 9, /*Tankers*/0, 0, 0, 0, 6, 7, 8, 9, /*Aircraft Carrier*/5, 6, 7, 8, 9};
                InitializeBoats(amountBoard0);
                break;
            case "BOARD1":
                amountBoard1[0] = new int[]{/*Submarine*/0, 0, 0, 0, 9, 9, 3, 4, /*Destroyers*/0, 0, 0, 7, 8, 9, 7, 8, 9, /*Tankers*/6, 6, 6, 6, 4, 4, 4, 4, /*Aircraft Carrier*/2, 2, 2, 2, 2};
                amountBoard1[1] = new int[]{/*Submarine*/0, 1, 8, 9, 3, 4, 0, 0, /*Destroyers*/4, 5, 6, 0, 0, 0, 8, 8, 8, /*Tankers*/3, 4, 5, 6, 6, 7, 8, 9, /*Aircraft Carrier*/3, 4, 5, 6, 7};
                InitializeBoats(amountBoard1);
                break;
        }
        return this;
    }
    
    private void InitializeBoats(int amountBoard[][]){
        //Submarine
                int quantityPositionSubmarine1 = 8;
                for(i = 0; i < quantityPositionSubmarine1; i++){
                    Boat(amountBoard[0][i], amountBoard[1][i]);
                }            
                //Destroyers
                int quantityPositionDestroyers1 = 9 + quantityPositionSubmarine1;
                for(i = 8; i < quantityPositionDestroyers1; i++){
                    Boat(amountBoard[0][i], amountBoard[1][i]);
                }           
                //Tankers
                int quantityPositionTankers1 = 8 + quantityPositionDestroyers1;
                for(i = 8; i < quantityPositionTankers1; i++){
                    Boat(amountBoard[0][i], amountBoard[1][i]);
                }                 
                //Aircraft Carrier
                int quantityPositionAircraftCarrier1 = 5 + quantityPositionTankers1;
                for(i = 8; i < quantityPositionAircraftCarrier1; i++){
                    Boat(amountBoard[0][i], amountBoard[1][i]);
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
        if(row == 9){
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
            return boardPlayerDefault.InitializeBoard("BOARD0");
        } else if(columnCountPlayer == 1){
            boardPlayerSelection = 1;
            return boardPlayerDefault.InitializeBoard("BOARD1");
        }
        return null;
    }
    
}
