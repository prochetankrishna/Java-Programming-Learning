package java8.lambdaExpression.lambdaExpressionCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Car {

    int registrationNumber;
    String manufacturerName;
    String modelName;

    public Car(int registrationNumber, String manufacturerName, String modelName) {
        this.registrationNumber = registrationNumber;
        this.manufacturerName = manufacturerName;
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber=" + registrationNumber +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}

public class SortingCustomClassUsingLambda {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();
        carList.add(new Car(123, "Tesla", "Roadster"));
        carList.add(new Car(456, "BMW", "X8"));
        carList.add(new Car(245, "Audi", "R8"));
        Collections.sort(carList, (carOne, carTwo) -> {
            if (carOne.registrationNumber < carTwo.registrationNumber) {
                return 1;
            } else if (carOne.registrationNumber > carTwo.registrationNumber) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println(carList); //Descending Order based on comparator defined above
    }
}
