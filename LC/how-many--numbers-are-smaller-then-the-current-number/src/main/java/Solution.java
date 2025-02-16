import java.util.Arrays;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int num : nums) {
                if (nums[i] > num) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
