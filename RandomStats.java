import java.util.*;

public class RandomStats {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        int[] occurances = new int[10];
        for (int i = 0; i < 500; i++) {
            occurances[s.randInt(0, 10)] ++;
        }
        s.prntln("Number\tOccurrences");
        for (int i = 0; i < occurances.length; i++) {
            s.prntln(i + "\t" + occurances[i]);
        }
    }
}
