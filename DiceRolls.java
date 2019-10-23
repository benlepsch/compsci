public class DiceRolls {
    public static Shortcuts s = new Shortcuts();
    public static void main(String[] args) {
        s.prntln("Dice 1\tDice2\tTotal");
        int a,b;
        for (int i = 0; i < 5; i++) {
            a = (int)(Math.random()*6) + 1;
            b = (int)(Math.random()*6) + 1;
            s.prntln(a + "\t" + b + "\t" + (a + b));
        }
    }
}