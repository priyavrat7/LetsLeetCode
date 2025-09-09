package MyJava.OOPS.Inheritance;
// Inheritance: is a mechanism in which one object acquires all the properties and behaviors of a parent object.
// It is used to achieve code reusability.
// Types of inheritance: single, multiple, hierarchical, multilevel, hybrid
// Single: one parent class and one child class
// Multiple: one parent class and multiple child classes
// Hierarchical: one parent class and multiple child classes
// Multilevel: one parent class and one child class and the child class is also a parent class

class Vehicle{
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year){
        this.brand = brand;
        this.year = year;
    }

    public void start(){
        System.out.println(brand + " is starting");
    }

    public void displayInfo(){
        System.out.println(brand + " is " + year + " years old");
    }
}

class Car extends Vehicle{
    private int numDoors;

    public Car(String brand, int year, int numDoors){ // constructor
        super(brand, year);
        this.numDoors = numDoors;
    }

    @Override // override the start method in the parent class - Run time polymorphism
    public void start(){
        System.out.println(brand + " is starting with " + numDoors + " doors");
    }

    // Add a new method to the child class
    public void carSound(){
        System.out.println("Vroom Vroom");
    }
}

class Truck extends Vehicle{
    private int cargoCapacity;

    public Truck(String brand, int year, int cargoCapacity){ // constructor
        super(brand, year);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public void start(){
        System.out.println(brand + " is starting with " + cargoCapacity + " cargo capacity");
    }

    public void truckSound(){
        System.out.println("HONK HONK");
    }
}

public class Vehicle_Main{
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle("Generic", 2000);

        Car car = new Car("Toyota", 2020, 4);
        Truck truck = new Truck("Ford", 2021, 10000);

        vehicle.start();
        car.start();
        truck.start();
        
        vehicle.displayInfo();
        car.displayInfo();
        truck.displayInfo();

        car.carSound();
        truck.truckSound();
    }
}