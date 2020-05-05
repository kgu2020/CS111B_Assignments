/**
* Algorithm:
* 1. Instantiates a Staff object
* 2. Staff object initializes an array of StaffMember objects
* 3. Each staff in the array gets bonus pay/hours accordingly
* 4. Sort the array by staff names in descending order
* 5. Display each staff's information and pay/vacation.
*/

/**
* The Firm program simulates and displays
* a database of workers in a firm.
*
* @author  Ken Gu
* @version 1.0
* @since   2020-05-04
*/
public class Firm
{
  /**
  * The main() for Firm.java; instantiates a Staff object
  * and calls its methods.
  * @param args Unused.
  * @return void
  */
  public static void main(String[] args)
  {
    Staff personnel = new Staff();
    personnel.sort();
    personnel.payday();
  }
}
