package Question3;

public class CommissionEmployeeTest2 {

    public static void main(String[] args) {
        // Instantiate CommissionEmployee object
        CommissionEmployee employee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);

        // Get commission employee data
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());

        employee.setGrossSales(5000);
        employee.setCommissionRate(.1);

        System.out.printf("%n%s:%n%n %s%n", "Updated employee information obtained by toString", employee);

        // Instantiate HourlyEmployee object
        HourlyEmployee hourlyEmployee = new HourlyEmployee("John", "Doe", "333-33-3333", 15.0, 45.0);

        // Get hourly employee data
        System.out.println("\nHourly Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", hourlyEmployee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", hourlyEmployee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", hourlyEmployee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Hourly wage is", hourlyEmployee.getWage());
        System.out.printf("%s %.2f%n", "Hours worked is", hourlyEmployee.getHours());

        hourlyEmployee.setWage(20.0);
        hourlyEmployee.setHours(50.0);

        System.out.printf("%n%s:%n%n %s%n", "Updated employee information obtained by toString", hourlyEmployee);
    }
}
