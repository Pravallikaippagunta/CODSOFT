import java.util.Random;
import java.util.Scanner;
public class NumberGame{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game");

        boolean playAgain = true;
        int totalScore = 0;

        while(playAgain){
            int targetNumber = random.nextInt(100)+ 1;
            int attempts = 0;
            int maxAttempts = 5;

            System.out.println("I have selected a number between 1 and 100. Try to guess!");
            while (attempts < maxAttempts){
                System.out.println("Enter the number ou guessed: ");
                int userGuess = sc.nextInt();
                sc.nextLine();
                attempts++;

            if (userGuess == targetNumber){
                System.out.println("Congratulations!! You have guessed the correct number in " + attempts +" "+  "attempts.");
                totalScore ++;
                break;
            }
            else if(userGuess < targetNumber && userGuess <= 100 && userGuess >= 1){
                System.out.println("Too low. Try Again!"); 
            }
            else if (userGuess > targetNumber && userGuess <=100 && userGuess>=1){
                System.out.println("Too High. Try Again!");
            }
            else {
                System.out.println("Invalid Guess. Your Guess must lie between 1 and 100.");
            }
        }
        if (attempts >= maxAttempts){
            System.out.println("Sorry you have run out of attempts. The correct number is "+ targetNumber + ".");
        }
        System.out.print("Do you want to play again? (yes/no): ");
        String playAgainInput = sc.nextLine();
        playAgain = playAgainInput.equalsIgnoreCase("yes");
    }
    System.out.println("Thank you for playing! Your total score is : " + totalScore);
    }
}