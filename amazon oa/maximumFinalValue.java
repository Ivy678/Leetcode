import java.util.Arrays;

class Solution {

    public static int maximumFinal(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Adjust the first element to be 1 (if necessary)
        arr[0] = 1;
        
        // Step 3: Iterate through the array, adjusting values to maintain the constraint
        for (int i = 1; i < arr.length; i++) {
            // If the current element is more than 1 unit bigger than the previous, adjust it
            if (arr[i] - arr[i-1] > 1) {
                arr[i] = arr[i-1] + 1;
            }
        }
        
        // Step 4: Return the last element
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4};
        int maxFinalValue = maximumFinal(arr);
        System.out.println(maxFinalValue); // Output: 4
    }
}
