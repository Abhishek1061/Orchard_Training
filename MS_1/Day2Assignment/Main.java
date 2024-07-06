package Java.Day2Assignment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("******* Vehicle Details ********");
        System.out.print("Enter the vehicle name: ");
        String vehicleName = sc.nextLine();
        System.out.print("Enter the vehicle speed: ");
        double vehicleSpeed = sc.nextDouble();
        sc.nextLine();

        Vehicle myVehicle = new Vehicle(vehicleName, vehicleSpeed);
        myVehicle.move();

        System.out.println();
        System.out.println("******* Car Details ********");
        System.out.print("Enter the car name: ");
        String carName = sc.nextLine();
        System.out.print("Enter the car speed: ");
        double carSpeed = sc.nextDouble();
        System.out.print("Enter the car doors: ");
        int carDoors = sc.nextInt();
        System.out.println();

        Car myCar = new Car(carName, carSpeed, carDoors);
        myCar.move();
        System.out.println();

        System.out.println("Creating intance of Car and call its move() to demonstrate Polymorpism");
        Vehicle anotherCar = new Car(carName, carSpeed, carDoors);
        anotherCar.move();

        sc.close();
    }
}

class Vehicle {
    protected String name;
    protected double speed;

    public Vehicle(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    public void move() {
        System.out.println(name + " is moving at speed of " + speed + " km/h.");
    }
}

class Car extends Vehicle {
    private int doors;

    public Car(String name, double speed, int doors) {
        super(name, speed);
        this.doors = doors;
    }

    @Override
    public void move() {
        System.out.println(name + " car is moving at a speed of " + speed + " km/h with " + doors + " doors.");
    }
}
