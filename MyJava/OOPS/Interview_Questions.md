## Abstract class vs interface — when to use which?

- **Abstract class**: Use when you want to provide some base implementation and shared state, while still enforcing certain methods for subclasses to implement.
- **Interface**: Use when you want to define a behavior/contract that can be shared across otherwise unrelated classes.

---

### Abstract Class Example

Vehicle is an abstract class because all vehicles share some base logic (`fuelUp()`) but differ in how they start.

```java
abstract class Vehicle {
    abstract void start();  // every vehicle must define how it starts

    void fuelUp() {         // common behavior
        System.out.println("Filling fuel tank...");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car starts with a key or button");
    }
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike starts with a kick or self-start");
    }
}
```

---

### Interface Example

`Camera` and `MusicPlayer` are interfaces because completely different devices (phone, drone, laptop, etc.) can implement them.

```java
interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

class Smartphone implements Camera, MusicPlayer {
    public void takePhoto() {
        System.out.println("Taking a photo with the smartphone");
    }
    public void playMusic() {
        System.out.println("Playing music on the smartphone");
    }
}
```

---

### Quick tips

- **Use an abstract class** when you need shared code/state and controlled extension points.
- **Use interfaces** for capability-style contracts and multiple inheritance of type.