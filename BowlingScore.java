import java.util.*;

public class BowlingScore {
    public static Shortcuts s = new Shortcuts();

    int score;
    BowlingFrame[] frames = new BowlingFrame[12];
    // "line" represents the line of input with numbers of pins knocked down
    // each frame should have two numbers unless the first number is a 10
    // an example line would be:
    // 9 0 10 9 1 8 0 10 10 10 9 0 9 0 8 0
    // would be separated into frames like
    // (9, 0), (10), (9, 1), (8, 0), (10), (10), (10), (9, 0), (9, 0), (8, 0)
    // how do i even store this tho
    // here's an idea: i make a new class for a "frame"
    // "frame" will have firstRoll and secondRoll as the number of pins knocked down, if the first was 10 the second will be 0
    // it will also have boolean values for strike or spare
    // it will have an integer value for score but that will only be calculated if its an open frame, otherwise it will probably be uninitialized
    public BowlingScore(String line) {
        // first things first lets break string into substrings separated by spaces
        // to do this we need an array so we find the length the array will be first by checking how many spaces there are
        s.prntln("we have recieverd line " + line);
        int spaces = 1;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ' && i < line.length() - 1) {
                spaces ++;
            }
        }

        int[] scores = new int[spaces];
        int last = 0, c = 0;
        for (int i = 0; i < line.length(); i++) {
            // int everything that comes before a space
            if (line.charAt(i) == ' ') {
                //s.prntln("parseintin " + line.substring(last, i));
                scores[c] = Integer.parseInt(line.substring(last, i));
                last = i+1;
                c ++;
                // if the person put a space at the end of the line, quit before the program breaks
                if (last == line.length()) {
                    //s.prntln("breakin");
                    break;
                }
            }

            // int the end of the line because there's no space after it
            if (i == line.length() - 1) {
                //s.prntln("parseintin " + line.substring(last, 1+i));
                scores[c] = Integer.parseInt(line.substring(last, i+1));
                last = i+1;
                c ++;
            }
        }
        // fun fact: all of the code above, if written in python, would be `scores = [int(i) for i in line.split(' ')]`
        s.prntln(scores);

        // ok, now we've got an array with every score in it
        // now we need to change that array into frames 
        // oh boy

        c = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == 10) {
                frames[c] = new BowlingFrame(c, new int[] {10, 0});
                c ++;
            } else {
                //s.prntln("making new frame with " + scores[i] + " and " + scores[i+1]);
                frames[c] = new BowlingFrame(c, new int[] {scores[i], scores[i+1]});
                c ++;
                i ++;
            }
        }

        // ok now we've got an array with every frame in it
        // we're just assuming for now that the person has entered all of the data correctly and that it was a valid game
        // now what? we need to score them i guess
        // this might get recursive so best to write a new function

        for (BowlingFrame f : frames) {
            if (f == null)
                break;
            //s.prntln("Getting score for frame:");
            //s.prntln(f.show());
            getScore(f);
        }
        
        for (BowlingFrame f : frames) {
            if (f == null)
                break;
            s.prntln(f.show());
        }
        
    }

    // i'm not doing this in the BowlingFrame class because i need to use other frames if it's a strike or spare
    int getScore(BowlingFrame frame) {
        // if it's not a strike or spare, its EZ
        if (!frame.strike && !frame.spare) {
            frame.score = frame.roll1 + frame.roll2;
            return frame.score;
        }

        if (frame.strike) {
            // get score from next two frames
            frame.score = 10 + getScore(frames[frame.index + 1]) + getScore(frames[frame.index + 2]);
            return frame.score;
        }

        if (frame.spare) {
            frame.score = 10 + getScore(frames[frame.index + 1]);
            return frame.score;
        }

        return 0;
    }

    public static void main(String[] args) {
        s.prnt("Enter scores: ");
        BowlingScore bruh = new BowlingScore(s.input.nextLine());
        
    }
}
