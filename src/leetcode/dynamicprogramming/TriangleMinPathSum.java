package leetcode.dynamicprogramming;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每次只能走相邻的路线
 *
 * @author yangjie
 */
public class TriangleMinPathSum {
    public static int triangleMin(int[][] triangle) {
        if (triangle.length < 1) {
            return 0;
        }
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        int[][] dp = new int[triangle.length][triangle.length];
        int result = Integer.MAX_VALUE;
        dp[0][0] = triangle[0][0];
        dp[1][1] = triangle[1][1] + triangle[0][0];
        dp[1][0] = triangle[1][0] + triangle[0][0];
        for (int i = 2; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        for (int k = 0; k < dp.length; k++) {
            result = Math.min(result, dp[dp.length - 1][k]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(triangleMin(triangle));
        System.out.println(triangleMin2(triangle));
    }

    /**
     * leetcode第120题最优解
     *
     * @param triangle
     */
    public static int triangleMin2(int[][] triangle) {
        int length = triangle.length;
        int[] dp = new int[triangle.length];
        dp[0] = triangle[0][0];
        for (int i = 1; i < length; i++) {
            dp[i] = dp[i - 1] + triangle[i][i];
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle[i][j];
            }
            dp[0] += triangle[i][0];
        }
        int min = dp[0];
        for (int k = 1; k < length; k++) {
            min = Math.min(min, dp[k]);
        }
        return min;
    }
}
