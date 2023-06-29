
public class HourlyEmployee extends Employee {
    private double hours;
    private double wage;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
            double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        setWage(wage);
        setHours(hours);
    }

    public void setWage(double wage) {
        if (wage < 0.0)
            throw new IllegalArgumentException("Wage must be >= 0.0");

        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setHours(double hours) {
        if (hours < 0.0 || hours > 168.0)
            throw new IllegalArgumentException("Hours must be between 0 and 168");

        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public double earnings() {
        if (hours <= 40)
            return wage * hours;
        else
            return (40 * wage) + ((hours - 40) * wage * 1.5);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n%s: %.2f%n%s: %.2f", "Wage", wage, "Hours", hours);
    }
}
