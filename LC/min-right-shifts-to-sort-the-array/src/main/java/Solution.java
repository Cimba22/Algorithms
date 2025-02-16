import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Берем точку опоры за индекс минимального числа.
 */

public class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        List<Integer> sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);

        // Check if nums is already sorted
        if (nums.equals(sortedNums)) {
            return 0;
        }

        // Find the index of the smallest element
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(minIndex)) {
                minIndex = i;
            }
        }

        // Check if rotating from minIndex gives a sorted array
        for (int i = 0; i < n; i++) {
            if (!nums.get((minIndex + i) % n).equals(sortedNums.get(i))) {
                return -1;
            }
        }

        return n - minIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> nums1 = List.of(3, 4, 5, 1, 2);
        System.out.println(solution.minimumRightShifts(nums1)); // Output: 2

//        List<Integer> nums2 = List.of(2, 1, 4);
//        System.out.println(solution.minimumRightShifts(nums2)); // Output: -1
    }
}
