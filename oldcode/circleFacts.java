import java.util.*;

public class circleFacts {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        double radius = input.nextDouble();
        System.out.print("Enter A for area, D for diameter, or C for circumference: ");
        char option = Character.toLowerCase(input.next().charAt(0));

        if (option == 'a') {
            System.out.println("The area of a circle with radius " + radius + " is " + (Math.PI*Math.pow(radius,2)));
        } else if (option == 'd') {
            System.out.println("The diameter of a circle with radius " + radius + " is " + 2 * radius);
        } else if (option == 'c') {
            System.out.println("The circumference of a circle with radius " + radius + " is " + 2*Math.PI*radius);
        }
    }
}