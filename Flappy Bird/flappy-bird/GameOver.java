import greenfoot.*;  
import java.awt.*;
public class GameOver extends Actor {
    
    /**
     * Creates a game over board.
     * 
     * @Return Nothing is returned
     * @param score the score
     */
    public GameOver(int score) 
    {
        GreenfootImage text = new GreenfootImage("Game Over\nScore: " + score, 40, Color.WHITE, new Color(0, 0, 0, 0));
        GreenfootImage image = new GreenfootImage(text.getWidth() + 20, text.getHeight() + 20);
        image.setColor(new Color(255, 255, 255, 128));
        image.fill();
        image.drawImage(text, 10, 10);
        setImage(image);
    }
}