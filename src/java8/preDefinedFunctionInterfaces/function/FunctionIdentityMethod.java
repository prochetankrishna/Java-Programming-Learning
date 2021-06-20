package java8.preDefinedFunctionInterfaces.function;

import java.util.function.Function;

public class FunctionIdentityMethod {

    public static void main(String[] args) {

        Function<String, String> identityFunction = Function.identity();
        System.out.println(identityFunction.apply("Chetan Krishna"));
    }
}
