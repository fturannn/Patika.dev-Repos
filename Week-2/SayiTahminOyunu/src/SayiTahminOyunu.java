import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int guess, lifes = 5;

        int number = (int) (Math.random() * 100);
        System.out.println(number);

        while (true) {
            System.out.print("Guess a number between 0 and 100: ");
            guess = input.nextInt();
            if (guess < 0 || guess > 100) {
                System.out.println("You guessed wrong number! Please enter a number between 0 and 100");
            } else {
                if (guess < number) {
                    System.out.println("Guess a greater number! ");
                    lifes--;
                    System.out.println("Lifes: " + lifes);
                } else if (guess > number) {
                    System.out.println("Guess a lower number! ");
                    lifes--;
                    System.out.println("Lifes: " + lifes);
                } else {
                    System.out.println("You guessed correct number! Congratulations!");
                    break;
                }
            }
            if (lifes == 0) {
                System.out.println("You lose! Game over!");
                break;
            }
        }
    }
}
