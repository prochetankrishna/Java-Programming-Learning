package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(0);
        numberList.add(10);
        numberList.add(20);
        numberList.add(5);
        numberList.add(15);
        numberList.add(25);
        System.out.println(numberList);

        //Only Even Numbers
        List<Integer> evenNumberList = numberList.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumberList);

        List<Integer> doubleOfNumberList = numberList.stream().map(number -> number * 2).collect(Collectors.toList());
        System.out.println(doubleOfNumberList);
    }
}
