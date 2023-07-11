package Question3.a;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary; // base salary per week

    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String socialSecurityNumber, double grossSales,
                                      double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    // Setter and Getter for baseSalary
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Override earnings() method to include base salary in total earnings
    @Override
    public double earnings() {
        return super.earnings() + baseSalary;
    }

    // Override toString() method to include base salary in the string representation
    @Override
    public String toString() {
        return String.format("%s%n%s: %.2f",
                super.toString(),
                "base salary", baseSalary);
    }
}


