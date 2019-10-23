import java.util.*;

public class CarRecall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Shortcuts s = new Shortcuts();
        int model;

        do {
            s.prnt("Enter your car's model number or 0 to quit: ");
            model = input.nextInt();
            if ( (model == 221 || model == 780) && model != 0) {
                s.prntln("You car is defective, repair it");
            } else if (model != 0) {
                s.prntln("you're good");
            }
        } while (model != 0);
    }
}