package java8.lambdaExpression.lambdaExpressionIntroduction;

@FunctionalInterface
interface stringUtil {

    int lengthOfString(String str);
}

public class LengthOfStringUsingLambdaExpression {

    public static void main(String[] args) {

        String fullName = "Chetan Krishna";
        stringUtil stringUtilRef = (str) -> {
            return str.length();
        };
        System.out.println("Length of [" + fullName + "] : " + stringUtilRef.lengthOfString(fullName));

        stringUtil anotherStringUtilRef = str -> str.length();
        System.out.println("Length of [" + fullName + "] : " + anotherStringUtilRef.lengthOfString(fullName));
    }
}
