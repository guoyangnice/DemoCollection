package search;

public class BinarySearchDemo {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,5,7,9},2));
        System.out.println(search(new int[]{1,3,5,7,9},3));
    }
    //二分查找
    public static int search(int[] nums,int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(nums[mid] > target){
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
