package java8.preDefinedFunctionInterfaces.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {

    int studentId;
    String studentName;
    int studentMarks;

    public Student(int studentId, String studentName, int studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }
}

public class PredicateAndFunction {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add (new Student(1, "Chetan Krishna", 85));
        studentList.add (new Student(2, "Chanchal Krishna", 65));
        studentList.add (new Student(3, "Manas Chopra", 45));

        Predicate<Student> isStudentPassPredicate = student -> student.studentMarks >= 50;
        Function<Student, Character> checkGradeOfStudent = student -> {

            if (student.studentMarks > 90) {
                return 'A';
            } else if (student.studentMarks > 75) {
                return 'B';
            } else {
                return 'C';
            }
        };

        for (Student currentStudent : studentList) {
            if (isStudentPassPredicate.test(currentStudent)) {
                System.out.println("***************************************************************");
                System.out.println("Student ID : " + currentStudent.studentId);
                System.out.println("Student Name : " + currentStudent.studentName);
                System.out.println("Student Marks : " + currentStudent.studentMarks);
                System.out.println("Student Grade : " + checkGradeOfStudent.apply(currentStudent));
                System.out.println("***************************************************************");
                System.out.println();
            }
        }
    }
}
