import java.util.*;

public class mastermindGame {
    public static Shortcuts s = new Shortcuts();

    boolean error = false;
    int[] pegs;

    mastermindGame(int peg_count, int colors) {
        if (peg_count > 10 || peg_count < 1 || colors > 9 || colors < 1) {
            error = true;
            return;
        }

        pegs = new int[peg_count];
        for (int i = 0; i < pegs.length; i++) {
            pegs[i] = (int) (Math.random() * colors) + 1;
        }

    }
}
