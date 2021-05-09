package leetcode.dynamicprogramming;

/**
 * 题目：给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 动态规划-线性关系中的分析方法
 * @author yangjie
 */
public class LongestAscendingSub {
    public static int longest(int[] nums) {
        int length = nums.length;
        if (length < 0) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        int result = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 5, 9, 3};
        System.out.println(longest(nums));
    }
}
