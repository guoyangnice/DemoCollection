package leetcode.dynamicprogramming;

/**
 * 动态规划一直是面试的痛点，本题是入门动态规划的第一题
 * 动态规划的核心是：记住子问题的解，从而寻找最优解。
 * 当然此题也有第二种解法，滚动数组，斐波那契也同样可以使用滚动数组来写
 * 题目：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？注意：给定 n 是一个正整数。
 *
 * @author yangjie
 */
public class ClimbStair1 {
    /**
     * 爬楼梯
     *
     * @param n
     */
    public static int climbStair(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStair(4));
    }
}
