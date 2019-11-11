import java.util.*;

public class Mankala {
    public static Shortcuts s = new Shortcuts();

    int[] p1side = new int[6];
    int[] p2side = new int[6];
    int p1home, p2home;

    public Mankala() {
        // initialize board
        p1side = s.fill(new int[p1side.length], 3);
        p2side = s.fill(new int[p2side.length], 3);
        p1home = p2home = 0;
    }

    void displayBoard() {
        s.prnt("  ");
        for (int i = 0; i < p2side.length; i++) 
            s.prnt(p2side[i] + "  ");
        s.prntln();
        s.prntln(p2home + "                  " + p1home);
        s.prnt("  ");
        for (int i = 0; i < p1side.length; i++)
            s.prnt(p1side[i] + "  ");
        s.prntln();
        s.prntln("  A  B  C  D  E  F");
    }

    // handle player 1's move
    // return 1 if they get to go again
    int p1move(int choice) {
        int stones = p1side[choice];
        p1side[choice] = 0;

        do {
            // fill the player's side
            for (int i = choice + 1; i < p1side.length; i++) {
                if (stones > 0) {
                    p1side[i] ++;
                    stones --;

                    // "steal" the stones from the other side and this side if it lands in an empty bin
                    if (stones == 0 && p1side[i] == 1 && p2side[i] > 0) {
                        p1home += p1side[i] + p2side[i];
                        p1side[i] = p2side[i] = 0;
                    }
                } else {
                    return 0;
                }
            }

            // fill player's home bin
            if (stones > 0) {
                p1home ++;
                stones --;
            } else 
                return 0;
            
            // ended on the player's home bin
            if (stones == 0) 
                return 1;
            
            // fill other player's side
            for (int i = (p2side.length - 1); i >= 0; i--) {
                if (stones > 0) {
                    stones --;
                    p2side[i] ++;
                } else {
                    return 0;
                }
            }

            choice = -1;

        } while (stones > 0);

        return 0;
    }

    // handle player 2's move
    // return 1 if they get to go again
    int p2move(int choice) {
        int stones = p2side[choice];
        p2side[choice] = 0;

        do {
            // fill the player's side
            for (int i = choice - 1; i >= 0; i--) {
                if (stones > 0) {
                    p2side[i] ++;
                    stones --;

                    // do the steal function
                    if (stones == 0 && p2side[i] == 1 && p1side[i] > 0) {
                        p2home += p2side[i] + p1side[i];
                        p2side[i] = p1side[i] = 0;
                    }
                } else 
                    return 0;
            }

            // fill player's home bin
            if (stones > 0) {
                p2home ++;
                stones --;
            } else 
                return 0;
            
            // ended on the player's home bin
            if (stones == 0) 
                return 1;
            
            // fill other player's side
            for (int i = 0; i < p1side.length; i++) {
                if (stones > 0) {
                    p1side[i] ++;
                    stones --;
                } else 
                    return 0;
            }

            choice = p2side.length;

        } while (stones > 0);

        return 0;
    }

    // calculate who won
    void endGame() {
        for (int i = 0; i < p1side.length; i++) {
            p1home += p1side[i];
            p2home += p2side[i];
        }
        if (p1home > p2home) {
            s.prntln("player 1 wins!");
            return;
        }
        if (p2home > p1home) {
            s.prntln("player 2 wins!");
            return;
        }
        s.prntln("tie!");
    }

    public void play() {
        String[] options = new String[] {"a", "b", "c", "d", "e", "f"};
        String in;
        int selected;


        // game loop
        while (true) {
            do {
                displayBoard();

                // if player 1 doesn't have any stones
                if (s.arrEquals(s.fill(new int[6], 0), p1side)) {
                    s.prntln("player 1 can't move");
                    endGame();
                    return;
                }

                // make sure player 1 picks something valid, so something that has at least one stone and that is a letter between a-f
                do {
                    s.prnt("Player 1: ");
                    in = s.input.next();

                    if (!s.inArr(options, in.toLowerCase())) {
                        s.prntln("That isn't a valid choice");
                        continue;
                    }
                    
                    selected = s.index(options, in.toLowerCase());
                    if (p1side[selected] == 0) {
                        s.prntln("You don't have anything in that pit");
                        continue;
                    }

                    break;
                } while (true);
            } while (p1move(selected) == 1); // returns 1 if the player gets to move again, 0 if not

            do {
                displayBoard();

                // if player 2 doesn't have any stones
                if (s.arrEquals(s.fill(new int[6], 0), p2side)) {
                    s.prntln("player 2 can't move");
                    endGame();
                    return;
                }

                // make sure player 2 picks something valid, so something that has at least one stone and that is a letter between a-f
                do {
                    s.prnt("Player 2: ");
                    in = s.input.next();

                    if (!s.inArr(options, in.toLowerCase())) {
                        s.prntln("That isn't a valid choice");
                        continue;
                    }
                    
                    selected = s.index(options, in.toLowerCase());
                    if (p2side[selected] == 0) {
                        s.prntln("You don't have anything in that pit");
                        continue;
                    }

                    break;
                } while (true);
            } while (p2move(selected) == 1); // returns 1 if the player gets to move again, 0 if not
        }
    }

    public static void main(String[] args) {
        Mankala m = new Mankala();
        m.play();
    }
}
