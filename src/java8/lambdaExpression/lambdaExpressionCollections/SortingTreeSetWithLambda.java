package java8.lambdaExpression.lambdaExpressionCollections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SortingTreeSetWithLambda {

    public static void main(String[] args) {

        Comparator<Integer> descendingComparator = (numberOne, numberTwo) -> {
            return (numberOne > numberTwo) ? -1 : (numberOne < numberTwo) ? 1 : 0;
        };

        Set<Integer> numberSet = new TreeSet<>();
        numberSet.add(10);
        numberSet.add(0);
        numberSet.add(15);
        numberSet.add(25);
        numberSet.add(5);
        numberSet.add(20);
        System.out.println(numberSet); //Ascending Order

        Set<Integer> numberSetDesc = new TreeSet<>(descendingComparator); //Custom Comparator Lambda
        numberSetDesc.add(10);
        numberSetDesc.add(0);
        numberSetDesc.add(15);
        numberSetDesc.add(25);
        numberSetDesc.add(5);
        numberSetDesc.add(20);
        System.out.println(numberSetDesc); //Descending Order
    }
}
