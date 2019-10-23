import java.util.*;

public class Palindrome {
    public static Shortcuts s = new Shortcuts();

    public static boolean isPalindrome(String word) {
        char[] forwards = new char[word.length()];
        char[] backwards = new char[word.length()];

        for (int i = 0; i < word.length(); i++) {
            forwards[i] = word.charAt(i);
            backwards[i] = word.charAt(word.length() - (i + 1));
        }

        for (int i = 0; i < forwards.length; i++) {
            if (forwards[i] != backwards[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "turtle";
        String palindrome = "neveroddoreven";

        s.prntln(isPalindrome(word));
        s.prntln(isPalindrome(palindrome));
    }
}
