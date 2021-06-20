package java8.lambdaExpression.lambdaExpressionCollections;

import java.util.Map;
import java.util.TreeMap;

public class SortingMapUsingLambda {

    public static void main(String[] args) {

        Map<Integer, String> employeeMap = new TreeMap<>();
        employeeMap.put(100, "Chetan");
        employeeMap.put(151, "Manas");
        employeeMap.put(198, "John");
        employeeMap.put(132, "Gregg");
        employeeMap.put(112, "David");
        System.out.println(employeeMap); //Ascending Order Based on Key

        //Custom Comparator
        Map<Integer, String> employeeMapDesc = new TreeMap<>((employeeIdOne, employeeIdTwo) ->
                (employeeIdOne < employeeIdTwo) ? 1 : (employeeIdOne > employeeIdTwo) ? -1 : 0);
        employeeMapDesc.put(100, "Chetan");
        employeeMapDesc.put(151, "Manas");
        employeeMapDesc.put(198, "John");
        employeeMapDesc.put(132, "Gregg");
        employeeMapDesc.put(112, "David");
        System.out.println(employeeMapDesc); //Descending Order Based on Key
    }
}
