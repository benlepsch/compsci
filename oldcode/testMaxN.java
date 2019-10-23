import java.util.*;

public class testMaxN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n;
        int b = 2;
        int a = 74;
        double z = 123.456;
        char nice = (char) (z - 25);
        a*=2+5;
        ++a;
        System.out.println(nice);
        n = input.nextInt();
        System.out.println((Math.pow(n, n)*Math.sqrt(2*Math.PI*n))/Math.pow(Math.E, n));
    }
}