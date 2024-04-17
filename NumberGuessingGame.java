package org.example;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Random random = new Random();

                boolean playAgain = true;
                while (playAgain) {
                        int lowerLimit = 1;
                        int upperLimit = 100;
                        int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                        int attempts = 0;

                        System.out.println("Welcome to the Number Guessing Game!");

                        while (true) {
                                System.out.print("Guess a number between " + lowerLimit + " and " + upperLimit + ": ");
                                int userGuess = scanner.nextInt();
                                attempts++;

                                if (userGuess < targetNumber) {
                                        System.out.println("Too low. Try guessing higher.");
                                } else if (userGuess > targetNumber) {
                                        System.out.println("Too high. Try guessing lower.");
                                } else {
                                        System.out.println("Congratulations! You've guessed the correct number " + targetNumber + " in " + attempts + " attempts.");
                                        break;
                                }

                                if (attempts == 5) {
                                        System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + targetNumber + ".");
                                        break;
                                }
                        }

                        System.out.print("Would you like to play again? (yes/no): ");
                        String playAgainInput = scanner.next();
                        if (!playAgainInput.equalsIgnoreCase("yes")) {
                                playAgain = false;
                                System.out.println("Thanks for playing!");
                        }
                }

                scanner.close();
        }
}
