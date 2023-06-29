import java.util.ArrayList;
import java.util.List;

// Main application class
public class CarbonFootprintApplication {
    public static void main(String[] args) {
        // Create objects for each class
        Building building = new Building("Society Building", 230, 110);
        Car car = new Car("Benz C200", 600, 1200);
        Bicycle bicycle = new Bicycle("Mountain Bike", 800);

        // Create ArrayList to hold CarbonFootprint objects
        List<CarbonFootprint> carbonFootprints = new ArrayList<>();

        // Add objects to the ArrayList
        try {

            carbonFootprints.add(building);
            carbonFootprints.add(car);
            carbonFootprints.add(bicycle);

            // Iterate through the ArrayList and invoke getCarbonFootprint method
            for (CarbonFootprint footprint : carbonFootprints) {
                // Check the type of the object and print relevant information
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

                // Calculate and print the carbon footprint
                System.out.println("Carbon Footprint: " + footprint.getCarbonFootprint());
                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("Error computing the carbon footprint.");
        }

    }
}
