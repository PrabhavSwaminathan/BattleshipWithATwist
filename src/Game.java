import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that imports the ShipList class, the CoordinateGenerator class, the FileIO Class, the input class and the Validation class.
 * It has the menu method from which the program runs.
 * @author Prabhav Swaminathan
 * @version 2018.21.10
 */
public class Game
{
    //ArrayList of player ships
    private ShipList playerShips;
    //ArrayList of computer ships
    private ShipList computerShips;
    //Object of CoordinateGenerator class to generate coordinates randomly
    private CoordinateGenerator coordinate;
    //An object of FileIO class to read from files and write to files
    private FileIO fileio;
    //Object of input class to accept input from the user
    private Input input;
    //Object of Validation class to validate user input
    private Validation validate;
    // To find out the winner of the game
    static int Winner = -1;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        playerShips = new ShipList();
        computerShips = new ShipList();
        coordinate = new CoordinateGenerator();
        fileio = new FileIO();
        input = new Input();
        validate = new Validation();
    }

    /**
     * To add computer ships.
     */
    public void addComputerShip()
    {
        System.out.println("Adding Computer Ship");
        int xPos = 0;
        int yPos = 0;
        int hullStrength = 0;
        int index = 0;
        boolean check_1 = true; // check_1 for checking the computer ship coordinates
        boolean check_2 = true; // check_2 for checking the player ship coordinate
        while(index < readNoOfShips())
        {
            check_1 = true;
            check_2 = true;
            while(check_1 || check_2)
            {
                xPos = coordinate.generateCoordinate(readGridSize());
                yPos = coordinate.generateCoordinate(readGridSize());
                check_1 =  checkCoordinateComputerShips(xPos,yPos);
                check_2 = checkCoordinatePlayerShips(xPos,yPos);
            }

            hullStrength = input.addHullStrength(); //To randomly generate hull strength
            computerShips.addShip("Computer Ship",xPos, yPos, hullStrength); //To add values to ArrayList of Computer Ships
            index++; //To increment the index for adding new elements to the ArrayList
        }
        computerShips.dispCoordinates(readGridSize(),readComputerShipsVisible()); //Method to display the grid with all the  computer ships on it
    }

    /**
     * Used to display the additional menu when either computer hits or player hits
     * @param roundNumber used to see what round of the game is going on
     */
    public void additionalMenu(int roundNumber)
    {
        System.out.println("Beginning Round "+roundNumber);
        System.out.println("Player Score: "+playerScoreCalc());
        System.out.println("Computer Score: "+computerScoreCalc());
    }

    /**
     * To add player ships.
     */
    public void addPlayerShip() // Method to add the Player Ships
    {
        Scanner console = new Scanner(System.in);
        boolean nameChk = true;
        boolean result =  true;
        int xPos = 0;
        int yPos = 0;
        String name = "";
        int hullStrength = 0;
        int index = 0;
        while(index < readNoOfShips()) //readNoOfShips methof reads the total number of Ships from the text file
        {
            nameChk = true;
            result =  true;
            System.out.println("\nPlease enter the details for the "+(index+1)+" ship");

            while(nameChk)
            {
                name = input.addName(); //To add name of the ship
                if(validate.checkName(name) == false)
                    nameChk = true;
                else
                    nameChk = false;
            }

            while(result)
            {
                xPos = checkxPos(); // To take x Position input from user
                yPos = checkyPos(); // To take x Position input from user
                result = checkCoordinatePlayerShips(xPos, yPos); // To check whether coordinates are being repeated or not
                if(result)
                    System.out.println("Enter unique coordinates");
            }
            hullStrength = input.addHullStrength(); //Method to randomly generate Hull Strength of the Ships
            playerShips.addShip(name, xPos, yPos, hullStrength); //To add user values to the playerShips ArrayList
            index++; //To increment the index for adding new elements to the ArrayList
        }
        playerShips.dispCoordinates(readGridSize(),true); //Method to display the grid with all the player ships on it
    }

    /**
     * Checks whether the input coordinates match existing coordinates of the computer ships or not
     * @param x checks the input value of the x coordinate by the user
     * @param y checks the input value of the y coordinate by the user
     * @return to return true (if coordinates match) or false (if coordinates do not match)
     */
    public boolean checkCoordinateComputerShips(int x, int y)
    {
        for (int i = 0; i < computerShips.getNoOfShip(); i++)
        {
            if(x == computerShips.getPosX(i) && y == computerShips.getPosY(i))
                return true;
        }
        return false;
    }

    /**
     * Checks whether the input coordinates match existing coordinates of the player ships or not
     * @param x checks the input value of the x coordinate by the user
     * @param y checks the input value of the y coordinate by the user
     * @return to return true (if coordinates match) or false (if coordinates do not match)
     */
    public boolean checkCoordinatePlayerShips(int x, int y)
    {
        for (int i = 0; i < playerShips.getNoOfShip(); i++)
        {
            if(x == playerShips.getPosX(i) && y == playerShips.getPosY(i))
                return true;
        }
        return false;
    }

    /**
     * Checks the value of the x position input by the user and does all the necessary validations.
     * @return the value of validated x Position
     */
    public int checkxPos()
    {
        String xPosTemp = ""; // x position is passed as a String to validate the input
        int xPos = 0;
        boolean valueOfxPos = true;
        while(valueOfxPos)
        {
            xPosTemp = input.addxPosition(); //To input value of x position from the user
            if(validate.checkInteger(xPosTemp,readGridSize()) == true)
            {
                xPos = Integer.parseInt(xPosTemp); //Converting string to integer
                valueOfxPos = false;
            }
            else
                valueOfxPos = true;
        }
        return xPos; //Value of validated x position is returned
    }

    /**
     * Checks the value of the y position input by the user and does all the necessary validations.
     * @return the value of validated y Position
     */
    public int checkyPos()
    {
        String yPosTemp = ""; // y position is passed as a String to validate the input
        int yPos = 0;
        boolean valueOfyPos = true;
        while(valueOfyPos)
        {
            yPosTemp = input.addyPosition(); //To input value of y position from the user
            if(validate.checkInteger(yPosTemp,readGridSize()) == true)
            {
                yPos = Integer.parseInt(yPosTemp); //Converting string to integer
                valueOfyPos = false;
            }
            else
                valueOfyPos = true;
        }
        return yPos; //Value of validated y position is returned
    }

    /**
     * Calculates the total score of the computer by calculating the total number of hits on the player Ships.
     * @return the value of Total Computer Score.
     */
    public int computerScoreCalc()
    {
        int computerHits = 0; //Total Number of Times computer has hit player ship
        int computerScore = 0; //Total Score of the computer calculated using the number of hits
        for(int i = 0; i < readNoOfShips(); i++)
        {
            if(playerShips.getHitsMade(i) > 0)
                computerHits = computerHits + playerShips.getHitsMade(i);
        }
        computerScore = computerHits * 10;
        return (computerScore);
    }

    /**
     * Computer makes a random guess of the coordinates  of where the player ships might be.
     */
    public void computerTurn()
    {
        Scanner console = new Scanner(System.in);
        int xPos = 0;
        int yPos = 0;
        int flag = 0;
        boolean destroyCheck = true;
        while(destroyCheck)
        {
            System.out.println("Computer makes a guess");
            xPos = coordinate.generateCoordinate(readGridSize()); //Randomly generate x coordinate within the specified range
            yPos = coordinate.generateCoordinate(readGridSize()); //Randomly generate y coordinate within the specified range
            System.out.println("x Position Guessed by Computer is "+xPos);
            System.out.println("x Position Guessed by Computer is "+yPos);
            for(int i = 0; i < readNoOfShips(); i++)
            {
                if(xPos == playerShips.getPosX(i) && yPos == playerShips.getPosY(i))
                {
                    if(playerShips.getHitsNeeded(i) == 0)
                    {
                        destroyCheck = true;
                        break;
                    }
                    else
                    {
                        destroyCheck = false;
                        flag=  1;
                        playerShips.addHitsMade(i,readMultipleHitsAllowed()); //If the coordinate guessed by the computer matches with any of the player ships, computer gets a hit
                        break;
                    }
                }
            }
            destroyCheck = false;
        }

        if(flag == 0)
            System.out.println("Computer Misses");
        else
            System.out.println("Computer Hits");
    }

    /**
     * A method that is used to end the game when either the player or the computer wins.
     * @return to return either true or false, true (to continue the game) & false (to end the game)
     */
    public boolean gameCheck()
    {
        boolean value = true;
        for(int i = 0; i < readNoOfShips(); i++)
        {
            if(totalHitsNeeded("playerHits") == 0 || totalHitsNeeded("computerHits") == 0) //The total hits function used here calculates the total remaining hits, if the number of
            {                                                                              //hits needed by either computer or player is 0, the game stops
                Winner = (totalHitsNeeded("playerHits") == 0)?1:0;
                value = false;
            }
            else
                value = true;
        }
        return value; //Returns either true or false, true (to continue the game) & false (to end the game)
    }

    /**
     * Main Driver Function of the program, All the methods are called from this menu method.
     */
    public void menu()
    {
        int round = 1; //Initializing the first round
        Scanner console = new Scanner(System.in);

        System.out.println("+==============================================================+");
        System.out.println("|                                                              |");
        System.out.println("|       Welcome to the Battleship Game -- With a Twist!!       |");
        System.out.println("|                                                              |");
        System.out.println("+==============================================================+");
        System.out.println("The game will use the grid size defined in the settings file.");
        System.out.println("Player grid size set as ("+readGridSize()+"x"+readGridSize()+")");
        System.out.println("Maximum number of ships allowed as "+readNoOfShips());
        System.out.println("Multiple hits allowed per ships set as "+readMultipleHitsAllowed());
        if(readComputerShipsVisible() == true)
            System.out.println("Computer Ships Visible : ON");
        else
            System.out.println("Computer Ships Visible : OFF");
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        addPlayerShip(); //Method to add player ship
        System.out.println("Loading Computer Settings:");
        addComputerShip(); //Method to add computer ship
        System.out.println("Computer Settings generated!");
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        do
        {
            if(playerScoreCalc() + computerScoreCalc() > 0 ) //Checks if either player or computer has made a successful attack, then only additional menu is displayed
                additionalMenu(round);
            System.out.println("\n Player Ships");
            playerShips.dispCoordinates(readGridSize(),true); //Display the positions of all the player ships.
            System.out.println("\n Computer Ships");
            computerShips.dispCoordinates(readGridSize(),readComputerShipsVisible()); //Display the positions of all the computer ships.
            playerTurn(); //Turn of the player
            computerTurn(); //Turn of the computer
            round++; //Incrementing the round number after both the player's and the computer's turn.
        }while(gameCheck());

        System.out.println("Player Score: "+playerScoreCalc()); //Displays final player Score
        System.out.println("Computer Score: "+computerScoreCalc()); //Displays final computer Score
        System.out.println("Player Ships");
        playerShips.dispCoordinates(readGridSize(),true); //Display the positions of all the player ships.
        System.out.println("Computer Ships");
        computerShips.dispCoordinates(readGridSize(),readComputerShipsVisible()); //Display the positions of all the computer ships.
        if(Winner == 1)
            System.out.println("CONGRATULATIONS PLAYER WINS......");
        else
            System.out.println("COMPUTER WINS......");
        fileio.writeFile(Winner, playerScoreCalc(), computerScoreCalc()); //Call the write method to store the values in a file.
    }

    /**
     * Calculates the total score of the player by calculating the total number of hits on the Computer Ships.
     * @return the value of Total player Score.
     */
    public int playerScoreCalc()
    {
        int playerHits = 0; //Total Number of Times player has hit computer ship
        int playerScore = 0; //Total Score of the player calculated using the number of hits
        for(int i = 0; i < readNoOfShips(); i++)
        {
            if(computerShips.getHitsMade(i) > 0){
                playerHits = playerHits + computerShips.getHitsMade(i);
            }
        }
        playerScore = playerHits*10;
        return (playerScore);
    }

    /**
     * Player makes a random guess of the coordinates  of where the computer ships might be.
     */
    public void playerTurn()
    {
        Scanner console = new Scanner(System.in);
        int xPos = 0;
        int yPos = 0;
        int flag = 0;
        boolean destroyCheck = true;
        while(destroyCheck)
        {
            System.out.println("Player to make a guess");
            System.out.println("Ship x Position (0 - "+(readGridSize()-1)+")");
            xPos = checkxPos(); //x Coordinate guessed by player
            System.out.println("Ship y Position (0 - "+(readGridSize()-1)+")");
            yPos = checkyPos(); //y Coordinate guessed by player
            for(int i = 0; i < readNoOfShips(); i++)
            {
                if(xPos == computerShips.getPosX(i) && yPos == computerShips.getPosY(i))
                {
                    if(computerShips.getHitsNeeded(i) == 0)
                    {
                        System.out.println("Ship has been destroyed, choose a different coordinate");
                        destroyCheck = true;
                        break;
                    }
                    else
                    {
                        destroyCheck = false;
                        flag=  1;
                        computerShips.addHitsMade(i,readMultipleHitsAllowed()); //If the coordinate guessed by the player matches with any of the computer ships, player gets a hit
                        break;
                    }
                }
            }
            destroyCheck = false;
        }
        if(flag == 0)
            System.out.println("Player Misses");
        else
            System.out.println("Player Hits");
    }

    /**
     * Reads the value of the visibilty of the Computer Ships from the input text file.
     * @return the boolean value true (computer ships are visible) or false (computer ships are not visible).
     */
    public boolean readComputerShipsVisible()
    {
        String file = new String();
        file = fileio.readFile();
        String[] str = file.split(" ");
        boolean computerShipsVisible = Boolean.parseBoolean(str[2]);
        return computerShipsVisible;
    }

    /**
     * Reads the value of the grid size from the input text file.
     * @return the integer value of grid size.
     */
    public int readGridSize()
    {
        String file = new String();
        file = fileio.readFile();
        String[] str = file.split( " ");
        int gridSize = Integer.parseInt(str[0]);
        return gridSize;
    }

    /**
     * Reads the value of the whether multiple hits on the Ships are allowed or not from the input text file.
     * @return the boolean value true (multiple hits are allowed) or false (multiple hits are not allowed).
     */
    public boolean readMultipleHitsAllowed()
    {
        String file = new String();
        file = fileio.readFile();
        String[] str = file.split(" ");
        boolean multipleHitsAllowed = Boolean.parseBoolean(str[1]);
        return multipleHitsAllowed;
    }

    /**
     * Reads the number of ships from the input text file.
     * @return the integer value of the number of ships.
     */
    public int readNoOfShips()
    {
        String file = new String();
        file = fileio.readFile();
        String[] str = file.split(" ");
        int noOfShips = Integer.parseInt(str[3]);
        return noOfShips;
    }

    /**
     * Reads the number of ships from the input text file.
     * @param input to check whether hits required by computer is needed or hits required by player is needed.
     * @return the total hits required.
     */
    public int totalHitsNeeded(String input)
    {
        int totalHitsReqd = 0;
        for(int i = 0; i < readNoOfShips(); i++)
        {
            if(input.equals("computerHits"))
                totalHitsReqd = totalHitsReqd + playerShips.getHitsNeeded(i);
            if(input.equals("playerHits"))
                totalHitsReqd = totalHitsReqd + computerShips.getHitsNeeded(i);
        }
        return totalHitsReqd;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.menu();
    }
}
