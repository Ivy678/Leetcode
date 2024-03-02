class Solution {
    public int makePowerNonDecreasing(int[] arr) {
        int n = arr.length;
        //这里使用了long类型来保存总增加量，以防止在处理大数据时发生整数溢出。
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                ans += arr[i - 1] - arr[i];
                // 更新当前服务器的能力，使其等于前一个服务器的能力
                arr[i] = arr[i - 1];
            }
        }
        // 如果总增加量超过了int的最大值，需要进行处理，这里直接返回ans
        // 但实际情况下可能需要根据问题的具体要求来处理这种情况
        return (int) Math.min(ans, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3, 4, 1, 6, 2};
        System.out.println(s.makePowerNonDecreasing(arr));
    }
    
}
