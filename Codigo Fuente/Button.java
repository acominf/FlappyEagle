import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends GameStuff
{
    private String selection;
    
    public Button(String selection)
    {
        this.selection = selection;
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(selection == "restart")
        {
            restartGame();
        }
        else if(selection == "start")showInstructions();
    }
    
    public void restartGame()
    {
        if(Greenfoot.mouseClicked(this) == true)
        {
            Greenfoot.setWorld(new FlappyWorld());
        }
    }
    
    public void showInstructions()
    {
        if(Greenfoot.mouseClicked(this) == true || "space".equals(Greenfoot.getKey()))
        {
            FlappyWorld level = (FlappyWorld)getWorld();
            level.showInstructionsScreen = true;
        }
    }
}
