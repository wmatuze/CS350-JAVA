
/* Sources:
Carbon footprint calcuations for all items (except bicycle) came from:
http://www.carbonfootprint.com/calculator.aspx

Calculations for the Bicycle carbon footprint came from:
http://www.guardian.co.uk/environment/2010/jun/08/carbon-footprint-cycling
*/

// Interface defining the CarbonFootprint behavior
interface CarbonFootprint {
    double getCarbonFootprint(); //Method to calculate the carbonfootprint
}

// Building class
class Building implements CarbonFootprint {
    private String buildingName;
    private double electricityUsage;
    private double naturalGasUsage;

    //Three-argument constructor
    public Building(String buildingName, double electricityUsage, double naturalGasUsage) {
        // implicit call to object's building constructor
        this.buildingName = buildingName;
        this.electricityUsage = electricityUsage;
        this.naturalGasUsage = naturalGasUsage;
    } // end constructor

    public double getCarbonFootprint() {
        // Assuming carbon footprint calculation based on electricity Usage and natural gas usage
        return (electricityUsage * 0.7) + (naturalGasUsage * 0.5);
    }

    // return Bulding name
    public String getBuildingName() {
        return buildingName;
    }
}

// Car class
class Car implements CarbonFootprint {
    private String carModel;
    private double fuelConsumption;
    private double milesDriven;

    //Two-argument constructor
    public Car(String carModel, double fuelConsumption, double milesDriven) {
        // implicit call to object's Car constructor
        this.carModel = carModel;
        this.fuelConsumption = fuelConsumption;
        this.milesDriven = milesDriven;
    }

    public double getCarbonFootprint() {
        // Assuming Carbon footprint calculation is based on fuel consumption and miles driven
        return (fuelConsumption * 2.3) + (milesDriven * 0.012);
    }

    public String getCarModel() {
        return carModel;
    }
}

//Bicycle class 
class Bicycle implements CarbonFootprint {
    private String bicycleType;
    private double milesRidden;

    public Bicycle(String bicycleType, double milesRidden) {
        this.bicycleType = bicycleType;
        this.milesRidden = milesRidden;
    }

    public double getCarbonFootprint() {
        // Assuming carbon footprint calculation is based on miles ridden
        return milesRidden * 0.012; 
    }

    public String getBicycleType() {
        return bicycleType;
    }
}