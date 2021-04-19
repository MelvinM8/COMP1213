/**
* SocialMediaMC.
*
* Project 9
* @author Melvin Moreno - COMP1213
* @version 3/31/2021
*/
public class SocialMediaMC extends IndirectMC {
//constant
/**
* BASE_COST variable.
*/
   public static final double BASE_COST = 3000.0;
//constructor
/**
* Constructor for SocialMediaMC.
* @param nameIn is used.
* @param revenueIn is used.
* @param costPerAdIn is used.
* @param numberOfAdsIn is used.
*/
   public SocialMediaMC(String nameIn, double revenueIn,
      double costPerAdIn, int numberOfAdsIn) {
      super(nameIn, revenueIn, costPerAdIn, numberOfAdsIn);
   }
   //methods
   /**
   * Returns a double representing the cost factor.
   * @return returns the cost factor.
   */
   public double getBaseCost() {
      return this.BASE_COST;
   }
}