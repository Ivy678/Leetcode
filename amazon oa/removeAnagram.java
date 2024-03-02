import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static List<String> removeAnagram(String[] textList) {
        // This set will store the normalized versions of the strings we have seen
        Set<String> seen = new HashSet<>();
        // This list will store the final list of unique (non-anagram) product IDs
        List<String> uniqueProducts = new ArrayList<>();
        
        for (String productId : textList) {
            // Normalize the current string by sorting its characters
            char[] chars = productId.toCharArray();
            Arrays.sort(chars);
            String normalized = new String(chars);
            
            // If we haven't seen this normalized version before, add the original string
            // to our result list and mark this normalized version as seen
            if (!seen.contains(normalized)) {
                uniqueProducts.add(productId);
                seen.add(normalized);
            }
        }
        
        // Sort the result list before returning
        uniqueProducts.sort(String::compareTo);
        return uniqueProducts;
    }
    
    public static void main(String[] args) {
        String[] textList = {"code", "doce", "ecod", "framer", "frame"};
        List<String> result = removeAnagram(textList);
        System.out.println(result);
    }
}
