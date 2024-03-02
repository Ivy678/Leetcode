import java.util.*;

class Solution {
    public int minimizeTheRange(int n, int m, int[] A, int[] B) {
        // Array to store the differences and original indexes
        int[][] differences = new int[n][2];
        for (int i = 0; i < n; i++) {
            differences[i][0] = A[i] - B[i]; // Calculate the difference
            differences[i][1] = i;           // Store the original index
        }
        
        // Sort the differences array based on the absolute difference
        Arrays.sort(differences, (a, b) -> Math.abs(b[0]) - Math.abs(a[0]));

        // Flip the cards with the highest positive difference
        for (int i = 0; i < m; i++) {
            int index = differences[i][1];
            // If flipping reduces the number, perform the flip
            if (differences[i][0] > 0) {
                A[index] = B[index];
            }
        }

        // Find the new minimum and maximum after possible flips
        int min = Arrays.stream(A).min().getAsInt();
        int max = Arrays.stream(A).max().getAsInt();
        
        // Return the minimum possible range
        return max - min;
    }
    

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int m = 2;
        int[] A = new int[]{1, 2, 17, 16, 9};
        int[] B = new int[]{3, 4, 5, 6, 11};
        System.out.println(s.minimizeTheRange(n, m, A, B));


        n = 5;
        m = 3;
        A = new int[]{5, 3, 12, 10, 9};
        B = new int[]{3, 4, 5, 6, 11};
        System.out.println(s.minimizeTheRange(n, m, A, B));
    }
}
