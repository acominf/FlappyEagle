import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Score class
 * 
 * @author Hernan Casillas
 * @version 1.0
 */
public class Score extends Actor
{
    public Score()
    {
        GreenfootImage newImage = new GreenfootImage(100, 50);
        
        newImage.setColor(greenfoot.Color.BLUE);
        newImage.fill();
        setImage(newImage);
    }
    
    public void setScore(int score)
    {
        GreenfootImage newImage = getImage();
        newImage.clear();
        
        Font f = new Font("Impact", false, false, 50);
        newImage.setFont(f);

        newImage.setColor(greenfoot.Color.WHITE);
        newImage.drawString("" + score, 25, 40);
        
        setImage(newImage);
        
    }
}
