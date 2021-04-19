import java.io.FileNotFoundException;
/**
* Contains the main method for running the program (MarketingCampaign)
*
* @author Melvin Moreno - COMP1213
* @version 4/15/2021
*/
public class MarketingCampaignPart3 {
   /**
   * @param args command line arguments.
   */
   public static void main(String[] args) {
      if (args.length == 0 || args[0] == null || args[0].equals("")) {
         System.out.println("File name expected as command line argument.");
         System.out.println("Program ending.");
      }
      else {
         String dataFileName = args[0];
         try {
            MarketingCampaignList test = new MarketingCampaignList();
            test.readFile(dataFileName);
            System.out.println(test.generateReport());
            System.out.print(test.generateReportByName());
            System.out.println(test.generateReportByCampaignCost());
            System.out.println(test.generateReportByROI());
            System.out.println(test.generateInvalidRecordsReport());
         }
         catch (FileNotFoundException e) {
            System.out.println("*** Attempted to read file: " + dataFileName
               + " (No such file or directory)");
         }
      }
   }
}