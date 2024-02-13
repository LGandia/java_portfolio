// ****************************************************************
//   Rock.java
//
//   Play Rock, Paper, Scissors with the user
//
// ****************************************************************
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

public class Rock
{
    public static void main(String[] args)
    {
        Rock O = new Rock();
        O.go();
    }
    public void go()
    {
        String personPlay;    //User's play -- "R", "P", or "S"
        String computerPlay;  //Computer's play -- "R", "P", or "S"
        int computerInt;      //Randomly generated number used to determine
        //computer's play


        Scanner scan = new Scanner(System.in);
        Random generator = new Random();


        //Get player's play -- note that this is stored as a string
        System.out.print("R (rock), P (paper) or S (scissors)"+"\n"+"Choose a letter: ");
        personPlay = scan.next();

        //Make player's play uppercase for ease of comparison
        personPlay = personPlay.toUpperCase();
        System.out.println("Player has chosen: " + personPlay);

        //Generate computer's play (0,1,2)
        computerInt = generator.nextInt(3);

        //Translate computer's randomly generated play to string

        //Using if else
        if (computerInt == 0)
            computerPlay = "R";
        else if (computerInt == 1)
            computerPlay = "P";
        else
            computerPlay = "S";

        //Using switch
        computerPlay = switch (computerInt)
        {
            case 0 -> "R";
            case 1 -> "P";
            case 2 -> "S";
            default -> computerPlay;
        };

        //Print computer's play
        System.out.println("Computer chose: "+ computerPlay);
        //See who won.  Use nested ifs instead of &&.
        if (personPlay.equals(computerPlay))
            System.out.println("It's a tie!");

        else if (personPlay.equals("R"))
            if (computerPlay.equals("S"))
                System.out.println("Rock crushes scissors.  You win!!");
            else
                System.out.println("Paper wraps rock. You loose!!");

        else if (personPlay.equals("S"))
            if (computerPlay.equals("P"))
                System.out.println("Scissors cuts paper. You win!!");
            else
                System.out.println("Rock crushes scissors. You loose!!");

        else if (personPlay.equals("P"))
            if (computerPlay.equals("R"))
                System.out.println("Paper wraps rock. You loose!!");
            else
                System.out.println("Scissors cuts paper. You win!!");

    }
}