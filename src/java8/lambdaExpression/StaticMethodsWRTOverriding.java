package java8.lambdaExpression;

interface arrayPrinter {

    static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element at index [" + i + "] : [" + arr[i] + "]");
        }
    }
}

class ArrayOperationOne implements arrayPrinter {

    //Not Overriding
    public static void printArray(int[] arr) {
        System.out.println("Printing Array from Array Operation Static Method");
    }
}

class ArrayOperationTwo implements arrayPrinter {

    //Not Overriding
    public void printArray(int[] arr) {
        System.out.println("Printing Array from Array Operation Instance Method");
    }
}

class ArrayOperationThree implements arrayPrinter {

    //Not Overriding
    private static void printArray(int[] arr) {
        System.out.println("Printing Array from Array Operation Static Method");
    }
}

public class StaticMethodsWRTOverriding {

    public static void main(String[] args) {
        ArrayOperationOne.printArray(new int[]{1,2,3});

        ArrayOperationTwo arrayOperationTwo = new ArrayOperationTwo();
        arrayOperationTwo.printArray(new int[]{1,2,3});

        arrayPrinter.printArray(new int[]{1,2,3});

        //For ArrayOperationThree printArray() scope is not available outside the class
    }
}
