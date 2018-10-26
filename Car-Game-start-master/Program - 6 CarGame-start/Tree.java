import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Actor
{
    /**
     * Tree is the constructor for objects of class Tree
     * 
     * @param imageNumber The randomized image for the Tree
     * @return Nothing is returned
     */
    public Tree(int imageNumber)
    {   
        if( imageNumber == 0 )
        {
            setImage("tree.png");
        }
        else if( imageNumber == 1 )
        {
            setImage("tree2.png");
        }
        else
        {
            setImage("tree3.png");
        }
    }
    
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveDown();
        
        checkReachedBottom();
    }    
    
    /**
     * moveDown is the method that moves the Trees down
     * the screen
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void moveDown()
    {
        setLocation( getX(), getY() + 2 );
    }
    
    /**
     * checkReachedBottom checks to see whether the Vehicle
     * has reached the bottom of the screen. If it has,
     * remove this Vehicle from the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkReachedBottom()
    {
        if( getY() >= getWorld().getHeight() - 1 )
        {
            getWorld().removeObject(this);
        }
    }
}
