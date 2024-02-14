import java.util.Arrays;

public class Code7BestTimeToBuyAnsSellStock {

    public static int findBestTime1(int[] prices) {

        int maxProfit = 0;

        for(int i = 0 ; i < prices.length-1 ; i++) {

            for(int j = i+1 ; j < prices.length ; j++) {

                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);

            }

        }

        return maxProfit;

    }

    public static int findBestTime2(int[] prices) {

        int[] aux = new int[prices.length];

        int max = -1;

        for(int i = prices.length - 1 ; i >= 0 ; i--) {

            aux[i] = max;
            max = Math.max(max, prices[i]);

        }

        int maxProfit = 0;

        for(int i = 0 ; i < prices.length ; i++) {

            maxProfit = Math.max(maxProfit , (aux[i] - prices[i]));

        }

        return maxProfit;

    }

    public static int findBestTime(int[] prices) {

        int minByingPrice = prices[0] , maxProfit = 0;

        for(int price : prices) {

            if(price < minByingPrice)
                minByingPrice = price;

            else if( price - minByingPrice > maxProfit )
                maxProfit = price - minByingPrice;

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        
        int[] prices = {7, 1, 5, 3, 6, 4};
        int ans = findBestTime(prices);
        System.out.println(ans);

    }
}
