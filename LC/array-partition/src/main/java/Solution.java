import java.util.Arrays;

/**
 * Сортировка массива и выбор минимальных значений из каждой пары последовательных чисел
 * (каждое второе число в отсортированном массиве) приводит к максимальной сумме минимальных значений пар.
 */
public class Solution {
    public int arrayPairSum(int[] nums) {
        // Sort the input array in ascending order
        Arrays.sort(nums);

        // Initialize a variable to store the sum of pairs
        int sum = 0;

        // Iterate over the sorted array with a step size of 2, starting from index 0
        for (int i = 0; i < nums.length; i += 2) {
            // Add the current element to the sum (this will be the smaller element of each pair)
            sum += nums[i];
        }

        // Return the maximum sum of pairs
        return sum;
    }
}
