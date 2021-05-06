package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 左子树移动k个位置
 *
 * @author yangjie
 */
public class AlimsDemo {
    /**
     * @param nums 数组
     * @param n    数组长度
     * @param k    最左侧树循环移动k个位置
     */
    public static void moveK(int[] nums, int n, int k) {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        while(j < n){
            list.add(nums[j]);
            j = 2 * j + 1;
        }

        int size = list.size();
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = list.get(i);
        }
        move(temp, k);
        int p = 0;
        for (int i = 0; i < temp.length; i++) {
            nums[p] = temp[i];
            p = 2 * p + 1;
        }
    }

    public static void move(int[] nums, int k) {
        int length = nums.length;
        // 右移newk + n * length个位置，和右移newk个位置效果是一样的
        int newk = k % length;
        int temp = 0;
        for (int i = 0; i < newk; i++) {
            temp = nums[length - 1];
            for (int j = length - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        moveK(nums,nums.length,1);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
