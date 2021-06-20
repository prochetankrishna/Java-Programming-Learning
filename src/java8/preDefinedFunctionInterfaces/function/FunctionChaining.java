package java8.preDefinedFunctionInterfaces.function;

import java.util.function.Function;

public class FunctionChaining {

    public static void main(String[] args) {

        Function<String, String> toUpperCaseFunction = userName -> userName.replaceAll(" ", "")
                                                                    .toUpperCase();
        Function<String, String> firstFiveCharactersFunction = userName -> userName.substring(0, 5);
        Function<String, String> createUserNameFunctionOne = toUpperCaseFunction.andThen(firstFiveCharactersFunction);

        System.out.println("Username for 'Chetan Krishna' : " + createUserNameFunctionOne.apply("Chetan Krishna"));

        Function<String, String> createUserNameFunctionTwo = toUpperCaseFunction.compose(firstFiveCharactersFunction);
        System.out.println("Username for 'Chetan Krishna' : " + createUserNameFunctionTwo.apply("Chetan Krishna"));


        Function<Integer, Integer> doubleFunction = number -> number + number;
        Function<Integer, Integer> squareFunction = number -> number * number;

        System.out.println(doubleFunction.andThen(squareFunction).apply(10));
        System.out.println(doubleFunction.compose(squareFunction).apply(10));
    }
}
