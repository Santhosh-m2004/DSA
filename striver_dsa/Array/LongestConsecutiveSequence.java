package Array;
import java.util.*;
public class LongestConsecutiveSequence {

    static int res(int[] nums){
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)){
                int cur=num;
                int streak=1;
                
                while(set.contains(cur+1)){
                    cur++;
                    streak++;
                }
                count=Math.max(count,streak);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(res(nums));
    }
}
