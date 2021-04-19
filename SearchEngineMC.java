/**
* SearchEngineMC.
*
* Project 9
* @author Melvin Moreno - COMP 1213
* @version 3/31/2021
*/
public class SearchEngineMC extends IndirectMC {
   //constant
   /**
   * BASE_COST variable.
   */
   public static final double BASE_COST = 2000.0;
   //constructor
   /**
   * Constructor for SearchEngineMC.
   * @param nameIn is used.
   * @param revenueIn is used.
   * @param costPerAdIn is used.
   * @param numberOfAdsIn is used.
   */
   public SearchEngineMC(String nameIn, double revenueIn,
      double costPerAdIn, int numberOfAdsIn) {
      super(nameIn, revenueIn, costPerAdIn, numberOfAdsIn);
   }
   //methods
   /**
   * Returns a double representing the BASE_COST for this class.
   * @return returns the base cost of this class.
   */
   public double getBaseCost() {
      return this.BASE_COST;
   }
}