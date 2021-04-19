import java.text.DecimalFormat;
/**
* IndirectMC.
*
* Project 9
* @author Melvin Moreno - COMP1213
* @version 3/31/2021
*/
public class IndirectMC extends MarketingCampaign {
   //instance variables
   protected double costPerAd;
   protected int numberOfAds;
   //class constant
   /**
   * BASE_COST variable.
   */
   public static final double BASE_COST = 1500.0;
   //constructor
   /**
   * IndirectMC constructor.
   * @param nameIn is used.
   * @param revenueIn is used.
   * @param costPerAdIn is used.
   * @param numberOfAdsIn is used.
   */
   public IndirectMC(String nameIn, double revenueIn,
      double costPerAdIn, int numberOfAdsIn) {
      super(nameIn, revenueIn);
      costPerAd = costPerAdIn;
      numberOfAds = numberOfAdsIn;
   }
   //methods
   /**
   * Returns a double representing cost per ad.
   * @return returns a double representing cost per ad.
   */
   public double getCostPerAd() {
      return costPerAd;
   }
   /**
   * Sets cost per ad.
   * @param costPerAdIn is used.
   */
   public void setCostPerAd(double costPerAdIn) {
      costPerAd = costPerAdIn;
   }
   /**
   * Returs an int representing the number of ads.
   * @return returns the number of ads.
   */
   public int getNumberOfAds() {
      return numberOfAds;
   }
   /**
   * Sets number of ads.
   * @param numberOfAdsIn is used.
   */
   public void setNumberOfAds(int numberOfAdsIn) {
      numberOfAds = numberOfAdsIn;
   }
   /**
   * Returns a double representing the constant BASE_COST.
   * @return returns BASE_COST.
   */
   public double getBaseCost() {
      return this.BASE_COST;
   }
   /**
   * Returns a double representing the campaign cost for the
   * IndirectMC.
   * @return returns campaign cost for the IndirectMC.
   */
   public double campaignCost() {
      return getBaseCost() + (costPerAd * numberOfAds);
   }
   /**
   * Returns a String describing the IndirectMC object.
   * @return returns a String describing the IndirectMC object.
   */
   public String toString() {
      DecimalFormat d = new DecimalFormat("$#,##0.00");
      return super.toString() + "\n   Base Cost: " + d.format(getBaseCost())
         + "\n   Ad Cost: " + d.format(costPerAd * numberOfAds) + " = "
         + d.format(costPerAd) + " per ad * " + numberOfAds + " ads";
   }
}