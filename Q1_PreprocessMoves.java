package March_21_Assignment;

import java.util.Scanner;

public class Q1_PreprocessMoves {
    public static int preprocessMoves(String A, String B) {
        int n = A.length();
        int moves = 0;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (A.charAt(i) == B.charAt(n - i - 1) || (A.charAt(i) != B.charAt(n - i - 1) && A.indexOf(B.charAt(i)) != -1 && B.indexOf(A.charAt(i)) != -1)) {
                    // Preprocess move needed to make A[i] == B[i]
                    moves++;
                } else {
                    // Preprocess move to change A[i] to any character
                    moves++;
                }
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String A = scanner.nextLine().trim();
            String B = scanner.nextLine().trim();
            int result = preprocessMoves(A, B);
            System.out.println(result);
        }


}
