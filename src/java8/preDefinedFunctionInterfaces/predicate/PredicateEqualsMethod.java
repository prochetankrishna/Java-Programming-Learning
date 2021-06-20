package java8.preDefinedFunctionInterfaces.predicate;

import java.util.function.Predicate;

public class PredicateEqualsMethod {

    public static void main(String[] args) {
        //isEqual Method [Static]
        Predicate<String> isChetanKrishna = Predicate.isEqual("Chetan Krishna");
        System.out.println("Is Student 'Chetan Krishna' ? : " + isChetanKrishna.test("Chetan Krishna"));
        System.out.println("Is Student 'Chetan Krishna' ? : " + isChetanKrishna.test("Chanchal Krishna"));
    }
}
