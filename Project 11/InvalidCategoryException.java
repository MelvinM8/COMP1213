/**
* Defines a new subclass of the Exception class.
*
* @author Melvin Moreno - COMP1213
* @version 4/15/2021
*/
public class InvalidCategoryException extends Exception {
   /**
   * Constructor.
   * @param categoryIn is used.
   */
   public InvalidCategoryException(String categoryIn) {
      super("For category: " + categoryIn);
   }
}