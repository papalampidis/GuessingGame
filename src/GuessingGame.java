import java.util.Scanner;

public class GuessingGame {

    public static int computerGuess(final int lowval, final int highval, final int randnum, int count) {
        if (highval >= lowval) {
            final int guess = lowval + (highval - lowval) / 2;

            if (guess == randnum) {
                return count;
            }
            if (guess > randnum) {
                count++;
                return (computerGuess(lowval, guess - 1, randnum, count));
            } else {
                count++;
                return (computerGuess(guess + 1, highval, randnum, count));
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        int guess = -55;
        int count = 0;
        final Scanner input = new Scanner(System.in);
        final int randnum = (int) (Math.random() * 100 + 1);

        while (guess != randnum) {

            System.out.println("Enter a guess between 1 and 100: ");
            guess = input.nextInt();
            if (guess < randnum) {
                System.out.println("Higher");
            } else if (guess > randnum) {
                System.out.println("Lower");
            } else {
                System.out.println("Congrats! You guessed it!");
                break;
            }
            count++;
        }
        input.close();
        System.out.println("It took you " + count + " attempts" + " to guess the number.");
        System.out.println("Computer guessed it in " + computerGuess(0, 100, randnum, 0) + " attempts.");
    }
}
