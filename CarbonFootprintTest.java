// package Question1;

// import java.util.ArrayList;
// import java.util.List;

// // public interface CarbonFootprint {
// //     double getCarbonFootprint();
// // }

// // public class Building implements CarbonFootprint {
// //     private double electricityUsage;
// //     private double gasUsage;

// //     public Building(double electricityUsage, double gasUsage) {
// //         this.electricityUsage = electricityUsage;
// //         this.gasUsage = gasUsage;
// //     }

// //     @Override
// //     public double getCarbonFootprint() {
// //         return (electricityUsage * 1.37) + (gasUsage * 1.84);
// //     }

// //     @Override
// //     public String toString() {
// //         return "Building with electricity usage: " + electricityUsage + "kWh and gas usuage: " + gasUsage + "m3";
// //     }
// // }

// // public class Car implements CarbonFootprint {
// //     private double milesDriven;
// //     private double fuelEfficiency;

// //     public Car(double milesDriven, double fuelEfficiency) {
// //         this.milesDriven = milesDriven;
// //         this.fuelEfficiency = fuelEfficiency;
// //     }

// //     @Override
// //     public double getCarbonFootprint() {
// //         return (milesDriven / fuelEfficiency) * 19.6;
// //     }

// //     @Override
// //     public String toString() {
// //         return "Car with miles driven: " + milesDriven + " and fuel efficiency: " + fuelEfficiency + " mpg";
// //     }
// // }

// // public class Bicycle implements CarbonFootprint {
// //     private double milesRidden;

// //     public Bicycle(double milesRidden) {
// //         this.milesRidden = milesRidden;
// //     }
// //     @Override
// //     public double getCarbonFootprint() {
// //         return milesRidden * 0.012;
// //     }

// //     @Override
// //     public String toString() {
// //         return "Bicycle with miles ridden: " + milesRidden;
// //     }
// // }

// public class CarbonFootprintTest {
//     public static void main(String[] args) {
//         ArrayList<CarbonFootprint> carbonFootprints = new ArrayList<>();
//         carbonFootprints.add(new Building(1000, 50));
//         carbonFootprints.add(new Car(15000, 25));
//         carbonFootprints.add(new Bicycle(500));

//         for (CarbonFootprint carbonFootprint : carbonFootprints) {
//             System.out.println(carbonFootprint);
//             System.out.printf("Carbon footprint: %.2f kg CO2e%n%n", carbonFootprint.getCarbonFootprint());
//         }

//     }
// }
