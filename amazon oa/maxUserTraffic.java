import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumUserTraffic(int[] login, int[] logout) {
        Map<Integer, Integer> dailyTraffic = new HashMap<>();
        
        // Process each user's login and logout
        for (int i = 0; i < login.length; i++) {
            for (int day = login[i]; day <= logout[i]; day++) {
                dailyTraffic.put(day, dailyTraffic.getOrDefault(day, 0) + 1);
            }
        }
        
        // Find the maximum traffic
        int maxTraffic = 0;
        for (int traffic : dailyTraffic.values()) {
            maxTraffic = Math.max(maxTraffic, traffic);
        }
        
        // Count the number of days with maximum traffic
        int maxTrafficDays = 0;
        for (int traffic : dailyTraffic.values()) {
            if (traffic == maxTraffic) {
                maxTrafficDays++;
            }
        }
        
        return maxTrafficDays;
    }

    public static void main(String[] args) {
        Solution analyzer = new Solution();
        int[] login = {1, 5, 5};
        int[] logout = {5, 10, 5};
        System.out.println(analyzer.maximumUserTraffic(login, logout));

        login = new int[]{1, 2, 3};
        logout = new int[]{10, 8, 4};
        System.out.println(analyzer.maximumUserTraffic(login, logout));

        login = new int[]{1, 3, 3};
        logout = new int[]{6, 6, 6};
        System.out.println(analyzer.maximumUserTraffic(login, logout));
    }
}
