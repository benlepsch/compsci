import java.util.*;

public class EvensAndOdds {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        int[] rng = new int[25];

        for (int i = 0; i < rng.length; i++) {
            rng[i] = s.randInt(0, 100);
        }

        s.prntln("ODD:");

        for (int i = 0; i < rng.length; i++) {
            if (rng[i] % 2 != 0)
                s.prnt(rng[i] + " ");
        }

        s.prntln();
        s.prntln("EVEN:");

        for (int i = 0; i < rng.length; i++) {
            if (rng[i] % 2 == 0)
                s.prnt(rng[i] + " ");
        }
        s.prntln();
    }
}
