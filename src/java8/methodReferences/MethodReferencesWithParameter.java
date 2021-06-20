package java8.methodReferences;

@FunctionalInterface
interface TaxableIncentive {

    double calculateTax(double salary, double incentive);
}

@FunctionalInterface
interface Taxable {

    double calculateTax(double Salary);
}

class TaxCalculator {

    public static double calculateTaxWithIncentive (double salary, double incentive) {
        return salary * 0.3 + incentive * 0.1;
    }

    public double calculateTaxOnSalary (double salary) {
        return salary * 0.3;
    }
}

public class MethodReferencesWithParameter {

    public static void main(String[] args) {
        //Static Method
        TaxableIncentive taxForSalaryAndIncentiveOne = TaxCalculator::calculateTaxWithIncentive;
        System.out.println(taxForSalaryAndIncentiveOne.calculateTax(10000, 10000));

        TaxCalculator taxCalculator = new TaxCalculator();
        /*
        -> This will not work Static Method and Instance
        TaxableIncentive taxForSalaryAndIncentiveTwo = taxCalculator::calculateTaxWithIncentive;
        System.out.println(taxForSalaryAndIncentiveOne.calculateTax(10000, 10000));
         */

        //Instance and Instance Method
        Taxable taxableForSalary = taxCalculator::calculateTaxOnSalary;
        System.out.println(taxableForSalary.calculateTax(10000));
    }
}
