package Recursion;
import java.util.*;
public class combinationSum2 {
    public static List<List<Integer>> comSum(int[] candidates,int target){
        Arrays.sort(candidates);
        List<List<Integer>> lst=new ArrayList();
        List<Integer> ans=new ArrayList();
        subset(candidates, target, 0, 0, lst, ans);
        return lst;
    }
    public static void subset(int[] candidates,int target,int idx,int sum,List<List<Integer>> lst,List<Integer> ans){
        if (sum == target) {
            lst.add(new ArrayList<>(ans));
            return;
        }
        if (sum > target) {
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]) continue;
            if(sum+candidates[i]>target) break;
            
            ans.add(candidates[i]);
            subset(candidates, target, i+1, sum+candidates[i], lst, ans);
            ans.remove(ans.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        System.out.println(comSum(candidates,target));
    }
}
