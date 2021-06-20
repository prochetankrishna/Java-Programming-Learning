package java8.methodReferences;

@FunctionalInterface
interface Shape {

    void draw();
}

class Circle {

    public static void drawCircle() {
        System.out.println("Drawing Circle");
    }
}

public class MethodReferencesWithOutParameter {

    public static void main(String[] args) {
        Shape shape = Circle::drawCircle;
        shape.draw();
    }
}
