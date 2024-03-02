import java.util.PriorityQueue;

class Solution {

    public static long getMaxRewardPoints(int[] reward) {
        long maxRewardPoints = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int points : reward) {
            maxHeap.add(points);
        }
        
        while (!maxHeap.isEmpty()) {
            int current = maxHeap.poll();
            if (current > 0) {
                maxRewardPoints += current;
                // Add back all items with decreased points, if they are greater than 0
                PriorityQueue<Integer> temp = new PriorityQueue<>((a, b) -> b - a);
                while (!maxHeap.isEmpty()) {
                    int next = maxHeap.poll() - 1;
                    if (next > 0) {
                        temp.add(next);
                    }
                }
                maxHeap = temp;
            }
        }
        
        return maxRewardPoints;
    }

    public static void main(String[] args) {
        int[] reward1 = {5, 2, 2, 3, 1};
        System.out.println(getMaxRewardPoints(reward1));  // Output: 7

        int[] reward2 = {5, 5, 5};
        System.out.println(getMaxRewardPoints(reward2));  // Output: 12
    }
}
