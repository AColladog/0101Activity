import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private static final int GROUND_X1 = 50;
    private static final int GROUND_X2 = 550;
    private static final int GROUND_Y1 = 40;
    private static final int GROUND_Y2 = 450;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     * @param numeroPelotas, es el número de pelotas que se crearán
     */
    public void bounce(int numeroPelotas)
    {
        int ground = 400;   // position of the ground line, lanza desde arriba a 400 de los 500
        ArrayList<BouncingBall> arrayPelotas = new ArrayList<>();;
        myCanvas.setVisible(true);

        // draw the ground, la línea del suelo desde el 50 hasta el 550 de 600
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
       
            Random aleatorio = new Random();
        for(int i = 0; i < numeroPelotas; i++){    
            int radio = 1 + (int)(Math.random()*(100-20+1)); // aleatorio.nextInt(80) + 20
            int y = aleatorio.nextInt(350);
            int x = aleatorio.nextInt(300);
            int colorRed = aleatorio.nextInt(256);
            int colorGreen = aleatorio.nextInt(256);
            int colorBlue = aleatorio.nextInt(256);
            Color pintado = new Color(colorRed, colorGreen, colorBlue);
            
            BouncingBall ball = new BouncingBall(x, y, radio, pintado, ground, myCanvas);//x, y, r, color, ground, canvas
            ball.draw();
            arrayPelotas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall pelota : arrayPelotas){
                pelota.move();
            }
            // stop once ball has travelled a certain distance on x axis
            for(BouncingBall moveBall : arrayPelotas){
                if(moveBall.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
    
    /**
     * Este método dibuja un rectágulo, sobre esté las bolas chocarán
     * @param numeroPelotas, es el número de pelotas que se crearán
     */
    public void boxBounce(int numeroPelotas){
        ArrayList<BoxBall> arrayPelotas = new ArrayList<>();
        //creo rectangulo
        myCanvas.setVisible(true);
        myCanvas.drawLine(GROUND_X1, GROUND_Y2, GROUND_X2, GROUND_Y2);
        myCanvas.drawLine(GROUND_X1, GROUND_Y1, GROUND_X2, GROUND_Y1);
        myCanvas.drawLine(GROUND_X1, GROUND_Y1, GROUND_X1, GROUND_Y2);
        myCanvas.drawLine(GROUND_X2, GROUND_Y1, GROUND_X2, GROUND_Y2);
        // crate and show the balls
       
        Random aleatorio = new Random();
        for(int i = 0; i < numeroPelotas; i++){    
            int radio = 1 + (int)(Math.random()*(100-20+1)); // aleatorio.nextInt(80) + 20
            int y = aleatorio.nextInt(350);
            int x = aleatorio.nextInt(300);
            int colorRed = aleatorio.nextInt(256);
            int colorGreen = aleatorio.nextInt(256);
            int colorBlue = aleatorio.nextInt(256);
            Color pintado = new Color(colorRed, colorGreen, colorBlue);
            
            BoxBall ball = new BoxBall(x, y, radio, pintado, GROUND_X2, GROUND_Y2, GROUND_X1, GROUND_Y1, myCanvas);//x, y, r, color, ground, canvas
            ball.draw();
            arrayPelotas.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BoxBall pelota : arrayPelotas){
                pelota.move();
            }     
        }
        
    }
}
