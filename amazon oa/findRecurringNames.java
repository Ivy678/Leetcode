import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findRecurringNames(String[] realNames, String[] allNames) {
        // 步骤1: 创建映射，将每个realName的排序后的字符串映射到原始字符串
        Map<String, String> nameMap = new HashMap<>();
        for (String name : realNames) {
            char[] chars = name.toCharArray();
            Arrays.sort(chars); // 对字符数组进行排序
            nameMap.put(new String(chars), name); // 存储排序后的字符串与原始字符串的映射
        }
        
        // 步骤2: 计数
        Map<String, Integer> countMap = new HashMap<>();
        for (String name : allNames) {
            char[] chars = name.toCharArray();
            Arrays.sort(chars);
            String sortedName = new String(chars);
            countMap.put(sortedName, countMap.getOrDefault(sortedName, 0) + 1);
        }
        
        // 步骤3: 筛选重复的名字
        List<String> recurringNames = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) { // 如果同一个排序后的名字出现超过一次
                recurringNames.add(nameMap.get(entry.getKey())); // 添加原始名字到结果列表中
            }
        }
        
        // 没有重复名字时返回["None"]
        if (recurringNames.isEmpty()) {
            return new String[]{"None"};
        }
        
        // 步骤4: 结果排序
        recurringNames.sort(String::compareTo); // 按字典序排序
        
        // 返回重复名字的数组
        return recurringNames.toArray(new String[0]);
    }

    public static void main (String[] args) {
        Solution s = new Solution();
        String[] realNames = new String[]{"paul", "paul", "john"};
        String[] allNames = new String[]{"john", "john", "paul", "paul", "george"};
        String[] result = s.findRecurringNames(realNames, allNames);
        //使用Arrays.toString()方法，这样可以得到数组内元素的字符串表示
        System.out.println(Arrays.toString(result));

        realNames = new String[]{"rohn", "henry", "daisy"};
        allNames = new String[]{"ryhen", "aisyd", "henry"};
        result = s.findRecurringNames(realNames, allNames);
        System.out.println(Arrays.toString(result));

        realNames = new String[]{"tom", "jerry"};
        allNames = new String[]{"reyjr", "mot", "tom", "jerry", "mto"};
        result = s.findRecurringNames(realNames, allNames);
        System.out.println(Arrays.toString(result));
    }
}
