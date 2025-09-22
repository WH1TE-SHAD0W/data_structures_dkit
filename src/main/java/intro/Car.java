package intro;

import java.time.LocalDate;

public class Car {
    private final String make;
    private final String model;
    private final String licensePlate;
    private final int year;

    public Car() {
        this.make = "Toyota";
        this.model = "HiAce";
        this.licensePlate = "152LH5621";
        this.year = 2015;
    }
    public Car(String make, String model, String licensePlate, int year) {
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
    }
    public int calcAge() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - this.year;
    }

    public String format() {
        return String.format(
                "Car Details:\nMake: %s\nModel: %s\nLicense Plate: %s\nYear: %d\nAge: %d years",
                make, model, licensePlate, year, calcAge()
        );
    }

    static void main() {
        Car car = new Car();
        System.out.println(car.calcAge());
        System.out.println(car.format());
    }
}
