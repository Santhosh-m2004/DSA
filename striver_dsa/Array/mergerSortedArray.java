package Array;
import java.util.*;
class mergerSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=nums1.length-1;
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k]=nums1[i];
                i--;
                k--;
            }else{
                nums1[k]=nums2[j];
                j--;
                k--;
            }
        }

        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.print(Arrays.toString(nums1));
    }
}
