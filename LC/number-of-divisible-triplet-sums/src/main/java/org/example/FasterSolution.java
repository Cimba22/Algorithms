package org.example;

public class FasterSolution {
    public int divisibleTripletCount(int[] nums, int d) {

        int[] map = new int[d];
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len - 2; i++) {
            int t = (d - nums[i] % d) % d;
            map[t] += 1;
            int j = i + 1;
            for (int k = j + 1; k < len; k++) {
                res += map[(nums[k] + nums[j]) % d];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FasterSolution solution = new FasterSolution();
        int[] nums = {3,3,4,7,8};
        System.out.println(solution.divisibleTripletCount(nums, 5));
    }

}
