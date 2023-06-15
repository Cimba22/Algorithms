package arraySort;

/**
 * One by one move boundary of unsorted subarray.
 * Find the minimum element in unsorted array.
 * Swap the found minimum element with the first element.
 * The time complexity is O(N^2) as there are two nested loops.
 * Auxiliary Space: O(1) as the only extra memory used is for temporary variables while swapping two values in Array.
 * The selection sort never makes more than O(N) swaps and can be useful when memory writing is costly
 */
public class Selection {
    void sort(int[] array){

        for (int i = 0; i < array.length - 1; i++){
            int min_idx = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }
}
