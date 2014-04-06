import java.awt.*;
import java.awt.geom.*;
public class BoxBall
{

    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPositionX1;      // y down position of ground
    private final int groundPositionY1;      // x rigth position of ground
    private final int groundPositionX2;      // y top position of ground
    private final int groundPositionY2;      // x left position of ground
    private Canvas canvas;
    private int ySpeed = 1;                
    private int xSpeed = 1;

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    int groundPos1, int groundPos2, int groundPos3, int groundPos4, Canvas drawingCanvas)
    {
        xPosition = xPos;   // Initial position
        yPosition = yPos;   // Initial position
        color = ballColor;
        diameter = ballDiameter;
        groundPositionX1 = groundPos1;
        groundPositionY1 = groundPos2;
        groundPositionX2 = groundPos3;
        groundPositionY2 = groundPos4;
        canvas = drawingCanvas;   
    }
    
    

}