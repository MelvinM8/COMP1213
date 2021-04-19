import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.NoSuchElementException;
/**
* Provides methods for reading in the data file and generating reports.
*
* Project 10
* @author Melvin Moreno - COMP1213
* @version 4/8/2021
*/
public class MarketingCampaignList {
   //instance variables
   private MarketingCampaign[] marketingCampaignList;
   private String[] invalidRecords;
   
   //constructor
   /**
   * Constructor for MarketingCampaignList.
   */
   public MarketingCampaignList() {
      marketingCampaignList = new MarketingCampaign[0];
      invalidRecords = new String[0];
   }
   //methods
   /**
   * Returns an array of type MarketingCampaign representing the
   * MarketingCampaign array field.
   * @return returns just that.
   */
   public MarketingCampaign[] getMarketingCampaignArray() {
      return marketingCampaignList;
   }
   /**
   * Returns an array of type String representing the invalid record array
   * field.
   * @return returns that.
   */
   public String[] getInvalidRecordsArray() {
      return invalidRecords;
   }
   /**
   * Accepts a MarketingCampaign object, increases the capacity of the
   * MarketingCampaign array by one, and adds the MarketingCampaign
   * object in the last position of the MarketingCampaign array.
   * @param obj is used.
   */
   public void addMarketingCampaign(MarketingCampaign obj) {
      marketingCampaignList = Arrays.copyOf(marketingCampaignList,
         marketingCampaignList.length + 1);
      marketingCampaignList[marketingCampaignList.length - 1] = obj;
   }
   /**
   * Acccepts a String, increases the capacity of the invalidRecords array
   * by one, and adds the String in the last position of the invalidRecords
   * array.
   * @param invalidRecordObj is used.
   */
   public void addInvalidRecord(String invalidRecordObj) {
      invalidRecords = Arrays.copyOf(invalidRecords,
         invalidRecords.length + 1);
      invalidRecords[invalidRecords.length - 1] = invalidRecordObj;
   }
   /**
   * Reads file and gives requested information.
   * @param dataFileName name of file.
   * @throws FileNotFoundException if the file cannot be opened.
   */
   public void readFile(String dataFileName) throws FileNotFoundException {
         
   // variables from part 2.
      int itemCount;
      String name = "";
      double revenue = 0;
      int numberOfMailPieces = 0;
      double costPerAd = 0;
      int numberOfAds = 0;
      double costPerMailPiece = 0;
   
      String reject = "";
   
      Scanner scan = new Scanner(new File(dataFileName));
      
      while (scan.hasNext()) {
         String random = scan.nextLine();
         Scanner scan2 = new Scanner(random);
         scan2.useDelimiter(",");
         String type = scan2.next();
         
         
            
         char code = type.toUpperCase().charAt(0);
         try {
            switch(code) {
               case 'D':
                  name = scan2.next().trim();
                  revenue = Double.parseDouble(scan2.next().trim());
                  costPerMailPiece = Double.parseDouble(scan2.next().trim());
                  numberOfMailPieces = Integer.parseInt(scan2.next().trim());
               
                  addMarketingCampaign(new DirectMC(name, revenue,
                     costPerMailPiece, numberOfMailPieces));
                  break;
               case 'I':
                  name = scan2.next().trim();
                  revenue = Double.parseDouble(scan2.next().trim());
                  costPerAd = Double.parseDouble(scan2.next().trim());
                  numberOfAds = Integer.parseInt(scan2.next().trim());
               
                  addMarketingCampaign(new IndirectMC(name, revenue,
                     costPerAd, numberOfAds));
                  break;
               case 'S':
                  name = scan2.next().trim();
                  revenue = Double.parseDouble(scan2.next().trim());
                  costPerAd = Double.parseDouble(scan2.next().trim());
                  numberOfAds = Integer.parseInt(scan2.next().trim());
               
                  addMarketingCampaign(new SearchEngineMC(name, revenue,
                     costPerAd, numberOfAds));
                  break;
               case 'M':
                  name = scan2.next().trim();
                  revenue = Double.parseDouble(scan2.next().trim());
                  costPerAd = Double.parseDouble(scan2.next().trim());
                  numberOfAds = Integer.parseInt(scan2.next().trim());
               
                  addMarketingCampaign(new SocialMediaMC(name, revenue,
                     costPerAd, numberOfAds));
                  break;
               default:
                  try {
                     throw new InvalidCategoryException(type);
                  }
                  catch (InvalidCategoryException e) {
                     addInvalidRecord(random + "\n" + e.toString());
                  }
                  break;
            }
         }
         catch (NumberFormatException e) {
            addInvalidRecord(random + "\n" + e.toString());
         }
         catch (NoSuchElementException e) {
            e = new NoSuchElementException("For missing input data");
            addInvalidRecord(random + "\n" + e.toString());
         }
      }
   }
      
   /**
   * Processes the MarketingCampaign array using the original order
   * from the file to produce the Marketing Campaign Report and then
   * returns the report as String.
   * @return returns summary.
   */
   public String generateReport() {  
      String result = "";
      for (MarketingCampaign marketingCampaign : marketingCampaignList) {
         result += "\n" + marketingCampaign.toString() + "\n";
      }
      return "-------------------------------\n"
         + "Marketing Campaign Report\n"
         + "-------------------------------\n" + result;
   }
   /**
   * Sorts the MarketingCampaign array by its natural ordering, and then
   * processes the MarketingCampaign array to produce the Marketing Report
   * (by Name), then returns the report as a String.
   * @return returns summary.
   */
   public String generateReportByName() {
      Arrays.sort(getMarketingCampaignArray());
      String output = "-------------------------------------------------\n"
         + "Marketing Campaign Report (by Name)\n"
         + "-------------------------------------------------\n\n";
      for (int i = 0; i < marketingCampaignList.length; i++) {
         output += marketingCampaignList[i].toString() + "\n\n";
      }
      return output;
   }
   /**
   * Sorts the MarketingCampaign array by campaign cost (lowest first),
   * and then processes the MarketingCampaign array to produce the Marketing
   * Campaign Report (by Campaign Cost) and then returns the report as a String.
   * @return returns that.
   */
   public String generateReportByCampaignCost() {
      String result = "";
      Arrays.sort(marketingCampaignList, new CampaignCostComparator());
      
      result += "-------------------------------------------------" + "\n";
      result += "Marketing Campaign Report (by Lowest Campaign Cost)\n";
      result += "-------------------------------------------------" + "\n";
      
      for (int i = 0; i < marketingCampaignList.length; i++) {
         result += "\n" + marketingCampaignList[i] + "\n";
      }
      return result;
   }
   /**
   * Sorts the MarketingCampaign array by ROI (highest first), and then
   * processes the MarketingCampaign array to produce the Marketing Campaign
   * Report (by ROI) and then returns the report as String.
   * @return returns that.
   */
   public String generateReportByROI() {
      String result = "";
      Arrays.sort(marketingCampaignList, new ROIComparator());
      
      result += "-------------------------------------------------" + "\n";
      result += "Marketing Campaign Report (by Highest ROI)\n";
      result += "-------------------------------------------------" + "\n";
      
      for (int i = 0; i < getMarketingCampaignArray().length; i++) {
         result += "\n" + marketingCampaignList[i] + "\n";
      }
      return result;
   }
   /**
   * Proecesses the invalid records array to produce the Invalid Records
   * Report and then returns the report as a String.
   * @return returns the Invalid Records Report.
   */
   public String generateInvalidRecordsReport() {
      String result = "";
      result += "----------------------" + "\n";
      result += "Invalid Records Report" + "\n";
      result += "----------------------" + "\n";
      
      for (int i = 0; i < invalidRecords.length; i++) {
         result += "\n" + invalidRecords[i] + "\n";
      }
      return result;
   }
}