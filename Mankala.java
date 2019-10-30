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
    public static void main(String[] args) {
        String[] options = new String[] {"a", "b", "c", "d", "e", "f"};
        String in;

        // initialize board
        m.p1side = m.p2side = s.fill(new int[m.p1side.length], 3);
        m.p1home = m.p2home = 0;

        m.displayBoard();

        while (true) {
            s.prnt("player 1: ");
            in = s.input.next();

            if (s.inArr(options, in.toLowerCase())) {
                
            }

        }
    }
}
