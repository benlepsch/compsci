public class MyCode {
    public void coolMethod(String parameter) {
        int[][] twoDArray = new int[parameter.length()][parameter.length()];
        int ltot;
        int maxtot = 0, maxl = 0;
        String max = "";

        for (int i = 0; i < twoDArray.length; i++) {
            ltot = 0;
            for (int j = 0; j < twoDArray[0].length; j++) {
                twoDArray[i][j] = parameter.charAt(i) * j;
                ltot += twoDArray[i][j];
            }
            if (ltot > maxtot) {
                maxtot = ltot;
                maxl = i;
            }
            System.out.println("Line total: " + ltot);
        }

        for (int j = 0; j < twoDArray[0].length; j++) {
            max += Character.toString((char)twoDArray[maxl][j]);
        }
        System.out.println("Highest scoring line: " + max);
    }

    public static void main(String[] args) {
        MyCode m = new MyCode();
        m.coolMethod("bruh to the max");
    }
}