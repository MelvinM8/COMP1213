import java.util.Comparator;
/**
* Defines the ordering from highest to lowest based on the ROI.
*
* Project 10
* @author Melvin Moreno - COMP1213
* @version 4/8/2021
*/
public class ROIComparator implements Comparator<MarketingCampaign> {
   /**
   * Compares methods for ROI.
   * @param c1 is the first ROI.
   * @param c2 is the second ROI.
   * @return returns the value of the compare result.
   */
   public int compare(MarketingCampaign c1, MarketingCampaign c2) {
      if (c1.calcROI() > c2.calcROI()) {
         return -1;
      }
      else if (c1.calcROI() < c2.calcROI()) {
         return 1;
      }
      return 0;
   }
}