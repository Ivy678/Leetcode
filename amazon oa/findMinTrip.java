// import java.util.HashMap;
// import java.util.Map;


// public class findMinTrip {
//     public int findMinTrips(int[] packageweight) {
//         Map<Integer, Integer> weightCounts = new HashMap<>();
//         // Count occurrences of each weight
//         // 对于packageweight中的每个元素，将其值依次赋给变量weight，然后执行循环体内的代码。
//         for (int weight : packageweight) {
//             weightCounts.put(weight, weightCounts.getOrDefault(weight, 0) + 1);
//         }

//         int trips = 0;
//         for (int count : weightCounts.values()) {
//             int groupsOfThree = count / 3; // Maximum groups of three
//             int remainder = count % 3;
    
//             trips += groupsOfThree;
//             if (remainder > 0) {
//                 trips += 1; // One more trip for the remainder (either 1 or 2)
//             }
//         }
    
//         return trips;
    
//     }

//     public static void main(String[] args){
//         int[] packageweight = new int[]{2, 4, 6, 6, 4, 2, 4};
//         findMinTrip s = new findMinTrip();
//         System.out.println(s.findMinTrips(packageweight));
//     }
    
// }

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMinTrips(int[] packageweight) {
        Map<Integer, Integer> weightCounts = new HashMap<>();
        for (int weight : packageweight) {
            weightCounts.put(weight, weightCounts.getOrDefault(weight, 0) + 1);
        }
        
        int trips = 0;
        for (Map.Entry<Integer, Integer> entry : weightCounts.entrySet()) {
            int count = entry.getValue();
            if (count % 3 == 0) {
                trips += count / 3;
            } else if (count % 3 == 1) {
                if (count == 1) return -1; // Cannot deliver just one package
                if (count < 4 && count > 1) return -1; // Not enough to form a valid group
                trips += (count - 4) / 3 + 2; // Handle the case with one set of two and the rest in sets of three
            } else { // count % 3 == 2
                trips += (count - 2) / 3 + 1; // One set of two and the rest in sets of three
            }
        }
        
        return trips;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.findMinTrips(new int[]{1, 8, 5, 8, 5, 1, 1})); // 3
        System.out.println(solution.findMinTrips(new int[]{3, 4, 4, 3, 1})); // -1
        System.out.println(solution.findMinTrips(new int[]{2, 4, 6, 6, 4, 2, 4})); // 3
    }
}
