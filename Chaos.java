public class Chaos {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        double start, x = 0.5;
        s.prnt("Enter a number between 2 and 4: ");
        start = s.input.nextDouble();
        s.input.close();

        for (int i = 0; i < 50; i++) {
            x = (start*x)*(1-x);
            s.prnt(x + " ");
        }
        s.prntln();
        s.prntln("Final value: " + x);
    }
}