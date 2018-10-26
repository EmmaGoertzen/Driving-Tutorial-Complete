import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class House extends Actor
{
    /**
     * House is the constructor for objects of class House
     * 
     * @param None There are no parameters
     * @return An object of class House is returned
     */
    public House()
    {
        getImage().scale(100, 100);
    }
    
    /**
     * Act - do whatever the House wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveDown();
        
        checkReachedBottom();
    }    
    
    /**
     * moveDown is the method that moves the Houses down
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
    
    /**
     * housesOrTreesInRange checks whether there are trees
     * or houses in a 100 pixel radius of this house
     * 
     * @param None There are no parameters
     * @return A boolean that represents whether there are houses or trees in range or not
     */
    public boolean housesOrTreesInRange()
    {
        //A variable that stores how many houses are in a 100 pixel range of this House
        int numHousesInRange = getObjectsInRange(100, House.class).size();
        
        //A variable that stores how many trees are in a 100 pixel range of this House
        int numTreesInRange = getObjectsInRange(100, Tree.class).size();
        
        //A variable that stores the total number of trees and houses in range of this house
        int totalNumberInRange = numHousesInRange + numTreesInRange;
        
        //Will return true if there are trees or houses in the range of this house
        return totalNumberInRange != 0;
    }
}
