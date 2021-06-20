package java8.lambdaExpression.lambdaExpressionIntroduction;

@FunctionalInterface
interface lambdaPrinter {

    void print();
}

public class UsingLambdaExpression {

    public static void main(String[] args) {

        //Define display() of Lambda
        lambdaPrinter laserJetPrinter = () -> {
            System.out.println("LaserJet Printer");
            System.out.println("Started Printing");
            System.out.println("Printing........");
            System.out.println("Printing Completed");
        };

        lambdaPrinter superFastPrinter = () -> {
            System.out.println("Super Fast Printer");
            System.out.println("Started Printing....Printing....Printing Complete");
        };

        laserJetPrinter.print();
        System.out.println();
        superFastPrinter.print();
    }
}
