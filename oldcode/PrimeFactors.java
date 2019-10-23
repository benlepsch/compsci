import java.util.*;

public class PrimeFactors {
    static void primeFactors(int num) {
        int counter = 2;
        while (counter <= num) {
            if (num % counter == 0) {
                System.out.print(counter + " ");
                primeFactors(num/counter);
                break;
            } else {
                counter ++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shortcuts s = new Shortcuts();
        int num;
        s.prntln("Enter a number to get prime factors of");
        num = input.nextInt();
        s.prnt("Prime Factors: ");
        primeFactors(num);
        s.prntln(""); 
        //System.out.println(s.primeFactors(num));
    }
}