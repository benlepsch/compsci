import java.util.*;

public class SelectionSort {
    public static Shortcuts s = new Shortcuts();

    int[] originalArray, sortedArray;
    int max;

    public void display() {
        s.prntln("Sorted array:");
        for (int i = 0; i < sortedArray.length; i++) {
            s.prnt(sortedArray[i] + " ");
        }
        s.prntln();
    }
    
    private int[] sort(int[] arr) {
        int min, index = 0, n = 0;

        do {
            min = max;

            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    index = i;
                }
            }

            sortedArray[n] = min;
            arr[index] = max;
            n++;
        } while (n < arr.length);

        return sortedArray;
    }

    SelectionSort(int[] arr) {
        originalArray = new int[arr.length];
        sortedArray = new int[arr.length];

        max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            originalArray[i] = arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        sortedArray = sort(originalArray);
    }
}
