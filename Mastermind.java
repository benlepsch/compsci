import java.util.*;

public class Mastermind {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        int pegs, colors;
        s.prnt("How many pegs? ");
        pegs = s.input.nextInt();
        s.prnt("How many colors? ");
        colors = s.input.nextInt();

        mastermindGame game = new mastermindGame(pegs, colors);

        if (game.error) {
            s.prntln("something went wrong, check to see if your pegs and colors are within 1-10 and 1-9");
            return;
        }

        int correct_pegs, correct_colors, guess = 0;
        int[] guesses = new int[pegs];
        int[] used = new int[pegs];
        int ui = 0;
        do {
            guess ++;
            correct_pegs = 0;
            correct_colors = 0;
            ui = 0;
            used = s.fill(used, 0);

            s.prntln("Guess " + guess);
            for (int i = 0; i < pegs; i++) {
                s.prnt("Color for peg " + (i+1) + ": ");
                guesses[i] = s.input.nextInt();
            }

            for (int i = 0; i < guesses.length; i++) {
                if (guesses[i] == game.pegs[i]) {
                    correct_pegs ++;
                    if (! s.inArr(used, i)) {
                        correct_colors ++;
                        used[ui] = i;
                        ui ++;
                    } else if (i == 0) {
                        correct_colors ++;
                        used[ui] = i;
                        ui ++;
                    }
                } else {
                    for (int j = 0; j < game.pegs.length; j++) {
                        if (guesses[i] == game.pegs[j]) {
                            if (! s.inArr(used, j)) {
                                correct_colors ++;
                                used[ui] = j;
                                ui ++;
                                break;
                            }
                        }
                    }
                }
            }
            s.prntln("You have " + correct_pegs + " peg(s) correct and " + correct_colors + " color(s) correct.");
            s.prnt("Hint: ");
            s.prntln(game.pegs);
            s.prntln(used);
        } while (correct_pegs != pegs);
        s.prntln("You have broken the code!");
    }
}
