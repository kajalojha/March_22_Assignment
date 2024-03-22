package March_21_Assignment;

import java.util.*;

public class Q5_Find_Frequent_Elements {
    public static List<Integer> findFrequentElements(int[] arr, int K) {
        int N = arr.length;
        int threshold = N / K;

        // Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find elements with frequency >= N/K
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases

            // Read the size of the array and the value of K
            System.out.print("Enter the size of the array and the value of K: ");
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Read the array elements
            System.out.println("Enter the array elements:");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume newline

            // Find and print the frequent elements
            List<Integer> frequentElements = findFrequentElements(arr, K);
            System.out.println("Frequent elements: " + frequentElements);
        }


}
