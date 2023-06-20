package Question3;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {
    @Test
    public void commissionEmployeeTest() {
        // Arrange
        CommissionEmployee employee = new CommissionEmployee(
                "John", "Doe", "123-456-7890", 5000.0, 0.05);

        // Act
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String ssn = employee.getSocialSecurityNumber();
        double earnings = employee.earnings();

        // Assert
        Assert.assertEquals("John", firstName);
        Assert.assertEquals("Doe", lastName);
        Assert.assertEquals("123-456-7890", ssn);
        Assert.assertEquals(250.0, earnings, 0.001);
    }

    @Test
    public void basePlusCommissionEmployeeTest() {
        // Arrange
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "Jane", "Smith", "987-654-3210", 8000.0, 0.04, 2000.0);

        // Act
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        String ssn = employee.getSocialSecurityNumber();
        double earnings = employee.earnings();

        // Assert
        Assert.assertEquals("Jane", firstName);
        Assert.assertEquals("Smith", lastName);
        Assert.assertEquals("987-654-3210", ssn);
        Assert.assertEquals(2320.0, earnings, 0.001);
    }

    @Test
    public void commissionEmployeeEarnings() {
        // Arrange
        CommissionEmployee employee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);

        // Act
        double earnings = employee.earnings();

        // Assert
        Assert.assertEquals(600.0, earnings, 0.01);
    }

    @Test
    public void commissionEmployeeToString() {
        // Arrange
        CommissionEmployee employee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);

        // Act
        String employeeString = employee.toString();

        // Assert
        String expectedString = "First name: Sue\n" +
                "Last name: Jones\n" +
                "Social Security Number: 222-22-2222\n" +
                "Gross sales: 10000.00\n" +
                "Commission rate: 0.06";
        Assert.assertEquals(expectedString, employeeString);
    }

    @Test
    public void hourlyEmployeeEarnings() {
        // Arrange
        HourlyEmployee employee = new HourlyEmployee("John", "Doe", "333-33-3333", 15.0, 45.0);

        // Act
        double earnings = employee.earnings();

        // Assert
        Assert.assertEquals(712.5, earnings, 0.01);
    }

    @Test
    public void hourlyEmployeeToString() {
        // Arrange
        HourlyEmployee employee = new HourlyEmployee("John", "Doe", "333-33-3333", 15.0, 45.0);

        // Act
        String employeeString = employee.toString();

        // Assert
        String expectedString = "First name: John\n" +
                "Last name: Doe\n" +
                "Social Security Number: 333-33-3333\n" +
                "Wage: 15.00\n" +
                "Hours: 45.00";
        Assert.assertEquals(expectedString, employeeString);
    }

}

//In this test file, each test method corresponds to a specific behavior that we want to test. 
//The tests cover the earnings and toString methods of both the CommissionEmployee and HourlyEmployee classes.
















