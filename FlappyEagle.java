import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * FlappyEagle class is for everything that happens within the player
 * 
 * @author Hernan Casillas
 * @version 1.6
 */
public class FlappyEagle extends Actor
{
    double dy = 0;
    private static final double g = .5;
    double BOOST_SPEED = -6;
    private GreenfootImage image1, image2;
    int animFrame = 1;
    int animCounter = 0;
    private int initialDelay;
    GreenfootSound wing = new GreenfootSound("sfx_wing.wav");
    GreenfootSound star = new GreenfootSound("StarSound.mp3");
    boolean invencible = false;
    int invencibleCounter = 0;
    
    /**
     * Constructor
     */
    public FlappyEagle()
    {
        image1 = new GreenfootImage("kirby_0.png");
        image2 = new GreenfootImage("kirby_1.png");
        setImage(image1);
    }
    
    /**
     * Act - do whatever the FlappyEagle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        initialDelay++;
        
        animCounter++;
        
        if(invencible == true)
        {
            invencibleCounter++;
            if(invencibleCounter == 560)
            {
                invencible = false;
                invencibleCounter = 0;
            }
        }
        
        
        if(animCounter % 9 == 0)
            animate();
        
        if(initialDelay >= 50)
        {
            applyGravity();

            checkCollision();        

            checkKey();
        
            rotateFlappy();
        
        }
    }
    
    /**
     *  A method to verify if the space is pressed and it plays a sound.
     */
    public void checkKey()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            dy = BOOST_SPEED; 
            wing.play();
        }
    }
    
    /**
     *  A method to rotate the player depending on the velocity
     */
    public void rotateFlappy()
    {   
        
        if(dy < 1)
            setRotation(-30);
        else if(dy < 0)
            setRotation(0);
        else if(dy < 12)
            setRotation(30);
        else if(dy < 30)
            setRotation(90);
    }
    
    /**
     * A method to add the player's physics
     */
    public void applyGravity()
    {
        setLocation(getX(), (int)(getY() + dy));
        dy = dy + g;
    }
    
    
    /**
     *  A method that stops the game 
     */
    public void gameOver()
    {
        GameOver gameOver = new GameOver();
        getWorld().addObject(gameOver, getWorld().getWidth()/2, getWorld().getHeight()/2);
        Greenfoot.stop();
    }
    
    /**
     * A method to animate the player 
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
    
    
    /**
     *  A method to verify if the player crashes with anything
     */
    public void checkCollision()
    {
        Actor Ground = getOneIntersectingObject(Ground.class);
        Actor Pipes = getOneIntersectingObject(Pipes.class);
        Actor Ghost = getOneIntersectingObject(Ghost.class);
        Actor Piranha = getOneIntersectingObject(Piranha.class);
        Actor Fries = getOneIntersectingObject(Fries.class);
        Actor Burger = getOneIntersectingObject(Burger.class);
        Actor Pizza = getOneIntersectingObject(Pizza.class);
        
        if(invencible == false)
        {
            if(Pipes != null)
            {
                Greenfoot.playSound("sfx_hit.wav");
                FlappyWorld level = (FlappyWorld)getWorld();
                level.showGameOverScreen = true;
                getWorld().removeObject(this);
            }
            else if(Ghost != null || Piranha != null)
            {
                Greenfoot.playSound("sfx_hit.wav");
                FlappyWorld level = (FlappyWorld)getWorld();
                level.showGameOverScreen = true;
                getWorld().removeObject(this);
            }
        }
        if(Ground != null)
            {
                //setLocation(getX(), 340);
                Greenfoot.playSound("sfx_hit.wav");
                FlappyWorld level = (FlappyWorld)getWorld();
                level.showGameOverScreen = true;
                getWorld().removeObject(this);
                star.stop();
            }
        else if(Fries != null)
        {
            Greenfoot.playSound("sfx_point.wav");
            FlappyWorld level = (FlappyWorld)getWorld();
            level.score++;
            level.scoreObj.setScore(level.score);
            getWorld().removeObject(Fries);
        }
        else if(Burger != null)
        {
            Greenfoot.playSound("sfx_point.wav");
            FlappyWorld level = (FlappyWorld)getWorld();
            level.score = level.score + 3;
            level.scoreObj.setScore(level.score);
            getWorld().removeObject(Burger);
        }
        else if(Pizza != null)
        {
            star.play();
            star.setVolume(100);
            FlappyWorld level = (FlappyWorld)getWorld();
            level.score = level.score + 5;
            level.scoreObj.setScore(level.score);
            getWorld().removeObject(Pizza);
            invencible = true;
        }
        
        
    }
    
}
