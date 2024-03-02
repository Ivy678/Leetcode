// 

import java.util.Arrays;

class Solution {

    // Function to find the number of computationally same process pairs using sorting and two pointers
    public static long getPairsCount(int[] process, int k) {
        // Sort the process array
        Arrays.sort(process);
        
        long count = 0; // Initialize count of pairs
        int left = 0; // Initialize left pointer
        int right = 1; // Initialize right pointer
        
        // Iterate over the array with two pointers
        while (right < process.length) {
            // If the difference between right and left pointers is within k, move right pointer
            if (process[right] - process[left] <= k) {
                // Add the number of new pairs formed
                count += right - left;
                right++;
            } else {
                // Move left pointer if the difference is greater than k
                left++;
                // Adjust right pointer if it overlaps left
                if (left == right) {
                    right++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        // Example 1
        int[] process1 = {100, 200, 300, 400};
        int k1 = 250;
        System.out.println("Example 1 Output: " + getPairsCount(process1, k1));

        // Example 2
        int[] process2 = {10, 12, 11};
        int k2 = 0;
        System.out.println("Example 2 Output: " + getPairsCount(process2, k2));

        // Example 3
        int[] process3 = {7, 10, 13, 11};
        int k3 = 3;
        System.out.println("Example 3 Output: " + getPairsCount(process3, k3));
    }
}
