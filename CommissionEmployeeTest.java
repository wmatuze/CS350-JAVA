package Question3;

public class CommissionEmployeeTest {
    public static void main(String[] args) {
        // Create a CommissionEmployee object
        CommissionEmployee employee = new CommissionEmployee(
                "John", "Doe", "123-456-7890", 5000.0, 0.05);

        // Display employee information and earnings
        System.out.println("Employee information:");
        System.out.println(employee.toString());
        System.out.println("Earnings: $" + employee.earnings());
    }
}
