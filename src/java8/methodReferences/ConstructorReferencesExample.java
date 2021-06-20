package java8.methodReferences;

interface Vehicle {

    Car get();
}

class Car {

    public Car() {
        System.out.println("Car Object Created");
    }
}

public class ConstructorReferencesExample {

    public static void main(String[] args) {

        //Lambda Expression
        Vehicle vehicleLambdaExpression = () -> {
            return new Car();
        };
        Car carOne = vehicleLambdaExpression.get();

        //Constructor Reference
        Vehicle vehicleConstructorReferences = Car::new;
        Car carTwo = vehicleConstructorReferences.get();
    }
}
