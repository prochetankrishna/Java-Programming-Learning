package java8.biFunctionalInterfaces.biFunction;

/*
interface BiFunction<T, U, R> {

    R apply (T t, U u);
}
*/

import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Double> computeTaxBiFunction = (basicSalary, incentive) -> {

            return basicSalary * 0.1 + incentive * 0.2;
        };
        System.out.println("Tax for Basic Salary [50000] and Incentive [20000] : " +
                computeTaxBiFunction.apply(50000, 20000));
    }
}
