package com.example.code.generated;
/* 121. 买卖股票的最佳时机 O(1) */
public class StockProfit {
    // 找某个元素的右边的元素的最大值，作差，比较差的大小,暴力法会超时
    // 对于某一个具体的日子，在当天卖出股票所能获得的最大值，是当前的股票价格减去之前出现过的最小值
    // 求整个过程的最大值
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]  < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
                
            }
        }
        return max;
    }
    public static void main(String[] args) {
        
        StockProfit solution = new StockProfit();




        
        // 每一天的股票价格：第 2 天以最低价 1 买入，第 5 天以 6 卖出
        int[] prices = {7, 1, 5, 3, 6, 4};

        /*
         * 日       股价    min     利益    max
         * 1日目       7       7       0       0
         * 2日目       1       1       0       0
         * 3日目       5       1       4       4
         * 4日目       3       1       2       4
         * 5日目       6       1       5       5
         * 6日目       4       1       3       5
         *
         * min  = その日までの最低株価
         * 利益 = 現在の株価 - min
         * max  = その日までの最大利益
         */
        int maxProfit = solution.maxProfit(prices);

        // min 会记录当前为止的最低价格，maxProfit 会记录当前为止的最大收益
        System.out.println("最大收益: " + maxProfit); // 结果：5
    }}
