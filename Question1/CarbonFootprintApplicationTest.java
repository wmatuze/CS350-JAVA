import org.junit.Assert;
import org.junit.Test;

public class CarbonFootprintApplicationTest {

    @Test
    public void testBuildingCarbonFootprintCalculation() {
        // Arrange
        Building building = new Building("FINDECO", 230, 110);
        double expectedCarbonFootprint = (230 * 0.7) + (110 * 0.5);

        //Act
        double actualCarbonFootprint = building.getCarbonFootprint();

        // Assert
        Assert.assertEquals(expectedCarbonFootprint, actualCarbonFootprint, 0.01);
    }


    @Test
    public void testCarCarbonFootprintCalculation() {
        // Arrange
        Car car = new Car("BWM-X6", 600, 1200);
        double expectedCarbonFootprint = (600 * 2.3) + (1200 * 0.012);

        //Act
        double actualCarbonFootprint = car.getCarbonFootprint();

        //Assert
        Assert.assertEquals(expectedCarbonFootprint, actualCarbonFootprint, 0.01);
    }
    
    @Test
    public void testBicycleCarbonFootprintCalculation() {
        // Arrange
        Bicycle bicycle = new Bicycle("Buffalo", 8000);
        double expectedCarbonFootprint = 8000 * 0.012;

        //Act
        double actualCarbonFootprint = bicycle.getCarbonFootprint();

        //Asset
        Assert.assertEquals(expectedCarbonFootprint, actualCarbonFootprint, 0.01);
    }
}
