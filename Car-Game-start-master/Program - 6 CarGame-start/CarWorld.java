import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarWorld extends World
{
    //A counter that records when a new line should be added
    private int lineCounter = 0;
    
    //A variable to store the new House object
    private House newHouse;
    
    //A variable to store the new House's x location
    private int newHouseX;
    
    //A variable to store the new Vehicle
    private Vehicle newVehicle;
    
    /**
     * Constructor for objects of class CarWorld.
     * 
     */
    public CarWorld()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        setPaintOrder( Car.class, Vehicle.class, Line.class );
        
        prepare();
    }
    
    /**
     * Act - This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        //write code here
        addVehiclesRandomly();
        
        addTreesRandomly();
        
        addHousesRandomly();
        
        addLineByCounter();
        
        lineCounter++;
    }
    
    /**
     * prepare is the method that prepares CarWorld to be
     * played. It adds the player-controlled Car and the lines
     * for the road.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void prepare()
    {
        addObject( new Car(), 300, 575 );
        
        for( int i = 0; i <= getHeight(); i += 120 )
        {
            addObject( new Line(), 300, i );
        }
    }
    
    /**
     * addVehiclesRandomly adds the oncoming Vehicles
     * 2% of the time to the top of the World at a random
     * X location between 200 and 400.
     */
    private void addVehiclesRandomly()
    {
        if( Greenfoot.getRandomNumber(100) < 2 )
        {
            newVehicle = new Vehicle( Greenfoot.getRandomNumber(5) );
            addObject( newVehicle, Greenfoot.getRandomNumber(200) + 200, 0 );
            checkForVehicleOverlap();
        }
    }
    
    /**
     * addVehiclesRandomly adds the Trees
     * 2% of the time to the top of the World. 50% of the
     * time, it is added on the left side of the world and
     * the other 50% of the time, it is added on the right.
     */
    private void addTreesRandomly()
    {
        if( Greenfoot.getRandomNumber(100) < 2 )
        {
            if( Greenfoot.getRandomNumber(100) < 50 )
            {
                addObject( new Tree( Greenfoot.getRandomNumber(3) ), Greenfoot.getRandomNumber(160), 0 ); 
            }
            else
            {
                addObject( new Tree( Greenfoot.getRandomNumber(3) ), Greenfoot.getRandomNumber(160) + 440, 0 );
            }
        }
    }
    
    /**
     * addHousesRandomly adds houses 0.5714% of the time to the
     * world. 50% of that time, it is added to the left of
     * the world. The other 50% of the time it is added to
     * the right
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addHousesRandomly()
    {
        if( Greenfoot.getRandomNumber(175) < 1 )
        {
            newHouse = new House();
            
            if( Greenfoot.getRandomNumber(100) < 50 )
            {
                newHouseX = Greenfoot.getRandomNumber(130);
            }
            else
            {
                newHouseX = Greenfoot.getRandomNumber(130) + 470;
            }
            
            addObject( newHouse, newHouseX, 0 );
            
            checkForHouseOrTreeOverlaps();
        }
    }
    
    /**
     * addLineByCounter adds a new Line to the world based
     * on a counter that counts how many act cycles have passed.
     * After 60 act cycles, the Lines have moved 120 pixels,
     * which means we must add a new Line to the top of the world.
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void addLineByCounter()
    {
        if( lineCounter >= 60 )
        {
            addObject( new Line(), 300, 0 );
            lineCounter = 0;
        }
    }
    
    /**
     * checkForHouseOrTreeOverlaps checks if there are houses
     * or trees already placed where the new house will be placed
     * and removes the new house we have placed if there are
     * already objects there
     */
    private void checkForHouseOrTreeOverlaps()
    {
        boolean houseOrTreeInRange = newHouse.housesOrTreesInRange();
        
        if( houseOrTreeInRange == true )
        {
            removeObject(newHouse);
        }
    }
    
    /**
     * checkForVehicleOverlap checks to see if there is already a Vehicle
     * in the range of the new vehicle that is being added to the world. If so,
     * remove that new vehicle
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkForVehicleOverlap()
    {
        boolean vehiclesInRange = newVehicle.vehicleInRange();
        
        if( vehiclesInRange == true )
        {
            removeObject( newVehicle );
        }
    }
}
