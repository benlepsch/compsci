import java.util.*;

public class Analysis {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        int toi = 0;
        String input;

        s.prntln("Enter some numbers 1-50:");
        while (true) {
            input = s.input.next();
            if (input.equals("end"))
                break;
            
            if (Integer.parseInt(input) > 50 || Integer.parseInt(input) < 1) {
                s.prntln("that's outside the bounds");
            } else {
                numbers[toi] = Integer.parseInt(input);
                toi ++;
            }
        }
        int[] arr = new int[toi];
        
        for (int i = 0; i < toi; i++) {
            arr[i] = numbers[i];
        }

        int max, min;

        max = arr[0];
        min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
            if (min > arr[i])
                min = arr[i];
        }        
        
        int[] occurrences = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            occurrences[arr[i]] ++;
        }

        int most = 0, median = 0;
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > most) {
                most = occurrences[i];
                median = i;
            }
        }


        s.prntln("Average: " + s.average(arr));
        s.prntln("Max: " + max + " Min: " + min + " Range: " + (max-min));
        s.prntln("Mode: " + median);

        for (int i = 5; i <= 50; i += 5) {
            s.prnt((i-4) + " - " + i + " : ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i && arr[j] >= i-4) 
                    s.prnt("*");
            }
            s.prntln();
        }
        //s.prntln(arr);
    }
}
