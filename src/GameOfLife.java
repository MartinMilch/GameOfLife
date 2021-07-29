
import java.util.Random;
import java.awt.*;

public class GameOfLife
{
    private int[][] raster;

    public void randomRaster(){
        
        Random random = new Random();
    
        for (int row = 0; row < raster.length; row++){
            for (int column = 0; column < raster[row].length; column++){
                
                int value = random.nextInt(2);
                raster[row][column] = value;
            }
        }        
    }
    
    @SuppressWarnings("unused")
	private void printRaster(){
        
        for (int row = 0; row < raster.length; row++){
            for (int column = 0; column < raster[row].length; column++){
                
                int value = raster[row][column];
                System.out.print(value);                
            }
            System.out.println(" ");
        }        
    }
    
    private int getNeighbor (int row, int column){
    
        int neighbor = 0;
        
        for (int i = row-1; i < row+2; i++){
            for (int j = column-1; j < column+2; j++){
                neighbor += raster[i][j];     
            }
        } 
        neighbor -= raster[row][column];
        
        return neighbor;
    }
    
    private int getRules(int state, int neighbor){
        
        if (state == 0){
            
            if (neighbor == 3) return 1;
            else return 0;
            
        } else {
            
            if ((neighbor < 2) || (neighbor > 3)) return 0;
            else return 1;
            
        }
    }
    
    public void nextGeneration(){
   
        int[][] tempRaster = new int[raster.length][raster[1].length]; 
        
        for (int row = 1; row < raster.length-1; row++){
            for (int column = 1; column < raster[row].length-1; column++){
                
                int neighbor = getNeighbor(row, column);
                tempRaster[row][column] = getRules (raster[row][column], neighbor);
            }
        }        
        
        raster = tempRaster;        
    }
    
    public void drawRaster(Graphics g, int height, int width){
        g.setColor(Color.GRAY);
    	g.fillRect(0, 0, width, height);
    	
        int h = (int)height / raster.length;
        int w = (int)width / raster[0].length;
           
        for (int row = 0; row < raster.length; row++){
            for (int column = 0; column < raster[row].length; column++){
                
                if (raster[row][column] == 0){
                    g.setColor(Color.BLACK);
                    
                } else {
                    g.setColor(Color.GREEN);
                };
                
                g.fillRect(column*(w+1), row*(h+1), w-1, h-1);
            }
        } 
    }
            
    /**
     * Konstruktor für Objekte der Klasse GameOfLife
     */
    public GameOfLife(int row, int column)
    {
        raster = new int[row][column];
        randomRaster();
        //printRaster();
    }

    
    
}