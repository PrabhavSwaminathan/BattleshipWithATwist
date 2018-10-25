import java.util.Random;
import java.util.Scanner;

public class CoordinateGenerator
{
    private int minimumValue;
    private int maximumValue;
   
    /**
     * Default Constructor for objects of class CoordinateGenerator
     */
    public CoordinateGenerator()
    {
        minimumValue = 0;
        maximumValue = 0;
    }
    
    /**
     * Parameterized Constructor for objects of class CoordinateGenerator
     * @param minimumValue sets the minimum value.
     * @param maximumValue sets the maximum value.
     */
    public CoordinateGenerator(int minimumValue, int maximumValue)
    {
        this.minimumValue = minimumValue;        
        this.maximumValue = maximumValue;
    }
    
    /**
     * Returns the integer value of Minimum Value.
     * @return the integer value of Minimum Value.
     */
    public int getMinimumValue()
    {
        return minimumValue;        
    }
    
    /**
     * Returns the integer value of Maximum Value.
     * @return the integer value of Maximum Value.
     */
    public int getMaximumValue()
    {
        return maximumValue;        
    }
    
    /**
     * Sets the value of Minimum Value.
     * @param minimumValue Value of Minimum Value is set.
     */
    public void setMinimumValue(int minimumValue)
    {
        this.minimumValue = minimumValue;
    }
    
    /**
     * Sets the value of Maximum Value.
     * @param maximumValue Value of Maximum Value is set.
     */
    public void setMaximumValue(int maximumValue)
    {
        this.maximumValue = maximumValue;
    }
    
    /**
     * Generates value of the coordinate within the grid size.
     * @param gridSize Value of grid size is set.
     */    
    public int generateCoordinate(int gridSize)
    {
        Random rand = new Random();
        setMinimumValue(0);
        setMaximumValue(gridSize-1);
        int  num = rand.nextInt(getMaximumValue()) + getMinimumValue(); 
        return num;
    }
    
}
