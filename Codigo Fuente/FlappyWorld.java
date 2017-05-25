import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Flappy World is the main class where everything in the world happens.
 * 
 * @author Hernan Casillas
 * @version 1.6
 */
public class FlappyWorld extends World
{
    int pipeCounter = 0;
    int flappyCounter = 0;
    int score = 0;
    int FIRST_PIPE = 207;
    Score scoreObj = null;
    int ghostCounter = 0;
    int ghostCounterDown = 0;
    int piranhaCounter = 0;
    int friesCounter = 0;
    int burgerCounter = 0;
    int pizzaCounter = 0;
    
    private int bgSelection = Greenfoot.getRandomNumber(2);
    private final String fileNamePrefix = "background";
    private final String fileNameSuffix = ".png";
    
    public boolean showTitleScreen = true, showInstructionsScreen = false, showGameOverScreen = false, playGame = false, addFlappy = true, 
    titleObjectsAdded = false, playGameObjectsAdded = false, instructionsObjectsAdded = false, gameOverObjectsAdded = false;
    
    private Title logo = new Title();
    private Button startButton = new Button("start");
    private FlappyEagle gamePlayer = new FlappyEagle();
    private Instructions tap = new Instructions("tap");
    private Instructions getReady = new Instructions("getReady");
    private GameOver gameOverText = new GameOver();
    private ScoreCard card = new ScoreCard();
    private Button restartButton = new Button("restart");
    private Medal bronze = new Medal("bronze");
    private Medal silver = new Medal("silver");
    private Medal gold = new Medal("gold");
    private FoodScore foodScore = new FoodScore();
    private Ghost ghost = new Ghost();
    private Ghost[] ghosts = new Ghost[4]; 
    private Ghost[] ghostsDown = new Ghost[2];
    private Piranha[] piranhas = new Piranha[2];
    private Fries fries = new Fries();
    private Pizza pizza = new Pizza();
    private Burger burger = new Burger();
    
    /**
     * Constructor for objects of class FlappyWorld.
     * 
     */
    public FlappyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        Greenfoot.start();
        
        switch(bgSelection)
        {
            case 0: setBackground(new GreenfootImage(fileNamePrefix + 1 + fileNameSuffix));
            break;
            case 1: setBackground(new GreenfootImage(fileNamePrefix + 2 + fileNameSuffix));
        }
        
        //Set paint order
        setPaintOrder(Transition.class, Score.class, GameOver.class, Medal.class, ScoreCard.class, Button.class, FlappyEagle.class, Ghost.class, Ground.class,
        Pipes.class, Piranha.class);
        
        
        // Create a Flappy Eagle object
        

        // Add flappy to our world
        //addObject(flappy, 50, getHeight()/2);
        
        Ground ground = new Ground();
        
        addObject(ground, getWidth()/2, getHeight()-20);
        
        scoreObj = new Score();
        //scoreObj.setScore(0);
        
    //    addObject(scoreObj, getWidth()/2, 50);
    }
    
    public void act()
    {
        createGround();
        
        if(showTitleScreen && !titleObjectsAdded)
        {
            addObject(new Transition("black"), getWidth()/2, getHeight()/2);
            addObject(logo, getWidth()/2, getHeight()/2 - 50);
            addObject(startButton, getWidth()/2, getHeight()/2 + 25);
            titleObjectsAdded = true;
        }
        else if(showInstructionsScreen && !instructionsObjectsAdded)
        {
            removeObject(logo);
            removeObject(startButton);
            addObject(new Transition("black"), getWidth()/2, getHeight()/2);
            addObject(getReady, getWidth()/2, getHeight()/2 - 75);
            addObject(foodScore, 75, 100);
            addObject(tap, getWidth()/2, getHeight()/2 + 10);
            instructionsObjectsAdded = true;
        }
        else if(playGame)
        {
            removeObject(getReady);
            removeObject(tap);
            removeObject(foodScore);
            
            if(!playGameObjectsAdded)
            {
                addObject(new Transition("black"), getWidth()/2, getHeight()/2);
                scoreObj.setScore(0);
                
                addObject(scoreObj, getWidth()/2, 50);  
                
                addObject(gamePlayer, 50, getHeight()/2);
                
                playGameObjectsAdded = true;
            }
            
            createAllPipes();
            
            spawnGhosts();
            spawnGhostsDown();
            
            spawnFries();
            
            spawnBurger();
            
            spawnPizza();
        }
        
        if(showGameOverScreen && !gameOverObjectsAdded)
        {
            playGame = false;
            addObject(new Transition("white"), getWidth()/2, getHeight()/2);
            addObject(gameOverText, getWidth()/2, getHeight()/2-125);
            addObject(card, getWidth()/2, getHeight()/2 - 10);
            addObject(restartButton, getWidth()/2, getHeight()/2 +100);
            
            scoreObj.setLocation(378, 198);
            
            if(getScore() >= 10 && getScore() < 25)
            {
                addObject(bronze, 237, 194);
            }
            else if(getScore() == 25)
            {
                removeObject(bronze);
            }
            else if(getScore() >= 25 && getScore() < 50)
            {
                addObject(silver, 237, 194);
            }
            else if(getScore() >= 50)
            {
                addObject(gold, 237, 194);
            }
            
            gameOverObjectsAdded = true;
        }
        
        
    }
    
    /**
     * A method that spawn ghosts in the world
     */
    public void spawnGhosts()
    {        
        ghostCounter++;
        
        if(ghostCounter % 200 == 0)
        {
            for(int i = 0; i < ghosts.length; i++)
            {
                ghosts[i] = new Ghost();
                int ghostX = getRandomNumber(getWidth()/2 ,getWidth());
                int ghostY = getRandomNumber(0 ,100);
                addObject(ghosts[i], ghostX, ghostY);
            }
        }
    }
    
    /**
     * A method that spawn ghosts down in the world
     */
    public void spawnGhostsDown()
    {        
        ghostCounterDown++;
        
        if(ghostCounterDown % 400 == 0)
        {
            for(int i = 0; i < ghostsDown.length; i++)
            {
                ghostsDown[i] = new Ghost();
                int ghostX = getRandomNumber(getWidth()/2 ,getWidth());
                int ghostY = getRandomNumber(300, 350);
                addObject(ghostsDown[i], ghostX, ghostY);
            }
        }
    }

    /**
     * A method that creates the ground in the world
     */
    public void createGround()
    {
        if(getObjects(Ground.class).size() < 2)
        {
            Ground additionalGround = new Ground();
            addObject(additionalGround, 900, getHeight()-20);
        }
    }
    
    /**
     * A method that creates all the pipes in the world randomly
     */
    public void createAllPipes()
    {
        pipeCounter++;
        
        int random = 0;
        
        if(pipeCounter % 60 == 0)
        {
           Pipes botPipe = new Pipes("bottom");
           Pipes topPipe = new Pipes("top");
           Piranha piranha = new Piranha();
        
           int pipeSpacing = 130;
           
           GreenfootImage image = botPipe.getImage();
           GreenfootImage image2 = piranha.getImage();
           
           int numOfPipes = Greenfoot.getRandomNumber(10) + 4;
           
        
           if(pipeCounter % 60 == 0)
           {
                   addObject(botPipe, getWidth(), getHeight() /2 + image.getHeight() - (random = Greenfoot.getRandomNumber(100)) - 10);
                   addObject(topPipe, getWidth(), botPipe.getY() - image.getHeight() - pipeSpacing);
                   if(pipeCounter % 240 == 0)
                   {
                       addObject(piranha, getWidth(), getHeight() /2 + image.getHeight() - random - 150);
                   }
                   
           }
        }
        
        if(pipeCounter >= FIRST_PIPE)
        {
            if(flappyCounter % 60 == 0)
            {
                score++;
                Greenfoot.playSound("sfx_point.wav");
                scoreObj.setScore(score);
            }
            flappyCounter++;
        }
    }
    
    /**
     * A method that spawn piranhas in the world
     */
    public void spawnPiranha()
    {
        piranhaCounter++;
        
        if(piranhaCounter % 240 == 0)
        {   
           Pipes piranha = new Pipes("top");
        
           int pipeSpacing = 130;
           
           GreenfootImage image = piranha.getImage();
            
            for(int i = 0; i < piranhas.length; i++)
            {
                piranhas[i] = new Piranha();
                addObject(piranhas[i], getWidth(), getHeight() /2 + image.getHeight() - Greenfoot.getRandomNumber(100) - 10);
            }
        }
    }
    
    /**
     * A method that spawn Fries in the world
     */
    public void spawnFries()
    {        
        friesCounter++;
        
        
        if(friesCounter % 240 == 0)
        {
                int friesX = getRandomNumber(getWidth()/2-100 ,getWidth());
                int friesY = getRandomNumber(getHeight()/2 ,getHeight()/2+20);
                addObject(fries, friesX, friesY);
        }
        
    }
    
    /**
     * A method that spawn burgers in the world
     */
    public void spawnBurger()
    {        
        burgerCounter++;
        
        
        if(burgerCounter % 420 == 0)
        {
                int burgerX = getRandomNumber(getWidth()/2-100 ,getWidth());
                int burgerY = getRandomNumber(getHeight()/2 ,getHeight()/2+20);
                addObject(burger, burgerX, burgerY);
        }
        
    }
    
    /**
     * A method that spawn pizza in the world
     */
    public void spawnPizza()
    {        
        pizzaCounter++;
        
        
        if(pizzaCounter % 600 == 0)
        {
                int pizzaX = getRandomNumber(getWidth()/2+100, getWidth());
                int pizzaY = getRandomNumber(100, 300);
                
                addObject(pizza, pizzaX, pizzaY);
        }
        
    }
    
    /**
     * A method to get the score
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * A method that gives you a random number between 2 numbers
     * 
     * @param first number
     * @param second number
     */
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }
}
