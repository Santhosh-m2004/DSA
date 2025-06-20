import java.util.*;

public class remove1stDuplicates {

    public static List<Integer> res(int[] nums){
        int[] fq=new int[500];
        List<Integer> lst=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            if(fq[nums[i]]==0){
                lst.add(nums[i]);
                fq[nums[i]]++;
            }
        }
        Collections.reverse(lst);
        return lst;
    }
    public static void main(String[] args) {
        // int[] nums={1,2,3,1,2,4};
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        input=input.replaceAll("[\\[\\]]", "").trim();
        String[] strInput=input.split(",");
        int[] nums=new int[strInput.length];
        for(int i=0;i<strInput.length;i++){
            nums[i]=Integer.parseInt(strInput[i]);
        }
        sc.close();
        System.out.println(res(nums));
    }
}
