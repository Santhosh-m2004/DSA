package matrix_java;
import java.util.*;
public class spiralMatrix {

    public static List<Integer> ans(int[][] mat,int m,int n) {
        List<Integer> list=new ArrayList<>();
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;

        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                list.add(mat[top][i]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                list.add(mat[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    list.add(mat[bottom][i]);
                }
            }
            bottom--;

            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    list.add(mat[i][left]);
                }
            }
            left++;
        }

        return list;
    }
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        int m=mat.length;
        int n=mat[0].length;
        List<Integer> res=ans(mat,m,n);
        for(int i=0;i<res.size();i++){
            if(i==res.size()-1){
                System.out.print(res.get(i));
            }
            else{
                System.out.print(res.get(i)+"->");
            }
        }
        
    }
}
