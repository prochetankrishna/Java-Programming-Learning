package java8.preDefinedFunctionInterfaces.predicate;

import java.util.function.Predicate;

public class PredicateJoining {

    public static void main(String[] args) {

        Predicate<Integer> isEvenPredicate = number -> number % 2 == 0;
        Predicate<Integer> isGreaterThanTen = number -> number > 10;

        //Check Whether number is less than or equal to 10
        Predicate<Integer> isSmallerThanEqualToTen = isGreaterThanTen.negate();
        System.out.println("Is 5 Greater than 10 : " + isSmallerThanEqualToTen.test(5));
        System.out.println("Is 5 Greater than 10 : " + isGreaterThanTen.negate().test(5));

        //Check Whether number is greater than 10 and Even
        Predicate<Integer> isEvenAndGreaterThanTen = isEvenPredicate.and(isGreaterThanTen);
        System.out.println("Is 11 greater than 10 AND even ? : " + isEvenAndGreaterThanTen.test(11));
        System.out.println("Is 11 greater than 10 AND even ? : " +
                isEvenPredicate.and(isGreaterThanTen).test(11));

        //Check Whether number is greater than 10 or even
        Predicate<Integer> isEvenOrGreaterThanTen = isEvenPredicate.or(isGreaterThanTen);
        System.out.println("Is 11 greater than 10 OR even ? : " + isEvenOrGreaterThanTen.test(11));
        System.out.println("Is 11 greater than 10 OR even ? : " +
                isEvenPredicate.or(isGreaterThanTen).test(11));

        //Perform some operation only for non null and non empty string
        String[] stringArr = {"Chetan", "", null, "Krishna"};
        Predicate<String> isStringValid = str -> str != null && str.length() != 0;
        for (String currentString : stringArr) {
            if (isStringValid.test(currentString)) {
                System.out.println(currentString);
            }
        }
    }
}
