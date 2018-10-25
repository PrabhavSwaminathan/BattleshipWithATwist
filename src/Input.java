import java.util.Random;
import java.util.Scanner;

/**
 * A class that is used to take input from the player. 
 * @author Prabhav Swaminathan
 * @version 2018.21.10
 */
public class Input
{
    /**
     * To add hull strength of ship, which is assigned randomly from 1 to 5 
     * @return hullStrength returns the value of hullStrength { hullStrength is the Number of hits needed}
     */
    public int addHullStrength()
    {
        Random rand = new Random();
        int  hullStrength = rand.nextInt(5) + 1; 
        return hullStrength;
    }

    /**
     * To add name of ship 
     * @return name returns the name of the ship
     */    
    public String addName()
    {
        Scanner console = new Scanner(System.in);
        String shipName = "";        
        System.out.println("Enter name of Ship: ");
        shipName = console.nextLine();
        return shipName; 
    } 
    
    /**
     * To add x coordinate of the ship 
     * @return xPos returns the x coordinate of the ship
     */       
    public String addxPosition()
    {
        Scanner console = new Scanner(System.in);
        String xPos = "";
        System.out.println("Enter the X coordinate of the ship");
        xPos = console.nextLine();
        return xPos;
    }
    
    /**
     * To add y coordinate of the ship 
     * @return yPos returns the y coordinate of the ship
     */      
    public String addyPosition()
    {
        Scanner console = new Scanner(System.in);
        String yPos = "";
        System.out.println("Enter the Y coordinate of the ship");
        yPos = console.nextLine();
        return yPos;
    }
}
