import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Just a class to put the ground in the game
 * 
 * @author Hernan Casillas 
 * @version 1.0
 */
public class Ground extends GameStuff
{
    int speed = 3;
    /**
     * Act - do whatever the Ground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX() - speed, getY());
        removeGround();
    }    
    
    private void removeGround()
    {
        if(getX() < - getImage().getWidth()/2)
        {
            getWorld().removeObject(this);
        }
    }
}
