import java.util.*;


public class primes {
    boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        primes temp = new primes();
        Shortcuts s = new Shortcuts();
        Scanner input = new Scanner(System.in);
        int a,b;

        System.out.println("Enter two numbers to get the prime numbers between them:");
        a = input.nextInt();
        b = input.nextInt();

        System.out.print("Primes: ");
        if (a > b) {
            for (int i = b; i < a; i++) {
                if (temp.isPrime(i)) {
                    s.prnt("" + i);
                    System.out.print(" ");
                }
            }
        } else {
            for (int i = a; i < b; i++) {
                if (temp.isPrime(i)) {
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}