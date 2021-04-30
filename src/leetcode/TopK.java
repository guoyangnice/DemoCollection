package leetcode;

import java.util.Arrays;

/**
 * 学以致用-这里使用堆排序查找出最大的k个数
 * 这里使用自己的方法完成了这道题
 * 解决topK的方法：
 *  1、堆排序（这种面试最常见，但不是最优解）时间复杂度为O(nlogn)
 *  2、快排 (最优解 O(N))
 *  3、使用优先队列
 *  4、排序完再取值
 * @author yangjie
 */
public class TopK {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 7, 5, 9, 2, 6};
        int[] result = sortHeap(nums, nums.length, 3);
        Arrays.stream(result).forEach(System.out::println);
    }

    /**
     * 堆化
     *
     * @param tree
     * @param n
     * @param i
     */
    public static void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    /**
     * 建堆
     *
     * @param tree
     * @param n
     */
    public static void buildHeap(int[] tree, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    public static int[] sortHeap(int[] tree, int n, int k) {
        int[] result = new int[k];
        buildHeap(tree, n);
        for (int i = n - 1; i >= n - k; i--) {
            swap(tree, i, 0);
            result[n - i - 1] = tree[i];
            heapify(tree, i, 0);
        }
        return result;
    }
}
