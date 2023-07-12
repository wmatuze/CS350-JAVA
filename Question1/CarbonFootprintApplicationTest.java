import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarbonFootprintApplicationTest {
    // Testing the getCarbonFootprint method from the Building class
    @Test
    public void testBuilding() {
        // Arrange
        Building building = new Building("Society Building", 230, 110);

        // Act
        double expected = (230 * 0.7) + (110 * 0.5);
        double actual = building.getCarbonFootprint();

        // Assert
        assertEquals(expected, actual, 0.001);
    }

    // Testing the getCarbonFootprint method from the Car class
    @Test
    public void testCar() {
        // Arrange
        Car car = new Car("Benz C200", 600, 1200);

        // Act
        double expected = (600 * 2.3) + (1200 * 0.012);
        double actual = car.getCarbonFootprint();

        // Assert
        assertEquals(expected, actual, 0.001);
    }

    // Testing the getCarbonFootprint method from the Bicycle class
    @Test
    public void testBicycle() {
        // Arrange
        Bicycle bicycle = new Bicycle("Mountain Bike", 800);

        // Act
        double expected = 800 * 0.012;
        double actual = bicycle.getCarbonFootprint();

        // Assert
        assertEquals(expected, actual, 0.001);
    }
}
