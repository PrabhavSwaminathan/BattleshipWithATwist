import java.util.Scanner;

/**
 * A class that validates the player input
 * @author Prabhav Swaminathan
 * @version 2018.21.10
 */public class Validation
   {
       
    /**
     * Used to check whether entered integer is numeric or not, also checks whether entered value is within range of the grid size.
     * @param input is used to pass the entered value of the coordinate by the player
     * @param gridSixe is used to check whether entered value of input by the player is within range or not
     */
    public boolean checkInteger(String input, int gridSize)
    {
        Scanner console = new Scanner(System.in);
        boolean error = true;
        boolean value = true;
        int result = 0;
        while(error)
        {
            if(checkInput(input) == true)
            {
                result = Integer.parseInt(input);
                if(result >= 0 && result < gridSize)
                {
                    error = false;
                }
                else
                {
                    System.out.println("Please enter a value between 0 and "+(gridSize-1));
                    value = false;
                    error = false;
                }
            }
            else
            {
                System.out.println("Wrong Input, please enter correct input");
                value = false;
                error = false;
            }
        }
        return value;
    }
    
    /**
     * Used to check whether entered integer is numeric or not using try and catch.
     * @param str is used to pass the input value as a string and then it is validated.
     */    
    public boolean checkInput(String str)
    {
        try
        {
            Integer.parseInt(str);
        }   
        catch(NumberFormatException ex)
        {
            return false;
        }   
        return true;
    }
    
    /**
     * Used to check whether entered name is between 3 and 15 characters or not.
     * @param name is used to pass the input value of name and then it is validated.
     */        
    public boolean checkName(String name)
    {
        boolean value = true;
        if(name.length() < 3 || name.length() > 15)
        {
            System.out.println("Name must be between 3 and 15 characters");
            value = false;
        }
        return value;
    }
}
