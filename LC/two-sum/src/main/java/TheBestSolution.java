public class TheBestSolution {
        public int[] twoSum(int[] nums, int target) {
            int next = 1;
            while(true) {
                for (int i = 0; i < nums.length - next; i++) {
                    if (nums[i] + nums[i + next] == target)
                        return new int[]{ i, next + i };
                }
                next++;
            }
        }
}
