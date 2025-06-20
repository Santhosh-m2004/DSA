package matrix_java;
import java.util.*;

public class SetMatrixZeroes {

    public static int[][] ansMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] r = new boolean[rows];
        boolean[] c = new boolean[cols];

        // Mark rows and columns that should be set to zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    r[i] = true;
                    c[j] = true;
                }
            }
        }

        // Set matrix elements to zero accordingly
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (r[i] || c[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static int[][] inputMatrix(String input) {
        // Remove unnecessary parts (e.g., "matrix = " and brackets)
        input = input.replaceAll("[^0-9,\\[\\]]", ""); // Keep only numbers, brackets, and commas
        input = input.replace("[[", "").replace("]]", ""); // Remove outer brackets

        String[] rows = input.split("\\],\\["); // Split rows correctly
        int rowCount = rows.length;
        int colCount = rows[0].split(",").length;
        
        int[][] mat = new int[rowCount][colCount];
        
        for (int i = 0; i < rowCount; i++) {
            String[] values = rows[i].split(",");
            for (int j = 0; j < colCount; j++) {
                mat[i][j] = Integer.parseInt(values[j].trim()); // Convert to integer
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input: ");
        String input = scanner.nextLine(); // Read the entire line
        
        int[][] matrix = inputMatrix(input); // Convert input string to 2D matrix
        ansMatrix(matrix); // Modify the matrix
        
        // Print the final matrix
        System.out.println("Output:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        
        scanner.close();
    }
}
