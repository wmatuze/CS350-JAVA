// package Question1;

import org.junit.Assert;
import org.junit.Test;

class CarbonFootprintTest {

    @Test
    public void buildingGetCarbonFootprint() {
        // Arrange
        Building building = new Building("ABC Tower", 10000);

        // Act
        double carbonFootprint = building.getCarbonFootprint();

        // Assert
        double expectedCarbonFootprint = 7000.0;
        Assert.assertEquals(expectedCarbonFootprint, carbonFootprint, 0.0);
    }

    @Test
    public void carGetCarbonFootprint() {
        // Arrange
        Car car = new Car("MarkX TOYOTA", 50);

        // Act
        double carbonFootprint = car.getCarbonFootprint();

        // Assert
        double expectedCarbonFootprint = 115.0;
        Assert.assertEquals(expectedCarbonFootprint, carbonFootprint, 0.0);
    }

    @Test
    public void bicycleGetCarbonFootprint() {
        // Arrange
        Bicycle bicycle = new Bicycle("Mountain Bike");

        // Act
        double carbonFootprint = bicycle.getCarbonFootprint();

        // Assert
        double expectedCarbonFootprint = 0.0;
        Assert.assertEquals(expectedCarbonFootprint, carbonFootprint, 0.0);
    }

    @Test
    public void buildingGetBuildingName() {
        // Arrange
        Building building = new Building("ABC Tower", 10000);

        // Act
        String buildingName = building.getBuildingName();

        // Assert
        String expectedBuildingName = "ABC Tower";
        Assert.assertEquals(expectedBuildingName, buildingName);
    }

    @Test
    public void carGetCarModel() {
        // Arrange
        Car car = new Car("MarkX TOYOTA", 50);

        // Act
        String carModel = car.getCarModel();

        // Assert
        String expectedCarModel = "MarkX TOYOTA";
        Assert.assertEquals(expectedCarModel, carModel);
    }

    @Test
    public void bicycleGetBicycleType() {
        // Arrange
        Bicycle bicycle = new Bicycle("Mountain Bike");

        // Act
        String bicycleType = bicycle.getBicycleType();

        // Assert
        String expectedBicycleType = "Mountain Bike";
        Assert.assertEquals(expectedBicycleType, bicycleType);
    }
}
