import java.util.HashMap;
import java.util.Map;

// 滑动窗口的精妙之处在于根据当前子序列和大小的情况，不断调节子序列的起始位置。

class Solution {
    // public int getMaxRacers(int[] speed, int k) {
    //     int maxSegmentLength = 0;
    //     int left = 0; // Start of the sliding window
    //     Map<Integer, Integer> speedCount = new HashMap<>(); // Frequency count of speeds in the current window
    //     int windowMaxFreq = 0; // Maximum frequency of a single speed in the current window

    //     for (int right = 0; right < speed.length; right++) {
    //         // Increment the count for the current speed
    //         speedCount.put(speed[right], speedCount.getOrDefault(speed[right], 0) + 1);
    //         // Update the max frequency in the current window
    //         windowMaxFreq = Math.max(windowMaxFreq, speedCount.get(speed[right]));

    //         // Check if we need to remove more than k racers to make all racers in the window have the same speed
    //         while ((right - left + 1) - windowMaxFreq > k) {
    //             // If so, move the left pointer to the right and update counts accordingly
    //             speedCount.put(speed[left], speedCount.get(speed[left]) - 1);
    //             if (speedCount.get(speed[left]) == 0) {
    //                 speedCount.remove(speed[left]); // Remove the speed entirely if its count drops to 0
    //             }
    //             left++; // Shrink the window from the left
    //         }

    //         // Update the max segment length if the current window is larger
    //         maxSegmentLength = Math.max(maxSegmentLength, right - left + 1);
    //     }

    //     return maxSegmentLength;
    // }

    public static int getMaxRacers(int[] speed, int k) {
        int l = 0;
        int len = 0;
        int n = speed.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < n; ++r){
            map.put(speed[r], map.getOrDefault(speed[r], 0) + 1);
            len = Math.max(len, map.get(speed[r]));
            if(r - l + 1 > len + k){
                int cur = map.get(speed[l]);
                //remove left side
                map.put(speed[l], cur - 1);
                ++l;
            }
        }
        return n - l - k;

    }

    public static void main(String[] args) {
        
        int[] speed = new int[]{1, 3, 4, 5, 6, 7, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int k = 2;
        System.out.println(getMaxRacers(speed, k));

        speed = new int[]{1, 4, 4, 2, 2, 4};
        k = 2;
        System.out.println(getMaxRacers(speed, k));
    }
    
 }