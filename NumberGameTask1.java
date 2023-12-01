// ---------------------------------   CODSOFT INTERNSHIP   ---------------------------------------

/*                                          TASK 1

1. Generate a random number within a specified range, such as 1 to 100.

2. Prompt the user to enter their guess for the generated number.

3. Compare the user's guess with the generated number and provide feedback on whether the guess
is correct, too high, or too low.

4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:

5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.*/

import java.util.Random;
import java.util.Scanner;

class NumberGame{


    private int lowerLimit; 
    private int upperLimit;
    private int botNumber;
    private int maxAttempt;
    private int roundCount;
    private int totalAttempt;
    private Scanner sc;

    public NumberGame(int lowerLimit, int upperLimit,int maxAttempt,Scanner sc)
    {
        this.lowerLimit=lowerLimit;
        this.upperLimit=upperLimit;
        this.maxAttempt=maxAttempt;
        this.roundCount=0;
        this.totalAttempt=0;
        this.sc = sc;
        botNumberGenerator();

    }
    public void botNumberGenerator() // It's a Function for where bot can generate a Random Number 
    {
        Random random = new Random();
       this.botNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
;

    }

    public void roundplay()  // function for implementation of NumberGame
    {
        roundCount++;
        System.out.println("\nRound: " + roundCount);
       
        int attempt;
        for( attempt = 1;attempt<=10;attempt++)
        {
            System.out.println("Attempt " + attempt +"/" +maxAttempt);
            System.out.print("Enter your guessing no between " + lowerLimit +" to " +upperLimit+" :");
            int playerGuessNo = sc.nextInt();
            if(playerGuessNo==botNumber){
                System.out.println("Congratulations!  You guessed the correct no :"+botNumber);
                System.out.println("You take total of "+attempt +" attempts ");
                totalAttempt=totalAttempt+attempt;
                break;
            }
            else if(playerGuessNo>upperLimit)
            {
                System.out.println("You gussed the no outside the range , Kindly guess a no between 1 to 100");
            }
            else if (playerGuessNo<botNumber)
            {
                System.out.println("Gussed no is too low ! Try Again ");

            }
            else {
                System.out.println("Gussed no is too high ! Try Again ");
            }


        }
        if(attempt>maxAttempt)
        {
            System.out.println("Sorry , You have taken all your attempts . The correct no was: "+botNumber);
          
        }
       
     
    }
    public void displayScore() // Function for displaying score 
    {
        System.out.println("Thanks for playing ! Your average number of attempts per round :" + (double)totalAttempt/roundCount);
    }
}

public class NumberGameTask1
{


    public static void main(String args[])
    {
        int lowerLimit = 1;
        int upperLimit=100;
        int maxAttempt =10;
        Scanner sc = new Scanner(System.in);
        NumberGame game = new NumberGame(lowerLimit,upperLimit,maxAttempt,sc);
        boolean playAgain = true;
        String playAgainInput;
        while(playAgain)  // While loop so that user can play game as much as times he want 
        {
            game.roundplay();
            System.out.println("Do you want to play Again ? (yes/no) ");
            playAgainInput = sc.next().toLowerCase();
          
            playAgain = playAgainInput.equals("yes");
        }
        game.displayScore();
        sc.close();
    }
}
