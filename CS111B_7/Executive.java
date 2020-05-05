/**
* The Executive class simulates an
* executive of a firm; Executive is an Employee
*
* @author  Ken Gu
* @version 1.0
* @since   2020-05-04
*/
public class Executive extends Employee
{
    private double bonus;
    private int extraVacation;

    /**
    * Constructor for an Executive;
    * takes in one more param.
    * @param extraDays Amount of vacation days an Executive gets.
    * @see Employee()
    */
    public Executive(String eName, String eAddress, String ePhone,
            String socSecNumber, double rate, int extraDays)
    {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        extraVacation = extraDays;
        bonus = 0;  // bonus has yet to be awarded
    }

    /**
    * Assigns value to the bonus pay.
    * @param execBonus A double containing the bonus amount.
    * @return void
    */
    public void awardBonus(double execBonus)
    {
        bonus = execBonus;
    }

    /**
    * Computes and returns the pay for an executive; polymorphic.
    * @return double Returns Employee's pay plus bonus.
    * @see pay() in Employee.java
    */
    public double pay()
    {
        double payment = super.pay() + bonus;

        bonus = 0;

        return payment;
    }
    /**
    * Computes and returns vacation duration for executive; polymorphic.
    * @return int Returns standard vacation amount + extra.
    * @see vacation() in Employee.java
    */
    public int vacation(){
      return STANDARD_VACATION + extraVacation;
    }
}
