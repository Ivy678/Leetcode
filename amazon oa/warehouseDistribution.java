class Solution {
    public static int minOperations(int[] boxes) {
        long totalBoxes = 0;
        for (int box : boxes) {
            totalBoxes += box;
        }
        
        int n = boxes.length;
        long averageBoxes = totalBoxes / n; // 平均每堆的箱子数
        long extraBoxes = totalBoxes % n; // 无法均匀分配的额外箱子数
        
        // 计算需要移动的箱子数
        long moves = 0;
        for (int box : boxes) {
            // 如果当前堆的箱子数少于平均数，则需要从其他堆移动箱子来填满
            if (box < averageBoxes) {
                moves += averageBoxes - box;
            } else if (box > averageBoxes && extraBoxes > 0) {
                // 如果当前堆的箱子数多于平均数，且还有额外的箱子需要分配
                // 则考虑将这些额外的箱子分配到其他堆
                long diff = box - averageBoxes;
                if (diff > 1) {
                    // 如果当前堆的箱子数比平均数多1以上，那么这部分箱子可以用来填补其他堆
                    moves += diff - 1;
                    extraBoxes--;
                }
            }
        }
        
        // 最终，操作次数应为总移动的箱子数除以2，因为每次移动实际上涉及到两个堆
        return (int) (moves / 2);
    }

    public static void main(String[] args) {
        int[] boxes1 = {5, 5, 8, 7};
        System.out.println(minOperations(boxes1)); // Output: 2

        int[] boxes2 = {2, 4, 1};
        System.out.println(minOperations(boxes2)); // Output: 1

        int[] boxes3 = {4, 4, 4, 4, 4};
        System.out.println(minOperations(boxes3)); // Output: 0
    }
}
