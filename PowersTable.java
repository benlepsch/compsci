public class PowersTable {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        s.prntln("x^1\tx^2\tx^3\tx^4\tx^5");
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 6; j++) {
                s.prnt((int)Math.pow(i, j) + "\t");
            }
            s.prntln();
        }
    }
}