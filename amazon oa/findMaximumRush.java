import java.util.*;

import java.util.TreeMap;

class Solution {
    public int findMaximumRush(int[] login, int[] logout) {
        TreeMap<Integer, Integer> timeline = new TreeMap<>();
        
        // 构建时间线，记录每个时间点登录(+1)和登出(-1)的变化
        for (int i = 0; i < login.length; i++) {
            timeline.put(login[i], timeline.getOrDefault(login[i], 0) + 1);
            timeline.put(logout[i], timeline.getOrDefault(logout[i], 0) - 1);
        }
        
        int currentUsers = 0; // 当前登录用户数
        int maxRush = 0; // 最大并发登录用户数
        int currentDay = 0; // 当前处理的天
        int daysOfMaxRush = 0; // 达到最大并发登录用户数的总天数
        
        // 遍历时间线来计算每个时间点的并发登录用户数
        for (Map.Entry<Integer, Integer> entry : timeline.entrySet()) {
            if (currentDay != entry.getKey()) {
                if (currentUsers == maxRush) {
                    // 如果前一天的用户数等于最大并发登录用户数，增加总天数
                    daysOfMaxRush += entry.getKey() - currentDay;
                }
                currentDay = entry.getKey();
            }
            
            currentUsers += entry.getValue();
            if (currentUsers > maxRush) {
                maxRush = currentUsers; // 更新最大并发登录用户数
                daysOfMaxRush = 1; // 重置达到最大并发登录用户数的总天数
            } else if (currentUsers == maxRush && entry.getValue() > 0) {
                // 如果当前用户数增加到最大并发登录用户数，开始一个新的总天数计数
                daysOfMaxRush = 1;
            }
        }
        
        return daysOfMaxRush;
    }
        

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] login = new int[]{1, 3, 3};
        int[] logout = new int[]{6, 6, 6};
        System.out.println(s.findMaximumRush(login, logout));

        login = new int[]{1, 3, 3};
        logout = new int[]{6, 6, 6};
        System.out.println(s.findMaximumRush(login, logout));

        login = new int[]{1, 1, 1};
        logout = new int[]{1, 1, 1};
        System.out.println(s.findMaximumRush(login, logout));
    }
}


