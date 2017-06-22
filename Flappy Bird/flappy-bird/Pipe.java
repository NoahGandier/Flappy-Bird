import greenfoot.*;
import java.awt.*;  
public class Pipe extends Actor 
{
    public static final int WIDTH = 100;
    /**
     * Creates a new pipe.
     *
     *@Return Nothing is returned
     * @param height the height of the pipe
     */
    
    public Pipe(int height) 
    {
        GreenfootImage image = new GreenfootImage(WIDTH, height);
        image.setColor(Color.GREEN);
        image.fill();
        setImage(image);
    }
    
    /**
     * Things to do for each turn.
     * 
     */
    public void act() 
    {
        move();
    }
    
    /**
     * Moves the pipe backward.
     * 
     * @Return Nothing is returned
     */
    private void move()
    {
        setLocation(getX() - Bird.SPEED, getY());
        if (getX() <= 0) 
        {
            getWorld().removeObject(this);
        }
    }
}