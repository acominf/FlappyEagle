import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends GameStuff
{
    int speed = 0;
    private static final GreenfootImage transition = new GreenfootImage(600, 400);
    private static final int fadeUpperLimit = 255;
    private static final int fadeLowerLimit = 25;
    
    
    public Transition(String selection)
    {
        if(selection == "black")
        {
            speed = 3;
            transition.setColor(Color.BLACK);
        }
        else if(selection == "white")
        {
            speed = 3;
            transition.setColor(Color.WHITE);
        }
        transition.fill();
        setImage(transition);
        transition.setTransparency(fadeUpperLimit);
    }
    
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        fadeOut();
    }
    
    public void fadeOut()
    {
        transition.setTransparency(transition.getTransparency() - speed);
        if(transition.getTransparency() <= fadeLowerLimit)
            getWorld().removeObject(this);
    }
}
