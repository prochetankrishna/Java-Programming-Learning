package java8.lambdaExpression.lambdaExpressionIntroduction;

interface sumCalculator {

    int sum (int numberOne, int numberTwo);
}

public class SumLambdaDemo {

    public static void main(String[] args) {

        sumCalculator calculateSum = (numberOne, numberTwo) -> {
            return numberOne + numberTwo;
        } ;

        System.out.println("Sum of 10 + 20 : " + calculateSum.sum(10, 20));
    }
}
