package Question3;
// Fig. 9.5: CommissionEmployeeTest.java
// CommissionEmployee class test program.

import Question3.a.CommissionEmployee;

public class CommissionEmployeeTest {
    public static void main(String[] args) {
        // instantiate CommissionEmployee object
        CommissionEmployee employee = new CommissionEmployee("Watutemwa", "Matuze", "20151705", 10000, .06);

        // Get commission employee data
        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%s %s%n", "Fist name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social Security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %s%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %s%n", "Commission rate is", employee.getCommissionRate());

        employee.setGrossSales(5000);
        employee.setCommissionRate(.1);

        System.out.printf("%n%s:%n%n%s%n", "Updtaed employee information obtained by toString", employee);
    } // end main
}// end class CommissionEmployeeTest