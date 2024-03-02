// import java.util.*;

import java.util.TreeMap;

class Solution {
    public int findMaximumRush(int[] login, int[] logout) {
        // 使用TreeMap来记录每个时间点的用户变化
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        // 对于每个登录和登出时间，记录时间线上的变化
        for (int i = 0; i < login.length; i++) {
            map.put(login[i], map.getOrDefault(login[i], 0) + 1);
            map.put(logout[i] + 1, map.getOrDefault(logout[i] + 1, 0) - 1);
        }
        
        int currentCount = 0, maxCount = 0;
        int previousKey = -1;
        int daysOfMaxRush = 0;
        
        for (var entry : map.entrySet()) {
            if (currentCount == maxCount) {
                // 累加持续的最大并发日数
                daysOfMaxRush += previousKey > 0 ? entry.getKey() - previousKey : 0;
            }
            
            currentCount += entry.getValue();
            if (currentCount > maxCount) {
                // 找到新的最大并发数，重置天数计数
                maxCount = currentCount;
                daysOfMaxRush = 0;
            }
            
            previousKey = entry.getKey();
        }
        
        // 处理最后一个最大并发段
        if (currentCount == maxCount) {
            daysOfMaxRush += previousKey > 0 ? map.lastKey() + 1 - previousKey : 0;
        }
        
        return daysOfMaxRush;
    }
        

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] login = new int[]{1, 5, 5};
        int[] logout = new int[]{5, 10, 5};
        System.out.println(s.findMaximumRush(login, logout));

        login = new int[]{1, 3, 3};
        logout = new int[]{6, 6, 6};
        System.out.println(s.findMaximumRush(login, logout));

        login = new int[]{1, 1, 1};
        logout = new int[]{1, 1, 1};
        System.out.println(s.findMaximumRush(login, logout));
    }
}


