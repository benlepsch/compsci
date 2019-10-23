public class GCD {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        s.prnt("Enter a number: ");
        int a = s.input.nextInt();
        s.prnt("Enter a second number: ");
        int b = s.input.nextInt();
        int temp;

        while (b > 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        s.prntln(a);
    }
}