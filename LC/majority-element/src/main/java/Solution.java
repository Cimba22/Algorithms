
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Первый проход: нахождение кандидата
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Возвращаем найденного кандидата (по условию задачи он всегда будет мажоритарным)
        return candidate;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {-1,1,1,1,2,1};
        System.out.println(solution.majorityElement(arr));
    }
}
