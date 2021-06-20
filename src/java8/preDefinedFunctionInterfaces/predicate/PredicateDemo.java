package java8.preDefinedFunctionInterfaces.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/*
interface Predicate <T> {
    boolean test(T t);
 */

public class PredicateDemo {

    public static void main(String[] args) {

        Predicate <Integer> isEvenPredicate = (number) -> number % 2 == 0;
        System.out.println("Is 2 Even ? : " + isEvenPredicate.test(2)); //true
        System.out.println("Is 8 Even ? : " + isEvenPredicate.test(8)); //true
        System.out.println("Is 9 Even ? : " + isEvenPredicate.test(9)); //false

        Predicate <Integer> isOddPredicate = (number) -> number % 2 != 0;
        System.out.println("Is 2 Odd ? : " + isOddPredicate.test(2)); //false
        System.out.println("Is 8 Odd ? : " + isOddPredicate.test(8)); //false
        System.out.println("Is 9 Odd ? : " + isOddPredicate.test(9)); //true

        Predicate <String> isLengthGreaterThanFivePredicate = (expression) -> expression.length() > 5;
        System.out.println("Is Length of 'Chetan' Greater than 5 : " +
                isLengthGreaterThanFivePredicate.test("Chetan"));  //true
        System.out.println("Is Length of 'Delhi' Greater than 5 : " +
                isLengthGreaterThanFivePredicate.test("Delhi"));   //false

        Predicate<Collection> isEmptyPredicate = collection -> collection.isEmpty();
        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add (1);
        numberList.add (2);
        System.out.println("Is ArrayList Empty ? : " + isEmptyPredicate.test(numberList));
    }
}
