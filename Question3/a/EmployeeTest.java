package Question3.a;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EmployeeTest {

    // Testing the toString method of the Employee class
    @Test
    public void testEmployeeToString() {
        // Arrange
        Employee employee = new Employee("John", "Doe", "123-456-7890");

        // Act
        String expected = "employee: John Doe\nsocial security number: 123-456-7890";
        String actual = employee.toString();

        // Assert
        assertEquals(expected, actual);
    }

    // Testing the toString method of the CommissionEmployee class
    @Test
    public void testCommissionEmployeeToString() {
        // Arrange
        CommissionEmployee commissionEmployee = new CommissionEmployee("Jane", "Smith",
                "987-654-3210", 50000.0, 0.1);

        // Act
        String expected = "employee: Jane Smith\nsocial security number: 987-654-3210\n" +
                "gross sales: 50000.00\ncommission rate: 0.10";
        String actual = commissionEmployee.toString();

        // Assert
        assertEquals(expected, actual);
    }

    // Testing the earnings method of the CommissionEmployee class
    @Test
    public void testCommissionEmployeeEarnings() {
        // Arrange
        CommissionEmployee commissionEmployee = new CommissionEmployee("Jane", "Smith",
                "987-654-3210", 50000.0, 0.1);

        // Act
        double expected = 5000.0; // (50000.0 * 0.1)
        double actual = commissionEmployee.earnings();

        // Assert
        assertEquals(expected, actual, 0.01);
    }
}

