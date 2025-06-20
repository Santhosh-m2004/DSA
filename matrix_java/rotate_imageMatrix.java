package matrix_java;

public class rotate_imageMatrix {

    public static void rotate(int [][] mat,int m){
        //transpose the matrix
        for(int i=0;i<m;i++){
            for(int j=i;j<m;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        //reverse the matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<m/2;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[i][m-j-1];
                mat[i][m-j-1]=temp;
            }
        }
        /*for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        } */


        //print the matrix
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        int m=mat.length;
        rotate(mat,m);

    }
}
