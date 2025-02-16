package org.example;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public boolean isPossibleToSplit(int[] nums) {

        int[] data = new int[101];
        for (int i : nums) {
            data[i]++;
            if (data[i] > 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,1,1,1};
        System.out.println(solution.isPossibleToSplit(nums));
    }
}




