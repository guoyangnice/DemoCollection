package leetcode;

/**
 * 接雨水-高频题
 * @author yangjie
 */
public class Lc42 {
    public int trap(int[] height) {
        int ans = 0,h1 = 0,h2 = 0;
        for(int i = 0;i < height.length;i++){
            h1 = Math.max(h1,height[i]);
            h2 = Math.max(h2,height[height.length - i - 1]);
            ans = ans + h1 + h2 - height[i];
            System.out.println("第" + i +"次循环：h1=" + h1 +",h2 = " + h2 +",ans = " + ans);
        }
        return ans - height.length * h1;
    }

    public static void main(String[] args) {
        int[] height= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("答案：" + new Lc42().trap(height));
    }
}
