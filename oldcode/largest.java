import java.util.*;

public class largest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int one, two, three, largest;
        System.out.println("Enter three numbers and i'll output the largest one");

        System.out.print("Enter the first number: ");
        one = input.nextInt();
        System.out.print("Enter the second number: ");
        two = input.nextInt();
        System.out.print("Enter the third number: ");
        three = input.nextInt();
        System.out.println();

        largest = one;
        if (two > largest)
            largest = two;
        if (three > largest)
            largest = three;
        
        System.out.println("The largest number is " + largest);
    }
}