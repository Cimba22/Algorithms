package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        long startTime = System.currentTimeMillis();
        int[] data = new int[nums.length];
        for (int i : nums) {
            data[i]++;
        }
        int[] result = new int[2];
        int a = 0;

        for (int index = 0; index < nums.length; index++) {
            if (data[index] == 2) {
                result[a++] = index;
            }else continue;
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{7,1,5,4,3,4,6,0,9,5,8,2};
        System.out.println(Arrays.toString(solution.getSneakyNumbers(nums)));
    }
}