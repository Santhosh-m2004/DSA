package slidingWindowAndTwoPointers;
import java.util.*;
/*There is only one row of fruit trees on the farm, oriented left to right.
An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit produced by the ith tree.
The goal is to gather as much fruit as possible, adhering to the owner's stringent rules:
1) There are two baskets available, and each basket can only contain one kind of fruit. 
The quantity of fruit each basket can contain is unlimited.
2) Start at any tree, but as you proceed to the right, select exactly one fruit from each tree, including the starting tree. 
One of the baskets must hold the harvested fruits.
3) Once reaching a tree with fruit that cannot fit into any basket, stop.
Return the maximum number of fruits that can be picked. */

//Brute force approach

// public class fruitsIntoBaskets {
//     public static int res(int[] nums){
//         int max=0;
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             HashSet<Integer> set=new HashSet<>();
//             for(int j=i;j<n;j++){
//                 set.add(nums[j]);
//                 if(set.size()<=2){
//                     max=Math.max(max,j-i+1);
//                 }else{
//                     break;
//                 }
//             }
//         }
//         return max;
//     }
//     public static void main(String[] args) {
//         int[] nums={1, 2, 3, 2, 2};
//         System.out.println(res(nums));
//     }
// }


//optimal 
public class fruitsIntoBaskets {
    public static int res(int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        int n=nums.length;
        int left=0;
        for(int right=0;right<n;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size()>2){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }

            max=Math.max(max,right-left+1);
        }
        
        return max;
    }
    public static void main(String[] args) {
        int[] nums={1, 2, 3, 2, 2};
        System.out.println(res(nums));
    }
}