package sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author yangjie
 */
public class HeapSort {

    public static void swap(int[] num, int i, int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    /**
     * 三个结点的heap调整
     * @param tree 数组
     * @param n 数组长度
     * @param i 从i的位置开始调整
     */
    public static void heapify(int tree[],int n,int i){
        if(i >= n){
            return;
        }
        //c1-c2：只是下标
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        //考虑数组越界，所以Cx < n
        if( c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){
            swap(tree, max, i);
            //递归表示对max下面的子树做调整
            heapify(tree, n, max);
        }
    }

    public static void buildHeap(int[] tree,int n){
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for(int i = parent; i >= 0; i--){
            heapify(tree,n,i);
        }
    }

    public static void heapSort(int tree[], int n){
        //创建堆
        buildHeap(tree,n);
        for (int i = n - 1; i >= 0; i--){
            //交换末尾元素和最大元素的位置
            swap(tree, i, 0);
            //这一步比较关键：这时候最大元素已经在末尾，
            // 不再参与后续的调整，所以这里传入的是i，表示参与的结点一直在减少
            heapify(tree,i,0);
        }
    }

    public static void main(String[] args) {
//        int[] tree = {4,10,3,5,1,2};
        int n = 6;
//        heapify(tree,n,0);
        int[] tree = {2, 5, 3, 1, 10, 4};
//        buildHeap(tree,n);
        heapSort(tree,n);
        Arrays.stream(tree).forEach(System.out::println);
    }
}
