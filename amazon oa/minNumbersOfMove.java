class Solution {
    public int getMinNumMoves(int[] blocks) {
        int minIndex = 0;
        int maxIndex = 0;

        // Find the indices of the lightest and heaviest blocks
        for (int i = 1; i < blocks.length; i++) {
            if (blocks[i] < blocks[minIndex]) {
                minIndex = i;
            }
            if (blocks[i] > blocks[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // Calculate moves for the lightest block to the front
        int movesForMin = minIndex; // Directly equals the index due to 0-based indexing
        
        // Calculate moves for the heaviest block to the end
        int movesForMax = blocks.length - maxIndex; // Moves to bring the heaviest to the end
        
        // If the heaviest block is before the lightest block in the array, we don't need to adjust its moves
        // However, if the heaviest block comes after the lightest block, we need to consider that moving the lightest block
        // to the front effectively moves the heaviest block one position closer to its correct position
        if (maxIndex > minIndex) {
            movesForMax = movesForMax - 1; // Adjust because moving min forward makes max one step closer
        }
        
        // Total moves is the sum of moves required for min and max
        int totalMoves = movesForMin + movesForMax;
        
        return totalMoves;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] blocks = new int[]{2, 4, 3, 1, 6};
        System.out.println(s.getMinNumMoves(blocks));

        blocks = new int[]{4, 11, 9, 10, 12};
        System.out.println(s.getMinNumMoves(blocks));

        blocks = new int[]{4, 12, 10, 9, 11};
        System.out.println(s.getMinNumMoves(blocks));


    }
    
}
