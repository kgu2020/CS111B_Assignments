/**
* The Employee class simulates a
* volunteer of a firm; Volunteer is a StaffMember
*
* @author  Ken Gu
* @version 1.0
* @since   2020-05-04
*/
public class Volunteer extends StaffMember
{
    /**
    * Constructor: Sets up this Volunteer with the specified
    * information; uses StaffMember's constructor aswell.
    * @see StaffMember() in StaffMember.java
    */
    public Volunteer(String eName, String eAddress, String ePhone)
    {
        super(eName, eAddress, ePhone);
    }

    /**
    * Returns the pay rate for this Volunteer; polymorphic.
    * @return double 0.0, Volunteers receive no monetary pay.
    */
    public double pay()
    {
        return 0.0;
    }

    /**
    * Returns the vacation duration for Volunteer; polymorphic.
    * @return int 0, Volunteers get no vacation.
    */
    public int vacation(){
      return 0;
    }
}
