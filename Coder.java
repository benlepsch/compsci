import java.util.*;

public class Coder {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        s.prnt("Enter a string: ");
        String toencode = s.input.nextLine();
        char[] encoded = new char[toencode.length()];

        for (int i = 0; i < toencode.length(); i++) {
            if (toencode.charAt(i) == 'x') {
                encoded[i] = 'a';
            } else if (toencode.charAt(i) == 'y') {
                encoded[i] = 'b';
            } else if (toencode.charAt(i) == ' ') {
                encoded[i] = ' ';
            } else {
                encoded[i] = (char)(toencode.charAt(i) + 2);
            }
        }

        s.prntln(s.arrToString(encoded));
    }
}
