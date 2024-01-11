/* John Dufresne 01/10/2024
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
Find and return the maximum profit you can achieve.
*/

public class MaxProfit {
    public static int maxProfit(int[] prices){
        int total = 0;
        int curr_stock = -1; //if 0, dont own a stock, otherwise is the value of owned stock

        for(int i = 0; i < prices.length-1; i++){
            if(curr_stock == -1){
                if(prices[i] < prices[i+1]){
                    curr_stock = prices[i];
                    total -= curr_stock;
                }
            }
            else{
                if(curr_stock < prices[i]){
                    int temp_highest = prices[i], j = i+1, n = prices.length;
                    while(j < n){
                        if(temp_highest < prices[j]){
                            temp_highest = prices[j];
                            j++;
                        }
                        else 
                            j = n;
                            break;
                    }
                    total += temp_highest;
                    curr_stock = -1;
                }
            }
        }
        //We never really check the last position of prices so see if we have left over stock and if we do check if it should be sold for last day.
        if(curr_stock != -1){
            if(prices[prices.length-1] > curr_stock)
                total += prices[prices.length-1];
        }
        return total;
    }
    public static void main(String args[]){
        int prices[] = {2,1,2,0,1}; // Array of prices for the week, 6 days
        //{7,1,5,3,6,4}
        System.out.println(maxProfit(prices));
    }
}
