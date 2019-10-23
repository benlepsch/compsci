import java.util.*;

public class GuessingGame {
    public static void main(String[] args) {
        Shortcuts s = new Shortcuts();
        Scanner input = new Scanner(System.in);
        int randomNumber = (int)(Math.random() * 20 + 1); 
        int guess;

        do {
            s.prntln("Enter a number between 1-20");
            guess = input.nextInt();
            if (guess < randomNumber) 
                s.prntln("Too low!");
            if (guess > randomNumber)
                s.prntln("Too high!");
            if (guess == randomNumber)
                s.prntln("You won!");
        } while (guess != randomNumber);
    }
}