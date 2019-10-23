import java.util.*;

public class Shortcuts {
    public static Shortcuts s = new Shortcuts();
    Scanner input = new Scanner(System.in);

    /**
     * shortcuts for System.out.print and .println 
     * there are so many because i had to do one for every variable type they could be passed
     */
    void prntln(String output) {
        System.out.println(output);
    }
    void prntln(int output) {
        s.prntln("" + output);
    }
    void prntln(double output) {
        s.prntln("" + output);
    }
    void prntln(char output) {
        s.prntln("" + output);
    }
    void prntln() {
        s.prntln("");
    }

    void prnt(String output) {
        System.out.print(output);
    }
    void prnt(int output) {
        s.prnt("" + output);
    }


    /**
     * random functions i was doing for other assignments anyway
     * @param num
     * @return
     */
    boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) 
            if (num % i == 0) 
                return false;
        return true;
    }


    double round(double num, int places) {
        String numHolder = "" + num;
        int dec = -1;
        String beforeDec, afterDec;
        places += 1;

        for (int i = 0; i < numHolder.length(); i++) {
            if (numHolder.charAt(i) == '.') {
                dec = i;
            }
        }


        beforeDec = numHolder.substring(0, dec);
        afterDec = numHolder.substring(dec + 1, dec + places);

        return Double.parseDouble(beforeDec + '.' + afterDec);
    }

}