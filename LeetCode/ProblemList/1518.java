/*
  1518. Water Bottles
  There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

  The operation of drinking a full water bottle turns it into an empty bottle.

  Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.
*/

class Solution {
  public int numWaterBottles(int numBottles, int numExchange) {
    int totalDrank = numBottles;
    int numEmpty = numBottles;

    while(numEmpty >= numExchange) {
      numBottles = numEmpty / numExchange;
      numEmpty = (numEmpty % numExchange) + numBottles;
      totalDrank += numBottles;
    }
    return totalDrank;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int numBottles = 9;
    int numExchange = 3;
    System.out.println(sol.numWaterBottles(numBottles, numExchange));
  }
}
