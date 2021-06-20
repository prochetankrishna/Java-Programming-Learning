package java8.lambdaExpression;

interface electricCar {

    default void switchOnEngine() {
        System.out.println("Starting Engine using Electric Charge");
    }
}

interface petrolCar {

    default void switchOnEngine() {
        System.out.println("Starting Engine using Petrol Ignition");
    }
}

class HybridCarOne implements electricCar, petrolCar {

    public void switchOnEngine() {
        petrolCar.super.switchOnEngine();
    }
}

class HybridCarTwo implements electricCar, petrolCar {

    @Override
    public void switchOnEngine() {
        System.out.println("Starting Engine using Petrol and then shifting to Electric");
    }
}

public class MultipleInheritanceDefaultMethods {

    public static void main(String[] args) {

        HybridCarOne carOne = new HybridCarOne();
        carOne.switchOnEngine();

        HybridCarTwo carTwo = new HybridCarTwo();
        carTwo.switchOnEngine();
    }
}
