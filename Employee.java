// Step 1: Create the superclass Employee
public class Employee {
    // Common attributes for all employees
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    // Constructor for Employee
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    // Getters for firstName, lastName, and socialSecurityNumber
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    // toString method for Employee
    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s",
                "employee", firstName, lastName,
                "social security number", socialSecurityNumber);
    }
}

// Step 2: Modify the CommissionEmployee class to inherit from Employee
public class CommissionEmployee extends Employee {
    // Specific attributes for CommissionEmployee
    private double grossSales;
    private double commissionRate;

    // Constructor for CommissionEmployee
    public CommissionEmployee(String firstName, String lastName,
                              String socialSecurityNumber, double grossSales,
                              double commissionRate) {
        // Call the superclass constructor using the 'super' keyword
        super(firstName, lastName, socialSecurityNumber);

        // Validate grossSales and commissionRate
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");

        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

        // Assign values to CommissionEmployee attributes
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    // Setters and getters for grossSales and commissionRate
    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0)
            throw new IllegalArgumentException(
                    "Gross sales must be >= 0.0");
        this.grossSales = grossSales;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException(
                    "Commission rate must be > 0.0 and < 1.0");

        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    // Calculate earnings for CommissionEmployee
    public double earnings() {
        return commissionRate * grossSales;
    }

    // Override toString to include CommissionEmployee details along with Employee details
    @Override
    public String toString() {
        return super.toString() + String.format("%n%s: %.2f%n%s: %.2f",
                "gross sales", grossSales,
                "commission rate", commissionRate);
    }
}
