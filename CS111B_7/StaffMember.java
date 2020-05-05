/**
* The StaffMember class represents a
* generic staff in a firm; StaffMember uses three interfaces
*
* @author  Ken Gu
* @version 1.0
* @since   2020-05-04
*/
abstract public class StaffMember implements Payable, VacationTime, Comparable<StaffMember>
{
    protected String name;
    protected String address;
    protected String phone;

    /**
    * StaffMember()
    * Constructor: Sets up this staff member using the specified
    * information.
    */
    public StaffMember(String eName, String eAddress, String ePhone)
    {
        name = eName;
        address = eAddress;
        phone = ePhone;
    }

    /**
    * Returns the name of a staff member.
    * @return String The instance data name.
    */
    public String getName(){
      return name;
    }

    /**
    * Compares two StaffMember objects by their names
    * @param b A StaffMember object.
    * @return int -1 if self object preceeds b in ASCII, 0 if equal, else 1.
    */
    public int compareTo(StaffMember b){
      if ((this.getName().compareTo(b.getName()) < 0))
        return -1;
      else if ((this.getName().compareTo(b.getName())) == 0)
        return 0;
      else
        return 1;
    }

    /**
    * toString()
    * Returns a String containing the staff member's info.
    * @return String result, a variable with the object's info.
    */
    public String toString()
    {
        String result = "Name: " + name + "\n";

        result += "Address: " + address + "\n";
        result += "Phone: " + phone;

        return result;
    }
}
