import greenfoot.*;
import java.awt.*;
public class Bird extends Actor 
{
    public static final int Fall = 1;
    public static final int SPEED = 10;
    public static final int jumpSpeed = -10;
    private int speed = 0;
    private int score = 0;
    
    /**
     * Creates a new bird.
     * 
     */
    public Bird() 
    {
        speed = 0;
        score = 0;
    }
    
    /**
     * Things to do for each turn.
     * 
     */
    public void act() 
    {
        checkFlap();
        move();
        if (checkHit()) 
        {
            Sky sky = (Sky) getWorld();
            sky.gameOver(score);
        } else 
        {
            checkScore();
        }
    }
    
    /**
     * Checks if the bird flaps.
     * 
     * @Return Nothing is returned
     */
    private void checkFlap() 
    {
        if (Greenfoot.mouseClicked(null)) 
        {
            speed = jumpSpeed;
        }
    }
    
    /**
     * Moves the bird.
     * 
     * 
     * @Return Nothing is returned
     */
    private void move() 
    {
        speed = speed + Fall;
        setLocation(getX(), getY() + speed);
    }
    
    /**
     * Checks if the bird hits the obstacles.
     * 
     * @return true if hit, false otherwise
     */
    private boolean checkHit() 
    {
        if (isTouching(Pipe.class)) 
        {
            return true;
        }
        if (getY() == getWorld().getHeight() - 1) 
        {
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the bird gets ths score.
     * 
     *@Return Nothing is returned
     */
    private void checkScore() 
    {
        if (isTouching(ScoreLine.class)) 
        {
            removeTouching(ScoreLine.class);
            score++;
            Sky sky = (Sky) getWorld();
            sky.setScore(score);
        }
    }
}