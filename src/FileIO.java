import java.io.*;
import java.util.Scanner;

/**
 * A class that is used to read data from the file and writes some data to the file.
 * @author Prabhav Swaminathan
 * @version 2018.21.10
 */
public class FileIO
{
    // Name of file
    private String fileName;

   /**
    * Default Constructor for objects of class FileIO
    */
   public FileIO() 
   { 
      fileName = "";
      FileReader input = null;
   }
   
   /**
    * Parameterized Constructor for objects of class FileIO.
    * @param fileName is used to store name of file.
    */   
   public FileIO(String fileName) 
   { 
      this.fileName = fileName;
   }
   
   /**
    * Method to read data from text file and saving data in different variables and finally concatinating the data from the input text file in the form of a string.
    * @return str returns the data from the input text file in the form of a string.
    */   
   public String readFile()
   {
       String str = new String();
       fileName = "./src/gamesettings.txt"; //Name of input text file
       try
       {
           FileReader input = new FileReader(fileName); 
           try
           {
               Scanner parser = new Scanner(input);
               parser.useDelimiter(","); //This is the delimiter because data values are seperated by comma.
               int grid = parser.nextInt(); //To get the integer value of gtidsize
               boolean multipleHitsAllowed = parser.nextBoolean(); //To get the boolean value of multiple hits allowed
               boolean computerShipVisible = parser.nextBoolean(); //To get the boolean value of computer ships visible
               int noOfShips = parser.nextInt(); //To get the integer value of number of ships
               //Concatinating the values obtained from the text file in a string 
               str = Integer.toString(grid) + " " + String.valueOf(multipleHitsAllowed) + " " + String.valueOf(computerShipVisible) + " " + Integer.toString(noOfShips);
           }
           finally
           {
               //Finally Closing File
               input.close();
           }
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(fileName + " not found");
        }
       catch(IOException ex)
        {
            System.out.println("Unexpected I/O exception occurs");
        } 
       return str;
   }
   
   /**
    * Method to write output (Winner, player score and computer score) to a file
    * @param Winner used to find whether the player won or the computer won.
    * @param playerScore is used to get the final player score
    * @param computerScore is used to get the final computer score
    */     
   public void writeFile(int Winner, int playerScore, int computerScore)
   {
       fileName = ("./src/gameoutcome.txt"); //Name of output text file
       try
       {
           PrintWriter output = new PrintWriter(fileName);
           try
           {
               if(Winner == 1)
                   output.println("Player wins. Final Score Player ("+playerScore+") and Computer ("+computerScore+")");
               else
                   output.println("Computer wins. Final Score Player ("+playerScore+") and Computer ("+computerScore+")");
           }
           finally
           {    
               //Finally Closing File
               output.close();
           }
       }
       catch(FileNotFoundException ex)
       {
            System.out.println(fileName + " not found");
       }
       catch(IOException ex)
       {
            System.out.println("Unexpected I/O exception occurs");
       } 
   }
}
