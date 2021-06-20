package java8.primitiveTypeFunctionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorsExample {

    public static void main(String[] args) {

        //If Input and Output are of Same Type
        /*
        interface UnaryOperator<T> {
            T apply(T t);
        }
        */
        UnaryOperator<Integer> squareOperator = (number) -> number * number;
        System.out.println("Square of 10 : " + squareOperator.apply(10));
    }
}

/*
interface IntUnaryOperator {
    int applyAsInt (int i);
}

interface LongUnaryOperator {
    long applyAsLong (long l);
}

interface DoubleUnaryOperator {
    double applyAsDouble (double d);
}
*/
