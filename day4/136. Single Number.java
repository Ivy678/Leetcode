package day4;

// XOR （exclusive or）按位异或运算（^）在二进制层面上进行操作，遵循这样的规则：对于每一位，如果两个比较位相同，则结果位为0；如果不同，则结果位为1。
//任何数和0进行异或运算结果仍然是原数。
// 任何数和自己进行异或运算结果是0。
// 异或运算满足交换律和结合律。
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i< nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}