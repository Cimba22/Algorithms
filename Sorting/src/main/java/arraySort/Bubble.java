package arraySort;

/**
 * Starting from the first index, compare the first and the second elements.
 * If the first element is greater than the second element, they are swapped.
 * Now, compare the second and the third elements. Swap them if they are not in order.
 * The above process goes on until the last element.
 *
 * Time Complexity: O(N2)
 * Auxiliary Space: O(1)
 *
 * Advantages of Bubble Sort:
 * Bubble sort is easy to understand and implement.
 * It does not require any additional memory space.
 * It is a stable sorting algorithm, meaning that elements with the same key value maintain their relative order in the sorted output.
 *
 * Disadvantages of Bubble Sort:
 * Bubble sort has a time complexity of O(N2) which makes it very slow for large data sets.
 * Bubble sort is a comparison-based sorting algorithm,
 *  which means that it requires a comparison operator to determine the relative order of elements in the input data set.
 * It can limit the efficiency of the algorithm in certain cases.
 */

public class Bubble {
    static void sort(int[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
