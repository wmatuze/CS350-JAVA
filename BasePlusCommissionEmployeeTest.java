package Question3;

public class BasePlusCommissionEmployeeTest {
    public static void main(String[] args) {
        // Create a BasePlusCommissionEmployee object
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee(
                "Jane", "Smith", "987-654-3210", 8000.0, 0.04, 2000.0);

        // Display employee information and earnings
        System.out.println("Employee information:");
        System.out.println(employee.toString());
        System.out.println("Earnings: $" + employee.earnings());
    }
}
