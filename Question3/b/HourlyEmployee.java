package Question3.b;
import Question3.a.Employee;

//HourlyEmployee class that inherits from Employee
public class HourlyEmployee extends Employee {
    // Instance variables for HourlyEmployee
    private double hours; // hours worked
    private double wage; // wage per hour

    // Constructor for HourlyEmployee
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
                          double wage, double hours) {
        // Call the superclass constructor using the 'super' keyword
        super(firstName, lastName, socialSecurityNumber);
        setWage(wage); // validate and set wage
        setHours(hours); // validate and set hours
    }

    // Setter for wage, ensuring it is non-negative
    public void setWage(double wage) {
        if (wage >= 0) {
            this.wage = wage;
        } else {
            throw new IllegalArgumentException("Wage must be non-negative.");
        }
    }

    // Getter for wage
    public double getWage() {
        return wage;
    }

    // Setter for hours, ensuring it is between 0 and 168
    public void setHours(double hours) {
        if (hours >= 0 && hours <= 168) {
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Hours must be between 0 and 168.");
        }
    }

    // Getter for hours
    public double getHours() {
        return hours;
    }

    // Calculate earnings for HourlyEmployee, accounting for overtime
    public double earnings() {
        double regularPay = wage * hours;
        double overtimePay = 0;

        if (hours > 40) {
            double overtimeHours = hours - 40;
            overtimePay = overtimeHours * (wage * 1.5);
        }

        return regularPay + overtimePay;
    }

    // Override toString to include HourlyEmployee details along with Employee details
    @Override
    public String toString() {
        return super.toString() + String.format("%n%s: %.2f%n%s: %.2f",
                "wage", wage,
                "hours worked", hours);
    }
}