package Question3.a;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommissionEmployeeTest {
    private CommissionEmployee employee;

    @Before
    public void setUp() {
        // Arrange: Create an instance of CommissionEmployee for testing
        employee = new CommissionEmployee("John", "Doe", "123456789", 10000, 0.06);
    }

    @Test
    public void testGetFirstName() {
        // Act: Perform the operation to get the first name
        String firstName = employee.getFirstName();

        // Assert: Check if the result matches the expected value
        assertEquals("John", firstName);
    }

    @Test
    public void testGetLastName() {
        // Act: Perform the operation to get the last name
        String lastName = employee.getLastName();

        // Assert: Check if the result matches the expected value
        assertEquals("Doe", lastName);
    }

    @Test
    public void testGetSocialSecurityNumber() {
        // Act: Perform the operation to get the social security number
        String ssn = employee.getSocialSecurityNumber();

        // Assert: Check if the result matches the expected value
        assertEquals("123456789", ssn);
    }

    @Test
    public void testEarnings() {
        // Act: Perform the operation to calculate the earnings
        double earnings = employee.earnings();

        // Assert: Check if the result matches the expected value
        assertEquals(10000 * 0.06, earnings, 0.01); // Using delta for double comparison
    }

    // Additional tests for setGrossSales, setCommissionRate, and toString can be added.
}
