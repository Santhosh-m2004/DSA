package Array;
import java.util.*;
public class mergeIntervals {

    static int[][]  merge(int[][] intervals) {
        if(intervals.length<1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        List<int[]>  list=new ArrayList<>();
        int[] cur=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(cur[1]>=intervals[i][0]){
                cur[1]=Math.max(cur[1],intervals[i][1]);
            }else{
                list.add(cur);
                cur=intervals[i];
            }
        }
        list.add(cur);
        return list.toArray(new int[list.size()][]);

    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));

    }
}
