package java8.primitiveTypeFunctionalInterfaces;

/*
interface IntPredicate {

    boolean test (int i);
}
*/

import java.util.function.IntPredicate;

public class IntPredicateDemo {

    public static void main(String[] args) {
        int[] arr = {0, 5, 10, 15, 20, 25, 30, 35, 40};
        IntPredicate isNumberEvenIntPredicate = number -> number % 2 == 0;
        for (int x : arr) {
            System.out.println("Is " + x + " even ? : " + isNumberEvenIntPredicate.test(x));
        }
    }
}
