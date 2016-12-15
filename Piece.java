package GUIs;

import java.util.Random;
import java.lang.Math;


public class Piece {
    //blocks enumerator
    enum Shapes { NoBlock, IBlock, JBlock, LBlock, SBlock, SquareBlock, TBlock, ZBlock};
    
    private Shapes pieceShape;
    private int coords[][];
    private int[][][] coordsTable;


    public Piece() {
        coords = new int[4][2];
        setShape(Shapes.NoBlock);
    }

    public void setShape(Shapes shape) {
        //blocks table
        coordsTable = new int[][][] {
                    { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },  //NO            
                    { { 0, -1},   { 0, 0 },   { 0, 1 },   { 0, 2 } },  //I
                    { { 1, -1},   { 0, -1},   { 0, 0 },   { 0, 1 } },   //J
                    { {-1, -1},   { 0, -1},   { 0, 0 },   { 0, 1 } },  //L
                    { { 0, -1},   { 0, 0 },   { 1, 0 },   { 1, 1 } },  //S
                    { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },  //SQ                   
                    { { -1, 0},   { 0, 0 },   { 1, 0 },   { 0, 1 } },  //T
                    { { 0, -1},   { 0, 0 },   { -1, 0},   { -1, 1} }, //Z            
        };

        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 2; ++j) {
                coords[i][j] = coordsTable[shape.ordinal()][i][j];
            }
        }
        pieceShape = shape;

    }

    private void setX(int index, int x) { 
        coords[index][0] = x; }

    private void setY(int index, int y) { 
        coords[index][1] = y; }

    public int getX(int index) { 
        return coords[index][0]; }

    public int getY(int index) { 
        return coords[index][1]; }

    public Shapes getShape()  { 
        return pieceShape; }
    
    public void randomShape()
        {
            Random r = new Random();
            int x = r.nextInt(7)+1;
            Shapes[] values = Shapes.values(); 
            setShape(values[x]);
        }
   
    public Piece rotate(){

        if(pieceShape == Shapes.SquareBlock)
            return this;
        else{
            Piece rotatedShape = new Piece();
            rotatedShape.pieceShape = pieceShape;
            for(int i = 0; i<4; i++){
                rotatedShape.setX(i, -getY(i));
                rotatedShape.setY(i, getX(i));
            }
            return rotatedShape;
        }            
    }
    
    public int minX()
        {
          int m = coords[0][0];
          for (int i=0; i < 4; i++) {
              m = Math.min(m, coords[i][0]);
          }
          return m;
        }


        public int minY() 
        {
          int m = coords[0][1];
          for (int i=0; i < 4; i++) {
              m = Math.min(m, coords[i][1]);
          }
          return m;
        }
}