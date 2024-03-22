package March_21_Assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3_Find_All_Occurance {
    public static List<Integer> findAllOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        // Construct the prefix array (lps) for the pattern
        int[] lps = new int[m];
        computeLPSArray(pattern, m, lps);

        int i = 0; // Index for text[]
        int j = 0; // Index for pattern[]

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                occurrences.add(i - j + 1);
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return occurrences;
    }

    // Construct the prefix array (lps) for the pattern
    private static void computeLPSArray(String pattern, int m, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the text and pattern from the user
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        // Find all occurrences of the pattern in the text
        List<Integer> occurrences = findAllOccurrences(text, pattern);

        // Print the indices of occurrences
        if (occurrences.isEmpty()) {
            System.out.println("Pattern not found in the text.");
        } else {
            System.out.println("Occurrences found at indices:");
            for (int index : occurrences) {
                System.out.print(index + " ");
            }
        }

        scanner.close();
    }
}
