import greenfoot.*;

/**
 * Write a description of class Line here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Line extends Actor
{
    /**
     * Line is the constructor for new objects of class Line
     * 
     * @param None There are no parameters
     * @return an object of class Line
     */
    public Line()
    {
        GreenfootImage img = new GreenfootImage(15,80);
        img.setColor(Color.WHITE);
        img.fill();
        setImage(img);
    }
    
    /**
     * Act - do whatever the Line wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveDown();
        
        checkReachedBottom();
    }    
    
    /**
     * moveDown is the method that changes the location 
     * of the Line to move down
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void moveDown()
    {
        setLocation( getX(), getY() + 2 );
    }
    
    /**
     * checkReachedBottom checks whether the Line has
     * reached the bottom of the world. If it has,
     * remove the Line from the world.
     */
    private void checkReachedBottom()
    {
        if( getY() >= getWorld().getHeight() - 1 )
        {
            getWorld().removeObject(this);
        }
    }
}
