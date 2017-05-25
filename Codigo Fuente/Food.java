import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food class is the father of every food
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    int xSpeed = 0;
    
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }   
    
    /**
     *  A method to move the food to the left.
     *  @param xSpeed is how fast do you want every food to move.
     */
    public void moveLeft(int xSpeed)
    {
        setLocation(getX() - xSpeed, getY());
    }
}
