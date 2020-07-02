package me.tsunani.guessingGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = scanner.next();
        System.out.println("Hello " + name);
        System.out.println("Would you like to play a game?");
        String game = scanner.next();

        game = game.toLowerCase();

        if(game.equals("no") || game.equals("n")) {
            System.out.println("That's too bad.");
            System.exit(1);
        } else if(game.equals("yes") || game.equals("y")) {
            System.out.println("Great please guess a number between 1 and 100");
            Random random = new Random();
            int number = random.nextInt(100) + 1;

            for(int i = 0; i < 5; i++) {
                int guess = scanner.nextInt();
                if(guessing(guess, number)) {
                    System.out.println("You Win");
                    System.exit(0);
                }
            }

        } else {
            System.out.println("Invalid Input");
            System.exit(1);
        }

        System.out.println("You didn't guess in time, I win.");
        System.out.println("GAME OVER");
        System.exit(1);

    }

    public static boolean guessing(int guess, int num) {
        if(guess == num) {
            return true;
        } else if(guess > num) {
            System.out.println("Lower");
            return false;
        } else {
            System.out.println("Higher");
            return false;
        }
    }
}
