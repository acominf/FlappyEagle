import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pipes class
 * 
 * @author Hernan Casillas
 * @version 1.2
 */
public class Pipes extends Actor
{
    private static final GreenfootImage Bottom = new GreenfootImage("bottom_pipe.png");
    private static final GreenfootImage Top = new GreenfootImage("top_pipe.png");
    int speed = 4;
    
    
    public Pipes(String selection)
    {   
        if(selection == "top")
            setImage(Top);
        else if(selection == "bottom")
            setImage(Bottom);
    }
    
    /**
     * Act - do whatever the Pipes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - 4, getY());
        removePipes();
    }
    
    /**
     * A method that removes the pipes when they pass the screen.
     */
    public void removePipes()
    {
        if(getX() < -getImage().getWidth())
            getWorld().removeObject(this);
            
    }
}
