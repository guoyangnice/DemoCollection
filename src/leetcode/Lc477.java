package leetcode;

public class Lc477 {
    public static int totalHammingDistance(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int res = 0;
        for(int left = 0, right = 1;left < nums.length;){
            res += Integer.bitCount(nums[left] ^ nums[right]);
            right++;
            if(right >= nums.length){
                left++;
                right = left + 1;
                if(right >= nums.length){
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{1337}));
    }
}
