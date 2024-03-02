// class Solution {
//     public int getLongestMatch(String text, String regex) {
//         // Split the regex into two parts: before and after the wildcard character '*'
//         String[] parts = regex.split("\\*", -1);
//         String start = parts[0];
//         String end = parts[1];
        
//         int maxLength = -1; // Initialize the maximum length as -1
        
//         // Iterate through the text to find matching substrings
//         for (int i = 0; i < text.length(); i++) {
//             for (int j = i + 1; j <= text.length(); j++) {
//                 String substring = text.substring(i, j);
//                 // Check if the current substring starts with the start part of the regex
//                 // and ends with the end part of the regex
//                 if (substring.startsWith(start) && substring.endsWith(end)) {
//                     // Calculate the length of the current matching substring
//                     int currentLength = j - i;
//                     // Update the maximum length if the current length is greater
//                     if (currentLength > maxLength) {
//                         maxLength = currentLength;
//                     }
//                 }
//             }
//         }
        
//         return maxLength;
//     }

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         // Test the function with the example given
//         int result = solution.getLongestMatch("hackerrank", "ack*r");
//         System.out.println(result); // Output: 6
//     }
// }


// 

class Solution {
    public static void main(String[] args) {
        String text = "hackerrank";
        String regex = "ack*r";
        System.out.println(getLongestMatch(text, regex));
    }

    public static int getLongestMatch(String text, String regex) {
        // Split the regex into prefix and suffix by the wildcard
        int asteriskIndex = regex.indexOf('*');
        String prefix = regex.substring(0, asteriskIndex);
        String suffix = regex.substring(asteriskIndex + 1);

        int maxMatchLength = -1;

        // Search for prefix and suffix in the text
        for (int start = 0; start <= text.length() - prefix.length(); start++) {
            // Match prefix
            if (text.startsWith(prefix, start)) {
                for (int end = text.length(); end >= start + prefix.length() + suffix.length(); end--) {
                    // Match suffix
                    if (text.startsWith(suffix, end - suffix.length())) {
                        int currentMatchLength = end - start;
                        maxMatchLength = Math.max(maxMatchLength, currentMatchLength);
                        // No need to check shorter suffixes since we are looking for the longest match
                        break;
                    }
                }
            }
        }

        return maxMatchLength;
    }
}
