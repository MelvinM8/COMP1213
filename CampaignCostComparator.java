import java.util.Comparator;
/**
* Defines the ordering from lowest to highest based on the campaign cost.
*
* Project 10
* @author Melvin Moreno - COMP1213
* @version 4/8/2021
*/
public class CampaignCostComparator implements Comparator<MarketingCampaign> {
   /**
   * Compares two MarketingCampaign objects.
   * @param c1 first Marketing Campaign object
   * @param c2 second Marketing Campaign object
   * @return int for order.
   */
   public int compare(MarketingCampaign c1, MarketingCampaign c2) {
      if (c1.campaignCost() < c2.campaignCost()) {
         return -1;
      }
      else if (c1.campaignCost() > c2.campaignCost()) {
         return 1;
      }
      else {
         return 0;
      }
   }
}