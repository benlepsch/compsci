import java.util.*;

public class Reduce {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num, denom, GCF=0;
        System.out.print("Enter numerator: ");
        num = input.nextInt();
        System.out.print("Enter denominator: ");
        denom = input.nextInt();
        //int adjusted = 0;
        //do {
            //adjusted = 0;
            for (int i = num; i >= 1; i --) {
                if (num % i == 0 && denom % i == 0) {
                    //adjusted = 1;
                    num = num / i;
                    denom = denom / i;
                    if (GCF == 0) {
                        GCF = i;
                    }
                    break;
                }
            }
        //} while (adjusted == 1);

        System.out.println("final fraction: " + num + "/" + denom);
        System.out.println("GCF of original fraction was " + GCF);
    }
}
