import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Car here.
 */ 

public class Car extends Actor
{
    //An integer to represent the damage sustained by the Car
    private int damage = 0;
    
    //An integer that only allows the Car to gain damage after 75 act cycles have passed
    private int damageDelay = 75;
    
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        if( Greenfoot.isKeyDown("right") )
        {
            moveRight(); 
        }
        
        if( Greenfoot.isKeyDown("left") )
        {
            moveLeft();
        }
        
        if( Greenfoot.isKeyDown("up") )
        {
            moveUp();
        }
        
        if( Greenfoot.isKeyDown("down") )
        {
            moveDown();
        }
        
        checkCollision();
        
        damageDelay++;
    }

    /**
     * moveRight is the method that changes the location 
     * of the Car to move right
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void moveRight()
    {   
        //write code here
        setLocation( getX() + 2, getY() );
    }

    /**
     * moveLeft is the method that changes the location 
     * of the Car to move left
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void moveLeft()
    {   
        //write code here
        setLocation( getX() - 2, getY() );
    }

    /**
     * moveUp is the method that changes the location 
     * of the Car to move up
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void moveUp()
    {   
        //write code here
        setLocation( getX(), getY() - 2 );
    }  

    /**
     * moveDown is the method that changes the location 
     * of the Car to move down
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void moveDown()
    {   
        //write code here
        setLocation( getX(), getY() + 2 );
    }         

    /**
     * checkCollision checks to see if the Car has collided
     * with another Vehicle. If it has, play a crash sound,
     * display text saying the player crashed, and stops
     * the scenario.
     */
    private void checkCollision()
    {
        //write code here
        Actor collided = getOneIntersectingObject( Vehicle.class );
        
        if( collided != null && damageDelay >= 75 )
        {
            Greenfoot.playSound("Explosion.wav");
            damage += 10;
            damageDelay = 0;
        }
        
        if( damage >= 100 )
        {
            getWorld().showText("YOU CRASHED!!!", getWorld().getWidth()/2, getWorld().getHeight()/2 );
            Greenfoot.stop();
        }
    }

}
