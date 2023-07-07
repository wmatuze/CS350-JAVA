package Question3.b;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee employee;

    @Before
    public void setUp() {
        // Arrange: Create an instance of HourlyEmployee for testing
        employee = new HourlyEmployee("Jane", "Smith", "987654321", 20.0, 45);
    }

    @Test
    public void testGetFirstName() {
        // Act: Perform the operation to get the first name
        String firstName = employee.getFirstName();

        // Assert: Check if the result matches the expected value
        assertEquals("Jane", firstName);
    }

    @Test
    public void testGetLastName() {
        // Act: Perform the operation to get the last name
        String lastName = employee.getLastName();

        // Assert: Check if the result matches the expected value
        assertEquals("Smith", lastName);
    }

    @Test
    public void testGetSocialSecurityNumber() {
        // Act: Perform the operation to get the social security number
        String ssn = employee.getSocialSecurityNumber();

        // Assert: Check if the result matches the expected value
        assertEquals("987654321", ssn);
    }

    // @Test
    // public void testEarnings() {
    // // Act: Perform the operation to calculate the earnings
    // double earnings = employee.earnings();

    // // Assert: Check if the result matches the expected value
    // assertEquals(20.0 * 40 + 20.0 * 1.5 * 5, earnings, 0.01); // Using delta for
    // double comparison
    // }
    @Test
    public void testEarnings() {
        // Act: Perform the operation to calculate the earnings
        double earnings = employee.earnings();

        // Assert: Check if the result matches the expected value
        assertEquals(20.0 * 40 + 20.0 * 1.5 * (45 - 40), earnings, 0.01); // Using delta for double comparison
    }

    // Additional tests for setWage, setHours, and toString can be added.
}
