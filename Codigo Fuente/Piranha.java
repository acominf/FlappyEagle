import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Piranha class
 * 
 * @author Hernan Casillas
 * @version 1.1
 */
public class Piranha extends Enemies
{
    private GreenfootImage image1, image2;
    int animFrame = 1;
    int animCounter = 0;
    
    public Piranha()
    {
        image1 = new GreenfootImage("sprite_0.png");
        image2 = new GreenfootImage("sprite_1.png");
        setImage(image1);
    }
    
    /**
     * Act - do whatever the Piranha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveLeft(4);
        
        animCounter++;
        
        if(animCounter % 9 == 0)
            animate();
    }    
    
    /**
     *  A method to animate the piranha
     */
    public void animate()
    {
        if(animFrame == 1)
            setImage(image1);
        else if(animFrame == 2)
        {
            setImage(image2);
            animFrame = 0;
        }   
            animFrame++;
    }
}
