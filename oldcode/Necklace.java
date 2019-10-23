import java.util.*;

public class Necklace {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shortcuts s = new Shortcuts();
        int first, second, a, b, out;
        s.prnt("Enter the first starting number: ");
        first = input.nextInt();
        s.prnt("Enter the second starting number: ");
        second = input.nextInt();
        
        boolean hb = false;
        int c = 0;
        
        a = first;
        b = second;
        
        s.prnt(a + " ");
        s.prnt(b + " ");

        do {
            out = first;
            first = second;
            out = second = (out + second) % 10;
            s.prnt(out + " ");
        
            if (a == first && b == second)
                hb = true;
            if (hb)
                c += 1;
        } while (c < 1);
        
        s.prntln();
    }
}

/*

we have
1 8
out = 1
first = 8
out and second = 1 + 8 % 10 = 9

out = 8
first = 9
out and second = 8 + 9 % 10 = 7

out = 9
first = 7
out and second = 9 + 7 % 10 = 6



*/