/**
* The Hourly class simulates a
* hourly-paid employee of a firm; Hourly is an employee
*
* @author  Ken Gu
* @version 1.0
* @since   2020-05-04
*/
public class Hourly extends Employee
{
    private int hoursWorked;

    /**
    * Constructor for a Hourly staff.
    * @see Employee()
    */
    public Hourly(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);

        hoursWorked = 0;
    }

    /**
    * Adds the specified number of hours
    * to this employee's accumulated hours.
    * @param moreHours An int containing amount of worked hours.
    * @return void
    */
    public void addHours(int moreHours)
    {
        hoursWorked += moreHours;
    }

    /**
    * Computes and returns the pay for a Hourly staff; polymorphic.
    * @return double Returns the payment amount.
    */
    public double pay()
    {
        double payment = payRate * hoursWorked;

        hoursWorked = 0;

        return payment;
    }

    /**
    * Computes and returns vacation duration for a Hourly staff;
    * polymorphic.
    * @return int Returns standard vacation amount - 7 days.
    * @see vacation() in Employee.java
    */
    public int vacation(){
      return STANDARD_VACATION - 7;
    }

    /**
    * toString method for Hourly; uses Employee's
    * toString aswell.
    * @return String A variable containing the employee's info
    * @see toString() in Employee.java
    */
    public String toString()
    {
        String result = super.toString();

        result += "\nCurrent hours: " + hoursWorked;

        return result;
    }
}
