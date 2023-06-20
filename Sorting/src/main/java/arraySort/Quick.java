package arraySort;

/**
 * Из массива выбирается опорный элемент, чаще всего посередине массива.
 * Другие элементы массива распределяются таким образом, чтобы меньшие размещались до него, а большие — после.
 * Далее первые шаги рекурсивно применяются к подмассивам,
 *  которые разделились опорным элементом на две части — слева и справа от него.
 *  Асимптотика: O(n log n) в среднем и лучшем случае, O(n2). Наихудшая
 *  * оценка достигается при неудачном выборе опорного элемента.
 *      Advantages of Quick Sort:
 * It is a divide-and-conquer algorithm that makes it easier to solve problems.
 * It is efficient on large data sets.
 * It has a low overhead, as it only requires a small amount of memory to function.
 *      Disadvantages of Quick Sort:
 * It has a worst-case time complexity of O(N2), which occurs when the pivot is chosen poorly.
 * It is not a good choice for small data sets.
 * It is not a stable sort, meaning that if two elements have the same key,
 *   their relative order will not be preserved in the sorted output in case of quick sort,
 *    because here we are swapping elements according to the pivot’s position (without considering their original positions).
 */
public class Quick {
    public static void quickSort(int[] array, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (array.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = array[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < border) i++;
            while (array[j] > border) j--;
            if (i <= j) {
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }

    public static void sort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

}
