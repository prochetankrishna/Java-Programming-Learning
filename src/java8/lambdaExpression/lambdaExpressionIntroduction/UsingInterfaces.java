package java8.lambdaExpression.lambdaExpressionIntroduction;

@FunctionalInterface
interface printer {

    void print();
}

class LaserJetPrinter implements printer {

    @Override
    public void print() {
        System.out.println("LaserJet Printer");
        System.out.println("Started Printing");
        System.out.println("Printing........");
        System.out.println("Printing Completed");
    }
}

class SuperFastPrinter implements printer {

    @Override
    public void print() {
        System.out.println("Super Fast Printer");
        System.out.println("Started Printing....Printing....Printing Complete");
    }
}

public class UsingInterfaces {

    public static void main(String[] args) {

        LaserJetPrinter laserJetPrinter = new LaserJetPrinter();
        laserJetPrinter.print();
        System.out.println();

        SuperFastPrinter superFastPrinter = new SuperFastPrinter();
        superFastPrinter.print();
    }
}
