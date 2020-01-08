import java.util.*;

public class Convert {
    public static Shortcuts s = new Shortcuts();

    /*
        2EF
        i = 0
        j = 3 - i - 0 = 2
        for char in number:
            total += number[i] * base ^ j
    */
    public static int convertToTen(String number, int base) {
        int total = 0;
        int j;
        double adding;
        for (int i = 0; i < number.length(); i++) {
            j = number.length() - i - 1;

            switch (number.charAt(i)) {
                case 'A':
                    adding = 10 * Math.pow(base, j);
                    break;
                case 'B':
                    adding = 11 * Math.pow(base, j);
                    break;
                case 'C':
                    adding = 12 * Math.pow(base, j);
                    break;
                case 'D':
                    adding = 13 * Math.pow(base, j);
                    break;
                case 'E':
                    adding = 14 * Math.pow(base, j);
                    break;
                case 'F':
                    adding = 15 * Math.pow(base, j);
                    break;

                default:
                    adding = (Character.getNumericValue(number.charAt(i)) * Math.pow(base, j));
                    break;
            }
            total += adding;
        }

        return total;
    }

    public static String convertToWeird(int number, int base) {
        if (base > 16)
            base = 16;
        if (base < 0)
            base = 0;
        
        String done = "";
        int pp;
        String prep;

        while (number != 0) {
            pp = number % base;
            if (pp < 10) {
                prep = Integer.toString(pp);
            } else {
                switch (pp) {
                    case (10):
                        prep = "A";
                        break;
                    case (11):
                        prep = "B";
                        break;
                    case (12):
                        prep = "C";
                        break;
                    case (13):
                        prep = "D";
                        break;
                    case (14):
                        prep = "E";
                        break;
                    default:
                        prep = "F";
                        break;
                }
            }
            done = prep + done;
            number /= base;
        }

        return done;
    }

    public static void main(String[] args) {
        //System.out.println(convertToTen("11001", 2));
        //System.out.println(convertToTen("2EF", 16));
        //System.out.println(convertToWeird(751 ,16));
        int base1, base2, baseR;
        String n1, n2;
        String operator;

        s.prnt("Enter the base of the first number: ");
        base1 = s.input.nextInt();
        s.prnt("Enter the number: ");
        n1 = s.input.next();
        s.prnt("Enter the base of the second number: ");
        base2 = s.input.nextInt();
        s.prnt("Enter the number: ");
        n2 = s.input.next();

        s.prnt("Enter the operation: ");
        operator = s.input.next();
        s.prnt("Enter the base of the result: ");
        baseR = s.input.nextInt();

        String ans;

        switch (operator) {
            case "+":
                ans = convertToWeird(( convertToTen(n1, base1) + convertToTen(n2, base2) ), baseR);
                break;
            case "-":
                ans = convertToWeird(( convertToTen(n1, base1) - convertToTen(n2, base2) ), baseR);
                break;
            case "*":
                ans = convertToWeird(( convertToTen(n1, base1) * convertToTen(n2, base2) ), baseR);
                break;
            default:
                ans = convertToWeird(( convertToTen(n1, base1) / convertToTen(n2, base2) ), baseR);
                break;
        }

        s.prntln(n1 + " {" + convertToTen(n1, base1) + "} " + operator + " " + n2 + " {" + convertToTen(n2, base2) + "} = " + ans + " {" + convertToTen(ans, baseR) + "}");

    }
}
