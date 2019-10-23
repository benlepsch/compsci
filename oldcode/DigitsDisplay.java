import java.util.*;

public class DigitsDisplay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shortcuts s = new Shortcuts();
        s.prnt("Enter an integer: ");
        String num = input.next();
        for (int i = 0; i < num.length(); i++) {
            s.prntln(num.charAt(i) + "");
        }
    }
}