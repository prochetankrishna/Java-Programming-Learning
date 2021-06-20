package java8.preDefinedFunctionInterfaces.supplier;

/*
interface Supplier <R> {

    R get();
}
 */

import java.util.Date;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        Supplier <Date> getSystemDateSupplier = () -> {
            return new Date();
        };
        System.out.println(getSystemDateSupplier.get());

        Supplier <String> getRandomCity = () -> {

            String[] cities = {"Delhi", "Mumbai", "Chennai", "Kolkata"};
            return cities[(int) (Math.random() * 4)];
        };
        System.out.println(getRandomCity.get());
    }
}
