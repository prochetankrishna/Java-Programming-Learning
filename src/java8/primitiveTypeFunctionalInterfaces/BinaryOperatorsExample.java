package java8.primitiveTypeFunctionalInterfaces;

import java.util.function.BinaryOperator;

public class BinaryOperatorsExample {

    public static void main(String[] args) {

        //When All the type parameter is same in BiFunction
        /*
        interface BinaryOperator<T> {
            T apply(T t1, T t2);
        }
         */
        BinaryOperator<String> concatString = (strOne, strTwo) -> strOne + " " + strTwo;
        System.out.println(concatString.apply("Chetan", "Krishna"));
    }
}
/*
interface IntBinaryOperator {
    int applyAsInt (int i1, int i2);
}

interface LongBinaryOperator {
    long applyAsLong (long l1, long l2);
}

interface DoubleBinaryOperator {
    double applyAsDouble (double d1, double d2);
}
 */
