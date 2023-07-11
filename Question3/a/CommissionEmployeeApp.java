package Question3.a;

public class CommissionEmployeeApp {
    public static void main(String[] args) {
        // instantiate CommissionEmployee object
        CommissionEmployee employee = new CommissionEmployee("Watutemwa", "Matuze", "20151705", 10000, 0.06);

        // Get commission employee data
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social Security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());

        employee.setGrossSales(5000);
        employee.setCommissionRate(0.1);

        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee);
        System.out.printf("%s %.2f%n", "Earnings: $", employee.earnings());
    }
}

