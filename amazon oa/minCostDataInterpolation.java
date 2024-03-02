
class NewClass {

    public static String getMinCostData(String data) {
        // Frequency array to keep track of each character's occurrence
        int[] freq = new int[26];
        char[] result = data.toCharArray();

        for (int i = 0; i < result.length; i++) {
            if (result[i] == '?') {
                // Find the lexicographically smallest character that can be placed
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (freq[ch - 'a'] == 0) { // This character has not occurred before
                        result[i] = ch;
                        freq[ch - 'a']++; // Update the frequency
                        break; // Break as we found the smallest character
                    }
                }
            } else {
                // Update frequency for non-'?' characters
                freq[result[i] - 'a']++;
            }
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String data1 = "aaaa?aaaa";
        System.out.println(getMinCostData(data1)); // Expected output: "aaaaabaaaa"

        String data2 = "??????";
        System.out.println(getMinCostData(data2)); // Expected output: "abcdef"

        String data3 = "abcd?";
        System.out.println(getMinCostData(data3)); // Expected output: "abcde"
    }
}
