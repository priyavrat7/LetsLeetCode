package OOPS.Interface_Abstract_Class;

abstract class Shape{
    protected String color;

    public Shape(String color){
        this.color = color;
    }

    // Abstract methods must be implemented by the subclass
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Concrete method, can be used by the subclass
    public void displayInfo(){
        System.out.println("ShapeColor: " + color);
    }
}

interface Drawable{
    void draw(); // public and abstract by default

    // default methods can be overridden by the subclass
    // default methods are not mandatory to implement by the subclasses
    default void erase(){ // default methods are not abstract and can have a body
        System.out.println("Erasing the drawing");
    }

    // Static methods can be called without creating an object
    // Static methods can not be overridden by the subclass and isn't inherited by the subclass
    static void printDrawingInfo(){
        System.out.println("This is a drawable object");
    }

}

interface Colorable{
    void setColor(String color);
    String getColor();
}

class Square extends Shape implements Drawable, Colorable{
    private double side;

    public Square(String color, double size){
        super(color);
        this.side = size;
    }

    @Override
    public double calculateArea(){ // overridden method from the parent class Shape
        return side * side;
    }

    @Override
    public double calculatePerimeter(){ // overridden method from the parent class Shape
        return 4 * side;
    }

    @Override
    public void draw(){ // overridden method from the interface Drawable
        System.out.println("Drawing a square with side: " + side);
    }

    @Override
    public void setColor(String color){ // overridden method from the interface Colorable
        this.color = color;
    }

    @Override
    public String getColor(){ // overridden method from the interface Colorable
        return color;
    }

}



public class Interface_Abstract_Main {
    public static void main(String[] args){
        Square square = new Square("Red", 10);
        square.draw();
        System.out.println(square.calculateArea());
        System.out.println(square.calculatePerimeter());
        //square.printDrawingInfo(); // error because static method must be called by the class name
        Drawable.printDrawingInfo(); // correct way to call static method
    }
}
