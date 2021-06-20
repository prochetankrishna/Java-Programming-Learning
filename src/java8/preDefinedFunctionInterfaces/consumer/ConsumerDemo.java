package java8.preDefinedFunctionInterfaces.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
interface Consumer <T> {

    void accept(T t);
}
*/
class Student {

    int studentId;
    String studentName;
    int studentMarks;
    char studentGrade;

    public Student(int studentId, String studentName, int studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
        this.studentGrade = 'X';
    }
}

public class ConsumerDemo {

    public static void main(String[] args) {

        Consumer<String> printString = str -> System.out.println(str);
        printString.accept("Chetan Krishna");

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
        Consumer<Student> printStudentInformation = currentStudent -> {
                System.out.println("***************************************************************");
                System.out.println("Student ID : " + currentStudent.studentId);
                System.out.println("Student Name : " + currentStudent.studentName);
                System.out.println("Student Marks : " + currentStudent.studentMarks);
                System.out.println("Student Grade : " + checkGradeOfStudent.apply(currentStudent));
                System.out.println("***************************************************************");
        };

        for (Student student : studentList) {

            if (isStudentPassPredicate.test(student)) {
                student.studentGrade = checkGradeOfStudent.apply(student);
                printStudentInformation.accept(student);
            }
        }
    }
}
