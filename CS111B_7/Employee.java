/**
* The Employee class simulates an
* employee of a firm; Employee is a StaffMember
*
* @author  Ken Gu
* @version 1.0
* @since   2020-05-04
*/
public class Employee extends StaffMember
{
    protected String socialSecurityNumber;
    protected double payRate;

    /**
    * Employee()
    * Constructor: Sets up this employee with the specified
    * information; uses StaffMember's constructor aswell.
    * @see StaffMember() in StaffMember.java
    */
    public Employee(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate)
    {
        super(eName, eAddress, ePhone);

        socialSecurityNumber = socSecNumber;
        payRate = rate;
    }

    /**
    * toString method for Employee; uses StaffMember's
    * toString aswell.
    * @return String A variable containing the employee's info
    * @see toString() in StaffMember.java
    */
    public String toString()
    {
        String result = super.toString();

        result += "\nSocial Security Number: " + socialSecurityNumber;

        return result;
    }

    /**
    * pay()
    * Returns the pay rate for this employee; polymorphic.
    * @return double The instance data payRate.
    */
    public double pay()
    {
        return payRate;
    }
    /**
    * vacation()
    * Returns the vacation duration standard; polymorphic.
    * @return int A constant from the Payable interface.
    */
    public int vacation(){
      return STANDARD_VACATION;
    }
}
