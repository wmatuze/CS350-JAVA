package Question3.b;

// Test program to test the HourlyEmployee class
public class HourlyEmployeeTest {
    public static void main(String[] args) {
        HourlyEmployee employee = new HourlyEmployee("Watutemwa", "Matuze", "427590161",
                15.0, 45.5);

        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%s %s%n", "First name:", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name:", employee.getLastName());
        System.out.printf("%s %s%n", "Social Security number:", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Wage:", employee.getWage());
        System.out.printf("%s %.2f%n", "Hours worked:", employee.getHours());

        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee);
        System.out.printf("%s %.2f%n", "Earnings:", employee.earnings());
    }
}
