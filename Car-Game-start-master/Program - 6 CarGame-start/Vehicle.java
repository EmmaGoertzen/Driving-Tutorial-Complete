import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vehicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vehicle extends Actor
{
    //Instance variables that store the possible images for the vehicles
    private GreenfootImage speedster = new GreenfootImage("speedster.png");
    private GreenfootImage police = new GreenfootImage("police.png");
    private GreenfootImage ambulance = new GreenfootImage("ambulance-n.png");
    private GreenfootImage familyCar = new GreenfootImage("family-car.png");
    
    /**
     * Vehicle is the constructor for objects of type Vehicle
     * 
     * @param imageNumber The number than corresponds to a randomized image for vehicle
     * @return An object of type Vehicle
     */
    public Vehicle(int imageNumber)
    {
        initializeImages();
        
        if( imageNumber == 0 )
        {
            setImage("car01.gif");
        }
        else if( imageNumber == 1 )
        {
            setImage( familyCar );
        }
        else if( imageNumber == 2 )
        {
            setImage( police );
        }
        else if( imageNumber == 3 )
        {
            setImage( ambulance );
        }
        else
        {
            setImage( speedster );
        }
    }
    
    /**
     * Act - do whatever the Vehicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveDown();
        
        checkReachedBottom();
    }
    
    /**
     * initializeImages alters the images defined above
     * to ensure they all have the same format
     * (i.e. looking down and the same size)
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void initializeImages()
    {
        familyCar.mirrorVertically();
        ambulance.mirrorVertically();
        
        ambulance.scale(36, 77);
        familyCar.scale(36, 77);
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
        setLocation( getX(), getY() + 3 );
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
     * vehicleInRange checks to see if there are any Vehicles in a 80 pixel radius
     * of this Vehicle
     * 
     * @param None There are no parameters
     * @return A boolean that represents if there are vehicles in range
     */
    public boolean vehicleInRange()
    {
        int numVehiclesInRange = getObjectsInRange(80, Vehicle.class).size();
        
        return numVehiclesInRange > 0;
    }
    
    
    
}
