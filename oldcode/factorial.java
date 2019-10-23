import java.util.*;

public class factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double n;

        System.out.print("Enter the value to factorial: ");
        n = input.nextInt();

        if (n == 0) {
            System.out.println(n + "! = 1");
        } else if (n < 0) {
            System.out.println(n + "! is undefined");
        } else {
            if (n > 142) {
                System.out.println(n + "! is too big to compute");
            } else {
                System.out.print(n + "! is " );
                System.out.println((Math.pow(n, n)*Math.sqrt(2*Math.PI*n))/Math.pow(Math.E, n));
            }
        }
    }
}