import java.util.*;

public class GeneratedNums {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        int val;
        s.prntln("Index\tGenerated Number");
        for (int i = 0; i < 101; i++) {
            String t = i + "";
            val = i;
            for (int j = 0; j < t.length(); j++) 
                val += Integer.parseInt(t.charAt(j) + "");
            
            s.prntln(i + "\t" + val);
        }
    }
}
