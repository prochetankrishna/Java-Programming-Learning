package java8.lambdaExpression.lambdaExpressionCollections;

//Comparator Interface contains only one abstract method that is compare(), hence we can use
//this interface for java8.lambdaExpression.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingListWithLambda {

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
        //Custom Comparator is provided using lambda Expression
        /* This is single line comparator which also does the same

        Collections.sort(numberList, (numberOne,
                                      numberTwo) -> (numberOne > numberTwo) ? -1 : (numberOne < numberTwo) ? 1 : 0);

         */
        Collections.sort(numberList, (numberOne, numberTwo) -> {
            if (numberOne > numberTwo) {
                return -1;
            } else if (numberOne < numberTwo) {
                return 1;
            } else {
                return 0;
            }
        });
        System.out.println(numberList);
    }
}
