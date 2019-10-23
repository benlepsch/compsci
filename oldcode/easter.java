import java.util.*;

// i'm chanigng the documentation now
// this code prints easter sunday date for any year 1900 - 2099

public class easter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input a year and i'll tell you somthing");

        int year = input.nextInt();
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;

        System.out.print("Easter sunday is ");
        a = (d + e + 22);

        if (year == 1954 || year == 1981 || year == 2049 || year == 2076) {
            a -= 7;
        }

        if (a > 30) {
            a -= 31;
            System.out.println("April " + a);
        } else {
            System.out.println("March " + a);
        }
    }
}