package matrix;
import java.util.*;
public class PascalTriangle {

    static List<Integer> generateRow(int row) {
        int res = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);
        for (int col = 1; col < row; col++) {
            res = res * (row - col);
            res = res / col;
            ansRow.add(res);
        }
        return ansRow;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pt = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            pt.add(generateRow(row));
        }
        return pt;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> triangle = generate(numRows);
        // for (List<Integer> row : triangle) {
        //     System.out.print(row);
        // }
        System.out.println(triangle);
    }
}
