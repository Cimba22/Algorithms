package arraySort;

import java.util.Arrays;

/**
 * Поразрядная сортировка — это линейный алгоритм сортировки,
 * который сортирует элементы, обрабатывая их поразрядно.
 * Это эффективный алгоритм сортировки целых чисел или строк с ключами фиксированного размера.
 * Его вычислительная сложность O(k * n), где k количество проходов по массиву.
 * Если n достаточно велико, а k наоборот очень мало, то данный алгоритм выигрывает у O(n * Log n).
 */

public class Radix {

        // A utility function to get maximum value in array[]
        static int getMax(int[] array, int n)
        {
            int max = array[0];
            for (int i = 1; i < n; i++)
                if (array[i] > max)
                    max = array[i];
            return max;
        }

        // A function to do counting sort of arr[] according to
        // the digit represented by exp.
        static void countSort(int[] arr, int n, int exp)
        {
            int[] output = new int[n]; // output array
            int i;
            int[] count = new int[10];
            Arrays.fill(count, 0);

            // Store count of occurrences in count[]
            for (i = 0; i < n; i++)
                count[(arr[i] / exp) % 10]++;

            // Change count[i] so that count[i] now contains
            // actual position of this digit in output[]
            for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

            // Build the output array
            for (i = n - 1; i >= 0; i--) {
                output[count[(arr[i] / exp) % 10] - 1] = arr[i];
                count[(arr[i] / exp) % 10]--;
            }

            // Copy the output array to arr[], so that arr[] now
            // contains sorted numbers according to current digit
            for (i = 0; i < n; i++)
                arr[i] = output[i];
        }

        // The main function to that sorts arr[] of
        // size n using Radix Sort
        static void sort(int[] arr, int n)
        {
            // Find the maximum number to know number of digits
            int m = getMax(arr, n);

            // Do counting sort for every digit. Note that
            // instead of passing digit number, exp is passed.
            // exp is 10^i where i is current digit number
            for (int exp = 1; m / exp > 0; exp *= 10)
                countSort(arr, n, exp);
        }
}
