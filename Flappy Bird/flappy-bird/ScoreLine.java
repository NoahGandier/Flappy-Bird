import greenfoot.*;
public class ScoreLine extends Actor 
{
    
    /**
     * Things to do for each turn.
     * 
     * @Return Nothing is returned
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