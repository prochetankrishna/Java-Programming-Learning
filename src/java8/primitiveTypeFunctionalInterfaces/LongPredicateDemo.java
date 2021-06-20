package java8.primitiveTypeFunctionalInterfaces;

import java.util.function.LongPredicate;

/*
interface LongPredicate {

    boolean test (long l);
}
*/
public class LongPredicateDemo {

    public static void main(String[] args) {
        long[] arr = {0, 5, 10, 15, 20, 25, 30, 35, 40};
        LongPredicate isNumberEvenLongPredicate = number -> number % 2 == 0;
        for (long x : arr) {
            System.out.println("Is " + x + " even ? : " + isNumberEvenLongPredicate.test(x));
        }
    }
}
