package java8.preDefinedFunctionInterfaces.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
interface Function<T, R> {

    R apply (T t);
}
*/

class Employee {

    int salary;
    String name;

    public Employee(int salary, String name) {
        this.salary = salary;
        this.name = name;
    }
}

public class FunctionDemo {

    public static void main(String[] args) {

        Function<String, Integer> stringLengthFunction = str -> str.length();
        System.out.println("Length of 'Chetan Krishna' : " + stringLengthFunction.apply("Chetan Krishna"));

        Function<Integer, Integer> squareOfNumberFunction = number -> number * number;
        System.out.println("Square of 8 : " + squareOfNumberFunction.apply(8));

        Function<List<Employee>, Integer> avgSalaryFunction = employeeList -> {
            int totalSalary = 0;
            for (Employee currentEmployee : employeeList) {
                totalSalary += currentEmployee.salary;
            }
            return totalSalary / employeeList.size();
        };
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add (new Employee(100000, "Chetan Krishna"));
        employeeList.add (new Employee(150000, "Chanchal Krishna"));
        System.out.println("AVG Salary : " + avgSalaryFunction.apply(employeeList));

        Function<String, Integer> numberOfSpaceFunction = str -> str.length() - str.replaceAll(" ", "").length();
        System.out.println("Number of Spaces in 'Java is Object Oriented Programming Language' without space is : " +
                numberOfSpaceFunction.apply("Java is Object Oriented Programming Language"));
    }
}
