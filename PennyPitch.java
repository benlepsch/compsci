import java.util.*;

public class PennyPitch {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        String[] board = new String[25];

        for (int i = 0; i < board.length; i++)
            board[i] = "      ";
        
        String[] prizes = new String[] {"puzzle", "poster", " doll ", " ball ", " game "};
        int t;

        for (int i = 0; i < prizes.length; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    t = (int) (Math.random()*board.length);
                } while (!board[t].equals("      "));

                board[t] = prizes[i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            s.prnt("[" + board[i] + "] ");
            if ((i+1) % 5 == 0)
                s.prntln();
        }

        HashMap<String, Integer> win = new HashMap<String, Integer>();
        for (int i = 0; i < prizes.length; i++) 
            win.put(prizes[i], 0);
        
        int toss;
        for (int i = 0; i < 10; i++) {
            toss = (int) (Math.random() * board.length);
            if (!board[toss].equals("      ")) {
                win.put(board[toss], win.get(board[toss]) + 1);
            }
        }

        s.prntln("You won: ");
        for (int i = 0; i < prizes.length; i++) {
            if (win.get(prizes[i]) >= 3) {
                s.prntln(prizes[i]);
            }
        }
        
    }
}
