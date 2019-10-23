public class DigitsSum {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        s.prnt("Enter a postivie integer: ");
        int i = s.input.nextInt(), total = 0;
        String str = "" + i;
        for (int j = 0; j < str.length(); j++) {
            total += Integer.parseInt(str.charAt(j) + "");
        }
        s.prntln(total);
    }
}