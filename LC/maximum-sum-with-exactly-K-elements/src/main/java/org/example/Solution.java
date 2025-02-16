package org.example;

class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        long startTime = System.currentTimeMillis();
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime);

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += max++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(solution.maximizeSum(nums, 3));
    }
}