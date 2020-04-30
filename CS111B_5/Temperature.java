import java.util.Scanner;
/**
 * Temperature --- program to mess with temperatures.
 * @author    Ken Gu
 * @version   1.0
 * @since     2020-03-13
*/
public class Temperature implements TemperatureInterface{
  private double degrees;
  private char type;
  /**
  * 4 overloaded constructors that
  * specify either one instance data, both, or default values.
  * @param degree a double primitive.
  * @param unit a character primitive.
  * @exception Any exception
  * @return No return value.
  */
  public Temperature(double degree, char unit){
    degrees = degree;
    type = unit;
  }
  public Temperature(double degree){
    degrees = degree;
    type = 'C';
  }
  public Temperature(char unit){
    degrees = 0.0;
    type = unit;
  }
  public Temperature(){
    degrees = 0.0;
    type = 'C';
  }
  /**
  * A method to print a string
  * containing the instance data.
  * @exception Any exception
  * @return No return value.
  */
  public void writeOutput(){
    System.out.println("" + degrees + type);
  }
  /**
  * A method to print instance data
  * in strictly Celsius.
  * @exception Any exception
  * @return No return value.
  */
  public void writeC(){
    //convert if in type F/f
    if (type == 'F' || type == 'f') {
      System.out.println((Math.round((degrees - 32)* 5 / 9 * 10) / 10.0) + "C");
    }
    else{
      System.out.println((Math.round(degrees * 10) / 10.0) + "C");
    }
  }
  /**
  * A method to print instance data
  * in strictly Fahrenheit.
  * @exception Any exception
  * @return No return value.
  */
  public void writeF(){
    //convert if in type C/c
    if (type == 'C' || type == 'c'){
      System.out.println((Math.round((degrees * 9 / 5 + 32) * 10) / 10.0) + "F");
    }
    else {
      System.out.println((Math.round(degrees * 10) / 10.0) + "F");
    }
  }
  /**
  * A method to return the value of
  * current instance's <code>degrees</code> in Fahrenheit.
  * @exception Any exception
  * @return a double primitive
  */
  public double getF(){
    if (type == 'C' || type == 'c'){
      return (Math.round((degrees * 9 / 5 + 32) * 10) / 10.0);
    }
    else if (type == 'F' || type == 'f'){
      return (Math.round(degrees * 10) / 10.0);
    }
    else{
      return degrees;
    }
  }
    /**
    * A method to return the value of
    * current instance's <code>degrees</code> in Celsius.
    * @exception Any exception
    * @return No return value.
    */
  public double getC(){
    if (type == 'F' || type == 'f'){
      return (Math.round((degrees - 32)* 5 / 9 * 10) / 10.0);
    }
    else if (type == 'C' || type =='c'){
      return (Math.round(degrees * 10) / 10.0);
    }
    else{
      return degrees;
    }
  }
    /**
    * Overloaded mutator method
    * for setting instance data.
    * @param value a double primitive.
    * @param unit a character primitve.
    * @exception Any exception
    * @return No return value.
    */
  public void set(double value, char unit){
    degrees = value;
    type = unit;
  }
  public void set(double value){
    degrees = value;
  }
  public void set(char unit){
    type = unit;
  }
    /**
    * A method to compare
    * <code>degrees</code> of two instances.
    * @param x a Temperature object.
    * @exception Any exception
    * @return equals or not
    */
  public boolean equals(Temperature x){
    return this.getC() == x.getC();
  }
    /**
    * A method to have user input
    * values and print them in a string.
    * @exception Any exception
    * @return No return value.
    */
  public void readInput(){
    double value;
    String unitIn;
    char unit;
    Scanner scan = new Scanner(System.in);
    System.out.println("Input temperature value:");
    value = scan.nextDouble();
    scan.nextLine();
    System.out.println("Enter 'F' (or 'f') for Fahrenheit or 'C' (or 'c') for Celsius:");
    unitIn = scan.nextLine();
    unit = unitIn.charAt(0);
    System.out.println();
    //validate unit type entered
    if ((unit == 'c') || (unit == 'f') || (unit == 'C') || (unit == 'F')) {
      type = unit;
      degrees = value;
    }
    else {
      System.out.println("Invalid units.");
    }
  }
    /**
    * A <code>toString</code> method for
    * printing instance data.
    * @exception Any exception
    * @return a string representing instance data.
    */
  public String toString(){
    String unit = Character.toString(type);
    String value = Double.toString(degrees);
    return "Temperature: " + value + unit + ".";
  }
}
