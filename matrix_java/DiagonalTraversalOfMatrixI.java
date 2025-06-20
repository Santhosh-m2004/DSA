/*Given a 2D matrix, print all elements of the given matrix in diagonal order. For example, consider the following 5 X 4 input matrix.  

Example:
1     2     3     4
5     6     7     8
9     10    11    12
13    14    15    16
17    18    19    20

Diagonal printing of the above matrix is
1
5 2
9 6 3
13 10 7 4
17 14 11 8
18 15 12
19 16
20
*/


package matrix_java;

public class DiagonalTraversalOfMatrixI {
    public static void main(String[] args) {
        int[][] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};

        int m=mat.length;
        int n=mat[0].length;

        for(int k=0;k<m-1;k++){
            int i=k;
            int j=0;
            while(i>=0){
                System.out.println(mat[i][j]);
                i=i-1;
                j=j+1;
            }
        }

        for(int k=1;k<=n-1;k++){
            int i=m-1;
            int j=k;
            while(j<=n-1){
                System.out.println(mat[i][j]);
                i=i-1;
                j=j+1;
            }
        }


    }
}
