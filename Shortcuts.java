import java.util.*;

public class Shortcuts {
    public static Shortcuts s = new Shortcuts();
    Scanner input = new Scanner(System.in);

    void sortMinMax(int[] nums) {
        
    }

    /**
     * print a char array formatted as a string
     */
    public String prntAsString(char[] arr) {
        String out = "";
        for (int i = 0; i < arr.length; i++) {
            out += arr[i];
        }
        return out;
    }

    /**
     * detects if the value "val" is in the array "arr"
     * @param arr - array to search
     * @param val - value to search for
     * @return
     */
    public boolean inArr(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean inArr(char[] arr, char val) {
        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * fill an array with a value
     * @param arr - array to fill
     * @param val - value to fill with
     */
    public int[] fill(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = val;
        }
        return arr;
    }

    /**
     * return the average of an int array
     */
    double average(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        return (double) sum / nums.length;
    }
    
    /**
     * return a random integer from lower(inclusive)  to upper(not inclusive)
     */
    int randInt(int lower, int upper) {
        return (int)(Math.random() * (upper - lower)) + lower;
    }

    /**
     * shortcuts for System.out.print and .println 
     * there are so many because i had to do one for every variable type they could be passed
     */
    void prntln(int[] output) {
        s.prnt("[");
        for (int i = 0; i < output.length; i++)
            s.prnt(output[i] + ", ");
        s.prntln("]");
    }
    void prntln(char[] output) {
        s.prnt("[");
        for (int i = 0; i < output.length; i++)
            s.prnt(output[i] + ", ");
        s.prntln("]");
    }
    void prntln(String output) {
        System.out.println(output);
    }
    void prntln(char output) {
        s.prntln("" + output);
    }
    void prntln(int output) {
        s.prntln("" + output);
    }
    void prntln(double output) {
        s.prntln("" + output);
    }
    void prntln(boolean output) {
        System.out.println(output);
    }
    void prntln() {
        s.prntln("");
    }

    void prnt(String output) {
        System.out.print(output);
    }
    void prnt(char output) {
        s.prnt("" + output);
    }
    void prnt(int output) {
        s.prnt("" + output);
    }
    void prnt(double output) {
        s.prnt("" + output);
    }


    /**
     * random functions i was doing for other assignments anyway
     * @param number to check if prime
     * @return true or false
     */
    boolean isPrime(int num) {
        for (int i = 2; i < num/2; i++) 
            if (num % i == 0) 
                return false;
        return true;
    }

    /**
     * misleading name, it actually truncates
     * @param num: number to truncate
     * @param places: number of decimal points to leave
     * @return: truncated number
     */
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