package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串的长度
 *
 * @author yangjie
 */
public class Lc3 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 5, 3};
        System.out.println(maxLength(arr));
    }

    public static int maxLength(int[] arr) {
        int res = 0;
        int length = arr.length;
        if(length == 0 || length == 1){
            return length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < length; right++) {
            if(map.containsKey(arr[right])){
                left = Math.max(left,map.get(arr[right]) + 1);
            }
            map.put(arr[right],right);
            res = Math.max(res,right - left + 1);
        }
        return res;
    }
}
