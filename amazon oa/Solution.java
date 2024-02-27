import java.util.*;

public class Solution {
    public int findMaximumRush(int[] login, int[] logout) {
        List<int[]> events = new ArrayList<>();
        // 步骤1：合并和标记事件
        for (int i = 0; i < login.length; i++) {
            events.add(new int[]{login[i], 1}); // 登录事件，标记为1
            events.add(new int[]{logout[i] + 1, -1}); // 登出事件的次日，标记为-1

            //“登出事件的次日”，这是因为在处理登出时间时，我们通常认为用户在登出当天仍然是在线的。
            //为了准确计算在线天数，我们可以在用户登出的次日标记一个事件，表示从这一天开始，用户不再在线。这样做是为了确保用户登出当天仍被计算为在线状态。
        }
        // 步骤2：排序事件
        Collections.sort(events, (a, b) -> a[0] - b[0]);
        
        int maxRush = 0, currentCount = 0, daysOfMaxRush = 0;
        for (int i = 0; i < events.size(); ) {
            int day = events.get(i)[0];
            while (i < events.size() && events.get(i)[0] == day) {
                currentCount += events.get(i)[1];
                i++;
            }
            // 步骤3 & 4：遍历事件，计算在线用户数并找出最大高峰
            if (currentCount > maxRush) {
                maxRush = currentCount;
                daysOfMaxRush = 1;
            } else if (currentCount == maxRush) {
                daysOfMaxRush++;
            }
        }
        // 步骤5：返回结果
        return daysOfMaxRush;
    }
}
