
/**
 * Beschreiben Sie hier die Klasse Start.
 * 
 * @author Martin Milch
 * @version 22.05.2021
 */
import javax.swing.*;

public class Start
{
    private final static String TITLE = "Game of Life";
    private final static int HEIGHT = 480;
    private final static int WIDTH = 640;
    private final static int SLEEPING_TIME = 250;
    private final static int ROWS = 64;
    private final static int COLUMNS = 64;
	
	void run() {
        GameOfLife gameOfLife = new GameOfLife (ROWS, COLUMNS);
        DrawPanel drawPanel = new DrawPanel(gameOfLife);
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize(WIDTH, HEIGHT);
        f.setTitle(TITLE);
        f.add(drawPanel);    
        f.setVisible( true );
        
        while (true){
            gameOfLife.nextGeneration();
            drawPanel.repaint();
            sleep(SLEEPING_TIME);
        }
	}
    
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
    
    public static void main(String[] args){
        Start start = new Start();
        start.run();
    }
    
}