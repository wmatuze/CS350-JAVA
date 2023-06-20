// package Question1;

import java.util.ArrayList;
import java.util.List;

//interface defining the CarbonFootprint behavior
interface CarbonFootprint {
    double getCarbonFootprint();
}

// Building class
class Building implements CarbonFootprint {
    private String buildingName;
    private double electricityUsage;

    public Building(String buildingName, double electricityUsage) {
        this.buildingName = buildingName;
        this.electricityUsage = electricityUsage;
    }

    public double getCarbonFootprint() {
        // Assuming carbon footprint calculation based on electricity usage
        return electricityUsage * 0.7; // Random calculation for demonstration
    }

    public String getBuildingName() {
        return buildingName;
    }
}

// Car class
class Car implements CarbonFootprint {
    private String carModel;
    private double fuelConsumption;

    public Car(String carModel, double fuelConsumption) {
        this.carModel = carModel;
        this.fuelConsumption = fuelConsumption;
    }

    public double getCarbonFootprint() {
        // Assuming carbon footprint calculation based on fuel consumption
        return fuelConsumption * 2.3; // Arbitrary calculation for demonstration
    }

    public String getCarModel() {
        return carModel;
    }
}

// Bicycle class
class Bicycle implements CarbonFootprint {
    private String bicycleType;

    public Bicycle(String bicycleType) {
        this.bicycleType = bicycleType;
    }

    public double getCarbonFootprint() {
        // Assuming bicycles have negligible carbon footprint
        return 0.0;
    }

    public String getBicycleType() {
        return bicycleType;
    }
}

// Main application class
public class CarbonFootprintApplication {
    public static void main(String[] args) {
        // Create object of each class
        Building building = new Building("ABC Tower", 10000);
        Car car = new Car("MarkX TOYOTA", 50);
        Bicycle bicycle = new Bicycle("Mountain Bike");

        // Create ArrayList to hold CarbonFootprint objects
        List<CarbonFootprint> carbonFootprints = new ArrayList<>();
        carbonFootprints.add(building);
        carbonFootprints.add(car);
        carbonFootprints.add(bicycle);

        // Iterate through the ArrayList and invoke getCarbonFootprint() method
        for (CarbonFootprint footprint : carbonFootprints) {
            if (footprint instanceof Building) {
                Building currentBuilding = (Building) footprint;
                System.out.println("Building: " + currentBuilding.getBuildingName());
            } else if (footprint instanceof Car) {
                Car currentCar = (Car) footprint;
                System.out.println("Car: " + currentCar.getCarModel());
            } else if (footprint instanceof Bicycle) {
                Bicycle currentBicycle = (Bicycle) footprint;
                System.out.println("Bicycle: " + currentBicycle.getBicycleType());
            }

            System.out.println("Carbon Footprint: " + footprint.getCarbonFootprint());
            System.out.println();
        }
    }
}
