// 提供的图像中描述的操作顺序显示了将字符串重新排列为反向的过程，意味着以相反的顺序写入字符，
// 是通过执行一系列移位，将字符从任何位置移动到字符串的末尾。
// 例如， 0100110 从后往前是 0110010
// 操作是从字符串中移除任何字符并将其追加到字符串的末尾。

class Solution {
    public int findMinimumOperations(String image) {
        // The length of the string image
        int n = image.length();
        int operations = 0;

        // Reverse the image string
        String reverseImage = new StringBuilder(image).reverse().toString();

        // Find the longest matching prefix and suffix
        for (int i = 0; i < n; i++) {
            if (image.substring(i).equals(reverseImage.substring(0, n-i))) {
                operations = i;
                break; // The number of operations needed is the length of the unmatched prefix
            }
        }
        return operations; // If no matching part is found, n operations are needed
    }

    public static void main(String[] args){
        Solution s = new Solution();
        String image = "abab";
        System.out.println(s.findMinimumOperations(image));

        image = "0100110";
        System.out.println(s.findMinimumOperations(image));

        image = "110010101011";
        System.out.println(s.findMinimumOperations(image));

        image = "010";
        System.out.println(s.findMinimumOperations(image));
    }
    
}
