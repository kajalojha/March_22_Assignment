package March_21_Assignment;
import java.util.Arrays;
import java.util.Scanner;

public class Q2_Min_Arrows {
    public static int minArrows(int[] balloons) {
        if (balloons.length == 0) return 0;

        Arrays.sort(balloons);
        int arrows = 1;
        int prevHeight = balloons[0];

        for (int i = 1; i < balloons.length; i++) {
            if (balloons[i] > prevHeight) {
                // Balloon is not destroyed by the previous arrow, shoot a new arrow
                arrows++;
                prevHeight = balloons[i];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of balloons
        System.out.print("Enter the number of balloons: ");
        int N = scanner.nextInt();

        // Read the heights of the balloons
        int[] balloons = new int[N];
        System.out.print("Enter the heights of the balloons: ");
        for (int i = 0; i < N; i++) {
            balloons[i] = scanner.nextInt();
        }

        // Calculate and print the minimum arrows required
        int minArrowsRequired = minArrows(balloons);
        System.out.println("Minimum arrows required: " + minArrowsRequired);

        scanner.close();
    }
}
