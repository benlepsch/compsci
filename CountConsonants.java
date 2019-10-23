import java.util.*;

public class CountConsonants {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        s.prnt("enter string: ");
        int consonant = 0;
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', ' '};
        String input = s.input.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (!s.inArr(vowels, input.charAt(i))) {
                consonant ++;
            }
        }
        s.prntln("THerea re this many consonant: " + consonant);
    }
}
