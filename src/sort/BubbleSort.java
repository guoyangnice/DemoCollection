package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2,4,8,6};
        sort(nums);
        for(int i = 0;i< nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    public static void sort(int nums[]){
        for(int i =0;i< nums.length;i++){
            for(int j = 0;j < nums.length-1-i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
