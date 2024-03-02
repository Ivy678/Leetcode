import java.util.Arrays;

class Solution {

    public static int groupStudents(int[] levels, int maxSpread) {
        // Sort the skill levels array
        Arrays.sort(levels);
        
        // Initialize the count of classes with 1 as the first student starts the first class
        int classes = 1;
        // The first student in the current class
        int firstInClass = levels[0];
        
        // Iterate through the sorted levels array starting from the second student
        for (int i = 1; i < levels.length; i++) {
            // If the current student's skill level is within maxSpread of the firstInClass, they can be in the same class
            if (levels[i] - firstInClass <= maxSpread) {
                continue;
            }
            // Else, start a new class with the current student
            else {
                classes++;
                firstInClass = levels[i];
            }
        }
        
        return classes;
    }

    public static void main(String[] args) {
        int[] levels = {1, 4, 7, 3, 4};
        int maxSpread = 2;
        System.out.println(groupStudents(levels, maxSpread)); // Output: 3
    }
}
