import java.util.*;

public class CourseGrades {
    public static Shortcuts s = new Shortcuts();

    public static void main(String[] args) {
        GradeBook grades = new GradeBook(12, 5);

        grades.getGrades();
        grades.showGrades();
        s.prntln(grades.studentAvg(2));
        s.prntln(grades.testAvg(2));
    }
}
