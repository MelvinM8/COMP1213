import java.text.DecimalFormat;
/**
* A program that describes marketing campaign data and provides methods to
* access the data.
*
* Project 9
* @author Melvin Moreno - COMP1213
* @version 3/31/2021
*/
public abstract class MarketingCampaign implements Comparable<MarketingCampaign>
{
   //instance variables
   protected String name;
   protected double revenue;
   //class variable
   protected static int marketingCampaignObj = 0;
   //constructor
   /**
   * Constructor for MarketingCampaing.
   * @param nameIn is used.
   * @param revenueIn is used.
   */
   public MarketingCampaign(String nameIn, double revenueIn) {
      name = nameIn;
      revenue = revenueIn;
      marketingCampaignObj++;
   }
   //methods
   /**
   * Returns a String representing the name.
   * @return returns the name.
   */
   public String getName() {
      return name;
   }
   /**
   * Sets the name.
   * @param nameIn is used.
   */
   public void setName(String nameIn) {
      name = nameIn;
   }
   /**
   * Returns a double representing revenue for the marketing campaign.
   * @return returns revenue.
   */
   public double getRevenue() {
      return revenue;
   }
   /**
   * Sets revenue for the marketing campaign.
   * @param revenueIn is used.
   */
   public void setRevenue(double revenueIn) {
      revenue = revenueIn;
   }
   /**
   * Returns an int representing the count.
   * @return returns the count.
   */
   public static int getCount() {
      return marketingCampaignObj;
   }
   /**
   * Resets count to zero.
   */
   public static void resetCount() {
      MarketingCampaign.marketingCampaignObj = 0;
   }
   /**
   * Calculates ROI and returns it.
   * @return returns the ROI.
   */
   public double calcROI() {
      return (revenue - campaignCost()) / campaignCost();
   }
   /**
   * Returns a String describing the MarketingCampaign object.
   * @return returns a String describing the MarketingCampaign object.
   */
   public String toString() {
      DecimalFormat d = new DecimalFormat("$#,##0.00");
      DecimalFormat r = new DecimalFormat("0.##%");
      return name + " (class " + this.getClass().toString().substring(6) + ")"
         + "\nRevenue: " + d.format(revenue) + "   Campaign Cost: "
         + d.format(campaignCost()) + "   ROI: " + r.format(calcROI());
   }
   /**
   * Returns a double representing the cost of the marketing campaign.
   * @return returns the cost of the marketing campaign.
   */
   public abstract double campaignCost();
   /**
   * Compares two marketing campaign objects.
   * @param obj is used.
   * @return returns an int representing order of list.
   */
   public int compareTo(MarketingCampaign obj) {
      int result = this.name.toLowerCase().compareTo(obj.name.toLowerCase());
      return result;
   }
}