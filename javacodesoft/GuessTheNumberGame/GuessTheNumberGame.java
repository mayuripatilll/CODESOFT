package GuessTheNumberGame;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 10;
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Guess the Number game!");

        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;
            System.out.println("I'm thinking of a number between " + lowerLimit + " and " + upperLimit + ".");

            while (attempts < maxAttempts) {
                System.out.print("Take a guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        scanner.close();
        System.out.println("Game Over! You won " + roundsWon + " round(s) with an average of " + (double) totalAttempts / roundsWon + " attempts per round.");
    }
}
