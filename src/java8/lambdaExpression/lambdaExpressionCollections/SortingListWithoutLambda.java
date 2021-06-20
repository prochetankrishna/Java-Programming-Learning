package java8.lambdaExpression.lambdaExpressionCollections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class DescendingOrderComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer numberOne, Integer numberTwo) {

        if (numberOne > numberTwo) {
            return -1;
        } else if (numberOne < numberTwo) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class SortingListWithoutLambda {

    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(0);
        numberList.add(15);
        numberList.add(5);
        numberList.add(20);

        System.out.println(numberList);
        Collections.sort(numberList); //Default Sorting Order Ascending
        System.out.println(numberList);
        Collections.sort(numberList, new DescendingOrderComparator()); //Custom Comparator Will be used
        System.out.println(numberList);
    }
}
