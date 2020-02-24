import java.util.*;

public class BowlingFrame {
    public static Shortcuts s = new Shortcuts();

    int roll1 = 0, roll2 = 0, score = 0, index = 0;
    boolean spare = false, strike = false;

    // not a lot of logic here because most of what I need to calculate involves multiple frames so I do it in the main program
    // this is basically just a 2d array replacement with names for each index of the inside arrays
    public BowlingFrame(int n, int[] rolls) {
        roll1 = rolls[0];
        roll2 = rolls[1];
        index = n;

        if (roll1 == 10) {
            strike = true;
        } else if (roll1 + roll2 == 10) {
            spare = true;
        }
    }

    // this is just for debugging
    String show() {
        return "frame: " + index + "\trolls: " + roll1 + "," + roll2 + "\tstrike: " + strike + "\tspare: " + spare + "\tscore: " + score;
    }
}
