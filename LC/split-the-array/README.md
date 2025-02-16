You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2 such that:

nums1.length == nums2.length == nums.length / 2.
nums1 should contain distinct elements.
nums2 should also contain distinct elements.
Return true if it is possible to split the array, and false otherwise.



Example 1:

Input: nums = [1,1,2,2,3,4]
Output: true
Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].
Example 2:

Input: nums = [1,1,1,1]
Output: false
Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do not contain distinct elements. Therefore, we return false.


Constraints:

1 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100

int[] data = new int[101]; creates an integer array named data with a size of 101. This array will be used to store the frequency of each number in the input array nums.
for (int i : nums) iterates over each element i in the input array nums.
data[i]++; increments the count of the current element i in the data array. This effectively tracks how many times each number appears in nums.
if (data[i] > 2) { return false; } checks if the count of any element in data becomes greater than 2. This condition ensures that no number appears more than twice in the input array. If this condition is violated, the method immediately returns false, indicating that splitting is not possible.
If the loop completes without encountering any violations in the if condition, it means that no number appears more than twice in nums. Therefore, the method returns true, signifying that splitting the array is possible.
Complexity
Time complexity: O(N)
Space complexity: O(N)