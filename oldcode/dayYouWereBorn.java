import java.util.*;

public class dayYouWereBorn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String bday;
        int year, month, fday, total;

        // input will look like 5-15 78
        // month-day last2digitsofyear

        System.out.print("Enter your birth date (ex: 5-15 78): ");
        bday = input.nextLine();
        total = 0;

        if (bday.substring(1,2).equals("-")) {
            fday = Integer.parseInt(bday.substring(2, 4));
            month = Integer.parseInt(bday.substring(0, 1));
        } else {
            fday = Integer.parseInt(bday.substring(3, 5));
            month = Integer.parseInt(bday.substring(0, 2));
        }
        
        year = Integer.parseInt(bday.substring(bday.length() - 4));

        if (year >= 2000) {
            total += 6;
        }

        System.out.println("Year: " + year);
        year = year % 100;
        System.out.println("Year: " + year);

        total += Math.round(year / 4) + year + fday;
        System.out.println("Total: " + total);

        switch (month) {
            case 1:
                total += 1;
                break;
            case 2:
                total += 4;
                break;
            case 3:
                total += 4;
                break;
            case 5:
                total += 2;
                break;
            case 6: 
                total += 5;
                break;
            case 8:
                total += 3;
                break;
            case 9:
                total += 6;
                break;
            case 10:
                total += 1;
                break;
            case 11:
                total += 4;
                break;
            case 12:
                total += 6;
                break;
        }
        System.out.println("Total: " + total);

        if ((100 - year) % 4 == 0) {
            if (month == 1 || month == 2) {
                total --;
            }
        }

        System.out.println("Total: " + total);

        total = total % 7;

        System.out.println("Total: " + total);

        String day;

        System.out.print("You were born on a ");
        switch (total) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            default:
                day = "Saturday";
                break;
        }
        System.out.println(day);
    }
}