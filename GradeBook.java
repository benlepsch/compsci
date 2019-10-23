import java.util.*;

public class GradeBook {
    public static Shortcuts s = new Shortcuts();

    int[][] students;

    public void getGrades() {
        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].length; j++) {
                s.prnt("Grade for student " + (i + 1) + ", test " + (j + 1) + ": ");
                students[i][j] = s.input.nextInt();
            }
        }
    }

    public void showGrades() {
        for (int i = 0; i < students.length; i++) {
            s.prnt("Student " + (i + 1) + ": ");
            for (int j = 0; j < students[i].length; j++) {
                s.prnt(students[i][j] + " ");
            }
            s.prntln();
        }
    }

    public double studentAvg(int student) {
        double avg = 0, c = 0;

        for (int i = 0; i < students[student].length; i++) {
            avg += students[student][i];
            c ++;
        }

        return (avg/c);
    }

    public double testAvg(int test) {
        double avg = 0.0, c = 0.0;

        for (int i = 0; i < students.length; i++) {
            avg += students[i][test];
            c ++;
        }

        return (avg/c);
    }

    GradeBook(int numStudents, int numTests) {
        students = new int[numStudents][numTests];
    }
}
