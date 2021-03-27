package sort;

//快排
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2,4,8,6};
        sort(nums,0,nums.length-1);
        for(int i = 0;i< nums.length;i++){
            System.out.println(nums[i]);
        }
    }

    public static void sort(int nums[],int left,int right){
        if(left > right){
            return;
        }
        int i = left;
        int j = right;
        int key = nums[left];
        while(i < j){
            while(i < j && nums[j] >= key ){
                j--;
            }

            while(i < j && nums[i] <= key ){
                i++;
            }

            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        nums[left] = nums[i];
        nums[i] = key;
        sort(nums,left,j-1);
        sort(nums,j+1,right);
    }
}
