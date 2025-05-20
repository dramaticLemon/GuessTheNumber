import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class GuessNumber {
    int live = 5;
    private final int endRange = 101;
    Scanner scanner = new Scanner(System.in);
    Logger logger = Logger.getLogger(GuessNumber.class.getName());

    public void game() {
        int guessNumber = getNumber();
        logger.info("WELCOME TO THE GAME !\nGuess the number 0 to " + (endRange - 1));
        while (live > 0) {
            int inputInteger = getUserInput(scanner);

            if (inputInteger == guessNumber) {
                logger.info("Winner!");
                scanner.close();
                return;
            } else {
                if (live == 1) {
                    logger.info("Didn't guess.");
                } else {
                    logger.info("Didn't guess, try again, ");
                    if (inputInteger > guessNumber) {
                        logger.info("you number > guess number.");
                    } else {
                        logger.info("you number < guess number.");
                    }
                }
            }
            live--;
        }
        logger.info("\n========GAME OVER==========");
        logger.info("Guess number is:" + guessNumber);
        scanner.close();
    }

    private int getNumber() {
        Random randomEngine = new Random();
        return randomEngine.nextInt(endRange);
    }

    private int getUserInput (Scanner scanner) {
        while (true) {
            logger.info("Enter a number: ");
            if (!scanner.hasNextInt()) {
                logger.warning("Enter a integer number!");
                scanner.next();
            } else {
                return scanner.nextInt();
            }
        }
    }


}
