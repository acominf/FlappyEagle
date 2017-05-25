import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends GameStuff
{
    public static final GreenfootImage getReadyText = new GreenfootImage("instructions_ready.png");
    public static final GreenfootImage tap = new GreenfootImage("instructions_tap.png");
    
    public Instructions(String selection)
    {
        if(selection == "getReady")setImage(getReadyText);
        else if(selection == "tap")setImage(tap);
    }
    /**
     * Act - do whatever the Instructions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        playGameNow();
    }    
    
    public void playGameNow()
    {
        if(Greenfoot.mouseClicked(this) == true || "space".equals(Greenfoot.getKey()))
        {
            FlappyWorld level = (FlappyWorld)getWorld();
            level.playGame = true;
        }
    }
}

