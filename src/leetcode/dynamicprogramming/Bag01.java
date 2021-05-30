package leetcode.dynamicprogramming;

/**
 * 动态规划系列经典题目-01背包问题-做好注释
 * 题目：
 * 月黑风高的夜晚，张三开启了法外狂徒模式：他背着一个可装载重量为 W 的背包去地主家偷东西。
 * 地主家有 N 个物品，每个物品有重量和价值两个属性，其中第 i 个物品的重量为 wt[i]，价值为 val[i]。
 * 问张三现在用这个背包装物品，最多能装的价值是多少？
 * @author yangjie
 *
 */
public class Bag01 {
    /**
     * 背包解答
     * @param wt 每一个物品的重量
     * @param val 每一个物品的价值
     * @param size 背包可装载的重量
     * @return
     */
    //表示物品的数量
    public int N = 0;
    //表示可装载重量
    public int W = 0;
    public int knapsackProblem(int[] wt,int[] val,int size) {
        //dp[i][w]:表示前i个物品，当前背包容量为w，此时可以装下的最大价值为dp[i][w]
        int[][] dp = new int[wt.length][size];
        //初始化表示质量为0的物品，价值为0
        for(int i = 0; i < size; i++){
            dp[i][0] = 0;
        }
        //表示第0个物品的价值为0
        for(int i = 0; i < size; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i] > W){
                    dp[i][W] = dp[i-1][W];
                }else{
                    dp[i][W] = Math.max(dp[i-1][W],dp[i-1][W-wt[i]] + val[i]);
                }
            }
        }
        return dp[wt.length-1][size-1];
    }
}
