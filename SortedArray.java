import java.util.*;

public class SortedArray {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        int[] nums;
        SelectionSort sortedArray;

        s.prnt("How many values in the array? ");
        nums = new int[s.input.nextInt()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random()*101);
        }
        s.prntln(nums);

        sortedArray = new SelectionSort(nums);
        sortedArray.display();
    }
}
