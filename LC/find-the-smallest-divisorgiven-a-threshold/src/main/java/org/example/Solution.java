package org.example;

public class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int max = 0;

        for(int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        while (l <= max) {
            int mid = l + (max - l) / 2;
            long sum = 0;

            for (int n : nums) {
                sum += (n + mid - 1) / mid;
                if (sum > threshold) {
                    break;
                }
            }

            if (sum <= threshold) {
                max = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
//TODO README.md to this problem