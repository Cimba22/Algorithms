import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {

        int sum = 0, sumAns = 0;

        for (int num : nums) {
            sum += num;
        }
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(nums[i]);
            sumAns += nums[i];
            if (sumAns > sum - sumAns) {
                return ans;
            }
        }
        return ans;
    }
}





























