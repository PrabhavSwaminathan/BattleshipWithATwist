import java.util.Scanner;
import java.util.ArrayList;

/**
 * A class that imports the Ship class and creates an ArrayList of class Ship.
 * @author Prabhav Swaminathan
 * @version 2018.21.10
 */
public class ShipList
{
    //ArrayList of class Ship
    private ArrayList<Ship> ships;
    
    /**
     * Default Constructor for objects of class ShipList
     */
    public ShipList()
    {
        ships = new ArrayList<Ship>();
    }
    
    /**
     * Used to add the number of hits made to the ship
     * @param index is used to match the index of ship being reffered to in the game class.
     * @param multipleHits is calling the multipleHitsAllowed attribute whose value is extracted from the text file.
     */     
    public void addHitsMade(int index, boolean multipleHits)
    {
        Ship s = new Ship();
        for(int i = 0; i < getNoOfShip(); i++)
        {
            
            if(index == i)
            {   s = ships.get(i);
                //If multipleHits is true then after ship is hit, no of hits needed decreases by 1 and number of hits made increases by 1
                if(multipleHits == true) 
                {
                    s.setNoOfHitsMade(s.getNoOfHitsMade()+1);
                    s.setNoOfHitsNeeded(s.getNoOfHitsNeeded()-1);
                    break;
                }
                //If multipleHits is false then after ship is hit it is completely destroyed. Number of Hits becomes 1 and the number of hits needed becomes 0.
                else
                {
                    s.setNoOfHitsMade(1);
                    s.setNoOfHitsNeeded(0);
                    break;
                }
            }
        }
    }
    
    /**
     * Used to add ship to ArrayList
     * @param shipName is used to add ship name.
     * @param xPos is used to add the the x Coordinate of the ship
     * @param yPos is used to add the the x Coordinate of the ship
     * @param noOfHits Needed is used to add the number of hits needed to destroy the ship
     */    
    public void addShip(String shipName, int xPos, int yPos, int noOfHitsNeeded)
    {
        Ship s = new Ship();
        Scanner console = new Scanner(System.in);
        s.setShipName(shipName);
        s.setxPos(xPos);
        s.setyPos(yPos); 
        s.setNoOfHitsNeeded(noOfHitsNeeded);
        ships.add(s);
    }

     /**
     * To display all ships on a given board. Although it uses a temporary 2D Array, each time the program is executed,
     * it picks the values from the input text file, so the value of grid size changes accordingly.
     * @param gridSize is used to get the gridSize from the input text file.
     * @param visible is used to check the visibilty of the computer ships {true - visible, false - not visible}
     */            
    public void dispCoordinates(int gridSize, boolean visible)
    {
        String[][] pos = new String[gridSize][gridSize];
        for(int i = 0; i < gridSize; i++)
        {
            for(int j = 0; j < gridSize; j++)
            {
                pos[i][j] = "NULL";
            }
        }
        
        for(int i = 0; i < getNoOfShip(); i++)
        {
            Ship s = new Ship(); 
            s = ships.get(i);
            pos[s.getxPos()][s.getyPos()] = " O ";
        }

        for(int i = 0; i < gridSize; i++)
        {
            for(int j = 0; j < gridSize; j++)
            {
                if(pos[i][j].equals(" O "))
                {
                    System.out.print(shipSymbol(i,j,visible)); 
                }
                else
                    System.out.print(" ~ ");
            }
            System.out.println("");
        }
    }
    
    /**
    * To get the value of number of hits made at a given index.
    * @param index is used to get the value of number of hits made at a given index.
    * @return value returns the value of number of hits made at a given index.
    */              
    public int getHitsMade(int index)
    {
        int value = 0;
        Ship s = new Ship();
        for(int i = 0; i < getNoOfShip(); i++)
        {
            if(index == i)
            {
                s = ships.get(i);
                value = s.getNoOfHitsMade();
            }
        }
        return value;
    }
    
    /**
    * To get the value of number of hits needed at a given index.
    * @param index is used to get the value of number of hits needed at a given index.
    * @return value returns the value of number of hits needed at a given index.
    */         
    public int getHitsNeeded(int index)
    {
        int value = 0;
        Ship s = new Ship();
        for(int i = 0; i < getNoOfShip(); i++)
        {

            if(index == i)
            {
                s = ships.get(i);
                value = s.getNoOfHitsNeeded();
            }
        }
        return value;
    }
            
    /**
     * To get the number of ships in arrayList at any given time.
     * @return ships.size() returns the value of the number of elements in the array list.
     */     
    public int getNoOfShip()
    {
        return ships.size();
    }
    
    /**
    * To get the x coordinate of a ship at a given index.
    * @param index is used to get the x coordinate of a ship at a given index.
    * @return value returns the value of x coordinate of a ship at a given index.
    */         
    public int getPosX(int index)
    {
        int value = 0;
        Ship s = new Ship();
        for(int i = 0; i < getNoOfShip(); i++)
        {
            s = ships.get(i);
            if(index == i)
            {
                value = s.getxPos();
            }
        }
        return value;
    }
    
    /**
    * To get the y coordinate of a ship at a given index.
    * @param index is used to get the y coordinate of a ship at a given index.
    * @return value returns the value of y coordinate of a ship at a given index.
    */         
    public int getPosY(int index)
    {
        int value = 0;
        Ship s = new Ship();
        for(int i = 0; i < getNoOfShip(); i++)
        {
            s = ships.get(i);
            if(index == i)
            {
                value = s.getyPos();
            }
        }
        return value;
    }
    
    /**
     * To display all values of the ship objects in the ArrayList
     */         
    public void listShip()
    {
        Ship s = new Ship();
        for(int i = 0; i < getNoOfShip(); i++)
        {
           s = ships.get(i);
           s.shipDetailsDisplay();
        }
    }

    /**
     * To remove ship at index in arrayList.
     * @param index is used to remove ship at a given index from the ArrayList
     */         
    public void removeShip(int index)
    {
        ships.remove(index);        
    }
     
    /**
    * To find the specific symbol at a given location of a ship on the grid. Like D{Damaged}, O{Not hit}, X{Destroyed}, ~{Water or Ships Hidden in Water}
    * @param x is used to pass the x coordinate of a given ship.
    * @param y is used to pass the x coordinate of a given ship.
    * @param visivle is used to check whether computer ships are visible or not.
    * @return str returns the particular symbol that should be used at a particular ship position.
    */        
    public String shipSymbol(int x, int y, boolean visible)
    {
        String str = new String();
        Ship s = new Ship();
        int hits_made = 0, hits_needed = 0;
        for(int i = 0; i < getNoOfShip(); i++)
        {
           s = ships.get(i);
           if(x == s.getxPos() && y == s.getyPos())
           {
               hits_needed =  s.getNoOfHitsNeeded();
               hits_made  = s.getNoOfHitsMade();
           }      
        }
        
        if(hits_needed == 0)     
            str=" X ";
        else if(hits_made > 0) 
            str=" D "; 
        else
            if(visible == true)
                str = " O ";
            else if(visible == false)
                str = " ~ ";
        return str;
    }
}
