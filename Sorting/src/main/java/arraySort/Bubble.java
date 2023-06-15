package arraySort;

/**
 * Starting from the first index, compare the first and the second elements.
 * If the first element is greater than the second element, they are swapped.
 * Now, compare the second and the third elements. Swap them if they are not in order.
 * The above process goes on until the last element.
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
