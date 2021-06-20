package java8.biFunctionalInterfaces.biConsumer;

/*
interface BiConsumer <T, U> {

    void accept (T t, U u);
}
*/

import java.util.function.BiConsumer;

public class BiConsumerDemo {

    public static void main(String[] args) {

        BiConsumer <Integer, Integer> printTaxInfoBiConsumer = (basicSalary, incentive) -> {

            System.out.println("Tax for Basic Salary [" + basicSalary + "] and Incentive [" +
                    incentive + "] : " + basicSalary * 0.1 + incentive * 0.2);
        };
        printTaxInfoBiConsumer.accept(50000, 20000);
    }
}
