import greenfoot.*;
import java.awt.*;
public class Sky extends World 
{
    public static final int pipeSpacing = 150;        
    public static final int pipeMinHeight = 25;        
    private final int pipeInt = 30;
    private int pipeTimer = 0;
    private ScoreBoard scoreBoard = null;
    /**
     * Constructor for objects of class Sky.
     * 
     */
    public Sky() 
    {
        super(600, 400, 1);
        addObject(new Bird(), getWidth() / 2, getHeight() / 2);
        scoreBoard = new ScoreBoard();
        addObject(scoreBoard, 70, 50);
        pipeTimer = pipeInt * 2;
        setPaintOrder(GameOver.class, ScoreBoard.class, Bird.class, Pipe.class);
    }
    
    /**
     * Things to do for each turn.
     * 
     */
    public void act() 
    {
        addPipePairPeriodically();
    }
    
    /**
     * Sets the score.
     * 
     * 
     * @Return Nothing is returned
     * @param score the score
     */
    public void setScore(int score) 
    {
        scoreBoard.setScore(score);
    }
    
    /**
     * Game over.
     * 
     * 
     * @Return Nothing is returned
     * @param score the score
     */
    public void gameOver(int score) 
    {
        addObject(new GameOver(score), getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
    
    /**
     * Adds a pipe pair periodically.
     * 
     * @Return Nothing is returned
     */
    private void addPipePairPeriodically() 
    {
        pipeTimer--;
        if (pipeTimer == 0) {
            addPipePair();
            pipeTimer = pipeInt;
        }
    }
    
    /**
     * Adds a pipe pair.
     * 
     * @Return Nothing is returned
     */
    private void addPipePair() 
    {
        int pipeMaxHeight = getHeight() - pipeSpacing - pipeMinHeight;
        int height1 = pipeMinHeight + Greenfoot.getRandomNumber(pipeMaxHeight - pipeMinHeight);
        int y1 = height1 / 2 - 1;
        int height2 = getHeight() - height1 - pipeSpacing;
        int y2 = getHeight() - height2 / 2 - 1;
        int y3 = height1 + pipeSpacing / 2 - 1;
        addObject(new Pipe(height1), getWidth() - 1, y1);
        addObject(new Pipe(height2), getWidth() - 1, y2);
        addObject(new ScoreLine(), getWidth() - Pipe.WIDTH / 2, y3);
    }
}