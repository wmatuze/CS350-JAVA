package Question3.a;

// The superclass Employee
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