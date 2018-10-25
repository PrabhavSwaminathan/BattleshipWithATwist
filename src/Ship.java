/**
 * A class that all the attributes of the ArrayList.
 * It has the accessor methods, mutator methods and the display method.
 * @author Prabhav Swaminathan
 * @version 2018.21.10
 */
public class Ship
{
    //For storing the name of the ship
    private String shipName;
    //For storing the x coordinate of the ship
    private int xPos;
    //For storing the y coordinate of the ship
    private int yPos;
    //For storing the number of Hits made on the ship
    private int noOfHitsMade;
    //For storing the number of Hits Needed to destroy the ship
    private int noOfHitsNeeded;
    /**
     * Default Constructor for objects of class Ship
     */
    public Ship()
    {
        shipName = " ";
        xPos = 0;
        yPos = 0;
        noOfHitsMade = 0;
        noOfHitsNeeded = 0;
    }
    
    /**
     * Parameterized Constructor for objects of class Ship
     * @param shipName - To add name of ship
     * @param xPos - To add x Position of ship {With validation for negative values}
     * @param yPos - To add y Position of ship {With validation for negative values}
     * @param noOfHitsMade - To add the number of Hits made on the ship {With validation for negative values}
     * @param noOfHitsNeeded - To add the number of Hits Needed to destroy the ship {With validation for negative values}
     */
    public Ship(String shipName, int xPos, int yPos, int noOfHitsMade, int noOfHitsNeeded)
    {
        this.shipName = shipName;
        
        if(xPos >= 0)
            this.xPos = xPos;
        else
            this.xPos = 0;
            
        if(yPos >= 0)
            this.yPos = yPos;
        else
            this.xPos = 0;
            
        if(noOfHitsMade >= 0)
            this.noOfHitsMade = noOfHitsMade;
        else
            this.noOfHitsMade = 0;
            
        if(noOfHitsNeeded >= 0)
            this.noOfHitsNeeded = noOfHitsNeeded;
        else
            this.noOfHitsNeeded = 0;
    }
    
    /**
     * To get the number of hits made on the ship
     * @return noOfHitsMade returns the number of hits made on the ship
     */
    public int getNoOfHitsMade()
    {
        return noOfHitsMade;
    }
    
    /**
     * To get the number of hits needed to destroy the ship
     * @return noOfHitsNeeded returns the number of hits needed to destroy the ship
     */
    public int getNoOfHitsNeeded()
    {
        return noOfHitsNeeded;
    }
    
    /**
     * To get the mame of the ship
     * @return shipName returns the name of the ship
     */
    public String getShipName()
    {
        return shipName;
    }
    
    /**
     * To get the x Coordinate of the ship
     * @return xPos returns the x Coordinate of the ship
     */    
    public int getxPos()
    {
        return xPos;
    }
    
    /**
     * To get the y Coordinate of the ship
     * @return yPos returns the y Coordinate of the ship
     */    
    public int getyPos()
    {
        return yPos;
    }
    
    /**
     * Sets the value of number of hits made {With validation for negative values}
     * @param noOfHitsMade Value of number of hits made is set.
     */    
    public void setNoOfHitsMade(int noOfHitsMade)
    {
        if(noOfHitsMade >= 0)
            this.noOfHitsMade = noOfHitsMade;
        else
            this.noOfHitsMade = 0;
    }
    
    /**
     * Sets the value of number of needed {With validation for negative values}
     * @param noOfHitsNeeded Value of number of hits needed is set.
     */    
    public void setNoOfHitsNeeded(int noOfHitsNeeded)
    {
        if(noOfHitsNeeded >= 0)
            this.noOfHitsNeeded = noOfHitsNeeded;
        else
            this.noOfHitsNeeded = 0;
    }
    
    /**
     * Sets the name of the ship.
     * @param noOfHitsMade name of ship is set.
     */    
    public void setShipName(String shipName)
    {
        this.shipName = shipName;
    }
    
    /**
     * Sets the value of x Coordinate of Ship {With validation for negative values}
     * @param xPos Value of x Coordinate of Ship is set.
     */       
    public void setxPos(int xPos)
    {
        if(xPos >= 0)
            this.xPos = xPos;
        else
            this.xPos = 0;
    }
    
    /**
     * Sets the value of y Coordinate of Ship {With validation for negative values}
     * @param yPos Value of y Coordinate of Ship is set.
     */        
    public void setyPos(int yPos)
    {
        if(yPos >= 0)
            this.yPos = yPos;
        else
            this.yPos = 0;
    }
    
    /**
     * Displays the details of the ship.
     */
    public void shipDetailsDisplay()
    {
        System.out.println("Name of Ship is "+getShipName());
        System.out.println("X Coordinate of Ship is "+getxPos());
        System.out.println("Y Coordinate od Ship is "+getyPos());
        System.out.println("Number of Hits made "+getNoOfHitsMade());
        System.out.println("Total Number of Hits Needed "+getNoOfHitsNeeded());
    }
}