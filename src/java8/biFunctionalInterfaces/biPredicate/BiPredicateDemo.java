package java8.biFunctionalInterfaces.biPredicate;

/*
interface BiPredicate<T, U> {

    boolean test (T t, U u);
}
 */

import java.util.function.BiPredicate;

public class BiPredicateDemo {

    public static void main(String[] args) {

        BiPredicate<Integer, Integer> isTaxableBiPredicate = (basicSalary, incentive) -> {

            return (basicSalary * 0.7 + incentive) > 20000 ? true : false;
        };
        System.out.println("Salary : 50000, Incentive : 20000 -> Taxable : " + isTaxableBiPredicate.test(50000, 20000));
    }
}
