import java.util.HashMap;
import java.util.Map;


public class findMinTrip {
    public int findMinTrips(int[] packageweight) {
        Map<Integer, Integer> weightCounts = new HashMap<>();
        // Count occurrences of each weight
        // 对于packageweight中的每个元素，将其值依次赋给变量weight，然后执行循环体内的代码。
        for (int weight : packageweight) {
            weightCounts.put(weight, weightCounts.getOrDefault(weight, 0) + 1);
        }

        int trips = 0;
        for (int count : weightCounts.values()) {
            int groupsOfThree = count / 3; // Maximum groups of three
            int remainder = count % 3;
    
            trips += groupsOfThree;
            if (remainder > 0) {
                trips += 1; // One more trip for the remainder (either 1 or 2)
            }
        }
    
        return trips;
    
    }

    public static void main(String[] args){
        int[] packageweight = new int[]{2, 4, 6, 6, 4, 2, 4};
        findMinTrip s = new findMinTrip();
        System.out.println(s.findMinTrips(packageweight));
    }
    
}

