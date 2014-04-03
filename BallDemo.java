import java.awt.Color;
import java.util.Random;
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

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line, lanza desde arriba a 400 de los 500
        
        myCanvas.setVisible(true);

        // draw the ground, la línea del suelo desde el 50 hasta el 550 de 600
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
       
            Random aleatorio = new Random();
            int radio = 1 + (int)(Math.random()*(100-20+1));
            int x = aleatorio.nextInt(300);
            int color = aleatorio.nextInt(256);
            Color pintado = new Color(color);
            BouncingBall ball = new BouncingBall(x, 50, radio, pintado, ground, myCanvas);//x, y, r, color, ground, canvas
            ball.draw();
            BouncingBall ball2 = new BouncingBall(7, 80, 20, Color.RED, ground, myCanvas);
            ball2.draw();
     

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
