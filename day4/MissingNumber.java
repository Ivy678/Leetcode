package day4;

// 268. Missing Number

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i< n; i++){
            if(nums[i]!= i){
                return i;
            }
        }
        return n;
    }
}