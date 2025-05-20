import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    int live = 5;
    private final int range = 100;
    Scanner scanner = new Scanner(System.in);

    public void game(int guessNumber) {
        System.out.println("WELCOME TO THE GAME !\nGuess the number 0 to " + range);
        while (live > 0) {
            int inputInteger = getUserInput(scanner);

            if (inputInteger == guessNumber) {
                System.out.println("Winner!");
                scanner.close();
                return;
            } else {
                if (live == 1) {
                    System.out.println("Didn't guess");
                } else {
                    System.out.print("Didn't guess, try again, ");
                    if (inputInteger > guessNumber) {
                        System.out.println("your number large.");
                    } else {
                        System.out.println("you number less.");
                    }
                }
            }
            live--;
        }
        System.out.println("\n========GAME OVER==========");
        System.out.println("Guess number is:" + guessNumber);
        scanner.close();
    }

    public int getNumber() {
        Random randomEngine = new Random();
        return randomEngine.nextInt(range);
    }

    private int getUserInput (Scanner scanner) {
        while (true) {
            System.out.println("Enter a number: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Enter a integer number!");
                scanner.next();
            } else {
                return scanner.nextInt();
            }
        }
    }


}
