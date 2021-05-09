package leetcode.dynamicprogramming;

/**
 * 题目：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 时间复杂度o（n）,空间复杂度o（n）
 * @author yangjie
 */
public class MaxSubSum2 {
    /**
     * @param nums 整数数组
     */
    public static int maxSubSum(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
            result = Math.max(dp[i],result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubSum(nums));
    }
}
