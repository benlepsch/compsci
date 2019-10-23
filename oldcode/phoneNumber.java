import java.util.*;

public class phoneNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a single letter and i'll give the corresponding digit on a telephone");
        char letter = input.next().charAt(0);
        int number;
        boolean invalid = false;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < alphabet.length(); i++) {
            if (letter == alphabet.charAt(i)) {
                System.out.println("Invalid character: uppercase letters only");
                invalid = true;
                break;
            }
        }

        if (!invalid) {
            letter = Character.toLowerCase(letter);
            
            if (letter == 'a' || letter == 'b' || letter == 'c') {
                number = 2;
            } else if (letter == 'd' || letter == 'e' || letter == 'f') {
                number = 3;
            } else if (letter == 'g' || letter == 'h' || letter == 'i') {
                number = 4;
            } else if (letter == 'j' || letter == 'k' || letter == 'l') {
                number = 5;
            } else if (letter == 'm' || letter == 'n' || letter == 'o') {
                number = 6;
            } else if (letter == 'p' || letter == 'q' || letter == 'r' || letter == 's') {
                number = 7;
            } else if (letter == 't' || letter == 'u' || letter == 'v') {
                number = 8;
            } else {
                number = 9;
            }

            System.out.println("Number is " + number);
        }
    }
}