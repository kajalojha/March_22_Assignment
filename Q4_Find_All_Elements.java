package March_21_Assignment;

import java.util.*;

public class Q4_Find_All_Elements {
    public static List<Integer> findCommonElements(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Use a set to store elements present in each row
        Set<Integer> commonElements = new HashSet<>();
        for (int j = 0; j < cols; j++) {
            commonElements.add(matrix[0][j]);
        }

        // Iterate over the remaining rows and find common elements
        for (int i = 1; i < rows; i++) {
            Set<Integer> currentRowElements = new HashSet<>();
            for (int j = 0; j < cols; j++) {
                currentRowElements.add(matrix[i][j]);
            }
            commonElements.retainAll(currentRowElements); // Keep only common elements
        }

        return new ArrayList<>(commonElements);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the number of rows and columns: ");
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Read the matrix elements
            int[][] matrix = new int[N][M];
            System.out.println("Enter the matrix elements:");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
                scanner.nextLine(); // Consume newline
            }

            // Find common elements in each row and print the result
            List<Integer> commonElements = findCommonElements(matrix);
            System.out.println("Common elements in each row: " + commonElements);
        }


}
