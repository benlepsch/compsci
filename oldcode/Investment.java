import java.util.*;

public class Investment {
    public static void main(String[] args) {
        Shortcuts s = new Shortcuts();
        double years = s.round(Math.log(2)/Math.log(1.075), 2);
        // A = final P = initial r = .075 n = number of times compounded per t = years
        // A = P(1 + r/n)^nt
        // A/P = (1 + r/n)^nt
        // ln(A/P)/nln(1+r/n) = t
        // ln(2)/ln(1.075) = t
        s.prntln("It will take " + years + " years for $2500 to grow to $5000");
    }
}