public class CubesSum {
    public static void main(String[] args) {
        int sumCubes;
        Shortcuts s = new Shortcuts();

        for (int i = 0; i < 10000; i++) {
            String n = i + "";
            sumCubes = 0;
            for (int j = 0; j < n.length(); j++) {
                sumCubes += Math.pow(Integer.parseInt(n.charAt(j) + ""), 3);
            }
            if (sumCubes == i) {
                s.prnt(" " + i);
            }
        }
        s.prntln("");
    }
}