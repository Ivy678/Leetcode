import java.util.*;

class Solution {
    public long countDistinctPasswords(String password) {
        // A set to keep all the distinct passwords
        Set<String> distinctPasswords = new HashSet<>();
        
        // Add the original password to the set
        distinctPasswords.add(password);
        
        // Iterate through all possible substrings
        for (int i = 0; i < password.length(); i++) {
            for (int j = i + 1; j <= password.length(); j++) {
                StringBuilder newPassword = new StringBuilder(password);
                // Reverse the substring and form a new password
                String reversedSubstring = new StringBuilder(password.substring(i, j)).reverse().toString();
                newPassword.replace(i, j, reversedSubstring);
                
                // Add the newly formed password to the set
                distinctPasswords.add(newPassword.toString());
            }
        }
        
        return distinctPasswords.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String password = "abc";
        System.out.println(s.countDistinctPasswords(password));

        password = "abaa";
        System.out.println(s.countDistinctPasswords(password));

        password = "abab";
        System.out.println(s.countDistinctPasswords(password));
    }
    
    
}
