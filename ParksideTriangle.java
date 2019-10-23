public class ParksideTriangle {
    public static Shortcuts s = new Shortcuts();

    public static int getNum(int num) {
        // not num % 9 because then you get 0 when it should be 9
        while (num > 9) {
            num -= 9;
        }
        return num;
    }

    /*
        1 2 4 7 2 7     1
          3 5 8 3 8     2
            6 9 4 9     3
              1 5 1     4
                6 2     5
                  3     6
    */

    public static void printParksideTriangle(int size, int seed) {
        int original = seed, t = 1;
        for (int i = 1; i <= size; i++) { // loops through rows
            // this is just to format the triangle correctly
            for (int k = 0; k < i - 1; k++) {
                s.prnt(" ");
            }

            for (int j = i - 1; j < size; j++) { // loops through each char in the rows
                seed = getNum(seed + j);
                s.prnt(seed);
            }

            s.prntln();

            seed = getNum(original + t + i-1);
            t += i;
        }
    }

    /*
        this loops through from 1-9 going up and down but 
        at the start of each row
        it adds the number of the row that it's on'
        except the first row is zero
    */

    public static void main(String[] args) {
        int size, seed;
        s.prnt("Enter size: ");
        size = s.input.nextInt();
        s.prnt("Enter seed: ");
        seed = s.input.nextInt();

        printParksideTriangle(size, seed);
    }
}
