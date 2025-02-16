import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {

        int result = 0;
        Arrays.sort(nums);
        int counter = 0;
        int[] temp = new int[nums.length];

        for (int i = 0; i <= nums.length - 1; i++){
            temp[i] = nums[i];

        }

        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,4,3,2,6,2,6,6,6,9};
        solution.majorityElement(arr);
    }
}
