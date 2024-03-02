import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] sortProductCodes(String order, String[] productCodes) {
        // Step 1: Map each character to its index in the order string
        int[] orderMap = new int[26]; // Assuming only lowercase English letters
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            orderMap[c - 'a'] = i;
        }

        // Step 2: Sort the productCodes array with a custom comparator
        Arrays.sort(productCodes, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int minLength = Math.min(s1.length(), s2.length());
                for (int i = 0; i < minLength; i++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    if (c1 != c2) {
                        // Compare based on the new precedence
                        return Integer.compare(orderMap[c1 - 'a'], orderMap[c2 - 'a']);
                    }
                }
                // If all compared characters are equal, the shorter string is considered less
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Step 3: Return the sorted array
        return productCodes;
    }

    public static void main(String[] args) {
        Solution sorter = new Solution();
        String order = "abcdefghijklmnopqrstuvwxyz";
        String[] productCodes = {"adc", "abc"};
        String[] sortedProductCodes = sorter.sortProductCodes(order, productCodes);

        for (String code : sortedProductCodes) {
            System.out.println(code);
        }
    }
}
