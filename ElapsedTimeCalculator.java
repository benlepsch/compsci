public class ElapsedTimeCalculator {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        s.prnt("Enter the starting hour: ");
        int start = s.input.nextInt();
        s.prnt("Enter am or pm: ");
        String half = s.input.next();
        s.prnt("Enter the number of elapsed hours: ");
        int elapsed = s.input.nextInt();
        String nhalf;

        int nt = elapsed + start;
        if (nt > 12) {
            nt -= 12;
            if (half.equals("pm"))
                nhalf = "am";
            else
                nhalf = "pm";
        } else {
            nhalf = half;
        }
        s.prntln("The time is: " + nt + ":00 " + nhalf);
    }
}