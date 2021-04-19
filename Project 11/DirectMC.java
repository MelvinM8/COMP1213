import java.text.DecimalFormat;
/**
* DirectMC.
*
* Project 9
* @author Melvin Moreno - COMP1213
* @version 3/31/2021
*/
public class DirectMC extends MarketingCampaign {
   //instance variables
   private double costPerMailPiece;
   private int numberOfMailPieces;
   //class variable
   /**
   * Final variable.
   */
   public static final double BASE_COST = 1000;
   //constructor
   /**
   * DirectMC constructor.
   * @param nameIn is used.
   * @param revenueIn is used.
   * @param costPerMailPieceIn is used.
   * @param numberOfMailPiecesIn is used.
   */
   public DirectMC(String nameIn, double revenueIn,
      double costPerMailPieceIn, int numberOfMailPiecesIn) {
      super(nameIn, revenueIn);
      costPerMailPiece = costPerMailPieceIn;
      numberOfMailPieces = numberOfMailPiecesIn;
   }
   //methods
   /**
   * Returns a double representing costPerMailPiece.
   * @return returns double represneting costPerMailPiece.
   */
   public double getCostPerMailPiece() {
      return costPerMailPiece;
   }
   /**
   * Sets the cost per mail piece.
   * @param costPerMailPieceIn is used.
   */
   public void setCostPerMailPiece(double costPerMailPieceIn) {
      costPerMailPiece = costPerMailPieceIn;
   }
   /**
   * Returns an int representing numberOfMailPieces.
   * @return returns numberOfMailPieces.
   */
   public int getNumberOfMailPieces() {
      return numberOfMailPieces;
   }
   /**
   * Sets numberOfMailPieces.
   * @param numberOfMailPiecesIn is used.
   */
   public void setNumberOfMailPieces(int numberOfMailPiecesIn) {
      numberOfMailPieces = numberOfMailPiecesIn;
   }
   /**
   * Returns a double representing the campaign cost for the DirectMC.
   * @return returns that ^.
   */
   public double campaignCost() {
      return BASE_COST + (costPerMailPiece * numberOfMailPieces);
   }
   /**
   * Return a String describing the DirectMC object.
   * @return returns a string describing the DirectMC object.
   */
   public String toString() {
      DecimalFormat d = new DecimalFormat("$#,##0.00");
      DecimalFormat r = new DecimalFormat("0.##%");
      String output = "";
      return super.toString() + "\n   Base Cost: " + d.format(this.BASE_COST)
         + "\n   Mail Cost: " + d.format(costPerMailPiece * numberOfMailPieces)
         + " = " + d.format(costPerMailPiece) + " per mail piece * "
         + numberOfMailPieces + " mail pieces";
   }
}