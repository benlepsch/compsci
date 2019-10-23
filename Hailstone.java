public class Hailstone {
    public static Shortcuts s = new Shortcuts();

    static int even(int num) {
        return num/2;
    }

    static int odd(int num) {
        return num * 3 + 1;
    }

    static void doAllCycle() {
        int loops = 0, start = 0;
        for (int i = 3; i < 201; i++) {
            loops = 0;
            start = i;
            while (true) {
                if (start % 2 == 0)
                    start = even(start);
                else 
                    start = odd(start);
                
                loops ++;

                if (start == 4) {
                    s.prntln(i + " works, done in " + loops + " loops");
                    break;
                }
                if (loops > 2000) {
                    s.prntln(i + "doesn't work :(");
                    break;
                }
            }
        }
        s.prntln("done");
    }

    static void maxIterations() {
        int loops = 0, start = 0, max = 0, index = 0;
        for (int i = 3; i < 201; i++) {
            loops = 0;
            start = i;
            while (true) {
                if (start % 2 == 0)
                    start = even(start);
                else 
                    start = odd(start);
                
                loops ++;

                if (loops > max) {
                    max = loops;
                    index = i;
                }
                
                if (start == 4) {
                    s.prntln(i + " works, done in " + loops + " loops");
                    break;
                }
                if (loops > 2000) {
                    s.prntln(i + "doesn't work :(");
                    break;
                }
            }
        }
        s.prntln(index + " had the most loops, with " + max);
    }
    
    public static void main(String[] args) {
        maxIterations();
    }
}