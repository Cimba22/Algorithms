package arraySort;

/**
 * Предполагается, что первый элемент списка отсортирован.
 * Переходим к следующему элементу (i), если он больше первого, оставляем его на своём месте.
 * Если он меньше, копируем его на вторую позицию, а i устанавливаем в качестве первого элемента.
 *
 * Time Complexity: O(N^2)
 * Auxiliary Space: O(1)
 *
 * The worst-case time complexity of the Insertion sort is O(N^2)
 * The average case time complexity of the Insertion sort is O(N^2)
 * The time complexity of the best case is O(N).
 *
 * Basically, Insertion sort is efficient for small data values.
 * Insertion sort is adaptive in nature, i.e. it is appropriate for data sets that are already partially sorted.
 */
public class Insertion {
    static void sort(int[] array){
        int j;
        for(int i = 1; i < array.length; i++){
            int swap = array[i];
            for (j = i; j > 0 && swap < array[j - 1]; j--){
                array[j] = array[j - 1];
            }
            array[j] = swap;
        }
    }
}
