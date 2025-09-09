package MyJava.OOPS.Abstraction;

// Abstract class is a class that is declared with the abstract keyword.
// It can have abstract methods and concrete methods.
// It cannot be instantiated.
// It is used to achieve abstraction.
// It is used to achieve polymorphism.
// It is used to achieve encapsulation.
// It is used to achieve inheritance.
abstract class Shape{
    protected String color;

    public Shape(String color){
        this.color = color;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public void displayInfo(){
        System.out.println("Color: " + color);
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(String color, double width, double height){
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea(){
        return width * height;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * (width + height);
    }
}

class Circle extends Shape{
    private double radius;
    private final double PI = 3.14159;

    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    @Override
    public double calculateArea(){
        return PI * radius * radius;
    }

    @Override
    public double calculatePerimeter(){
        return 2 * PI * radius;
    }
}

public class Shape_Main {
    public static void main(String[] args){
        Shape rectangle = new Rectangle("Red", 10, 20);
        Shape circle = new Circle("Blue", 10);

        rectangle.displayInfo();
        circle.displayInfo();

        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());
    }
}
