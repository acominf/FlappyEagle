import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Enemies class has a function for the enemies to move left.
 * 
 * @author Hernan Casillas
 * @version 1.0
 */
public class Enemies extends Actor
{
    int xSpeed = 0;
    /**
     * Act - do whatever the Enemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void moveLeft(int xSpeed)
    {
        setLocation(getX() - xSpeed, getY());
    }
}
