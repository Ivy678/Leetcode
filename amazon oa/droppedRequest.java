import java.util.List;

class Solution {
    public static int droppedRequests(List<Integer> requestTime) {
        int dropped = 0;
        int[] counts = new int[requestTime.get(requestTime.size() - 1) + 1];

        // Count the requests per second
        for (int time : requestTime) {
            counts[time]++;
        }

        int totalRequests = 0;
        for (int i = 1; i < counts.length; i++) {
            totalRequests += counts[i]; // Total requests until current second
            int perSecond = counts[i];
            int perTenSeconds = Math.min(i, 10) == 10 ? totalRequests - (i >= 11 ? totalRequests - counts[i-10] : 0) : totalRequests;
            int perMinute = Math.min(i, 60) == 60 ? totalRequests - (i >= 61 ? totalRequests - counts[i-60] : 0) : totalRequests;

            if (perSecond > 3) {
                dropped += perSecond - 3;
                counts[i] = 3; // Adjust current second count to max allowed after dropping
            }

            if (perTenSeconds > 20) {
                int toDrop = perTenSeconds - 20;
                for (int j = i; j > i - 10 && toDrop > 0; j--) {
                    int drop = Math.min(toDrop, counts[j]);
                    counts[j] -= drop;
                    toDrop -= drop;
                    dropped += drop;
                }
            }

            if (perMinute > 60) {
                int toDrop = perMinute - 60;
                for (int j = i; j > i - 60 && toDrop > 0; j--) {
                    int drop = Math.min(toDrop, counts[j]);
                    counts[j] -= drop;
                    toDrop -= drop;
                    dropped += drop;
                }
            }
        }

        return dropped;
    }

    public static void main(String[] args) {
        // Example test cases
        System.out.println(droppedRequests(List.of(1, 1, 1, 1, 2))); // Output: 1
        System.out.println(droppedRequests(List.of(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 7, 7))); // Output: 2
        System.out.println(droppedRequests(List.of(1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11))); // Output: 7
    }
}
