public class Main {
    public static void main (String[] args) {
        GuessNumber gs = new GuessNumber();
        int number = gs.getNumber();
        gs.game(number);
    }
}