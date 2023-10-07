import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        
        Random random = new Random();

        
        int randomNumber = random.nextInt(100) + 1;

        
        Scanner scanner = new Scanner(System.in);

        int numberOfTries = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("********************NUMBER GAME********************");
        System.out.println("A Random Number Has Been Chosen Between 1 And 100. Try To Guess It.");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter Your Guess: ");
            int userGuess = scanner.nextInt();
            numberOfTries++;

            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please Enter A Number Between 1 And 100.");
            } else if (userGuess < randomNumber) {
                System.out.println("Try A Higher Number.");
            } else if (userGuess > randomNumber) {
                System.out.println("Try A Lower Number.");
            } else {
                System.out.println("Congratulations! You've Guessed The Correct Number (" + randomNumber + ") In " + numberOfTries + " Tries.");
                hasGuessedCorrectly = true;
            }
        }

        
        scanner.close();
    }
} 