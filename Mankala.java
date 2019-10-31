import java.util.*;

public class Mankala {
    public static Shortcuts s = new Shortcuts();
    public static Mankala m = new Mankala();

    int[] p1side = new int[6];
    int[] p2side = new int[6];
    int p1home, p2home;

    void displayBoard() {
        s.prnt("  ");
        for (int i = 0; i < m.p2side.length; i++) 
            s.prnt(m.p2side[i] + "  ");
        s.prntln();
        s.prntln(p2home + "                  " + p1home);
        s.prnt("  ");
        for (int i = 0; i < m.p1side.length; i++)
            s.prnt(m.p1side[i] + "  ");
        s.prntln();
        s.prntln("  A  B  C  D  E  F");
    }

    // handle player 1's move
    // return 1 if they get to go again
    int p1move(int choice) {
        /*
        
        stones available = m.p1side[choice]

        for i in range(choice, m.p1side.length)
            fill player's side with stones'

        */

        return 0;
    }

    // handle player 2's move
    // return 1 if they get to go again
    int p2move(int choice) {
        return 0;
    }

    public static void main(String[] args) {
        String[] options = new String[] {"a", "b", "c", "d", "e", "f"};
        String in;
        int selected;

        // initialize board
        m.p1side = m.p2side = s.fill(new int[m.p1side.length], 3);
        m.p1home = m.p2home = 0;

        m.displayBoard();

        // game loop
        boolean playing = true;
        while (playing) {
            do {
                // if player 1 doesn't have any stones
                if (s.arrEquals(s.fill(new int[6], 0), m.p1side)) {
                    s.prntln("player 1 can't move");
                    playing = false;
                    break;
                }
                

                s.prnt("Player 1: ");
                in = s.input.next();

                // make sure player 1 picks something valid, so something that has at least one stone and that is a letter between a-f
                do {
                    if (!s.inArr(options, in.toLowerCase())) {
                        s.prntln("That isn't a valid choice");
                        continue;
                    }
                    
                    selected = s.index(options, in.toLowerCase());
                    if (m.p1side[selected] == 0) {
                        s.prntln("You don't have anything in that pit");
                        continue;
                    }

                    break;
                } while (true);
            } while (m.p1move(selected) == 1); // returns 1 if the player gets to move again, 0 if not

            do {
                // if player 2 doesn't have any stones
                if (s.arrEquals(s.fill(new int[6], 0), m.p2side)) {
                    s.prntln("player 2 can't move");
                    playing = false;
                    break;
                }
                
                s.prnt("Player 2: ");
                in = s.input.next();

                // make sure player 2 picks something valid, so something that has at least one stone and that is a letter between a-f
                do {
                    if (!s.inArr(options, in.toLowerCase())) {
                        s.prntln("That isn't a valid choice");
                        continue;
                    }
                    
                    selected = s.index(options, in.toLowerCase());
                    if (m.p1side[selected] == 0) {
                        s.prntln("You don't have anything in that pit");
                        continue;
                    }

                    break;
                } while (true);
            } while (m.p2move(selected) == 1); // returns 1 if the player gets to move again, 0 if not
        }
    }
}
