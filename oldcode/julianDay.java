import java.util.*;

public class julianDay {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a julian day: ");
        int jday = input.nextInt();

        int day = (jday + 1) % 7;

        String weekday;

        switch (day) {
            case 0:
            weekday = "Saturday";
            case 1:
            weekday = "Monday";
            case 2:
            weekday = "Tuesday";
            case 3:
            weekday = "Wednesday";
            case 4:
            weekday = "Thursday";
            case 5:
            weekday = "Friday";
            default:
            weekday = "Saturday";
        }

        System.out.println("Julian Day number " + jday + " is " + weekday);
    }
}