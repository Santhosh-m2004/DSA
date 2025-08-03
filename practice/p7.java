package practice;
import java.util.*;
// Print matrix in spiral
public class p7 {
    public static ArrayList<Integer> res(int[][] mat){
        ArrayList<Integer> lst=new ArrayList<>();
        int row=mat.length;
        int col=mat[0].length;
        int left=0;
        int right=col-1;;
        int top=0;
        int bottom=row-1;

        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                lst.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                lst.add(mat[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    lst.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    lst.add(mat[i][left]);
                }
                left++;
            }
        }

        return lst;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(res(matrix));
    }
}
